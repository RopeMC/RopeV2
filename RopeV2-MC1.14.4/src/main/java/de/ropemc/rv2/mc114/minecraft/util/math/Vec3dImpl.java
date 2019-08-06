package de.ropemc.rv2.mc114.minecraft.util.math;

import de.ropemc.rv2.api.minecraft.util.math.Vec3d;
import de.ropemc.rv2.util.ReflectAccessor;

public class Vec3dImpl implements Vec3d.Wrapper {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("csi");

    private static int cVec3d = accessor.getConstructorAccess().getIndex(double.class, double.class, double.class);
    private static int mGetX = accessor.getMethodAccess().getIndex("a", new Class[0]);
    private static int mGetY = accessor.getMethodAccess().getIndex("b", new Class[0]);
    private static int mGetZ = accessor.getMethodAccess().getIndex("c", new Class[0]);

    private Object handle;

    public Vec3dImpl(Object handle) {
        this.handle = handle;
    }

    public Vec3dImpl(double x, double y, double z){
        this.handle = accessor.getConstructorAccess().newInstance(cVec3d, x, y, z);
    }

    public double getX() {
        return (double) accessor.getMethodAccess().invoke(handle, mGetX);
    }
    public double getY() {
        return (double) accessor.getMethodAccess().invoke(handle, mGetY);
    }
    public double getZ() {
        return (double) accessor.getMethodAccess().invoke(handle, mGetZ);
    }

    public Object getHandle() {
        return handle;
    }
}
