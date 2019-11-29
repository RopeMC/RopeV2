package de.ropemc.rv2.api.minecraft.util.math;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.Rope;
import lombok.Getter;
import lombok.experimental.Delegate;

public class Vec3d {

    private static MinecraftWrapperFactory getMinecraftWrapperFactory(){
        return Rope.getRopeMC().getImplementation(MinecraftWrapperFactory.class);
    }

    @Delegate
    @Getter
    private Wrapper wrapper;

    public Vec3d(double x, double y, double z){
        this.wrapper = getMinecraftWrapperFactory().vec3d(x,y,z);
    }

    public Vec3d(Object handle){
        this.wrapper = getMinecraftWrapperFactory().vec3d(handle);
    }

    public interface Wrapper {
        double getX();
        double getY();
        double getZ();
        Object getHandle();
    }

}
