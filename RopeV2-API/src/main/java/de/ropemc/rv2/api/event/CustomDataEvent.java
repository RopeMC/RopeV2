package de.ropemc.rv2.api.event;

public class CustomDataEvent extends Event {

    private String name;
    private Object[] data;

    public CustomDataEvent(String name, Object... data){
        this.name = name;
        this.data = data;
    }

    public String getName(){
        return name;
    }

    public Object[] getData(){
        return data;
    }

}
