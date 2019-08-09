package de.ropemc.rv2.mc114.manager;

import de.ropemc.rv2.api.manager.ItemManager;
import de.ropemc.rv2.api.minecraft.item.Item;
import de.ropemc.rv2.api.minecraft.util.ResourceLocation;
import de.ropemc.rv2.api.minecraft.util.registry.Registry;
import de.ropemc.rv2.api.mod.Mod;

public class ItemManagerImpl implements ItemManager {

    public Item register(Mod mod, String id, Item item){
        ResourceLocation location = new ResourceLocation(mod.modInfo().getId(), id);
        return Registry.register(location, item);
    }

}
