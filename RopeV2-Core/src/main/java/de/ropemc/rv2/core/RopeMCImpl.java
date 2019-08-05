package de.ropemc.rv2.core;

import de.ropemc.rv2.api.Minecraft;
import de.ropemc.rv2.api.RopeMC;

public class RopeMCImpl implements RopeMC {

    private Minecraft minecraft = null;

    public Minecraft getMinecraft() {
        return minecraft;
    }

    public void setMinecraft(Minecraft minecraft){
        this.minecraft = minecraft;
    }

    public byte[] transform(String className){
        return null;
    }

    public void run(){

    }

}
