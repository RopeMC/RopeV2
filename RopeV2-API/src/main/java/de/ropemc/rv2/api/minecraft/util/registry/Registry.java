package de.ropemc.rv2.api.minecraft.util.registry;

import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.minecraft.item.Item;
import de.ropemc.rv2.api.minecraft.util.ResourceLocation;

public interface Registry {

    static Item register(ResourceLocation resourceLocation, Item element){
        return Rope.getRopeMC().getImplementation(Static.class).register(resourceLocation, element);
    }

    interface Static {
        Item register(ResourceLocation resourceLocation, Item item);
    }

}
