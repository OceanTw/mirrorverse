package dev.ocean.mirrorverse;

import org.bukkit.plugin.java.JavaPlugin;

public class Goofyverse extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Goofyverse has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Goofyverse has been disabled!");
    }

}