package de.ropemc.rv2.api.minecraft.item;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.minecraft.block.Block;

public class BlockItem extends Item {

    public BlockItem(Block blockIn, Item.Properties properties){
        super(Rope.getRopeMC().getImplementation(MinecraftWrapperFactory.class).blockItem(blockIn, properties));
    }

    public BlockItem(Object handle){
        super(Rope.getRopeMC().getImplementation(MinecraftWrapperFactory.class).blockItem(handle));
    }

    public Wrapper getWrapper(){
        return (Wrapper) wrapper;
    }

    public interface Wrapper extends Item.Wrapper {

    }



}
