package object;

import Main.GamePanel;
import entity.Entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Shield extends Entity {
    public Shield(GamePanel gp){
        super(gp);
        name = "DefaultSword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        defenseValue = 1;
    }
}
