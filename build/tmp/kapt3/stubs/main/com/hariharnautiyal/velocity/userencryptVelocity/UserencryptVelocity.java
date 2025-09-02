package com.hariharnautiyal.velocity.userencryptVelocity;

@com.velocitypowered.api.plugin.Plugin(id = "userencrypt-velocity", name = "userencrypt-velocity", version = "1.0-SNAPSHOT", description = "UserEncrypt minecraft velocity plugin to prevent from username stealing in offline mode servers.", url = "https://harihar.site/projects/userencrypt", authors = {"Harihar Nautiyal"})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u0012H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/hariharnautiyal/velocity/userencryptVelocity/UserencryptVelocity;", "", "proxyServer", "Lcom/velocitypowered/api/proxy/ProxyServer;", "logger", "Lorg/slf4j/Logger;", "dataFolder", "Ljava/nio/file/Path;", "(Lcom/velocitypowered/api/proxy/ProxyServer;Lorg/slf4j/Logger;Ljava/nio/file/Path;)V", "gson", "Lcom/google/gson/Gson;", "playerAliases", "", "", "playersFile", "generateAlias", "originalName", "loadData", "", "onGameProfileRequest", "event", "Lcom/velocitypowered/api/event/player/GameProfileRequestEvent;", "onPostLogin", "Lcom/velocitypowered/api/event/connection/PostLoginEvent;", "onProxyInitialization", "Lcom/velocitypowered/api/event/proxy/ProxyInitializeEvent;", "saveData", "userencrypt-velocity"})
public final class UserencryptVelocity {
    @org.jetbrains.annotations.NotNull()
    private final com.velocitypowered.api.proxy.ProxyServer proxyServer = null;
    @org.jetbrains.annotations.NotNull()
    private final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final java.nio.file.Path dataFolder = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> playerAliases = null;
    private java.nio.file.Path playersFile;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    @com.google.inject.Inject()
    public UserencryptVelocity(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.proxy.ProxyServer proxyServer, @org.jetbrains.annotations.NotNull()
    org.slf4j.Logger logger, @com.velocitypowered.api.plugin.annotation.DataDirectory()
    @org.jetbrains.annotations.NotNull()
    java.nio.file.Path dataFolder) {
        super();
    }
    
    @com.velocitypowered.api.event.Subscribe()
    public final void onProxyInitialization(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.event.proxy.ProxyInitializeEvent event) {
    }
    
    private final void loadData() {
    }
    
    private final void saveData() {
    }
    
    private final java.lang.String generateAlias(java.lang.String originalName) {
        return null;
    }
    
    @com.velocitypowered.api.event.Subscribe()
    public final void onPostLogin(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.event.connection.PostLoginEvent event) {
    }
    
    @com.velocitypowered.api.event.Subscribe()
    public final void onGameProfileRequest(@org.jetbrains.annotations.NotNull()
    com.velocitypowered.api.event.player.GameProfileRequestEvent event) {
    }
}