package object;

import Main.GamePanel;
import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Potion_Orange extends SuperObject{
    GamePanel gp;
    public Potion_Orange(GamePanel gp){

        this.gp = gp;
        name = "OrangeJuice";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/Orange.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        description = "["+name+"] \nDas ist ein Heiltrank";
        type = type_consumable;
    }
    public void use(){
        gp.player.life += 2;
        if (gp.player.life > gp.player.maxLife){
            gp.player.life = gp.player.maxLife;
        }
    }
}
