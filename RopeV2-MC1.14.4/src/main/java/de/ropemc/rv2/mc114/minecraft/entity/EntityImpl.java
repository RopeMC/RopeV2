package de.ropemc.rv2.mc114.minecraft.entity;

import de.ropemc.rv2.api.minecraft.entity.Entity;
import de.ropemc.rv2.api.minecraft.util.math.Vec3d;
import de.ropemc.rv2.mc114.minecraft.util.math.Vec3dImpl;
import de.ropemc.rv2.util.ReflectAccessor;

// Method Access should be replaced with field access in case of motion
public class EntityImpl implements Entity {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("aio");

    private static int mGetMotion = accessor.getMethodAccess().getIndex("cj");
    private static int mSetMotion;

    static {
        try {
            mSetMotion = accessor.getMethodAccess().getIndex("d", Class.forName("csi"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Object handle;

    public EntityImpl(Object handle) {
        this.handle = handle;
    }

    public boolean isOnGround() {
        return false;
    }

    public Vec3d getMotion() {
        return new Vec3d(accessor.getMethodAccess().invoke(handle, mGetMotion));
    }

    public void setMotion(Vec3d motion){
        accessor.getMethodAccess().invoke(this.handle, mSetMotion, motion.getWrapper().getHandle());
    }
}
