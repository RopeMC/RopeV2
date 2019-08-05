package de.ropemc.rv2.api;

import de.ropemc.rv2.api.event.EventBus;
import de.ropemc.rv2.api.minecraft.client.Minecraft;

public class Rope {

    private static RopeMC ropeMC = null;

    public static RopeMC getRopeMC(){
        return ropeMC;
    }

    public static Minecraft getMinecraft(){
        return getRopeMC().getMinecraft();
    }

    public static EventBus getEventBus(){
        return getRopeMC().getEventBus();
    }

}
