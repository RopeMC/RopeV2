package de.ropemc.rv2.api.manager;

import de.ropemc.rv2.api.minecraft.block.Block;
import de.ropemc.rv2.api.mod.Mod;

public interface BlockManager {

    Block register(Mod mod, String id, Block block);

}
