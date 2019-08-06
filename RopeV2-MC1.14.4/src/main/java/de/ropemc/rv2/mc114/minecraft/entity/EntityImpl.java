package de.ropemc.rv2.mc114.minecraft.entity;

import de.ropemc.rv2.api.minecraft.entity.Entity;
import de.ropemc.rv2.api.minecraft.util.math.BlockPos;
import de.ropemc.rv2.api.minecraft.util.math.Vec3d;
import de.ropemc.rv2.api.minecraft.util.text.ITextComponent;
import de.ropemc.rv2.mc114.minecraft.util.math.Vec3dImpl;
import de.ropemc.rv2.util.ReflectAccessor;

// Method Access should be replaced with field access in case of motion
public class EntityImpl implements Entity {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("aio");

    private static int mGetMotion = accessor.getMethodAccess().getIndex("cj");
    private static int mSetMotion;
    private static int mSetFlag = accessor.getMethodAccess().getIndex("b", int.class, boolean.class);
    private static int mGetFlag = accessor.getMethodAccess().getIndex("i", int.class);
    private static int mIsGlowing = accessor.getMethodAccess().getIndex("bm", new Class[0]);
    private static int mSetGlowing = accessor.getMethodAccess().getIndex("h", boolean.class);
    private static int mGetPosition = accessor.getMethodAccess().getIndex("bO", new Class[0]);
    private static int mGetPositionVector = accessor.getMethodAccess().getIndex("bP", new Class[0]);

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

    public Vec3d getMotion() {
        return new Vec3d(accessor.getMethodAccess().invoke(handle, mGetMotion));
    }

    public void setMotion(Vec3d motion){
        accessor.getMethodAccess().invoke(this.handle, mSetMotion, motion.getWrapper().getHandle());
    }

    public boolean isGlowing() {
        return (boolean) accessor.getMethodAccess().invoke(this.handle, mIsGlowing);
    }

    public void setGlowing(boolean glowingIn) {
        accessor.getMethodAccess().invoke(this.handle, mSetGlowing, glowingIn);
    }

    public BlockPos getPosition() {
        return new BlockPos(accessor.getMethodAccess().invoke(this.handle, mGetPosition));
    }

    public Vec3d getPositionVector() {
        return new Vec3d(accessor.getMethodAccess().invoke(this.handle, mGetPositionVector));
    }

    public void setFlag(int flag, boolean state){
        accessor.getMethodAccess().invoke(this.handle, mSetFlag, flag, state);
    }

    public boolean getFlag(int flag){
        return (boolean) accessor.getMethodAccess().invoke(this.handle, mGetFlag, flag);
    }

    public void sendMessage(ITextComponent text) { }
}
