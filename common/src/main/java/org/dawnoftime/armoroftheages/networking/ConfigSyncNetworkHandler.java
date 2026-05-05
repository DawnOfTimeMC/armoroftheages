package org.dawnoftime.armoroftheages.networking;

import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.dawnoftime.armoroftheages.config.SkinSyncState;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;

public interface ConfigSyncNetworkHandler {
    void syncConfig();
    void registerHandler(Consumer<HashMap<UUID, PreferredModel>> handler);
    void registerSkinHandler(Consumer<HashMap<UUID, SkinSyncState>> handler);
    void setup();
}
