package object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sword_Mystic extends SuperObject{
    GamePanel gp;
    public Sword_Mystic(GamePanel gp){

        this.gp = gp;
        name = "Mystic Sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/playerImages/sword_normal.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        attackValue = 5;
        description = "["+name+"] \n Attack:";
        attackWidth = 36;
        attackHeight = 36;
        type = type_weapon;
        rarity = mystic;
    }

}
