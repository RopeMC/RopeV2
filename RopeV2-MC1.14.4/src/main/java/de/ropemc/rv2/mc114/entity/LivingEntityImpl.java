package de.ropemc.rv2.mc114.entity;

import de.ropemc.rv2.api.entity.LivingEntity;
import de.ropemc.rv2.util.ReflectAccessor;

public class LivingEntityImpl extends EntityImpl implements LivingEntity {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("aix");

    private static int mGetHealth = accessor.getMethodAcess().getIndex("cD");
    private static int mSetHealth = accessor.getMethodAcess().getIndex("c");

    public LivingEntityImpl(Object handle) {
        super(handle);
    }

    public int getHurtTime() {
        return 0;
    }

    public float getHealth() {
        return float.class.cast(accessor.getMethodAcess().invoke(this.handle, mGetHealth));
    }

    public void setHealth(float health) {
        accessor.getMethodAcess().invoke(this.handle, mSetHealth,  health);
    }
}
