package de.ropemc.rv2.api.mod;

import java.io.File;
import java.util.List;

public interface ModLoader {

    Mod loadMod(File file);
    void loadMods(File dir);
    List<Mod> getMods();
    Mod getMod(String id);

}
