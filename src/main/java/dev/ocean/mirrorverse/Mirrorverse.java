package dev.ocean.mirrorverse;

import dev.ocean.mirrorverse.commands.SetupCommand;
import dev.ocean.mirrorverse.configs.ConfigService;
import dev.ocean.mirrorverse.listeners.EntityListener;
import dev.ocean.mirrorverse.mirrors.MirrorManager;
import dev.ocean.mirrorverse.selections.Selection;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Mirrorverse extends JavaPlugin {

    @Getter
    private static Mirrorverse instance;

    private MirrorManager mirrorManager;
    private Selection selection;

    @Override
    public void onEnable() {
        instance = this;
        mirrorManager = new MirrorManager();
        selection = new Selection();
        new ConfigService().load();

        getCommand("setup").setExecutor(new SetupCommand());
        getServer().getPluginManager().registerEvents(new EntityListener(), this);
        getLogger().info("Mirrorverse has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Mirrorverse has been disabled!");
    }

}