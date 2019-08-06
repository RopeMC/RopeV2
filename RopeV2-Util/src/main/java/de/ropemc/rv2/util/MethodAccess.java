package de.ropemc.rv2.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodAccess {

    private Class<?> clazz;

    public MethodAccess(Class<?> clazz){
        this.clazz = clazz;
    }

    private List<Method> methods = new ArrayList<>();

    public int getIndex(String name, Class... types){
        Method method = getMethod(name, types);
        if(method == null)
            return -1;
        methods.add(method);
        return methods.size()-1;
    }

    private Method getMethod(String name, Class... types){
        try {
            Method method = clazz.getDeclaredMethod(name, types);
            if(!method.isAccessible())
                method.setAccessible(true);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object invoke(Object instance, int index, Object... params){
        if(index < 0)
            return null;
        if(index >= methods.size())
            return null;
        try {
            return methods.get(index).invoke(instance, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
