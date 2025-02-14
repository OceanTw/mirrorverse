package dev.ocean.mirrorverse.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@UtilityClass
public class ItemUtils {

    public ItemStack getSetupWand() {
        ItemStack itemStack = new ItemStack(Material.BLAZE_ROD);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.handle("&5&lSetup Wand"));
        itemStack.setItemMeta(itemMeta);
        ConsoleUtils.debug("Created setup wand item.");
        return itemStack;
    }
}
