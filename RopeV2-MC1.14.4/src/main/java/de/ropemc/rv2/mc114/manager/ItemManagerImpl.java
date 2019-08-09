package de.ropemc.rv2.mc114.manager;

import de.ropemc.rv2.api.manager.ItemManager;
import de.ropemc.rv2.api.minecraft.item.Item;
import de.ropemc.rv2.api.minecraft.util.ResourceLocation;
import de.ropemc.rv2.api.minecraft.util.registry.Registry;
import de.ropemc.rv2.api.mod.Mod;

import java.util.HashMap;
import java.util.Map;

public class ItemManagerImpl implements ItemManager {

    private boolean ready = false;
    private Map<ResourceLocation, Item> waiting = new HashMap<>();

    public Item register(Mod mod, String id, Item item){
        ResourceLocation location = new ResourceLocation(mod.modInfo().getId(), id);
        if(!ready){
            waiting.put(location, item);
            return item;
        }
        return Registry.register(location, item);
    }

    public void ready(){
        ready = true;
        for(ResourceLocation location : waiting.keySet()){
            Registry.register(location, waiting.get(location));
        }
        waiting.clear();
    }

}
