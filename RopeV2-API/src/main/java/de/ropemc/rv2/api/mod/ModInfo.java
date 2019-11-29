package de.ropemc.rv2.api.mod;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Locale;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class ModInfo {

    private String id;
    private String name;
    private String version;
    private String author;

    public ModInfo(String name, String version, String author) {
        this(name, name, version, author);
    }

    private String makeIdValid(String raw){
        StringBuilder sb = new StringBuilder();
        for(char c : raw.toLowerCase(Locale.GERMAN).toCharArray()){
            String VALID_ID = "abcdefghijklmnopqrstuvwxyz_0123456789";
            if(VALID_ID.contains(String.valueOf(c))){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ModInfo)) return false;
        ModInfo modInfo = (ModInfo) o;
        return Objects.equals(this.id, modInfo.id) &&
                Objects.equals(this.version, modInfo.version);
    }

    public int hashCode() {
        return Objects.hash(name, version, author);
    }

    public String toString(){
        return name + " ("+version+" by "+author+")";
    }

}
