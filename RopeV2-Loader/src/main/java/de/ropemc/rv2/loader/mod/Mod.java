package de.ropemc.rv2.loader.mod;

public interface Mod {
    default void onEnable() {}
    default void onDisable() {}
    ModInfo modInfo();
}
