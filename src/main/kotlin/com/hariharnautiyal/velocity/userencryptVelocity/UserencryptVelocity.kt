package com.hariharnautiyal.velocity.userencryptVelocity

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.connection.PostLoginEvent
import com.velocitypowered.api.event.player.GameProfileRequestEvent
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.plugin.annotation.DataDirectory
import com.velocitypowered.api.proxy.ProxyServer
import com.velocitypowered.api.util.GameProfile
import net.kyori.adventure.text.Component
import org.slf4j.Logger
import java.math.BigInteger
import java.nio.file.Files
import java.nio.file.Path
import java.security.MessageDigest
import java.security.SecureRandom
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import kotlin.io.path.createDirectories
import kotlin.io.path.exists
import kotlin.io.path.notExists

@Plugin(
    id = "userencrypt-velocity",
    name = "userencrypt-velocity",
    version = BuildConstants.VERSION,
    description = "UserEncrypt minecraft velocity plugin to prevent from username stealing in offline mode servers.",
    url = "https://harihar.site/projects/userencrypt",
    authors = ["Harihar Nautiyal"]
)
class UserencryptVelocity @Inject constructor(
    private val proxyServer: ProxyServer,
    private val logger: Logger,
    @DataDirectory private val dataFolder: Path
) {
    private val playerAliases: MutableMap<String, String> = ConcurrentHashMap()
    private lateinit var playersFile: Path
    private val gson = Gson()

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
        try {
            if (dataFolder.notExists()) {
                dataFolder.createDirectories()
            }
            playersFile = dataFolder.resolve("players.json")

            loadData()

            logger.info("UserEncrypt ${BuildConstants.VERSION} initialized successfully using JSON storage.")
        } catch (e: Exception) {
            logger.error("Failed to initialize UserEncrypt. The plugin will be disabled.", e)
        }
    }

    private fun loadData() {
        if (playersFile.exists()) {
            try {
                Files.newBufferedReader(playersFile).use { reader ->
                    val type = object : TypeToken<ConcurrentHashMap<String, String>>() {}.type
                    playerAliases.putAll(gson.fromJson(reader, type))
                    logger.info("Loaded ${playerAliases.size} player entries from players.json")
                }
            } catch (e: Exception) {
                logger.error("Could not read or parse players.json. A new file will be created.", e)
            }
        }
    }

    private fun saveData() {
        try {
            Files.newBufferedWriter(playersFile).use { writer ->
                gson.toJson(playerAliases, writer)
            }
        } catch (e: Exception) {
            logger.error("Failed to save data to players.json!", e)
        }
    }

    private fun generateAlias(originalName: String): String {
        val salt = ByteArray(16).apply { SecureRandom().nextBytes(this) }
        val digest = MessageDigest.getInstance("SHA-256")
        digest.update(salt)
        val hashBytes = digest.digest(originalName.toByteArray(Charsets.UTF_8))
        return BigInteger(1, hashBytes).toString(36).take(8)
    }

    @Subscribe
    fun onPostLogin(event: PostLoginEvent) {
        val player = event.player
        val original = player.username

        val alias = playerAliases.getOrPut(original) {
            val newAlias = generateAlias(original)
            saveData()
            newAlias
        }

        player.sendMessage(Component.text("Hello $original! Your secure ID is $alias"))
    }

    @Subscribe
    fun onGameProfileRequest(event: GameProfileRequestEvent) {
        val originalName = event.username

        logger.info(originalName);

        val alias = playerAliases.getOrPut(originalName) {
            val newAlias = generateAlias(originalName)
            saveData()
            newAlias
        }

        val offlineUuid = UUID.nameUUIDFromBytes("OfflinePlayer:$alias".toByteArray(Charsets.UTF_8))
        val newProfile = GameProfile(offlineUuid, alias, emptyList())

        event.gameProfile = newProfile
    }
}