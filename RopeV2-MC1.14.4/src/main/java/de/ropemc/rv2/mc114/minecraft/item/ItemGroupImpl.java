package de.ropemc.rv2.mc114.minecraft.item;

import de.ropemc.rv2.api.minecraft.item.ItemGroup;
import de.ropemc.rv2.util.ReflectAccessor;

public class ItemGroupImpl {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("bba");

    private static int fBuildingBlocks = accessor.getFieldAccess().getIndex("b");
    private static int fDecorations = accessor.getFieldAccess().getIndex("c");
    private static int fRedstone = accessor.getFieldAccess().getIndex("d");
    private static int fTransportation = accessor.getFieldAccess().getIndex("e");
    private static int fMisc = accessor.getFieldAccess().getIndex("f");
    private static int fSearch = accessor.getFieldAccess().getIndex("g");
    private static int fFood = accessor.getFieldAccess().getIndex("h");
    private static int fTools = accessor.getFieldAccess().getIndex("i");
    private static int fCombat = accessor.getFieldAccess().getIndex("j");
    private static int fBrewing = accessor.getFieldAccess().getIndex("k");
    private static int fHotbar = accessor.getFieldAccess().getIndex("m");

    public static Class<?> getClazz(){
        return accessor.getClazz();
    }

    public static Object get(ItemGroup itemGroup){
        int field = -1;
        switch (itemGroup){
            case BUILDING_BLOCKS:
                field = fBuildingBlocks;
                break;
            case DECORATIONS:
                field = fDecorations;
                break;
            case REDSTONE:
                field = fRedstone;
                break;
            case TRANSPORTATION:
                field = fTransportation;
                break;
            case MISC:
                field = fMisc;
                break;
            case SEARCH:
                field = fSearch;
                break;
            case FOOD:
                field = fFood;
                break;
            case TOOLS:
                field = fTools;
                break;
            case COMBAT:
                field = fCombat;
                break;
            case BREWING:
                field = fBrewing;
                break;
            case HOTBAR:
                field = fHotbar;
                break;
        }
        if(field == -1)
            return null;
        return accessor.getFieldAccess().get(null, field);
    }

    /*
    BUILDING_BLOCKS,
    DECORATIONS,
    REDSTONE,
    TRANSPORTATION,
    MISC,
    SEARCH,
    FOOD,
    TOOLS,
    COMBAT,
    BREWING,
    HOTBAR
    */

}
