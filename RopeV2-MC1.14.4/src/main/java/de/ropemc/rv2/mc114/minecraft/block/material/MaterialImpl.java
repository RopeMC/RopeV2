package de.ropemc.rv2.mc114.minecraft.block.material;

import de.ropemc.rv2.api.minecraft.block.material.Material;
import de.ropemc.rv2.util.ReflectAccessor;

public enum MaterialImpl {
    AIR(accessor().getFieldAccess().getIndex("a")),
    STRUCTURE_VOID(accessor().getFieldAccess().getIndex("b")),
    PORTAL(accessor().getFieldAccess().getIndex("c")),
    CARPET(accessor().getFieldAccess().getIndex("d")),
    PLANTS(accessor().getFieldAccess().getIndex("e")),
    OCEAN_PLANT(accessor().getFieldAccess().getIndex("f")),
    TALL_PLANTS(accessor().getFieldAccess().getIndex("g")),
    SEA_GRASS(accessor().getFieldAccess().getIndex("h")),
    WATER(accessor().getFieldAccess().getIndex("i")),
    BUBBLE_COLUMN(accessor().getFieldAccess().getIndex("j")),
    LAVA(accessor().getFieldAccess().getIndex("k")),
    SNOW(accessor().getFieldAccess().getIndex("l")),
    FIRE(accessor().getFieldAccess().getIndex("m")),
    MISCELLANEOUS(accessor().getFieldAccess().getIndex("n")),
    WEB(accessor().getFieldAccess().getIndex("o")),
    REDSTONE_LIGHT(accessor().getFieldAccess().getIndex("p")),
    CLAY(accessor().getFieldAccess().getIndex("q")),
    EARTH(accessor().getFieldAccess().getIndex("r")),
    ORGANIC(accessor().getFieldAccess().getIndex("s")),
    PACKED_ICE(accessor().getFieldAccess().getIndex("t")),
    SAND(accessor().getFieldAccess().getIndex("u")),
    SPONGE(accessor().getFieldAccess().getIndex("v")),
    SHULKER(accessor().getFieldAccess().getIndex("w")),
    WOOD(accessor().getFieldAccess().getIndex("x")),
    BAMBOO_SAPLING(accessor().getFieldAccess().getIndex("y")),
    BAMBOO(accessor().getFieldAccess().getIndex("z")),
    WOOL(accessor().getFieldAccess().getIndex("A")),
    TNT(accessor().getFieldAccess().getIndex("B")),
    LEAVES(accessor().getFieldAccess().getIndex("C")),
    GLASS(accessor().getFieldAccess().getIndex("D")),
    ICE(accessor().getFieldAccess().getIndex("E")),
    CACTUS(accessor().getFieldAccess().getIndex("F")),
    ROCK(accessor().getFieldAccess().getIndex("G")),
    IRON(accessor().getFieldAccess().getIndex("H")),
    SNOW_BLOCK(accessor().getFieldAccess().getIndex("I")),
    ANVIL(accessor().getFieldAccess().getIndex("J")),
    BARRIER(accessor().getFieldAccess().getIndex("K")),
    PISTON(accessor().getFieldAccess().getIndex("L")),
    CORAL(accessor().getFieldAccess().getIndex("M")),
    GOURD(accessor().getFieldAccess().getIndex("N")),
    DRAGON_EGG(accessor().getFieldAccess().getIndex("O")),
    CAKE(accessor().getFieldAccess().getIndex("P"));
    private static ReflectAccessor accessor;
    private static ReflectAccessor accessor(){
        if(accessor == null){
            accessor = ReflectAccessor.getByName("clo");
        }
        return accessor;
    }
    public static Class<?> getClazz(){
        return accessor.getClazz();
    }
    private Material material;
    private int field;
    MaterialImpl(int field){
        this.field = field;
        this.material = Material.valueOf(this.toString());
    }
    public Material getMaterial(){
        return material;
    }
    public Object getValue(){
        return accessor.getFieldAccess().get(null, field);
    }
    public static MaterialImpl get(Material material){
        for(MaterialImpl m : values()){
            if(m.getMaterial().equals(material)){
                return m;
            }
        }
        return null;
    }
    public static Object getValue(Material material){
        MaterialImpl m = get(material);
        if(m == null)
            return null;
        return m.getValue();
    }
}
