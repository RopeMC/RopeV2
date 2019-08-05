package de.ropemc.rv2.api.minecraft.util.math;

import de.ropemc.rv2.api.Rope;

public class Vec3d {

    private Wrapper wrapper;

    public Vec3d(double x, double y, double z){
        this.wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().vec3d(x,y,z);
    }

    public Vec3d(Object handle){
        this.wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().vec3d(handle);
    }

    public double getX(){
        return wrapper.getX();
    }

    public double getY(){
        return wrapper.getY();
    }

    public double getZ(){
        return wrapper.getZ();
    }

    public Wrapper getWrapper(){
        return wrapper;
    }

    public interface Wrapper {
        double getX();
        double getY();
        double getZ();
        Object getHandle();
    }

}
