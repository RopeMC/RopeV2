package de.ropemc.rv2.api;

public class Rope {

    private static RopeMC ropeMC = null;

    public static RopeMC getRopeMC(){
        return ropeMC;
    }

    public static Minecraft getMinecraft(){
        return getRopeMC().getMinecraft();
    }

}
