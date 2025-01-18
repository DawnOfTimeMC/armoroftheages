package org.dawnoftime.armoroftheages.networking;

import org.dawnoftime.armoroftheages.config.PreferredModel;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;

public interface ConfigSyncNetworkHandler {
    void syncConfig();
    void registerHandler(Consumer<HashMap<UUID, PreferredModel>> handler);
    void setup();
}
