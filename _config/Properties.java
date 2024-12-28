package _config;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Properties {

    private static final String CONFIG_FILE = "configuration.txt";

    /**
     * Saves or updates a property in the config.txt file.
     * If the property exists, its value will be updated; otherwise, it will be added.
     *
     * @param property the property name (e.g., "speed").
     * @param value the value to be associated with the property.
     */
    public static void saveProperty(String property, String value) {
        List<String> lines = new ArrayList<>();
        boolean propertyFound = false;

        // Read existing lines
        if (Files.exists(Paths.get(CONFIG_FILE))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith(property + "=")) {
                        lines.add(property + "=" + value); // Update the property
                        propertyFound = true;
                    } else {
                        lines.add(line); // Keep other lines unchanged
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // If the property was not found, append it
        if (!propertyFound) {
            lines.add(property + "=" + value);
        }

        // Write back all lines
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONFIG_FILE))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the value of a property from config.txt.
     * If the property does not exist, returns null.
     *
     * @param property the property name to read (e.g., "speed").
     * @return the value associated with the property, or null if not found.
     */
    public static String readProperty(String property) {
        if (!Files.exists(Paths.get(CONFIG_FILE))) {
            return null; // File does not exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(property + "=")) {
                    return line.substring((property + "=").length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Property not found
    }

}

