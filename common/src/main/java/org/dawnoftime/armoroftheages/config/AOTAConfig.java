package org.dawnoftime.armoroftheages.config;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.minecraft.resources.ResourceLocation;
import org.dawnoftime.armoroftheages.Constants;

public class AOTAConfig {
    public static ConfigClassHandler<AOTAConfig> CONFIG_CLASS_HANDLER = ConfigClassHandler
            .createBuilder(AOTAConfig.class)
            .id(ResourceLocation.tryBuild(Constants.MOD_ID, "config"))
            .serializer(config -> GsonConfigSerializerBuilder
                    .create(config)
                    .setPath(Constants.CONFIG_PATH)
                    .appendGsonBuilder(GsonBuilder::setPrettyPrinting).build())
            .build();


}
