package org.dawnoftime.armoroftheages;

import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.dawnoftime.armoroftheages.networking.ConfigSyncNetworkHandler;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.UUID;

public class CommonClass {
    public static HashMap<UUID, PreferredModel> CURRENT_PREFERRED_MODEL_MAP = new HashMap<>();
    public static ConfigSyncNetworkHandler CONFIG_SYNC_HANDLER = null;

    public static void init() {
        AOTAConfig.CONFIG_CLASS_HANDLER.load();
        CONFIG_SYNC_HANDLER.setup();
        CONFIG_SYNC_HANDLER.registerHandler(uuidPreferredModelHashMap -> {
            CURRENT_PREFERRED_MODEL_MAP = uuidPreferredModelHashMap;
        });
    }
}