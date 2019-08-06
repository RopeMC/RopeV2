package de.ropemc.rv2.loader;

import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.minecraft.client.Minecraft;
import de.ropemc.rv2.api.minecraft.client.gui.FontRenderer;
import de.ropemc.rv2.api.minecraft.client.gui.IngameGui;

import java.util.ArrayList;
import java.util.List;

public class JHClientGUI {

    private boolean visible = false;
    private int sel = 0;
    private int pos = -100;
    //private static ResourceLocation logo = new ResourceLocation("jhclient/logo.png");

    public List<Module> modules = new ArrayList<>();

    public void setVisible(boolean visible){
        this.visible=visible;
    }

    public void toggleVisible(){
        setVisible(!visible);
    }

    public boolean isVisible(){
        return visible;
    }

    public void setSelection(int sel){
        this.sel=sel;
    }

    public int getSelection(){
        return sel;
    }

    public void setPos(int pos){
        this.pos=pos;
    }

    public int getPos(){
        return pos;
    }

    public void renderScreen(IngameGui gui){
        Minecraft minecraft = Rope.getMinecraft();
        if(minecraft == null)
            return;
        FontRenderer fontRenderer = minecraft.getFontRenderer();
        if(fontRenderer == null)
            return;
        if(!visible){
            if(pos<=-100){
                return;
            }
        }
        /*
        this.drawRect(pos, 0, pos+100, 500, 0x66424242);
        this.drawHorizontalLine(pos, pos+99, 14, 0x66000000);
        this.drawHorizontalLine(pos, pos+99, 25+(9*modules.size()), 0x66000000);
        this.drawRect(pos, 18+(9*sel), pos+100, 28+(9*sel), 0x99424242);
        */
        String client_name = "\247bJHClient";
        String client_version = "\2477Version 0.1c";
        fontRenderer.drawString(client_name, pos+4, 4, 0xffffffff);
        fontRenderer.drawString(client_version, pos+4, 80+(9*modules.size()), 0xffffffff);
        int c = 0;
        for(Module m : modules){
            String color = "c";
            if(m.isToggled()){
                color = "a";
            }
            fontRenderer.drawString("\247"+color+m.getName(), pos+4, 20+(9*c), 0xffffffff);
            c++;
        }
        /*
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(logo);
        int w = 32;
        int h = 32;
        float fw = w;
        float fh = h;
        Gui.drawModalRectWithCustomSizedTexture(pos+(50-(w/2)), 40+(9*modules.size()), 0.0F, 0.0F, w, h, fw, fh);
        */
    }

    public static class Module {
        private String name;
        private boolean toggled = false;
        public Module(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
        public void setToggled(boolean toggled){
            this.toggled = toggled;
        }
        public boolean isToggled(){
            return toggled;
        }
        public void toggle(){
            setToggled(!isToggled());
        }
    }

}
