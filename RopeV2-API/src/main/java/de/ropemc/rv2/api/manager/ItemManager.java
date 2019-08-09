package de.ropemc.rv2.api.manager;

import de.ropemc.rv2.api.minecraft.item.Item;
import de.ropemc.rv2.api.mod.Mod;

public interface ItemManager {

    Item register(Mod mod, String id, Item item);

}
