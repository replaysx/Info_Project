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
    public NPC_Wizard(GamePanel gp){
        super(gp);
this.gp = gp;
type = 1;
        direction = "left";
        speed = 2;
        imageLeft = new BufferedImage[13];
        imageRight = new BufferedImage[13];
        getImage();
        maxLife = 10;
        life = maxLife;
        attack = 5;
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
        int i = new Random().nextInt(100)+1;
        if (i>=99 && projectile.alive == false && shotAvailableCounter == 30){
            projectile.set(worldX,worldY,direction,true);
            gp.projectileList.add(projectile);
            shotAvailableCounter = 0;
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
