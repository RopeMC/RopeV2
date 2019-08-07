package de.ropemc.rv2.mc114.minecraft.entity.player;

import de.ropemc.rv2.api.minecraft.entity.player.PlayerEntity;
import de.ropemc.rv2.mc114.minecraft.entity.LivingEntityImpl;
import de.ropemc.rv2.util.ReflectAccessor;

public class PlayerEntityImpl extends LivingEntityImpl implements PlayerEntity {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("awg");

    private static int mCanAttackPlayer;

    static {
        try {
            mCanAttackPlayer = accessor.getMethodAccess().getIndex("a", Class.forName("awg"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PlayerEntityImpl(Object handle) {
        super(handle);
    }

    public boolean canAttackPlayer(PlayerEntity other) {
        return (boolean) accessor.getMethodAccess().invoke(this.handle, mCanAttackPlayer, other);
    }
}
