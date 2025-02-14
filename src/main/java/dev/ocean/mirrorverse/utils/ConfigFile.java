package dev.ocean.mirrorverse.utils;

import dev.ocean.mirrorverse.Mirrorverse;
import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@Getter
public class ConfigFile {
    private final File file;
    private final YamlConfiguration configuration;
    private final Mirrorverse plugin = Mirrorverse.getInstance();


    public ConfigFile(String name) {
        File dataFolder = new File(plugin.getDataFolder().getParentFile(), "Marine");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        this.file = new File(dataFolder, name + ".yml");

        if (!file.exists()) {
            try {
                boolean created = file.createNewFile();
                if (!created) {
                    throw new IOException("File was not created.");
                }
            } catch (IOException e) {
                ConsoleUtils.error("Error occurred creating config file: " + e);
            }
        }

        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    public void reload() {
        try {
            configuration.load(file);
        } catch (Exception e) {
            ConsoleUtils.error("Error occurred reloading config: " + e);
        }
    }

    public void save() {
        try {
            configuration.save(file);
        } catch (IOException e) {
            ConsoleUtils.error("Error occurred saving config: " + e);
        }
    }
}