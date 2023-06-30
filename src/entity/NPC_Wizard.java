package entity;

import Main.GamePanel;
import object.Coin;
import object.Heal;
import object.Potion_Orange;
import object.Projectile_Rock;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_Wizard extends Entity{
    GamePanel gp;
    public int attackAvailableCounter = 0;
    public NPC_Wizard(GamePanel gp){
        super(gp);
this.gp = gp;
type = 1;
        direction = "left";
        speed = 2;
        imageLeft = new BufferedImage[13];
        imageRight = new BufferedImage[13];
        attackLeft = new BufferedImage[18];
        attackRight = new BufferedImage[18];
        getImage();
        getAttackImage();
        maxLife = 10;
        life = maxLife;
        attack = 2;
        defense =0;
        projectile = new Projectile_Rock(gp);


    }
    public void getImage(){
        try {
            imageRight[0] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (1).png"));
            imageRight[1] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (2).png"));
            imageRight[2] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (3).png"));
            imageRight[3] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (4).png"));
            imageRight[4] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (5).png"));
            imageRight[5] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (6).png"));
            imageRight[6] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (7).png"));
            imageRight[7] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (8).png"));
            imageRight[8] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (9).png"));
            imageRight[9] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (10).png"));
            imageRight[10] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (11).png"));
            imageRight[11] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (12).png"));
            imageRight[12] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/right1 (13).png"));
            imageLeft[0] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (1).png"));
            imageLeft[1] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (2).png"));
            imageLeft[2] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (3).png"));
            imageLeft[3] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (4).png"));
            imageLeft[4] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (5).png"));
            imageLeft[5] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (6).png"));
            imageLeft[6] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (7).png"));
            imageLeft[7] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (8).png"));
            imageLeft[8] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (9).png"));
            imageLeft[9] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (10).png"));
            imageLeft[10] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (11).png"));
            imageLeft[11] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (12).png"));
            imageLeft[12] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/left1 (13).png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void getAttackImage(){
        try {


            attackRight[0] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (1).png"));
            attackRight[1] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (2).png"));
            attackRight[2] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (3).png"));
            attackRight[3] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (4).png"));
            attackRight[4] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (5).png"));
            attackRight[5] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (6).png"));
            attackRight[6] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (7).png"));
            attackRight[7] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (8).png"));
            attackRight[8] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (9).png"));
            attackRight[9] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (10).png"));
            attackRight[10] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (11).png"));
            attackRight[11] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (12).png"));
            attackRight[12] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (13).png"));
            attackRight[13] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (14).png"));
            attackRight[14] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (15).png"));
            attackRight[15] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (16).png"));
            attackRight[16] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (17).png"));
            attackRight[17] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/Attack (18).png"));

            attackLeft[0] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL1.png"));
            attackLeft[1] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL2.png"));
            attackLeft[2] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL3.png"));
            attackLeft[3] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL4.png"));
            attackLeft[4] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL5.png"));
            attackLeft[5] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL6.png"));
            attackLeft[6] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL7.png"));
            attackLeft[7] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL8.png"));
            attackLeft[8] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL9.png"));
            attackLeft[9] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL10.png"));
            attackLeft[10] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL11.png"));
            attackLeft[11] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL12.png"));
            attackLeft[12] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL13.png"));
            attackLeft[13] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL14.png"));
            attackLeft[14] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL15.png"));
            attackLeft[15] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL16.png"));
            attackLeft[16] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL17.png"));
            attackLeft[17] = ImageIO.read(getClass().getResourceAsStream("/SkeletonImages/AttackL18.png"));


        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void setAction(){
        if (attackAvailableCounter<1000){
            attackAvailableCounter++;
        }

        int distanceX = gp.player.worldX - worldX;
        if (attacking == true){
            if (direction == "right"){
                solidArea.x += attackArea.width;
            }else {
                solidArea.x -= attackArea.width;

            }
        }else {
            solidArea.x = solidAreaDefaultX;
        }

        if (distanceX <= 200 && distanceX >=-200){
            if (distanceX < 0){
                direction = "left";
            }
            if (distanceX > 0){
                direction = "right";
            }
            if (distanceX <=100 && distanceX >= -100 && attackAvailableCounter == 1000){
                attacking = true;
                attackAvailableCounter =0;
            }



            int i = new Random().nextInt(100) + 1;
            /* if (i >= 1 && projectile.alive == false && shotAvailableCounter == 30) {
                System.out.println("!!!!!!!!!!!!!!!!!!");
                projectile.set(worldX, worldY, direction, true);
                projectile.alive = false;
                gp.projectileList.add(projectile);
                shotAvailableCounter = 0;
            }*/
        }else {


          /*  actionLockCounter++;
            if (actionLockCounter == 120) {
                Random random = new Random();
                int i = random.nextInt(100) + 1;
                if (i < 50) {
                    direction = "right";
                }
                if (i >= 50) {
                    direction = "left";
                }
                actionLockCounter = 0;
            }*/

        }
    }


    @Override
    public void checkDrop() {

        int i = new Random().nextInt(3)+1;
        switch (i){
            case 1: dropItem(new Coin(gp));
            break;
            case 2: dropItem(new Potion_Orange(gp));
                break;
            case 3: dropItem(new Heal());
                break;
        }
    }
}
