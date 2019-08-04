package de.ropemc.rv2.core.mod;

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
}
