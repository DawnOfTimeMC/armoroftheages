package org.dawnoftime.armoroftheages;

import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.networking.ConfigSyncNetworkHandler;

public class CommonClass {
    public static ConfigSyncNetworkHandler CONFIG_SYNC_HANDLER = null;

    public static void init() {
        AOTAConfig.CONFIG_CLASS_HANDLER.load();

    }
}