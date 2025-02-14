package dev.ocean.mirrorverse.listeners;

import dev.ocean.mirrorverse.Mirrorverse;
import dev.ocean.mirrorverse.selections.Selection;
import dev.ocean.mirrorverse.utils.StringUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class EntityListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Location location = event.getBlock().getLocation();
        if (player.getItemInHand() == null || !player.getItemInHand().hasItemMeta() || !player.getItemInHand().getItemMeta().hasDisplayName()) {
            return;
        }
        if (player.getItemInHand().getItemMeta().getDisplayName().contains("Setup Wand")) {
            Selection selection = Mirrorverse.getInstance().getSelection();
            selection.setPos1(location);
            player.sendMessage(StringUtils.handle("&aSelection 1 has been set!"));
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Location location = event.getClickedBlock().getLocation();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getItemInHand().getItemMeta().getDisplayName().contains("Setup Wand")) {
                Selection selection = Mirrorverse.getInstance().getSelection();
                selection.setPos2(location);
                player.sendMessage(StringUtils.handle("&aSelection 2 has been set!"));
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Location to = event.getTo();
    }
}
