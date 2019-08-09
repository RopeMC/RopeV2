package de.ropemc.rv2.mc114.manager;

import de.ropemc.rv2.api.manager.BlockManager;
import de.ropemc.rv2.api.minecraft.block.Block;
import de.ropemc.rv2.api.minecraft.util.ResourceLocation;
import de.ropemc.rv2.api.minecraft.util.registry.Registry;
import de.ropemc.rv2.api.mod.Mod;

import java.util.HashMap;
import java.util.Map;

public class BlockManagerImpl implements BlockManager {

    private boolean ready = false;
    private Map<ResourceLocation, Block> waiting = new HashMap<>();

    public Block register(Mod mod, String id, Block block){
        ResourceLocation location = new ResourceLocation(mod.modInfo().getId(), id);
        if(!ready){
            waiting.put(location, block);
            return block;
        }
        return Registry.register(location, block);
    }

    public void ready(){
        ready = true;
        for(ResourceLocation location : waiting.keySet()){
            Registry.register(location, waiting.get(location));
        }
        waiting.clear();
    }

}
