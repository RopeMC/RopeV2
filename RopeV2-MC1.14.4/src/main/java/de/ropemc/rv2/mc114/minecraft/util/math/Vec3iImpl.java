package de.ropemc.rv2.mc114.minecraft.util.math;

import de.ropemc.rv2.api.minecraft.util.math.Vec3i;
import de.ropemc.rv2.util.ReflectAccessor;

public class Vec3iImpl implements Vec3i.Wrapper {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("fs");

    private static int cVec3ii = accessor.getConstructorAccess().getIndex(int.class, int.class, int.class);
    private static int cVec3id = accessor.getConstructorAccess().getIndex(double.class, double.class, double.class);
    private static int mGetX = accessor.getMethodAccess().getIndex("o", new Class[0]);
    private static int mGetY = accessor.getMethodAccess().getIndex("p", new Class[0]);
    private static int mGetZ = accessor.getMethodAccess().getIndex("q", new Class[0]);

    protected Object handle;

    public Vec3iImpl(Object handle) {
        this.handle = handle;
    }

    public Vec3iImpl(int x, int y, int z){
        this.handle = accessor.getConstructorAccess().newInstance(cVec3ii, x, y, z);
    }

    public Vec3iImpl(double x, double y, double z){
        this.handle = accessor.getConstructorAccess().newInstance(cVec3id, x, y, z);
    }

    public int getX() {
        return (int) accessor.getMethodAccess().invoke(handle, mGetX);
    }

    public int getY() {
        return (int) accessor.getMethodAccess().invoke(handle, mGetY);
    }

    public int getZ() {
        return (int) accessor.getMethodAccess().invoke(handle, mGetZ);
    }

    public Object getHandle() {
        return handle;
    }
}
