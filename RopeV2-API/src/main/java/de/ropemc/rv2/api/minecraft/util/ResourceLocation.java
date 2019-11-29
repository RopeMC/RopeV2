package de.ropemc.rv2.api.minecraft.util;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.Rope;
import lombok.Getter;
import lombok.experimental.Delegate;

public class ResourceLocation {

    private static MinecraftWrapperFactory getMinecraftWrapperFactory(){
        return Rope.getRopeMC().getImplementation(MinecraftWrapperFactory.class);
    }

    @Delegate
    @Getter
    private Wrapper wrapper;

    public ResourceLocation(String id){
        wrapper = getMinecraftWrapperFactory().resourceLocation(id);
    }

    public ResourceLocation(String group, String id){
        wrapper = getMinecraftWrapperFactory().resourceLocation(group, id);
    }

    public ResourceLocation(Object handle){
        wrapper = getMinecraftWrapperFactory().resourceLocation(handle);
    }

    public interface Wrapper {
        String getNamespace();
        String getPath();
    }

}
