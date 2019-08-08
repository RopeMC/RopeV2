package de.ropemc.rv2.mc114.minecraft.block.material;

import de.ropemc.rv2.api.minecraft.block.material.MaterialColor;
import de.ropemc.rv2.util.ReflectAccessor;

public enum MaterialColorImpl {
    AIR(accessor().getFieldAccess().getIndex("b")),
    GRASS(accessor().getFieldAccess().getIndex("c")),
    SAND(accessor().getFieldAccess().getIndex("d")),
    WOOL(accessor().getFieldAccess().getIndex("e")),
    TNT(accessor().getFieldAccess().getIndex("f")),
    ICE(accessor().getFieldAccess().getIndex("g")),
    IRON(accessor().getFieldAccess().getIndex("h")),
    FOLIAGE(accessor().getFieldAccess().getIndex("i")),
    SNOW(accessor().getFieldAccess().getIndex("j")),
    CLAY(accessor().getFieldAccess().getIndex("k")),
    DIRT(accessor().getFieldAccess().getIndex("l")),
    STONE(accessor().getFieldAccess().getIndex("m")),
    WATER(accessor().getFieldAccess().getIndex("n")),
    WOOD(accessor().getFieldAccess().getIndex("o")),
    QUARTZ(accessor().getFieldAccess().getIndex("p")),
    ADOBE(accessor().getFieldAccess().getIndex("q")),
    MAGENTA(accessor().getFieldAccess().getIndex("r")),
    LIGHT_BLUE(accessor().getFieldAccess().getIndex("s")),
    YELLOW(accessor().getFieldAccess().getIndex("t")),
    LIME(accessor().getFieldAccess().getIndex("u")),
    PINK(accessor().getFieldAccess().getIndex("v")),
    GRAY(accessor().getFieldAccess().getIndex("w")),
    LIGHT_GRAY(accessor().getFieldAccess().getIndex("x")),
    CYAN(accessor().getFieldAccess().getIndex("y")),
    PURPLE(accessor().getFieldAccess().getIndex("z")),
    BLUE(accessor().getFieldAccess().getIndex("A")),
    BROWN(accessor().getFieldAccess().getIndex("B")),
    GREEN(accessor().getFieldAccess().getIndex("C")),
    RED(accessor().getFieldAccess().getIndex("D")),
    BLACK(accessor().getFieldAccess().getIndex("E")),
    GOLD(accessor().getFieldAccess().getIndex("F")),
    DIAMOND(accessor().getFieldAccess().getIndex("G")),
    LAPIS(accessor().getFieldAccess().getIndex("H")),
    EMERALD(accessor().getFieldAccess().getIndex("I")),
    OBSIDIAN(accessor().getFieldAccess().getIndex("J")),
    NETHERRACK(accessor().getFieldAccess().getIndex("K")),
    WHITE_TERRACOTTA(accessor().getFieldAccess().getIndex("L")),
    ORANGE_TERRACOTTA(accessor().getFieldAccess().getIndex("M")),
    MAGENTA_TERRACOTTA(accessor().getFieldAccess().getIndex("N")),
    LIGHT_BLUE_TERRACOTTA(accessor().getFieldAccess().getIndex("O")),
    YELLOW_TERRACOTTA(accessor().getFieldAccess().getIndex("P")),
    LIME_TERRACOTTA(accessor().getFieldAccess().getIndex("Q")),
    PINK_TERRACOTTA(accessor().getFieldAccess().getIndex("R")),
    GRAY_TERRACOTTA(accessor().getFieldAccess().getIndex("S")),
    LIGHT_GRAY_TERRACOTTA(accessor().getFieldAccess().getIndex("T")),
    CYAN_TERRACOTTA(accessor().getFieldAccess().getIndex("U")),
    PURPLE_TERRACOTTA(accessor().getFieldAccess().getIndex("V")),
    BLUE_TERRACOTTA(accessor().getFieldAccess().getIndex("W")),
    BROWN_TERRACOTTA(accessor().getFieldAccess().getIndex("X")),
    GREEN_TERRACOTTA(accessor().getFieldAccess().getIndex("Y")),
    RED_TERRACOTTA(accessor().getFieldAccess().getIndex("Z")),
    BLACK_TERRACOTTA(accessor().getFieldAccess().getIndex("aa"));
    private static ReflectAccessor accessor;
    private static ReflectAccessor accessor(){
        if(accessor == null){
            accessor = ReflectAccessor.getByName("clp");
        }
        return accessor;
    }
    public static Class<?> getClazz(){
        return accessor.getClazz();
    }
    private MaterialColor materialColor;
    private int field;
    MaterialColorImpl(int field){
        this.field = field;
        this.materialColor = MaterialColor.valueOf(this.toString());
    }
    public MaterialColor getMaterialColor(){
        return materialColor;
    }
    public Object getValue(){
        return accessor.getFieldAccess().get(null, field);
    }
    public static MaterialColorImpl get(MaterialColor material){
        for(MaterialColorImpl m : values()){
            if(m.getMaterialColor().equals(material)){
                return m;
            }
        }
        return null;
    }
    public static Object getValue(MaterialColor materialColor){
        MaterialColorImpl m = get(materialColor);
        if(m == null)
            return null;
        return m.getValue();
    }
}
