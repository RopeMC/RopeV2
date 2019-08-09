package de.ropemc.rv2.mc114;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
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
import de.ropemc.rv2.mc114.minecraft.block.BlockImpl;
import de.ropemc.rv2.mc114.minecraft.item.ItemImpl;
import de.ropemc.rv2.mc114.minecraft.util.DamageSourceImpl;
import de.ropemc.rv2.mc114.minecraft.util.ResourceLocationImpl;
import de.ropemc.rv2.mc114.minecraft.util.math.Vec3dImpl;
import de.ropemc.rv2.mc114.minecraft.util.math.Vec3iImpl;
import de.ropemc.rv2.mc114.minecraft.util.text.StringTextComponentImpl;

public class MinecraftWrapperFactoryImpl implements MinecraftWrapperFactory {

    public Vec3d.Wrapper vec3d(double x, double y, double z) {
        return new Vec3dImpl(x, y, z);
    }
    public Vec3d.Wrapper vec3d(Object handle) {
        return new Vec3dImpl(handle);
    }

    public Vec3i.Wrapper vec3i(int x, int y, int z) {
        return new Vec3iImpl(x, y, z);
    }
    public Vec3i.Wrapper vec3i(double x, double y, double z) {
        return new Vec3iImpl(x, y, z);
    }
    public Vec3i.Wrapper vec3i(Object handle) {
        return new Vec3iImpl(handle);
    }

    public StringTextComponent.Wrapper stringTextComponent(String text) {
        return new StringTextComponentImpl(text);
    }
    public StringTextComponent.Wrapper stringTextComponent(Object handle) {
        return new StringTextComponentImpl(handle);
    }

    public DamageSource.Wrapper damageSource(String name) {
        return new DamageSourceImpl(name);
    }
    public DamageSource.Wrapper damageSource(Object handle) {
        return new DamageSourceImpl(handle);
    }

    public Item.Wrapper item(Item.Properties properties) {
        return new ItemImpl(properties);
    }
    public Item.Wrapper item(Object handle) {
        return new ItemImpl(handle);
    }

    public Item.Properties.Wrapper itemProperties() {
        return new ItemImpl.PropertiesImpl();
    }
    public Item.Properties.Wrapper itemProperties(Object handle) {
        return new ItemImpl.PropertiesImpl(handle);
    }

    public Block.Wrapper block(Block.Properties properties) {
        return new BlockImpl(properties);
    }
    public Block.Wrapper block(Object handle) {
        return new BlockImpl(handle);
    }

    public Block.Properties.Wrapper blockProperties(Material material, MaterialColor materialColor) {
        return new BlockImpl.PropertiesImpl(material, materialColor);
    }
    public Block.Properties.Wrapper blockProperties(Object handle) {
        return new BlockImpl.PropertiesImpl(handle);
    }

    public ResourceLocation.Wrapper resourceLocation(String id){
        return new ResourceLocationImpl(id);
    }
    public ResourceLocation.Wrapper resourceLocation(String group, String id){
        return new ResourceLocationImpl(group, id);
    }
    public ResourceLocation.Wrapper resourceLocation(Object handle){
        return new ResourceLocationImpl(handle);
    }

}
