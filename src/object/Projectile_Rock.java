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
        speed = 3;
        maxLife = 800;
        life = maxLife;
        attack = 5;
        alive = false;
        imageLeft = new BufferedImage[2];
        imageRight = new BufferedImage[2];
        getImage();


    }
    public  void getImage(){
        try {


            imageRight[0] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Projectile1.png"));
            imageRight[1] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Projectile2.png"));
            imageLeft[0] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/ProjectileL1.png"));
            imageLeft[1] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/ProjectileL2.png"));



        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
