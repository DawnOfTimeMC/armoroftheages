package org.dawnoftime.armoroftheages;

import org.dawnoftime.armoroftheages.config.AOTAConfig;

public class CommonClass {
    public static void init() {
        AOTAConfig.CONFIG_CLASS_HANDLER.load();
    }
}