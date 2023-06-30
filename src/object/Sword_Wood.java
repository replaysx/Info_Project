package object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sword_Wood extends SuperObject{
    GamePanel gp;
    public Sword_Wood(GamePanel gp){

        this.gp = gp;
        name = "Default Sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/playerImages/sword_normal.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        attackValue = 1;
        description = "["+name+"] \nDas ist ein Schwert";
        attackWidth = 36;
        attackHeight = 36;
        type = type_weapon;
        rarity = common;
    }
}
