package de.ropemc.rv2.loader;

import de.ropemc.rv2.api.Minecraft;
import de.ropemc.rv2.api.RopeMC;
import de.ropemc.rv2.mc114.HookTransformer;

public class RopeMCImpl implements RopeMC {

    private Minecraft minecraft = null;
    public Minecraft getMinecraft() {
        return minecraft;
    }

    private HookTransformer transformer = new HookTransformer();

    public byte[] transform(String className){
        return transformer.transform(className);
    }

    public void run(){
        System.out.println("Hello World from RopeV2");
    }

}
