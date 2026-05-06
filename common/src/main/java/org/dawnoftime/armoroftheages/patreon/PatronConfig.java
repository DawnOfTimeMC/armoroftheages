package org.dawnoftime.armoroftheages.patreon;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PatronConfig {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = new Gson();

    // Written by async fetch thread, read by server tick thread
    private static volatile PatronConfig CACHED = null;

    public List<String> tier1 = new ArrayList<>();
    public List<String> tier2 = new ArrayList<>();
    public List<String> tier3 = new ArrayList<>();
    public List<String> tier4 = new ArrayList<>();
    public List<String> tier5 = new ArrayList<>();
    public List<String> tier6 = new ArrayList<>();

    public static void load(Path cacheFile) {
        try {
            if (!Files.exists(cacheFile)) {
                CACHED = new PatronConfig();
                return;
            }
            String json = Files.readString(cacheFile, StandardCharsets.UTF_8);
            PatronData data = GSON.fromJson(json, PatronData.class);
            PatronConfig config = new PatronConfig();
            if (data != null) {
                if (data.tier1 != null) data.tier1.forEach(e -> { if (e.uuid != null) config.tier1.add(e.uuid); });
                if (data.tier2 != null) data.tier2.forEach(e -> { if (e.uuid != null) config.tier2.add(e.uuid); });
                if (data.tier3 != null) data.tier3.forEach(e -> { if (e.uuid != null) config.tier3.add(e.uuid); });
                if (data.tier4 != null) data.tier4.forEach(e -> { if (e.uuid != null) config.tier4.add(e.uuid); });
                if (data.tier5 != null) data.tier5.forEach(e -> { if (e.uuid != null) config.tier5.add(e.uuid); });
                if (data.tier6 != null) data.tier6.forEach(e -> { if (e.uuid != null) config.tier6.add(e.uuid); });
            }
            CACHED = config;
        } catch (Exception e) {
            LOGGER.warn("[armoroftheages] Failed to parse patron cache: {}", e.getMessage());
            CACHED = new PatronConfig();
        }
    }

    // Returns cached config, or empty config if not yet loaded
    public static PatronConfig get() {
        PatronConfig cached = CACHED;
        if (cached == null) {
            LOGGER.warn("[armoroftheages] Patron cache not yet loaded, returning tier 0");
            return new PatronConfig();
        }
        return cached;
    }

    // Checks highest tier first to avoid misidentifying a high-tier patron
    public static int getPlayerMaxTier(String uuid) {
        PatronConfig config = get();
        if (config.tier6.contains(uuid)) return 6;
        if (config.tier5.contains(uuid)) return 5;
        if (config.tier4.contains(uuid)) return 4;
        if (config.tier3.contains(uuid)) return 3;
        if (config.tier2.contains(uuid)) return 2;
        if (config.tier1.contains(uuid)) return 1;
        return 0;
    }

    private static class PatronData {
        List<PatronEntry> tier1;
        List<PatronEntry> tier2;
        List<PatronEntry> tier3;
        List<PatronEntry> tier4;
        List<PatronEntry> tier5;
        List<PatronEntry> tier6;
    }

    private static class PatronEntry {
        String uuid;
        String name;
    }
}
