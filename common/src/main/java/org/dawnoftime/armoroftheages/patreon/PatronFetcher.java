package org.dawnoftime.armoroftheages.patreon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PatronFetcher {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REMOTE_URL =
        "https://raw.githubusercontent.com/DawnOfTimeMC/patreon_list/main/patrons.json";
    private static final int TIMEOUT_MS = 3000;

    public static String fetchAndCache(Path cacheFile) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(REMOTE_URL).openConnection();
            connection.setConnectTimeout(TIMEOUT_MS);
            connection.setReadTimeout(TIMEOUT_MS);
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                LOGGER.warn("[armoroftheages] Patron list fetch returned HTTP {}", responseCode);
                return null;
            }

            try (InputStream is = connection.getInputStream()) {
                String json = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                Files.createDirectories(cacheFile.getParent());
                Files.writeString(cacheFile, json, StandardCharsets.UTF_8);
                return json;
            }
        } catch (IOException e) {
            LOGGER.warn("[armoroftheages] Failed to fetch patron list: {}", e.getMessage());
            return null;
        }
    }
}
