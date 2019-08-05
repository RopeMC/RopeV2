package de.ropemc.rv2.core.mod;

public interface Mod {
    default void onEnable() {}
    default void onDisable() {}
    ModInfo modInfo();
}
