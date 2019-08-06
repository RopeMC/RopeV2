package de.ropemc.rv2.api.mod;

public interface Mod {
    default void onLoad() {}
    default void onEnable() {}
    default void onDisable() {}
    ModInfo modInfo();
}
