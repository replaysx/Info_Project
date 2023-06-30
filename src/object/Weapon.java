package object;

import Main.GamePanel;
import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Weapon extends SuperObject {
GamePanel gp;
    public Weapon(GamePanel gp){

this.gp = gp;
        name = "Rare Sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/playerImages/sword_normal.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        attackValue = 2;
        description = "["+name+"] \nDas ist ein Schwert";
        attackWidth = 36;
        attackHeight = 36;
        type = type_weapon;
        rarity = rare;
    }
}
