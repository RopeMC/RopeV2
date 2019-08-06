package de.ropemc.rv2.loader.mod;

import java.util.Objects;

public class ModInfo {
    private String name;
    private String version;
    private String author;

    public ModInfo(String name, String version, String author) {
        this.name = name;
        this.version = version;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ModInfo)) return false;
        ModInfo modInfo = (ModInfo) o;

        return Objects.equals(this.name, modInfo.name) &&
                Objects.equals(this.version, modInfo.version) &&
                Objects.equals(this.author, modInfo.author);
    }

    public int hashCode() {
        return Objects.hash(name, version, author);
    }
}
