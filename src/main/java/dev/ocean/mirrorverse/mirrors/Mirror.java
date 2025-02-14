package dev.ocean.mirrorverse.mirrors;

import dev.ocean.mirrorverse.utils.ConsoleUtils;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

import java.io.Console;

@Getter
@Setter
public abstract class Mirror {
    public MirrorType mirrorType;
    public Location pos1;
    public Location pos2;

    public void setup() {
        if (pos1 == null || pos2 == null) {
            ConsoleUtils.error("You need to select two positions to create a mirror.");
            return;
        }
        createMirror();
    }

    public abstract void createMirror();
}
