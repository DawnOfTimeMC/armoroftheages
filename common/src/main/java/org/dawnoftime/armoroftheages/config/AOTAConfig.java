package org.dawnoftime.armoroftheages.config;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.impl.controller.BooleanControllerBuilderImpl;
import dev.isxander.yacl3.impl.controller.EnumControllerBuilderImpl;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.dawnoftime.armoroftheages.CommonClass;
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

    @SerialEntry
    public boolean generateArmorLoot = true;
    @SerialEntry
    public boolean generateBambooHat = true;
    @SerialEntry
    public boolean generateAnubisArmor = true;
    @SerialEntry
    public boolean generateCenturionArmor = true;
    @SerialEntry
    public boolean generateExaltedAurumArmor = true;
    @SerialEntry
    public boolean generateHolyArmor = true;
    @SerialEntry
    public boolean generateIronPlateArmor = true;
    @SerialEntry
    public boolean generateJapaneseLightArmor = true;
    @SerialEntry
    public boolean generateOYoroiArmor = true;
    @SerialEntry
    public boolean generatePharaohArmor = true;
    @SerialEntry
    public boolean generateQuetzalcoatlArmor = true;
    @SerialEntry
    public boolean generateRaijinArmor = true;

    public static AOTAConfig get() {
        return CONFIG_CLASS_HANDLER.instance();
    }

    public static YetAnotherConfigLib createScreen() {
        return YetAnotherConfigLib.create(CONFIG_CLASS_HANDLER,
                (AOTAConfig defaults, AOTAConfig config, YetAnotherConfigLib.Builder builder) -> {
                    var preferredModel = Option.<PreferredModel>createBuilder()
                            .name(Component.translatable("config.armoroftheages.preferred_model"))
                            .description(OptionDescription.of(Component.translatable("config.armoroftheages.preferred_model.description")))
                            .binding(defaults.preferredModel, () -> config.preferredModel, val -> config.preferredModel = val)
                            .controller(opt -> new EnumControllerBuilderImpl<>(opt).enumClass(PreferredModel.class))
                            .available(config.usePreferredModel)
                            .build();

                    var usedPreferredModel = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.use_preferred_model"))
                            .description(OptionDescription.of(Component.translatable("config.armoroftheages.use_preferred_model.description")))
                            .binding(defaults.usePreferredModel, () -> config.usePreferredModel, val -> config.usePreferredModel = val)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .addListener((option, event) -> {
                                if (event == OptionEventListener.Event.STATE_CHANGE) {
                                    preferredModel.setAvailable(option.pendingValue());
                                }
                            })
                            .build();

                    var ignoredSynchronizedPreferredModel = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.ignore_synchronized_preferred_models"))
                            .description(OptionDescription.of(Component.translatable("config.armoroftheages.ignore_synchronized_preferred_models.description")))
                            .binding(defaults.ignoredSynchronizedPreferredModel, () -> config.ignoredSynchronizedPreferredModel, val -> config.ignoredSynchronizedPreferredModel = val)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .build();

                    var generateBambooHat = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_bamboo_hat"))
                            .binding(defaults.generateBambooHat,
                                    () -> config.generateBambooHat,
                                    v -> config.generateBambooHat = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .available(config.generateArmorLoot)
                            .build();

                    var generateAnubisArmor = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_anubis_armor"))
                            .binding(defaults.generateAnubisArmor,
                                    () -> config.generateAnubisArmor,
                                    v -> config.generateAnubisArmor = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .available(config.generateArmorLoot)
                            .build();

                    var generateCenturionArmor = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_centurion_armor"))
                            .binding(defaults.generateCenturionArmor,
                                    () -> config.generateCenturionArmor,
                                    v -> config.generateCenturionArmor = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .available(config.generateArmorLoot)
                            .build();

                    var generateExaltedAurumArmor = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_exalted_aurum_armor"))
                            .binding(defaults.generateExaltedAurumArmor,
                                    () -> config.generateExaltedAurumArmor,
                                    v -> config.generateExaltedAurumArmor = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .available(config.generateArmorLoot)
                            .build();

                    var generateHolyArmor = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_holy_armor"))
                            .binding(defaults.generateHolyArmor,
                                    () -> config.generateHolyArmor,
                                    v -> config.generateHolyArmor = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .available(config.generateArmorLoot)
                            .build();

                    var generateIronPlateArmor = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_iron_plate_armor"))
                            .binding(defaults.generateIronPlateArmor,
                                    () -> config.generateIronPlateArmor,
                                    v -> config.generateIronPlateArmor = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .available(config.generateArmorLoot)
                            .build();

                    var generateJapaneseLightArmor = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_japanese_light_armor"))
                            .binding(defaults.generateJapaneseLightArmor,
                                    () -> config.generateJapaneseLightArmor,
                                    v -> config.generateJapaneseLightArmor = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .available(config.generateArmorLoot)
                            .build();

                    var generateOYoroiArmor = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_o_yoroi_armor"))
                            .binding(defaults.generateOYoroiArmor,
                                    () -> config.generateOYoroiArmor,
                                    v -> config.generateOYoroiArmor = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .available(config.generateArmorLoot)
                            .build();

                    var generatePharaohArmor = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_pharaoh_armor"))
                            .binding(defaults.generatePharaohArmor,
                                    () -> config.generatePharaohArmor,
                                    v -> config.generatePharaohArmor = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .available(config.generateArmorLoot)
                            .build();

                    var generateQuetzalcoatlArmor = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_quetzalcoatl_armor"))
                            .binding(defaults.generateQuetzalcoatlArmor,
                                    () -> config.generateQuetzalcoatlArmor,
                                    v -> config.generateQuetzalcoatlArmor = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .available(config.generateArmorLoot)
                            .build();

                    var generateRaijinArmor = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_raijin_armor"))
                            .binding(defaults.generateRaijinArmor,
                                    () -> config.generateRaijinArmor,
                                    v -> config.generateRaijinArmor = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .available(config.generateArmorLoot)
                            .build();

                    var generateArmorLoot = Option.<Boolean>createBuilder()
                            .name(Component.translatable("config.armoroftheages.generate_armor_loot"))
                            .description(OptionDescription.of(Component.translatable("config.armoroftheages.generate_armor_loot.description")))
                            .binding(defaults.generateArmorLoot,
                                    () -> config.generateArmorLoot,
                                    v -> config.generateArmorLoot = v)
                            .controller(opt -> new BooleanControllerBuilderImpl(opt).coloured(true).trueFalseFormatter())
                            .addListener((option, event) -> {
                                if (event == OptionEventListener.Event.STATE_CHANGE) {
                                    boolean available = option.pendingValue();
                                    generateBambooHat.setAvailable(available);
                                    generateAnubisArmor.setAvailable(available);
                                    generateCenturionArmor.setAvailable(available);
                                    generateExaltedAurumArmor.setAvailable(available);
                                    generateHolyArmor.setAvailable(available);
                                    generateIronPlateArmor.setAvailable(available);
                                    generateJapaneseLightArmor.setAvailable(available);
                                    generateOYoroiArmor.setAvailable(available);
                                    generatePharaohArmor.setAvailable(available);
                                    generateQuetzalcoatlArmor.setAvailable(available);
                                    generateRaijinArmor.setAvailable(available);
                                }
                            })
                            .build();

                    return builder.title(Component.translatable("config.armoroftheages.title"))
                            .save(() -> {
                                CONFIG_CLASS_HANDLER.save();
                                CommonClass.CONFIG_SYNC_HANDLER.syncConfig();
                            })
                            .category(ConfigCategory.createBuilder()
                                    .name(Component.translatable("config.armoroftheages.title"))
                                    .option(LabelOption.create(Component.translatable("config.armoroftheages.notice")))
                                    .option(ignoredSynchronizedPreferredModel)
                                    .option(usedPreferredModel)
                                    .option(preferredModel)
                                    .build())

                            .category(ConfigCategory.createBuilder()
                                    .name(Component.translatable("config.armoroftheages.category.armor_loot"))
                                    .option(generateArmorLoot)
                                    .option(generateBambooHat)
                                    .option(generateAnubisArmor)
                                    .option(generateCenturionArmor)
                                    .option(generateExaltedAurumArmor)
                                    .option(generateHolyArmor)
                                    .option(generateIronPlateArmor)
                                    .option(generateJapaneseLightArmor)
                                    .option(generateOYoroiArmor)
                                    .option(generatePharaohArmor)
                                    .option(generateQuetzalcoatlArmor)
                                    .option(generateRaijinArmor)
                                    .build());
                });
    }

}
