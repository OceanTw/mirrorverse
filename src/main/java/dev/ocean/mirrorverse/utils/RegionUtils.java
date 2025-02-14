package dev.ocean.mirrorverse.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class RegionUtils {

    public List<Location> getBlocks(Location pos1, Location pos2) {
        List<Location> blocks = new ArrayList<>();
        int minX = Math.min(pos1.getBlockX(), pos2.getBlockX());
        int minY = Math.min(pos1.getBlockY(), pos2.getBlockY());
        int minZ = Math.min(pos1.getBlockZ(), pos2.getBlockZ());

        int maxX = Math.max(pos1.getBlockX(), pos2.getBlockX());
        int maxY = Math.max(pos1.getBlockY(), pos2.getBlockY());
        int maxZ = Math.max(pos1.getBlockZ(), pos2.getBlockZ());

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    blocks.add(new Location(pos1.getWorld(), x, y, z));
                }
            }
        }
        return blocks;
    }

    public boolean isInRegion(Location pos, Location pos1, Location pos2) {
        if (pos1 == null || pos2 == null) {
            return false;
        }
        if (pos1.getBlockX() <= pos.getBlockX() && pos2.getBlockX() >= pos.getBlockX()) {
            if (pos1.getBlockY() <= pos.getBlockY() && pos2.getBlockY() >= pos.getBlockY()) {
                if (pos1.getBlockZ() <= pos.getBlockZ() && pos2.getBlockZ() >= pos.getBlockZ()) {
                    // Inside region

                    return true;
                }
            }
        }
        return false;
    }

}
