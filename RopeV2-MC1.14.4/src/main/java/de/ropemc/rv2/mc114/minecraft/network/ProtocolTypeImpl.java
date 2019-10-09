package de.ropemc.rv2.mc114.minecraft.network;

import de.ropemc.rv2.api.minecraft.network.IModPacket;
import de.ropemc.rv2.api.minecraft.network.PacketDirection;
import de.ropemc.rv2.api.minecraft.network.ProtocolType;
import de.ropemc.rv2.util.ReflectAccessor;

public enum ProtocolTypeImpl {

    /*
    HANDSHAKING(accessor().getFieldAccess().getIndex("a")),
    PLAY(accessor().getFieldAccess().getIndex("b")),
    STATUS(accessor().getFieldAccess().getIndex("c")),
    LOGIN(accessor().getFieldAccess().getIndex("d"))
    */
    ;

    private static ReflectAccessor accessor;

    private static ReflectAccessor accessor(){
        if(accessor == null)
            accessor = ReflectAccessor.getByName("jd");
        return accessor;
    }

    //private static int mRegisterPacket = accessor().getMethodAccess().getIndex("a", PacketDirectionImpl.getClazz(), Class.class);

    private ProtocolType protocolType;
    private int field;

    ProtocolTypeImpl(int field){
        protocolType = ProtocolType.valueOf(name());
        this.field = field;
    }

    public ProtocolType getProtocolType(){
        return protocolType;
    }

    public Object getValue(){
        return accessor().getFieldAccess().get(null, field);
    }

    public ProtocolTypeImpl registerPacket(PacketDirectionImpl packetDirection, Class<? extends IModPacket> packetClass){
        //Create a new Class that wraps the packetClass and implements IPacket
        //accessor.getMethodAccess().invoke(getValue(), mRegisterPacket, packetDirection.getValue(), newClass);
        return this;
    }

    public static ProtocolTypeImpl get(ProtocolType protocolType){
        for(ProtocolTypeImpl pt : values()){
            if(pt.getProtocolType().equals(protocolType)){
                return pt;
            }
        }
        return null;
    }

    public static Object getValue(ProtocolType protocolType){
        ProtocolTypeImpl pt = get(protocolType);
        if(pt == null)
            return null;
        return pt.getValue();
    }

    public class WrapperImpl implements ProtocolType.Wrapper {
        public void registerPacket(ProtocolType protocolType, PacketDirection packetDirection, Class<? extends IModPacket> packetClass) {
            ProtocolTypeImpl.get(protocolType).registerPacket(PacketDirectionImpl.get(packetDirection), packetClass);
        }
    }

}
