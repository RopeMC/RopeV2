package de.ropemc.rv2.api;

import de.ropemc.rv2.api.minecraft.block.Block;
import de.ropemc.rv2.api.minecraft.block.material.Material;
import de.ropemc.rv2.api.minecraft.block.material.MaterialColor;
import de.ropemc.rv2.api.minecraft.client.gui.screen.inventory.InventoryScreen;
import de.ropemc.rv2.api.minecraft.item.Item;
import de.ropemc.rv2.api.minecraft.util.DamageSource;
import de.ropemc.rv2.api.minecraft.util.ResourceLocation;
import de.ropemc.rv2.api.minecraft.util.math.Vec3d;
import de.ropemc.rv2.api.minecraft.util.math.Vec3i;
import de.ropemc.rv2.api.minecraft.util.text.StringTextComponent;

public interface MinecraftWrapperFactory {

    Vec3d.Wrapper vec3d(double x, double y, double z);
    Vec3d.Wrapper vec3d(Object handle);

    Vec3i.Wrapper vec3i(int x, int y, int z);
    Vec3i.Wrapper vec3i(double x, double y, double z);
    Vec3i.Wrapper vec3i(Object handle);

    StringTextComponent.Wrapper stringTextComponent(String text);
    StringTextComponent.Wrapper stringTextComponent(Object handle);

    DamageSource.Wrapper damageSource(String name);
    DamageSource.Wrapper damageSource(Object handle);

    Item.Wrapper item(Item.Properties properties);
    Item.Wrapper item(Object handle);

    Item.Properties.Wrapper itemProperties();
    Item.Properties.Wrapper itemProperties(Object handle);

    Block.Wrapper block(Block.Properties properties);
    Block.Wrapper block(Object handle);

    Block.Properties.Wrapper blockProperties(Material material, MaterialColor materialColor);
    Block.Properties.Wrapper blockProperties(Object handle);

    ResourceLocation.Wrapper resourceLocation(String id);
    ResourceLocation.Wrapper resourceLocation(String group, String id);
    ResourceLocation.Wrapper resourceLocation(Object handle);

}
