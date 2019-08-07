package de.ropemc.rv2.mc114.minecraft.util;

import de.ropemc.rv2.api.minecraft.util.DamageSource;
import de.ropemc.rv2.util.ReflectAccessor;

public class DamageSourceImpl implements DamageSource.Wrapper {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("ahx");

    private static int cDamageSource = accessor.getConstructorAccess().getIndex(String.class);

    protected Object handle;

    public DamageSourceImpl(Object handle) {
        this.handle = handle;
    }

    public DamageSourceImpl(String name) {
        this.handle = accessor.getConstructorAccess().newInstance(cDamageSource, name);
    }

    public Object getHandle() {
        return handle;
    }
}
