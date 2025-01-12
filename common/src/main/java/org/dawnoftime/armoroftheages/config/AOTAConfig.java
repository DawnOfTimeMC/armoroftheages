package org.dawnoftime.armoroftheages.config;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.impl.controller.BooleanControllerBuilderImpl;
import dev.isxander.yacl3.impl.controller.EnumControllerBuilderImpl;
import net.minecraft.network.chat.Component;
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
    @SerialEntry
    public boolean usePreferredModel = false;
    @SerialEntry
    public boolean ignoredSynchronizedPreferredModel = true;
    @SerialEntry
    public PreferredModel preferredModel = PreferredModel.MALE;

    public static YetAnotherConfigLib createScreen() {
        final var notice = Component.translatable("config.armoroftheages.notice");

        return YetAnotherConfigLib.create(CONFIG_CLASS_HANDLER,
                (AOTAConfig defaults, AOTAConfig config, YetAnotherConfigLib.Builder builder) -> {
                    var usedPreferredModel = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.use_preferred_model"))
                            .description(OptionDescription.of(Component.translatable("config.armoroftheages.use_preferred_model.description")))
                            .binding(defaults.usePreferredModel, () -> config.usePreferredModel, val -> config.usePreferredModel = val)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .build();

                    var ignoredSynchronizedPreferredModel = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.ignore_synchronized_preferred_models"))
                            .description(OptionDescription.of(Component.translatable("config.armoroftheages.ignore_synchronized_preferred_models.description")))
                            .binding(defaults.ignoredSynchronizedPreferredModel, () -> config.ignoredSynchronizedPreferredModel, val -> config.ignoredSynchronizedPreferredModel = val)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .build();

                    var preferredModel = Option.<PreferredModel>createBuilder()
                            .name(Component.translatable("config.armoroftheages.preferred_model"))
                            .description(OptionDescription.of(Component.translatable("config.armoroftheages.preferred_model.description")))
                            .binding(defaults.preferredModel, () -> config.preferredModel, val -> config.preferredModel = val)
                            .controller(opt -> new EnumControllerBuilderImpl<>(opt).enumClass(PreferredModel.class))
                            .build();

                    return builder.title(Component.translatable("config.armoroftheages.title"))
                            .save(() -> {
                                CONFIG_CLASS_HANDLER.save();


                            })
                            .category(ConfigCategory.createBuilder()
                                    .name(Component.translatable("config.armoroftheages.title"))
                                    .option(usedPreferredModel)
                                    .option(ignoredSynchronizedPreferredModel)
                                    .option(preferredModel)
                                    .build());
                });
    }

    public enum PreferredModel {
        MALE,
        FEMALE
    }
}
