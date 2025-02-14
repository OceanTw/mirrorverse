package dev.ocean.mirrorverse.utils;

import dev.ocean.mirrorverse.configs.impl.SettingsLocale;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

@UtilityClass
public class ConsoleUtils {

    public static void info(String message) {
        log(ChatColor.BLUE + "[INFO] " + message);
    }

    public static void warn(String message) {
        log(ChatColor.YELLOW + "[WARN] " + message);
    }

    public static void error(String message) {
        log(ChatColor.RED + "[ERROR] " + message);
    }

    public static void debug(String message) {
        if (SettingsLocale.DEBUG.getBoolean()) {
            log(ChatColor.GRAY + "[DEBUG] " + message);
        }
    }

    private static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}