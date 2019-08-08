package de.ropemc.rv2.api.minecraft.util;

import de.ropemc.rv2.api.Rope;

public class ResourceLocation {

    private Wrapper wrapper;

    public ResourceLocation(String id){
        wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().resourceLocation(id);
    }

    public ResourceLocation(String group, String id){
        wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().resourceLocation(group, id);
    }

    public ResourceLocation(Object handle){
        wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().resourceLocation(handle);
    }

    public Wrapper getWrapper(){
        return wrapper;
    }

    public interface Wrapper {

    }

}
