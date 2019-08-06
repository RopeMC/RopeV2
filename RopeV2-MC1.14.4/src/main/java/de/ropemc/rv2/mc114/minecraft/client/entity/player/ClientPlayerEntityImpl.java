package de.ropemc.rv2.mc114.minecraft.client.entity.player;

import de.ropemc.rv2.api.minecraft.client.entity.player.ClientPlayerEntity;
import de.ropemc.rv2.api.minecraft.util.text.ITextComponent;
import de.ropemc.rv2.util.ReflectAccessor;

public class ClientPlayerEntityImpl extends AbstractClientPlayerEntityImpl implements ClientPlayerEntity {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("dmp");

    private static int mSendMessage;

    static {
        try {
            mSendMessage = accessor.getMethodAccess().getIndex("a", Class.forName("jo"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ClientPlayerEntityImpl(Object handle) {
        super(handle);
    }

    public void sendMessage(ITextComponent text) {
        accessor.getMethodAccess().invoke(this.handle, mSendMessage, text.getHandle());
    }
}
