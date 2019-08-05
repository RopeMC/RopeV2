package de.ropemc.rv2.loader.mod;

import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class ModLoader {
    private File modFolder;
    private List<Mod> mods;

    public ModLoader(File modFolder) {
        this.modFolder = modFolder;
        if (!modFolder.exists()) modFolder.mkdir();
        mods = Arrays.stream(Objects.requireNonNull(modFolder.listFiles()))
                .filter(File::isFile)
                .filter(file -> file.getName().endsWith(".jar"))
                .map(this::loadMod)
                .collect(Collectors.toList());
    }

    private Mod loadMod(File file) {
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
                System.out.println("Successfully loaded mod " + file.getName() + "!");

                Mod instance = mainClass.newInstance();
                instance.onEnable();
                return instance;
            }

        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Error while loading mod " + file.getName());
    }
}
