package object;

import Main.GamePanel;
import entity.Projectile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Projectile_Rock extends Projectile {
    GamePanel gp;
    public Projectile_Rock(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "Rock";
        speed = 5;
        maxLife = 80;
        life = maxLife;
        attack = 2;
        alive = false;
        imageLeft = new BufferedImage[13];
        imageRight = new BufferedImage[13];
        getImage();


    }
    public  void getImage(){
        try {
           /* for (int i = 0;i<13;i++){
                imageRight[i]= ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
                imageLeft[i] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            }*/

            imageRight[0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[2] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[3] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[4] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[5] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[6] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[7] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[8] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[9] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[10] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[11] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageRight[12] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [2] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [3] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [4] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [5] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [6] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [7] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [8] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [9] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [10] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [11] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
            imageLeft [12] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
