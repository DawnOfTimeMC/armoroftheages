package org.dawnoftime.armoroftheages;

import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.dawnoftime.armoroftheages.networking.ConfigSyncNetworkHandler;
import org.dawnoftime.armoroftheages.setbonus.SetBonusRegistry;
import java.util.HashMap;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

public class CommonClass {
    public static HashMap<UUID, PreferredModel> CURRENT_PREFERRED_MODEL_MAP = new HashMap<>();
    public static ConfigSyncNetworkHandler CONFIG_SYNC_HANDLER = null;

    /** Set by client init (Fabric/Forge). Returns null on server or before client is ready. */
    public static Supplier<@Nullable Player> LOCAL_PLAYER_SUPPLIER = () -> null;

    public static void init() {
        SetBonusRegistry.init();
        AOTAConfig.CONFIG_CLASS_HANDLER.load();
        CONFIG_SYNC_HANDLER.setup();
        CONFIG_SYNC_HANDLER.registerHandler(uuidPreferredModelHashMap -> {
            CURRENT_PREFERRED_MODEL_MAP = uuidPreferredModelHashMap;
        });
    }
}