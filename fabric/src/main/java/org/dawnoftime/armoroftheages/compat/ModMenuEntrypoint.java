package org.dawnoftime.armoroftheages.compat;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import org.dawnoftime.armoroftheages.config.AOTAConfig;

public class ModMenuEntrypoint implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AOTAConfig.createScreen().generateScreen(parent);
    }
}
