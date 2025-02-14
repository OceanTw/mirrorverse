package dev.ocean.mirrorverse.mirrors.impl;

import dev.ocean.mirrorverse.mirrors.Mirror;
import dev.ocean.mirrorverse.utils.ConsoleUtils;
import dev.ocean.mirrorverse.utils.RegionUtils;
import org.bukkit.Location;

public class NormalMirror extends Mirror {
    @Override
    public void createMirror() {
        ConsoleUtils.debug("Creating normal mirror...");
        int x1 = pos1.getBlockX(), y1 = pos1.getBlockY(), z1 = pos1.getBlockZ();
        int x2 = pos2.getBlockX(), y2 = pos2.getBlockY(), z2 = pos2.getBlockZ();

        int mirrorLineX = (x1 + x2) / 2;
        int mirrorLineY = (y1 + y2) / 2;
        int mirrorLineZ = (z1 + z2) / 2;
        for (Location location : RegionUtils.getBlocks(pos1, pos2)) {
            Location mirrorLocation = location.clone().add(mirrorLineX - location.getBlockX(), mirrorLineY - location.getBlockY(), mirrorLineZ - location.getBlockZ());
            location.getBlock().setType(mirrorLocation.getBlock().getType());
            ConsoleUtils.debug("Mirrored block at " + location + " to " + mirrorLocation);
        }
    }
}
