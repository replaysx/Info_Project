package entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Wizard extends Entity{
    public NPC_Wizard(GamePanel gp){
        super(gp);


        direction = "left";
        speed = 2;
        getImage();
    }
    public void getImage(){
        try {
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_left_1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_right_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_left_2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/oldman_right_2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void setAction(){
        actionLockCounter ++;
        if (actionLockCounter ==120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i < 50) {
                direction = "right";
            }
            if (i >= 50) {
                direction = "left";
            }
            actionLockCounter = 0;
        }
    }
}
