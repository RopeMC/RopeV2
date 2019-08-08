package de.ropemc.rv2.api.minecraft.util.registry;

import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.minecraft.block.Block;
import de.ropemc.rv2.api.minecraft.item.Item;
import de.ropemc.rv2.api.minecraft.util.ResourceLocation;

public interface Registry {

    static Item register(ResourceLocation resourceLocation, Item item){
        return Rope.getRopeMC().getImplementation(Static.class).register(resourceLocation, item);
    }

    static Block register(ResourceLocation resourceLocation, Block block){
        return Rope.getRopeMC().getImplementation(Static.class).register(resourceLocation, block);
    }

    interface Static {
        Item register(ResourceLocation resourceLocation, Item item);
        Block register(ResourceLocation resourceLocation, Block block);
    }

}
