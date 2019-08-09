package de.ropemc.rv2.api.minecraft.block;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.minecraft.block.material.Material;
import de.ropemc.rv2.api.minecraft.block.material.MaterialColor;

public class Block {

    private static MinecraftWrapperFactory getMinecraftWrapperFactory(){
        return Rope.getRopeMC().getImplementation(MinecraftWrapperFactory.class);
    }

    private Wrapper wrapper;

    public Block(Object handle){
        wrapper = getMinecraftWrapperFactory().block(handle);
    }

    public Block(Properties properties){
        wrapper = getMinecraftWrapperFactory().block(properties);
    }

    public Wrapper getWrapper(){
        return wrapper;
    }

    public interface Wrapper {

    }

    public static class Properties {
        private Wrapper wrapper;
        public Properties(Object handle){
            wrapper = getMinecraftWrapperFactory().blockProperties(handle);
        }
        public Properties(Material material, MaterialColor materialColor){
            wrapper = getMinecraftWrapperFactory().blockProperties(material, materialColor);
        }
        public Wrapper getWrapper(){
            return wrapper;
        }
        public interface Wrapper {

        }
    }

}
