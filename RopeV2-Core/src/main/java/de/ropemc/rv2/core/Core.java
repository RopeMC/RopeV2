package de.ropemc.rv2.core;


import de.ropemc.rv2.mc114.HookTransformer;

import java.io.File;
import java.lang.instrument.Instrumentation;

public class Core {

    public static File mainFolder = new File("RopeV2");

    public static void premain(String args, Instrumentation instrumentation){
        System.out.println("Hello World! This is RopeV2 straight from the hell!");
        if (!mainFolder.exists()) mainFolder.mkdir();
        //ModLoader modLoader = new ModLoader();
        instrumentation.addTransformer(new HookTransformer());
        System.out.println("RopeV2 became an overlord!");
    }

}
