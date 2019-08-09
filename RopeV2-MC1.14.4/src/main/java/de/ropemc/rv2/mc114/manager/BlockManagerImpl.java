package de.ropemc.rv2.mc114.manager;

import de.ropemc.rv2.api.manager.BlockManager;
import de.ropemc.rv2.api.minecraft.block.Block;
import de.ropemc.rv2.api.minecraft.util.ResourceLocation;
import de.ropemc.rv2.api.minecraft.util.registry.Registry;
import de.ropemc.rv2.api.mod.Mod;

public class BlockManagerImpl implements BlockManager {

    public Block register(Mod mod, String id, Block block){
        ResourceLocation location = new ResourceLocation(mod.modInfo().getId(), id);
        return Registry.register(location, block);
    }

}
