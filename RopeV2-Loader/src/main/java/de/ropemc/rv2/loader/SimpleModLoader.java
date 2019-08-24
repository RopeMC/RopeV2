package de.ropemc.rv2.loader;

import de.ropemc.rv2.api.mod.Mod;
import de.ropemc.rv2.api.mod.ModInfo;
import de.ropemc.rv2.api.mod.ModLoader;

import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class SimpleModLoader implements ModLoader {

    private List<Mod> mods = new ArrayList<>();

    public List<Mod> getMods(){
        return mods;
    }

    public void loadMods(File dir){
        mods.addAll(Arrays.stream(Objects.requireNonNull(dir.listFiles()))
                .filter(File::isFile)
                .filter(file -> file.getName().endsWith(".jar"))
                .map(this::loadMod)
                .collect(Collectors.toList()));
    }

    public Mod loadMod(File file) {
        System.out.println("Loading mod " + file.getName());
        try {
            URLClassLoader classLoader = new URLClassLoader(new java.net.URL[] {file.toURI().toURL()});
            Class<Mod> mainClass = null;
            JarFile jf = new JarFile(file);
            Enumeration<JarEntry> en = jf.entries();
            while (en.hasMoreElements()) {
                JarEntry element = en.nextElement();
                if (element.getName().endsWith(".class")) {
                    Class<?> clazz = classLoader.loadClass(element.getName().replace("/", ".").substring(0, element.getName().length() - 6));
                    if (Arrays.asList(clazz.getInterfaces()).contains(Mod.class)) {
                        mainClass = (Class<Mod>) clazz;
                    }
                }
            }
            if (mainClass != null) {
                Mod instance = mainClass.newInstance();
                instance.onLoad();
                System.out.println("Successfully loaded mod " + instance.modInfo().toString() + "!");
                return instance;
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Error while loading mod " + file.getName());
    }

    public Mod getMod(String id){
        return mods.stream().filter(mod -> mod.modInfo().getId().equals(id)).findFirst().orElse(null);
    }

}
