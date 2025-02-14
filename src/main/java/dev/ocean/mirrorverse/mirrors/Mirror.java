package dev.ocean.mirrorverse.regions;

import dev.ocean.mirrorverse.mirrors.MirrorType;
import dev.ocean.mirrorverse.utils.ConsoleUtils;
import dev.ocean.mirrorverse.utils.RegionUtils;
import org.bukkit.Location;

import java.util.Map;
import java.util.Set;

public abstract class Region {
    private MirrorType mirrorType;
    private Location pos1;
    private Location pos2;
    private Map<RegionPart, RegionPart> reflections;
}
