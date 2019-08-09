package de.ropemc.rv2.api;

import de.ropemc.rv2.api.event.EventBus;
import de.ropemc.rv2.api.manager.BlockManager;
import de.ropemc.rv2.api.manager.ItemManager;
import de.ropemc.rv2.api.minecraft.client.Minecraft;
import de.ropemc.rv2.api.mod.ModLoader;

public interface RopeMC {

    Minecraft getMinecraft();
    EventBus getEventBus();
    void addTransformer(ClassTransformer transformer);
    ModLoader getModLoader();
    <T> T getImplementation(Class<T> interfaceClass);
    BlockManager getBlockManager();
    ItemManager getItemManager();

}
