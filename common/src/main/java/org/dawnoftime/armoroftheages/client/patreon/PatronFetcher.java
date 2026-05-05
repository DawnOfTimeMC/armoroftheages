package org.dawnoftime.armoroftheages.client.patreon;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class PatronFetcher {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PATRONS_URL =
            "https://raw.githubusercontent.com/DawnOfTimeMC/patreon_list/main/patrons.json";
    private static final int TIMEOUT_MS = 5000;

    public static void fetchAndApply(UUID playerUuid) {
        if (playerUuid == null) return;
        String uuidStr = playerUuid.toString();

        CompletableFuture.runAsync(() -> {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(PATRONS_URL).openConnection();
                connection.setConnectTimeout(TIMEOUT_MS);
                connection.setReadTimeout(TIMEOUT_MS);
                connection.setRequestProperty("User-Agent", "ArmorOfTheAges-Mod");

                if (connection.getResponseCode() != 200) {
                    LOGGER.warn("[AOTA] Patron list fetch failed: HTTP {}", connection.getResponseCode());
                    return;
                }

                JsonObject root;
                try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
                    root = JsonParser.parseReader(reader).getAsJsonObject();
                }

                // Check tiers from highest to lowest; take the first match (highest tier the player is in)
                int detectedTier = 0;
                outer:
                for (int tier = 6; tier >= 1; tier--) {
                    JsonArray arr = root.getAsJsonArray("tier" + tier);
                    if (arr == null) continue;
                    for (JsonElement el : arr) {
                        String uuid = el.getAsJsonObject().get("uuid").getAsString();
                        if (uuidStr.equalsIgnoreCase(uuid)) {
                            detectedTier = tier;
                            break outer;
                        }
                    }
                }

                ClientPatronState.playerTier = detectedTier;
                if (detectedTier > 0) {
                    LOGGER.info("[AOTA] Patron recognized: tier {}", detectedTier);
                }
            } catch (Exception e) {
                LOGGER.warn("[AOTA] Patron fetch error: {}", e.getMessage());
            }
        });
    }
}
