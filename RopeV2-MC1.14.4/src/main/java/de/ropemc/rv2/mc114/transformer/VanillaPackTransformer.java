package de.ropemc.rv2.mc114.transformer;

import de.ropemc.rv2.api.ClassTransformer;
import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.minecraft.util.ResourceLocation;
import de.ropemc.rv2.api.mod.Mod;
import de.ropemc.rv2.mc114.minecraft.util.ResourceLocationImpl;
import javassist.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class VanillaPackTransformer implements ClassTransformer {

    public String[] getTransformedClasses() {
        return new String[]{"wo"};
    }

    public void transform(CtClass ctClass) {
        try {
            ctClass.getClassPool().importPackage("java.io");
            ctClass.getClassPool().importPackage("java.util");
            ctClass.getClassPool().importPackage("java.util.function");
            CtClass predicateClass = ctClass.getClassPool().get("java.util.function.Predicate");
            CtClass stringClass = ctClass.getClassPool().get("java.lang.String");
            CtClass typeClass = ctClass.getClassPool().get("wm");
            CtClass locationClass = ctClass.getClassPool().get("qv");

            CtMethod rootResourceStreamMethod = ctClass.getDeclaredMethod("b", new CtClass[]{stringClass});
            rootResourceStreamMethod.insertBefore("InputStream customStream = VanillaPackTransformer.getRootResourceStream($1);if(customStream != null)return customStream;");

            CtMethod resourceStreamMethod = ctClass.getDeclaredMethod("a", new CtClass[]{typeClass, locationClass});
            resourceStreamMethod.insertBefore("InputStream customStream = VanillaPackTransformer.getResourceStream($1, $2);if(customStream != null)return customStream;");

            CtMethod oldAllResourceLocationsMethod = ctClass.getDeclaredMethod("a", new CtClass[]{typeClass, stringClass, CtClass.intType, predicateClass});
            oldAllResourceLocationsMethod.setName("olda");
            CtMethod allResourceLocationsMethod = CtMethod.make("public Collection a(wm typeHandle, String pathIn, int maxDepth, Predicate filter){Set theSet = olda($1, $2, $3, $4); theSet.addAll(VanillaPackTransformer.getAllResourceLocations($1, $2, $3, $4)); return theSet;}", ctClass);
            ctClass.addMethod(allResourceLocationsMethod);

            CtMethod resourceExistsMethod = ctClass.getDeclaredMethod("b", new CtClass[]{typeClass, locationClass});
            resourceExistsMethod.insertBefore("if(VanillaPackTransformer.resourceExists($1, $2))return true;");

            CtMethod oldResourceNamespacesMethod = ctClass.getDeclaredMethod("a", new CtClass[]{typeClass});
            oldResourceNamespacesMethod.setName("olda");
            CtMethod resourceNamespacesMethod = CtMethod.make("public Set a(wm typeHandle){Set theSet = VanillaPackTransformer.getResourceNamespaces($1); theSet.addAll(olda($1)); return theSet;}", ctClass);
            ctClass.addMethod(resourceNamespacesMethod);
        } catch (NotFoundException | CannotCompileException e) {
            e.printStackTrace();
        }
    }

    public static InputStream getRootResourceStream(String fileName) throws IOException {
        return null;
    }

    public static InputStream getResourceStream(Object typeHandle, Object locationHandle) throws IOException {
        ResourceLocation.Wrapper location = new ResourceLocationImpl(locationHandle);
        if(location.getNamespace().equals("minecraft"))
            return null;
        String namespace = location.getNamespace();
        Mod mod = Rope.getRopeMC().getModLoader().getMod(namespace);
        if(mod == null)
            return null;
        return mod.getClass().getClassLoader().getResourceAsStream("assets/"+namespace+"/"+location.getPath());
    }

    public static Collection getAllResourceLocations(Object typeHandle, String pathIn, int maxDepth, Predicate<String> filter){
        return new HashSet();
    }

    public static Set<String> getResourceNamespaces(Object typeHandle){
        Set<String> namespaces = new HashSet<>();
        for(Mod mod : Rope.getRopeMC().getModLoader().getMods()){
            namespaces.add(mod.modInfo().getId());
        }
        return namespaces;
    }

    public static boolean resourceExists(Object typeHandle, Object locationHandle){
        ResourceLocation.Wrapper location = new ResourceLocationImpl(locationHandle);
        String namespace = location.getNamespace();
        if(namespace.equals("minecraft") || namespace.equals("realms"))
            return false;
        Mod mod = Rope.getRopeMC().getModLoader().getMod(namespace);
        if(mod == null)
            return false;
        URL url = mod.getClass().getClassLoader().getResource("assets/"+namespace+"/"+location.getPath());
        return url != null;
    }

}
