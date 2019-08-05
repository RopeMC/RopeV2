package de.ropemc.rv2.loader;


import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.RopeMC;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;

public class Main {

    public static void premain(String args, Instrumentation instrumentation){
        RopeMCImpl ropeMC = new RopeMCImpl();
        setRopeMC(ropeMC);
        instrumentation.addTransformer((classLoader, className, aClass, protectionDomain, bytes) -> ropeMC.transform(className));
        ropeMC.run();
    }

    private static void setRopeMC(RopeMC ropeMC){
        Field ropeMCField = null;
        try {
            ropeMCField = Rope.class.getDeclaredField("ropeMC");
            ropeMCField.setAccessible(true);
            ropeMCField.set(null, ropeMC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
