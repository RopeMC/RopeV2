package de.ropemc.rv2.api.minecraft.block;

import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.minecraft.block.material.Material;
import de.ropemc.rv2.api.minecraft.block.material.MaterialColor;

public class Block {

    private Wrapper wrapper;

    public Block(Object handle){
        wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().block(handle);
    }

    public Block(Properties properties){
        wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().block(properties);
    }

    public Wrapper getWrapper(){
        return wrapper;
    }

    public interface Wrapper {

    }

    public static class Properties {
        private Wrapper wrapper;
        public Properties(Object handle){
            wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().blockProperties(handle);
        }
        public Properties(Material material, MaterialColor materialColor){
            wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().blockProperties(material, materialColor);
        }
        public Wrapper getWrapper(){
            return wrapper;
        }
        public interface Wrapper {

        }
    }

}
