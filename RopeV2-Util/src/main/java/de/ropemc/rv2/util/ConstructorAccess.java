package de.ropemc.rv2.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ConstructorAccess {

    private Class<?> clazz;

    public ConstructorAccess(Class<?> clazz){
        this.clazz = clazz;
    }

    private List<Constructor> constructors = new ArrayList<>();

    public int getIndex(Class... types){
        Constructor constructor = getConstructor(types);
        if(constructor == null)
            return -1;
        constructors.add(constructor);
        return constructors.size()-1;
    }

    private Constructor getConstructor(Class... types){
        try {
            Constructor constructor = clazz.getDeclaredConstructor(types);
            if(!constructor.isAccessible())
                constructor.setAccessible(true);
            return constructor;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object newInstance(int index, Object... params){
        if(index < 0)
            return null;
        if(index >= constructors.size())
            return null;
        try {
            return constructors.get(index).newInstance(params);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
