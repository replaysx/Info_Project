package entity;

import Main.GamePanel;
import object.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_Ghost extends Entity{
    GamePanel gp;
    public int attackAvailableCounter = 0;
    public NPC_Ghost(GamePanel gp){
        super(gp);
        this.gp = gp;
        type = 1;
        direction = "left";
        speed = 2;
        imageLeft = new BufferedImage[6];
        imageRight = new BufferedImage[6];
        attackLeft = new BufferedImage[7];
        attackRight = new BufferedImage[7];
        getImage();
        getAttackImage();
        maxLife = 10;
        life = maxLife;
        attack = 2;
        defense =0;
        attacking = false;
        projectile = new Projectile_Rock(gp);


    }
    public void getImage(){
        try {
            imageRight[0] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Run1.png"));
            imageRight[1] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Run2.png"));
            imageRight[2] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Run3.png"));
            imageRight[3] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Run4.png"));
            imageRight[4] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Run5.png"));
            imageRight[5] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Run6.png"));

            imageLeft[0] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/RunL1.png"));
            imageLeft[1] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/RunL2.png"));
            imageLeft[2] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/RunL3.png"));
            imageLeft[3] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/RunL4.png"));
            imageLeft[4] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/RunL5.png"));
            imageLeft[5] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/RunL6.png"));



        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void getAttackImage(){
        try {


            attackRight[0] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Attack1.png"));
            attackRight[1] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Attack2.png"));
            attackRight[2] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Attack3.png"));
            attackRight[3] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Attack4.png"));
            attackRight[4] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Attack5.png"));
            attackRight[5] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Attack6.png"));
            attackRight[6] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/Attack7.png"));
            attackLeft[0] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/AttackL1.png"));
            attackLeft[1] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/AttackL2.png"));
            attackLeft[2] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/AttackL3.png"));
            attackLeft[3] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/AttackL4.png"));
            attackLeft[4] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/AttackL5.png"));
            attackLeft[5] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/AttackL6.png"));
            attackLeft[6] = ImageIO.read(getClass().getResourceAsStream("/WizardImages/AttackL7.png"));



        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void setAction(){
        if (attackAvailableCounter<1000){
            attackAvailableCounter++;
        }

        int distanceX = gp.player.worldX - this.worldX;
        if (distanceX <= 300 && distanceX >=-300){
            if (distanceX < 0){
                direction = "left";
            }
            if (distanceX > 0){
                direction = "right";
            }
            if (attacking == false){
                int i = new Random().nextInt(100) + 1;
                if(i >= 99 && projectile.alive == false && shotAvailableCounter == 300) {
                    attacking = true;
                }
            }else if (animationNum==5 && projectile.alive == false && shotAvailableCounter == 300){
                System.out.println(worldY);
                projectile.set(worldX -20, worldY-20, direction, true);
                gp.projectileList.add(projectile);
                shotAvailableCounter = 0;
            }




        }
        spriteCounter++;
        if (spriteCounter > 5) {
            if (spriteNum == 5){
                spriteNum = 4;
            }
            spriteNum ++;
            spriteCounter = 0;

        }
        if (attacking==true){
            animationCounter ++;
            if (animationCounter > 8){
                if (animationNum == 6){
                    attacking = false;
                    animationNum =0;

                }animationNum ++;
                animationCounter = 0;
            }


        }
        if (distanceX <= 150 && distanceX >=-150){
            spriteNum = 1;
        }
        if (collisionon == false && ((distanceX <= 200 && distanceX >=-200)&&(distanceX >= 100 || distanceX <=-100))&&attacking==false){
            switch (direction){
                case"right":
                    worldX = worldX + speed;
                    break;
                case"left":
                    worldX = worldX - speed;
                    break;
            }
        }

    }


    @Override





    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;


        switch (direction) {

            case "right":
                if (attacking == true){
                    image = attackRight[animationNum];
                }
                else {
                    image = imageRight[0];}
                break;
            case "left":if (attacking == true){
                image = attackLeft[animationNum];
            }
            else{
                image = imageLeft[spriteNum - 1];}
                break;
        }

        if (type == 1) {
            double oneScale = (double) gp.tileSize / maxLife;
            double hpBar = oneScale * life;
            g2.setColor(Color.darkGray);
            g2.fillRect(screenX - 2, screenY - 17, gp.tileSize + 4, 14);
            g2.setColor(Color.red);
            g2.fillRect(screenX, screenY - 15, (int)hpBar, 10);
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize *2, gp.tileSize*2, null);
    }
}
