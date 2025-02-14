package dev.ocean.mirrorverse.configs;

import dev.ocean.mirrorverse.configs.impl.SettingsLocale;
import dev.ocean.mirrorverse.utils.ConfigFile;
import lombok.Getter;

@Getter
public class ConfigService {
    @Getter
    private static ConfigService instance;
    private ConfigFile settingsConfig;
    private ConfigFile arenasConfig;
    private ConfigFile kitsConfig;
    private ConfigFile scoreboardsConfig;

    public void load() {
        settingsConfig = new ConfigFile("settings");
        arenasConfig = new ConfigFile("arenas");
        kitsConfig = new ConfigFile("kits");
        scoreboardsConfig = new ConfigFile("scoreboards");

        initialize();
    }

    public void reload() {
        settingsConfig.reload();
        arenasConfig.reload();
        kitsConfig.reload();
        scoreboardsConfig.reload();
    }

    public void initialize() {
        instance = this;
        SettingsLocale.DEBUG.load();
    }
}