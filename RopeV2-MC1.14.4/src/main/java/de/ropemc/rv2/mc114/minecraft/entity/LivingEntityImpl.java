package de.ropemc.rv2.mc114.minecraft.entity;

import de.ropemc.rv2.api.minecraft.entity.LivingEntity;
import de.ropemc.rv2.util.ReflectAccessor;

public class LivingEntityImpl extends EntityImpl implements LivingEntity {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("aix");

    private static int mGetHealth = accessor.getMethodAccess().getIndex("cD");
    private static int mSetHealth = accessor.getMethodAccess().getIndex("c", float.class);
    private static int fHurtTime = accessor.getFieldAccess().getIndex("ax");

    public LivingEntityImpl(Object handle) {
        super(handle);
    }

    public int getHurtTime() {
        return (int) accessor.getFieldAccess().get(this.handle, fHurtTime);
    }

    public float getHealth() {
        return (float) accessor.getMethodAccess().invoke(this.handle, mGetHealth);
    }

    public void setHealth(float health) {
        accessor.getMethodAccess().invoke(this.handle, mSetHealth, health);
    }
}
