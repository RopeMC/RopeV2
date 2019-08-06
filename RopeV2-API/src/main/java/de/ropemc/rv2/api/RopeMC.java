package de.ropemc.rv2.api;

import de.ropemc.rv2.api.event.EventBus;
import de.ropemc.rv2.api.minecraft.client.Minecraft;
import de.ropemc.rv2.api.mod.ModLoader;

public interface RopeMC {

    Minecraft getMinecraft();
    EventBus getEventBus();
    void addTransformer(ClassTransformer transformer);
    ModLoader getModLoader();
    MinecraftWrapperFactory getMinecraftWrapperFactory();

}
