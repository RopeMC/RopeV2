package de.ropemc.rv2.core;

import de.ropemc.rv2.core.mod.ModLoader;

import java.io.File;
import java.lang.instrument.Instrumentation;

public class Core {
    public static File mainFolder = new File("RopeV2");

    public static void premain(String args, Instrumentation instrumentation){
        if (!mainFolder.exists()) mainFolder.mkdir();
        ModLoader modLoader = new ModLoader();
    }

}
