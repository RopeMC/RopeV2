package de.ropemc.rv2.mc114.minecraft.network;

import de.ropemc.rv2.api.minecraft.network.PacketDirection;
import de.ropemc.rv2.util.ReflectAccessor;

public enum PacketDirectionImpl {

    SERVERBOUND(accessor().getFieldAccess().getIndex("a")),
    CLIENTBOUND(accessor().getFieldAccess().getIndex("b"));

    private static ReflectAccessor accessor;

    private static ReflectAccessor accessor(){
        if(accessor == null)
            accessor = ReflectAccessor.getByName("kd");
        return accessor;
    }

    public static Class<?> getClazz(){
        return accessor.getClazz();
    }

    private PacketDirection packetDirection;
    private int field;

    PacketDirectionImpl(int field){
        packetDirection = PacketDirection.valueOf(name());
        this.field = field;
    }

    public PacketDirection getPacketDirection(){
        return packetDirection;
    }

    public Object getValue(){
        return accessor().getFieldAccess().get(null, field);
    }

    public static PacketDirectionImpl get(PacketDirection packetDirection){
        for(PacketDirectionImpl pd : values()){
            if(pd.getPacketDirection().equals(packetDirection)){
                return pd;
            }
        }
        return null;
    }

    public static Object getValue(PacketDirection packetDirection){
        PacketDirectionImpl pd = get(packetDirection);
        if(pd == null)
            return null;
        return pd.getValue();
    }

}
