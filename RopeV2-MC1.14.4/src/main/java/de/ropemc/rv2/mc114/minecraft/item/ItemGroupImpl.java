package de.ropemc.rv2.mc114.minecraft.item;

import de.ropemc.rv2.api.minecraft.item.ItemGroup;
import de.ropemc.rv2.util.ReflectAccessor;

import java.util.HashMap;
import java.util.Map;

public class ItemGroupImpl {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("bba");

    private static Map<ItemGroup, Integer> relationMap = new HashMap<ItemGroup, Integer>() {{
        put(ItemGroup.BUILDING_BLOCKS, accessor.getFieldAccess().getIndex("b"));
        put(ItemGroup.DECORATIONS, accessor.getFieldAccess().getIndex("c"));
        put(ItemGroup.REDSTONE, accessor.getFieldAccess().getIndex("d"));
        put(ItemGroup.TRANSPORTATION, accessor.getFieldAccess().getIndex("e"));
        put(ItemGroup.MISC, accessor.getFieldAccess().getIndex("f"));
        put(ItemGroup.SEARCH, accessor.getFieldAccess().getIndex("g"));
        put(ItemGroup.FOOD, accessor.getFieldAccess().getIndex("h"));
        put(ItemGroup.TOOLS, accessor.getFieldAccess().getIndex("i"));
        put(ItemGroup.COMBAT, accessor.getFieldAccess().getIndex("j"));
        put(ItemGroup.BREWING, accessor.getFieldAccess().getIndex("k"));
        put(ItemGroup.HOTBAR, accessor.getFieldAccess().getIndex("m"));
    }};

    public static Class<?> getClazz(){
        return accessor.getClazz();
    }

    public static Object get(ItemGroup itemGroup){
        int field = relationMap.getOrDefault(itemGroup, -1);
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
