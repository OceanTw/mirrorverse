package dev.ocean.mirrorverse.mirrors;

import lombok.Getter;

import java.util.List;

@Getter
public class MirrorManager {
    List<Mirror> mirrors;

    public void addMirror(Mirror region) {
        mirrors.add(region);
    }

}
