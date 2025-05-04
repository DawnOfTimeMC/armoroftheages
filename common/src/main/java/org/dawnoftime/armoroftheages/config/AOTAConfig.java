package org.dawnoftime.armoroftheages.config;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.impl.controller.BooleanControllerBuilderImpl;
import dev.isxander.yacl3.impl.controller.EnumControllerBuilderImpl;
import dev.isxander.yacl3.impl.controller.FloatFieldControllerBuilderImpl;
import dev.isxander.yacl3.impl.controller.IntegerFieldControllerBuilderImpl;
import net.minecraft.ChatFormatting;
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

    // Preferred Model
    @SerialEntry public boolean usePreferredModel = false;
    @SerialEntry public boolean ignoredSynchronizedPreferredModel = true;
    @SerialEntry public PreferredModel preferredModel = PreferredModel.MALE;

    // IRON_PLATE armor
    @SerialEntry public int ironPlateDurability = 25;
    @SerialEntry public int ironPlateHelmetDef = 3;
    @SerialEntry public int ironPlateChestDef = 9;
    @SerialEntry public int ironPlateLegsDef = 7;
    @SerialEntry public int ironPlateFeetDef = 3;
    @SerialEntry public int ironPlateEnchantability = 6;
    @SerialEntry public float ironPlateToughness = 0.0F;

    // HOLY armor
    @SerialEntry public int holyDurability = 40;
    @SerialEntry public int holyHelmetDef = 4;
    @SerialEntry public int holyChestDef = 10;
    @SerialEntry public int holyLegsDef = 8;
    @SerialEntry public int holyFeetDef = 4;
    @SerialEntry public int holyEnchantability = 4;
    @SerialEntry public float holyToughness = 2.0F;

    // EXALTED_AURUM armor
    @SerialEntry public int exaltedAurumDurability = 35;
    @SerialEntry public int exaltedAurumHelmetDef = 3;
    @SerialEntry public int exaltedAurumChestDef = 9;
    @SerialEntry public int exaltedAurumLegsDef = 7;
    @SerialEntry public int exaltedAurumFeetDef = 3;
    @SerialEntry public int exaltedAurumEnchantability = 12;
    @SerialEntry public float exaltedAurumToughness = 3.0F;

    // JAPANESE_LIGHT armor
    @SerialEntry public int japaneseLightDurability = 12;
    @SerialEntry public int japaneseLightHelmetDef = 2;
    @SerialEntry public int japaneseLightChestDef = 7;
    @SerialEntry public int japaneseLightLegsDef = 6;
    @SerialEntry public int japaneseLightFeetDef = 2;
    @SerialEntry public int japaneseLightEnchantability = 10;
    @SerialEntry public float japaneseLightToughness = 0.0F;

    // O_YOROI armor
    @SerialEntry public int oYoroiDurability = 20;
    @SerialEntry public int oYoroiHelmetDef = 3;
    @SerialEntry public int oYoroiChestDef = 8;
    @SerialEntry public int oYoroiLegsDef = 6;
    @SerialEntry public int oYoroiFeetDef = 3;
    @SerialEntry public int oYoroiEnchantability = 16;
    @SerialEntry public float oYoroiToughness = 2.0F;

    // RAIJIN armor
    @SerialEntry public int raijinDurability = 35;
    @SerialEntry public int raijinHelmetDef = 3;
    @SerialEntry public int raijinChestDef = 9;
    @SerialEntry public int raijinLegsDef = 7;
    @SerialEntry public int raijinFeetDef = 3;
    @SerialEntry public int raijinEnchantability = 26;
    @SerialEntry public float raijinToughness = 2.0F;

    // PHARAOH armor
    @SerialEntry public int pharaohDurability = 10;
    @SerialEntry public int pharaohHelmetDef = 3;
    @SerialEntry public int pharaohChestDef = 8;
    @SerialEntry public int pharaohLegsDef = 6;
    @SerialEntry public int pharaohFeetDef = 3;
    @SerialEntry public int pharaohEnchantability = 37;
    @SerialEntry public float pharaohToughness = 2.0F;

    // ANUBIS
    @SerialEntry public int anubisDurability = 25;
    @SerialEntry public int anubisHelmetDef = 3;
    @SerialEntry public int anubisChestDef = 8;
    @SerialEntry public int anubisLegsDef = 6;
    @SerialEntry public int anubisFeetDef = 3;
    @SerialEntry public int anubisEnchantability = 52;
    @SerialEntry public float anubisToughness = 3.0F;

    // CENTURION armor
    @SerialEntry public int centurionDurability = 22;
    @SerialEntry public int centurionHelmetDef = 3;
    @SerialEntry public int centurionChestDef = 7;
    @SerialEntry public int centurionLegsDef = 5;
    @SerialEntry public int centurionFeetDef = 3;
    @SerialEntry public int centurionEnchantability = 10;
    @SerialEntry public float centurionToughness = 3.0F;

    // QUETZALCOATL armor
    @SerialEntry public int quetzalcoatlDurability = 25;
    @SerialEntry public int quetzalcoatlHelmetDef = 2;
    @SerialEntry public int quetzalcoatlChestDef = 6;
    @SerialEntry public int quetzalcoatlLegsDef = 5;
    @SerialEntry public int quetzalcoatlFeetDef = 2;
    @SerialEntry public int quetzalcoatlEnchantability = 20;
    @SerialEntry public float quetzalcoatlToughness = 6.0F;

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

                    // Preferred Model options
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

                    // IRON_PLATE Options
                    var ironPlateDurability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.iron_plate_durability"))
                            .binding(defaults.ironPlateDurability, () -> config.ironPlateDurability, val -> config.ironPlateDurability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var ironPlateHelmetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.iron_plate_helmet_def"))
                            .binding(defaults.ironPlateHelmetDef, () -> config.ironPlateHelmetDef, val -> config.ironPlateHelmetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var ironPlateChestDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.iron_plate_chest_def"))
                            .binding(defaults.ironPlateChestDef, () -> config.ironPlateChestDef, val -> config.ironPlateChestDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var ironPlateLegsDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.iron_plate_legs_def"))
                            .binding(defaults.ironPlateLegsDef, () -> config.ironPlateLegsDef, val -> config.ironPlateLegsDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var ironPlateFeetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.iron_plate_feet_def"))
                            .binding(defaults.ironPlateFeetDef, () -> config.ironPlateFeetDef, val -> config.ironPlateFeetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var ironPlateEnchantability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.iron_plate_enchantability"))
                            .binding(defaults.ironPlateEnchantability, () -> config.ironPlateEnchantability, val -> config.ironPlateEnchantability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var ironPlateToughness = Option.<Float>createBuilder()
                            .name(Component.translatable("config.armoroftheages.iron_plate_toughness"))
                            .binding(defaults.ironPlateToughness, () -> config.ironPlateToughness, val -> config.ironPlateToughness = val)
                            .controller(FloatFieldControllerBuilderImpl::new)
                            .build();

                    // HOLY Options
                    var holyDurability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.holy_durability"))
                            .binding(defaults.holyDurability, () -> config.holyDurability, val -> config.holyDurability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var holyHelmetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.holy_helmet_def"))
                            .binding(defaults.holyHelmetDef, () -> config.holyHelmetDef, val -> config.holyHelmetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var holyChestDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.holy_chest_def"))
                            .binding(defaults.holyChestDef, () -> config.holyChestDef, val -> config.holyChestDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var holyLegsDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.holy_legs_def"))
                            .binding(defaults.holyLegsDef, () -> config.holyLegsDef, val -> config.holyLegsDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var holyFeetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.holy_feet_def"))
                            .binding(defaults.holyFeetDef, () -> config.holyFeetDef, val -> config.holyFeetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var holyEnchantability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.holy_enchantability"))
                            .binding(defaults.holyEnchantability, () -> config.holyEnchantability, val -> config.holyEnchantability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var holyToughness = Option.<Float>createBuilder()
                            .name(Component.translatable("config.armoroftheages.holy_toughness"))
                            .binding(defaults.holyToughness, () -> config.holyToughness, val -> config.holyToughness = val)
                            .controller(FloatFieldControllerBuilderImpl::new)
                            .build();

                    // EXALTED_AURUM Options
                    var exaltedAurumDurability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.exalted_aurum_durability"))
                            .binding(defaults.exaltedAurumDurability, () -> config.exaltedAurumDurability, val -> config.exaltedAurumDurability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var exaltedAurumHelmetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.exalted_aurum_helmet_def"))
                            .binding(defaults.exaltedAurumHelmetDef, () -> config.exaltedAurumHelmetDef, val -> config.exaltedAurumHelmetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var exaltedAurumChestDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.exalted_aurum_chest_def"))
                            .binding(defaults.exaltedAurumChestDef, () -> config.exaltedAurumChestDef, val -> config.exaltedAurumChestDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var exaltedAurumLegsDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.exalted_aurum_legs_def"))
                            .binding(defaults.exaltedAurumLegsDef, () -> config.exaltedAurumLegsDef, val -> config.exaltedAurumLegsDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var exaltedAurumFeetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.exalted_aurum_feet_def"))
                            .binding(defaults.exaltedAurumFeetDef, () -> config.exaltedAurumFeetDef, val -> config.exaltedAurumFeetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var exaltedAurumEnchantability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.exalted_aurum_enchantability"))
                            .binding(defaults.exaltedAurumEnchantability, () -> config.exaltedAurumEnchantability, val -> config.exaltedAurumEnchantability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var exaltedAurumToughness = Option.<Float>createBuilder()
                            .name(Component.translatable("config.armoroftheages.exalted_aurum_toughness"))
                            .binding(defaults.exaltedAurumToughness, () -> config.exaltedAurumToughness, val -> config.exaltedAurumToughness = val)
                            .controller(FloatFieldControllerBuilderImpl::new)
                            .build();

                    // JAPANESE_LIGHT Options
                    var japaneseLightDurability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.japanese_light_durability"))
                            .binding(defaults.japaneseLightDurability, () -> config.japaneseLightDurability, val -> config.japaneseLightDurability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var japaneseLightHelmetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.japanese_light_helmet_def"))
                            .binding(defaults.japaneseLightHelmetDef, () -> config.japaneseLightHelmetDef, val -> config.japaneseLightHelmetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var japaneseLightChestDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.japanese_light_chest_def"))
                            .binding(defaults.japaneseLightChestDef, () -> config.japaneseLightChestDef, val -> config.japaneseLightChestDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var japaneseLightLegsDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.japanese_light_legs_def"))
                            .binding(defaults.japaneseLightLegsDef, () -> config.japaneseLightLegsDef, val -> config.japaneseLightLegsDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var japaneseLightFeetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.japanese_light_feet_def"))
                            .binding(defaults.japaneseLightFeetDef, () -> config.japaneseLightFeetDef, val -> config.japaneseLightFeetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var japaneseLightEnchantability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.japanese_light_enchantability"))
                            .binding(defaults.japaneseLightEnchantability, () -> config.japaneseLightEnchantability, val -> config.japaneseLightEnchantability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var japaneseLightToughness = Option.<Float>createBuilder()
                            .name(Component.translatable("config.armoroftheages.japanese_light_toughness"))
                            .binding(defaults.japaneseLightToughness, () -> config.japaneseLightToughness, val -> config.japaneseLightToughness = val)
                            .controller(FloatFieldControllerBuilderImpl::new)
                            .build();

                    // O_YOROI Options
                    var oYoroiDurability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.o_yoroi_durability"))
                            .binding(defaults.oYoroiDurability, () -> config.oYoroiDurability, val -> config.oYoroiDurability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var oYoroiHelmetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.o_yoroi_helmet_def"))
                            .binding(defaults.oYoroiHelmetDef, () -> config.oYoroiHelmetDef, val -> config.oYoroiHelmetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var oYoroiChestDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.o_yoroi_chest_def"))
                            .binding(defaults.oYoroiChestDef, () -> config.oYoroiChestDef, val -> config.oYoroiChestDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var oYoroiLegsDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.o_yoroi_legs_def"))
                            .binding(defaults.oYoroiLegsDef, () -> config.oYoroiLegsDef, val -> config.oYoroiLegsDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var oYoroiFeetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.o_yoroi_feet_def"))
                            .binding(defaults.oYoroiFeetDef, () -> config.oYoroiFeetDef, val -> config.oYoroiFeetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var oYoroiEnchantability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.o_yoroi_enchantability"))
                            .binding(defaults.oYoroiEnchantability, () -> config.oYoroiEnchantability, val -> config.oYoroiEnchantability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var oYoroiToughness = Option.<Float>createBuilder()
                            .name(Component.translatable("config.armoroftheages.o_yoroi_toughness"))
                            .binding(defaults.oYoroiToughness, () -> config.oYoroiToughness, val -> config.oYoroiToughness = val)
                            .controller(FloatFieldControllerBuilderImpl::new)
                            .build();

                    // RAIJIN Options
                    var raijinDurability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.raijin_durability"))
                            .binding(defaults.raijinDurability, () -> config.raijinDurability, val -> config.raijinDurability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var raijinHelmetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.raijin_helmet_def"))
                            .binding(defaults.raijinHelmetDef, () -> config.raijinHelmetDef, val -> config.raijinHelmetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var raijinChestDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.raijin_chest_def"))
                            .binding(defaults.raijinChestDef, () -> config.raijinChestDef, val -> config.raijinChestDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var raijinLegsDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.raijin_legs_def"))
                            .binding(defaults.raijinLegsDef, () -> config.raijinLegsDef, val -> config.raijinLegsDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var raijinFeetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.raijin_feet_def"))
                            .binding(defaults.raijinFeetDef, () -> config.raijinFeetDef, val -> config.raijinFeetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var raijinEnchantability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.raijin_enchantability"))
                            .binding(defaults.raijinEnchantability, () -> config.raijinEnchantability, val -> config.raijinEnchantability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var raijinToughness = Option.<Float>createBuilder()
                            .name(Component.translatable("config.armoroftheages.raijin_toughness"))
                            .binding(defaults.raijinToughness, () -> config.raijinToughness, val -> config.raijinToughness = val)
                            .controller(FloatFieldControllerBuilderImpl::new)
                            .build();

                    // PHARAOH Options
                    var pharaohDurability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.pharaoh_durability"))
                            .binding(defaults.pharaohDurability, () -> config.pharaohDurability, val -> config.pharaohDurability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var pharaohHelmetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.pharaoh_helmet_def"))
                            .binding(defaults.pharaohHelmetDef, () -> config.pharaohHelmetDef, val -> config.pharaohHelmetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var pharaohChestDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.pharaoh_chest_def"))
                            .binding(defaults.pharaohChestDef, () -> config.pharaohChestDef, val -> config.pharaohChestDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var pharaohLegsDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.pharaoh_legs_def"))
                            .binding(defaults.pharaohLegsDef, () -> config.pharaohLegsDef, val -> config.pharaohLegsDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var pharaohFeetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.pharaoh_feet_def"))
                            .binding(defaults.pharaohFeetDef, () -> config.pharaohFeetDef, val -> config.pharaohFeetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var pharaohEnchantability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.pharaoh_enchantability"))
                            .binding(defaults.pharaohEnchantability, () -> config.pharaohEnchantability, val -> config.pharaohEnchantability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var pharaohToughness = Option.<Float>createBuilder()
                            .name(Component.translatable("config.armoroftheages.pharaoh_toughness"))
                            .binding(defaults.pharaohToughness, () -> config.pharaohToughness, val -> config.pharaohToughness = val)
                            .controller(FloatFieldControllerBuilderImpl::new)
                            .build();

                    // ANUBIS Options
                    var anubisDurability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.anubis_durability"))
                            .binding(defaults.anubisDurability, () -> config.anubisDurability, val -> config.anubisDurability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var anubisHelmetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.anubis_helmet_def"))
                            .binding(defaults.anubisHelmetDef, () -> config.anubisHelmetDef, val -> config.anubisHelmetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var anubisChestDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.anubis_chest_def"))
                            .binding(defaults.anubisChestDef, () -> config.anubisChestDef, val -> config.anubisChestDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var anubisLegsDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.anubis_legs_def"))
                            .binding(defaults.anubisLegsDef, () -> config.anubisLegsDef, val -> config.anubisLegsDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var anubisFeetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.anubis_feet_def"))
                            .binding(defaults.anubisFeetDef, () -> config.anubisFeetDef, val -> config.anubisFeetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var anubisEnchantability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.anubis_enchantability"))
                            .binding(defaults.anubisEnchantability, () -> config.anubisEnchantability, val -> config.anubisEnchantability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var anubisToughness = Option.<Float>createBuilder()
                            .name(Component.translatable("config.armoroftheages.anubis_toughness"))
                            .binding(defaults.anubisToughness, () -> config.anubisToughness, val -> config.anubisToughness = val)
                            .controller(FloatFieldControllerBuilderImpl::new)
                            .build();

                    // CENTURION Options
                    var centurionDurability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.centurion_durability"))
                            .binding(defaults.centurionDurability, () -> config.centurionDurability, val -> config.centurionDurability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var centurionHelmetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.centurion_helmet_def"))
                            .binding(defaults.centurionHelmetDef, () -> config.centurionHelmetDef, val -> config.centurionHelmetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var centurionChestDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.centurion_chest_def"))
                            .binding(defaults.centurionChestDef, () -> config.centurionChestDef, val -> config.centurionChestDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var centurionLegsDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.centurion_legs_def"))
                            .binding(defaults.centurionLegsDef, () -> config.centurionLegsDef, val -> config.centurionLegsDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var centurionFeetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.centurion_feet_def"))
                            .binding(defaults.centurionFeetDef, () -> config.centurionFeetDef, val -> config.centurionFeetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var centurionEnchantability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.centurion_enchantability"))
                            .binding(defaults.centurionEnchantability, () -> config.centurionEnchantability, val -> config.centurionEnchantability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var centurionToughness = Option.<Float>createBuilder()
                            .name(Component.translatable("config.armoroftheages.centurion_toughness"))
                            .binding(defaults.centurionToughness, () -> config.centurionToughness, val -> config.centurionToughness = val)
                            .controller(FloatFieldControllerBuilderImpl::new)
                            .build();

                    // QUETZALCOATL Options
                    var quetzalcoatlDurability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.quetzalcoatl_durability"))
                            .binding(defaults.quetzalcoatlDurability, () -> config.quetzalcoatlDurability, val -> config.quetzalcoatlDurability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var quetzalcoatlHelmetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.quetzalcoatl_helmet_def"))
                            .binding(defaults.quetzalcoatlHelmetDef, () -> config.quetzalcoatlHelmetDef, val -> config.quetzalcoatlHelmetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var quetzalcoatlChestDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.quetzalcoatl_chest_def"))
                            .binding(defaults.quetzalcoatlChestDef, () -> config.quetzalcoatlChestDef, val -> config.quetzalcoatlChestDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var quetzalcoatlLegsDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.quetzalcoatl_legs_def"))
                            .binding(defaults.quetzalcoatlLegsDef, () -> config.quetzalcoatlLegsDef, val -> config.quetzalcoatlLegsDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var quetzalcoatlFeetDef = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.quetzalcoatl_feet_def"))
                            .binding(defaults.quetzalcoatlFeetDef, () -> config.quetzalcoatlFeetDef, val -> config.quetzalcoatlFeetDef = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var quetzalcoatlEnchantability = Option.<Integer>createBuilder()
                            .name(Component.translatable("config.armoroftheages.quetzalcoatl_enchantability"))
                            .binding(defaults.quetzalcoatlEnchantability, () -> config.quetzalcoatlEnchantability, val -> config.quetzalcoatlEnchantability = val)
                            .controller(IntegerFieldControllerBuilderImpl::new)
                            .build();

                    var quetzalcoatlToughness = Option.<Float>createBuilder()
                            .name(Component.translatable("config.armoroftheages.quetzalcoatl_toughness"))
                            .binding(defaults.quetzalcoatlToughness, () -> config.quetzalcoatlToughness, val -> config.quetzalcoatlToughness = val)
                            .controller(FloatFieldControllerBuilderImpl::new)
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


                    // Build the config screen
                    return builder
                            .title(Component.translatable("config.armoroftheages.title"))
                            .category(
                                    ConfigCategory.createBuilder()
                                            .name(Component.translatable("config.armoroftheages.armor_properties_title"))

                                            // JAPANESE_LIGHT
                                            .group(OptionGroup.createBuilder()
                                                    .name(Component.translatable("config.armoroftheages.group.japanese_light").withStyle(ChatFormatting.WHITE))
                                                    .option(japaneseLightDurability)
                                                    .option(japaneseLightHelmetDef)
                                                    .option(japaneseLightChestDef)
                                                    .option(japaneseLightLegsDef)
                                                    .option(japaneseLightFeetDef)
                                                    .option(japaneseLightEnchantability)
                                                    .option(japaneseLightToughness)
                                                    .collapsed(true)
                                                    .build()
                                            )

                                            // PHARAOH
                                            .group(OptionGroup.createBuilder()
                                                    .name(Component.translatable("config.armoroftheages.group.pharaoh").withStyle(ChatFormatting.WHITE))
                                                    .option(pharaohDurability)
                                                    .option(pharaohHelmetDef)
                                                    .option(pharaohChestDef)
                                                    .option(pharaohLegsDef)
                                                    .option(pharaohFeetDef)
                                                    .option(pharaohEnchantability)
                                                    .option(pharaohToughness)
                                                    .collapsed(true)
                                                    .build()
                                            )

                                            // IRON_PLATE
                                            .group(OptionGroup.createBuilder()
                                                    .name(Component.translatable("config.armoroftheages.group.iron_plate").withStyle(ChatFormatting.YELLOW))
                                                    .option(ironPlateDurability)
                                                    .option(ironPlateHelmetDef)
                                                    .option(ironPlateChestDef)
                                                    .option(ironPlateLegsDef)
                                                    .option(ironPlateFeetDef)
                                                    .option(ironPlateEnchantability)
                                                    .option(ironPlateToughness)
                                                    .collapsed(true)
                                                    .build()
                                            )

                                            // O_YOROI
                                            .group(OptionGroup.createBuilder()
                                                    .name(Component.translatable("config.armoroftheages.group.o_yoroi").withStyle(ChatFormatting.YELLOW))
                                                    .option(oYoroiDurability)
                                                    .option(oYoroiHelmetDef)
                                                    .option(oYoroiChestDef)
                                                    .option(oYoroiLegsDef)
                                                    .option(oYoroiFeetDef)
                                                    .option(oYoroiEnchantability)
                                                    .option(oYoroiToughness)
                                                    .collapsed(true)
                                                    .build()
                                            )

                                            // CENTURION
                                            .group(OptionGroup.createBuilder()
                                                    .name(Component.translatable("config.armoroftheages.group.centurion").withStyle(ChatFormatting.YELLOW))
                                                    .option(centurionDurability)
                                                    .option(centurionHelmetDef)
                                                    .option(centurionChestDef)
                                                    .option(centurionLegsDef)
                                                    .option(centurionFeetDef)
                                                    .option(centurionEnchantability)
                                                    .option(centurionToughness)
                                                    .collapsed(true)
                                                    .build()
                                            )

                                            // HOLY
                                            .group(OptionGroup.createBuilder()
                                                    .name(Component.translatable("config.armoroftheages.group.holy").withStyle(ChatFormatting.LIGHT_PURPLE))
                                                    .option(holyDurability)
                                                    .option(holyHelmetDef)
                                                    .option(holyChestDef)
                                                    .option(holyLegsDef)
                                                    .option(holyFeetDef)
                                                    .option(holyEnchantability)
                                                    .option(holyToughness)
                                                    .collapsed(true)
                                                    .build()
                                            )

                                            // EXALTED_AURUM
                                            .group(OptionGroup.createBuilder()
                                                    .name(Component.translatable("config.armoroftheages.group.exalted_aurum").withStyle(ChatFormatting.LIGHT_PURPLE))
                                                    .option(exaltedAurumDurability)
                                                    .option(exaltedAurumHelmetDef)
                                                    .option(exaltedAurumChestDef)
                                                    .option(exaltedAurumLegsDef)
                                                    .option(exaltedAurumFeetDef)
                                                    .option(exaltedAurumEnchantability)
                                                    .option(exaltedAurumToughness)
                                                    .collapsed(true)
                                                    .build()
                                            )

                                            // RAIJIN
                                            .group(OptionGroup.createBuilder()
                                                    .name(Component.translatable("config.armoroftheages.group.raijin").withStyle(ChatFormatting.LIGHT_PURPLE))
                                                    .option(raijinDurability)
                                                    .option(raijinHelmetDef)
                                                    .option(raijinChestDef)
                                                    .option(raijinLegsDef)
                                                    .option(raijinFeetDef)
                                                    .option(raijinEnchantability)
                                                    .option(raijinToughness)
                                                    .collapsed(true)
                                                    .build()
                                            )

                                            // ANUBIS
                                            .group(OptionGroup.createBuilder()
                                                    .name(Component.translatable("config.armoroftheages.group.anubis").withStyle(ChatFormatting.LIGHT_PURPLE))
                                                    .option(anubisDurability)
                                                    .option(anubisHelmetDef)
                                                    .option(anubisChestDef)
                                                    .option(anubisLegsDef)
                                                    .option(anubisFeetDef)
                                                    .option(anubisEnchantability)
                                                    .option(anubisToughness)
                                                    .collapsed(true)
                                                    .build()
                                            )

                                            // QUETZALCOATL
                                            .group(OptionGroup.createBuilder()
                                                    .name(Component.translatable("config.armoroftheages.group.quetzalcoatl").withStyle(ChatFormatting.LIGHT_PURPLE))
                                                    .option(quetzalcoatlDurability)
                                                    .option(quetzalcoatlHelmetDef)
                                                    .option(quetzalcoatlChestDef)
                                                    .option(quetzalcoatlLegsDef)
                                                    .option(quetzalcoatlFeetDef)
                                                    .option(quetzalcoatlEnchantability)
                                                    .option(quetzalcoatlToughness)
                                                    .collapsed(true)
                                                    .build()
                                            )
                                            .build()
                            )
                            .category(
                                    ConfigCategory.createBuilder()
                                            .name(Component.translatable("config.armoroftheages.title"))
                                            .option(LabelOption.create(Component.translatable("config.armoroftheages.notice")))
                                            .option(ignoredSynchronizedPreferredModel)
                                            .option(usedPreferredModel)
                                            .option(preferredModel)
                                            .build()
                            )
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
                                    .build())
                            .save(() -> {
                                CONFIG_CLASS_HANDLER.save();
                                CommonClass.CONFIG_SYNC_HANDLER.syncConfig();
                            });
                });
    }

}
