package object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sword_Legendary extends SuperObject{
    GamePanel gp;
    public Sword_Legendary(GamePanel gp){

        this.gp = gp;
        name = "Legendary Sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/playerImages/sword_normal.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        attackValue = 4;
        description = "["+name+"] \nDas ist ein Schwert";
        attackWidth = 36;
        attackHeight = 36;
        type = type_weapon;
        rarity = legendary;
    }
}
