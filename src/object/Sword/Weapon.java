package object.Sword;

import Main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Weapon extends SuperObject {
GamePanel gp;
    public Weapon(GamePanel gp){

this.gp = gp;
        name = "Rare Sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/sword_normal.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        attackValue = 2;
        coinValue = 5;
        description = "["+name+"] \nAttack: "+attackValue;
        attackWidth = 36;
        attackHeight = 36;
        type = type_weapon;
        rarity = rare;
    }
}
