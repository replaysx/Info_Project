package entity;


import Main.GamePanel;
import Main.KeyHandler;
import object.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenY;
    public final int screenX;
   public int hasKey = 0;
   public boolean invincible;
   public int invincibleCounter;
   public int damage = 1;

   public ArrayList<SuperObject> inventory = new ArrayList<>();
   public final int maxInventorySize = 20;
    public SuperObject currentWeapon;
    public SuperObject currentShield;






public int realjumpspeed;
    public double jumpspeed;
    double gravityspeed;



    public Player(GamePanel gp,KeyHandler keyH){
        super(gp);
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2;
        screenY = gp.screenHeight/2;
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 125;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 48;
        solidArea.height = 68;
        setDefaultValues();
        setItems();
    }
public void setDefaultValues(){

        worldX = 10;
        worldY = 0;
        speed = 4;
        direction = "right";
        gravityspeed = 0.5;
        jumpspeed = 0;
        maxLife = 6;
        life = maxLife;
        imageLeft = new BufferedImage[8];
        imageRight = new BufferedImage[8];
        attackLeft = new BufferedImage[8];
        attackRight = new BufferedImage[8];
        jumpLeft = new BufferedImage[3];
        jumpRight = new BufferedImage[8];
    getPlayerImage();
        level = 1;
        strength =1;
        coin = 0;

        currentWeapon = new Weapon(gp);
        currentShield = new Shield(gp);
        attack = getAttack();
        defense = getDefense();


}
public void selectItem(){
        int itemIndex = gp.ui.getItemIndex();
        if (itemIndex <inventory.size()){
            SuperObject selectedItem = inventory.get(itemIndex);
            if (selectedItem.type == currentWeapon.type_weapon){
                currentWeapon = selectedItem;
                attack = getAttack();
            }
            if (selectedItem.type == currentShield.type_shield){
                currentShield = selectedItem;
                defense = getDefense();
            }
            if (selectedItem.type == currentShield.type_consumable){
                selectedItem.use();
                inventory.remove(itemIndex);
            }

        }
}

public void setItems(){
        inventory.clear();
        inventory.add(currentWeapon);
    inventory.add(currentShield);
    inventory.add(new Key());
    inventory.add(new Key());
    inventory.add(new Key());
    inventory.add(new Key());
    inventory.add(new Key());
    inventory.add(new Key());
    inventory.add(new Key());
    inventory.add(new Key());
    inventory.add(new Key());
    inventory.add(new Key());
}
public int getAttack(){
    attackArea.width = currentWeapon.attackWidth;
    attackArea.height = currentWeapon.attackHeight;
     return attack = currentWeapon.attackValue;



}
public int getDefense(){
return  defense = currentShield.defenseValue;
}
public void getPlayerImage(){
        try {
            imageRight[0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/run1.png"));
            imageRight[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/run2.png"));
            imageRight[2] = ImageIO.read(getClass().getResourceAsStream("/playerImages/run3.png"));
            imageRight[3] = ImageIO.read(getClass().getResourceAsStream("/playerImages/run4.png"));
            imageRight[4] = ImageIO.read(getClass().getResourceAsStream("/playerImages/run5.png"));
            imageRight[5] = ImageIO.read(getClass().getResourceAsStream("/playerImages/run6.png"));
            imageRight[6] = ImageIO.read(getClass().getResourceAsStream("/playerImages/run7.png"));
            imageRight[7] = ImageIO.read(getClass().getResourceAsStream("/playerImages/run8.png"));
            imageLeft[0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/runL (1).png"));
            imageLeft[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/runL (8).png"));
            imageLeft[2] = ImageIO.read(getClass().getResourceAsStream("/playerImages/runL (7).png"));
            imageLeft[3] = ImageIO.read(getClass().getResourceAsStream("/playerImages/runL (6).png"));
            imageLeft[4] = ImageIO.read(getClass().getResourceAsStream("/playerImages/runL (5).png"));
            imageLeft[5] = ImageIO.read(getClass().getResourceAsStream("/playerImages/runL (4).png"));
            imageLeft[6] = ImageIO.read(getClass().getResourceAsStream("/playerImages/runL (3).png"));
            imageLeft[7] = ImageIO.read(getClass().getResourceAsStream("/playerImages/runL (2).png"));

            attackRight[0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attac1.png"));
            attackRight[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attac2.png"));
            attackRight[2] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attac3.png"));
            attackRight[3] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attac4.png"));
            attackRight[4] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attac5.png"));
            attackRight[5] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attac6.png"));
            attackRight[6] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attac7.png"));
            attackRight[7] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attac8.png"));
            attackLeft[0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attacL (1).png"));
            attackLeft[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attacL (2).png"));
            attackLeft[2] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attacL (3).png"));
            attackLeft[3] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attacL (4).png"));
            attackLeft[4] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attacL (5).png"));
            attackLeft[5] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attacL (6).png"));
            attackLeft[6] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attacL (7).png"));
            attackLeft[7] = ImageIO.read(getClass().getResourceAsStream("/playerImages/attacL (8).png"));

            jumpRight[0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/jump.png"));
            jumpRight[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/midair.png"));
            jumpRight[2] = ImageIO.read(getClass().getResourceAsStream("/playerImages/fall.png"));

            jumpLeft[0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/jumpL.png"));
            jumpLeft[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/midairL.png"));
            jumpLeft[2] = ImageIO.read(getClass().getResourceAsStream("/playerImages/fallL.png"));




        }catch (IOException e){
            e.printStackTrace();
        }
}

public void update() {
        if (keyH.enterPressed == true){
            attacking = true;
        }
        if (attacking == true){

            attacking();
        }else {damage =1;}
        int objIndex = gp.cChecker.checkObject(this,true);
    pickUp(objIndex);
gp.cChecker.checkisgrounded(this);
if (invincible==true){
    invincibleCounter ++;
    if (invincibleCounter>60){
        invincible =false;
        invincibleCounter = 0;
    }
}

 if (isgrounded == false){
     jumpspeed = jumpspeed - gravityspeed;
    gravityspeed = gravityspeed + 0.01;
    realjumpspeed = (int)jumpspeed;
    worldY = worldY - realjumpspeed;
}
else {
    gravityspeed = 0.5;
    realjumpspeed = 0;
    if(keyH.jump == true){
        jumpspeed = 10;
        worldY = worldY-1;

    }
    else {jumpspeed = 0;}
}


    if (keyH.leftPressed || keyH.rightPressed || keyH.upPressed || keyH.downPressed ) {
        if (keyH.upPressed) {
            direction = "up";

        } else if (keyH.downPressed && isgrounded ==true) {
            direction = "down";

        } else if (keyH.leftPressed) {

            direction = "left";
        } else if (keyH.rightPressed) {

            direction = "right";
        }

            spriteCounter++;
            if (spriteCounter > 4) {
                if (spriteNum == 8){
                    spriteNum = 0;
                }
                spriteNum ++;
                spriteCounter = 0;

        }


        collisionon =false;
        int npcIndex = gp.cChecker.checkEntity(this,gp.npc);
        interactNPC(npcIndex);
        gp.cChecker.checkTile(this);
        objIndex = gp.cChecker.checkObject(this,true);
        pickUp(objIndex);
        gp.eHandler.checkEvent();
        if (collisionon == false){
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
if (life<=0){
    gp.gameState = gp.gameOverState;
}

}
public void attacking(){
    int currentWorldX = worldX;
    int currentWorldY = worldY;
    int solidAreaWidth = solidArea.width;
    int solidAreaHeight = solidArea.height;

    switch (direction){
        case "right": worldX += attackArea.width;
            break;
        case "left": worldX -= attackArea.width;
            break;
    }
    solidArea.width = attackArea.width;
    solidArea.height = attackArea.height;

    int monsterIndex = gp.cChecker.checkEntity(this, gp.npc);
    damageMonster(monsterIndex);

    worldX = currentWorldX;
    worldY = currentWorldY;
    solidArea.width = solidAreaWidth;
    solidArea.height = solidAreaHeight;

        animationCounter ++;
        if (animationCounter > 4){
            if (animationNum == 8){
                attacking = false;
                animationNum =0;

            }animationNum ++;
            animationCounter = 0;
        }
}
public void interactNPC(int i){
        if (i!=999){
            if (invincible == false){
                int damage = gp.npc[i].attack -defense;
                life = life-damage ;
                invincible = true;
            }
        }

}
public void damageMonster(int i){
       if (i!=999){
           damage = attack;
           gp.npc[i].life -= damage;
           damage =0;

           if (gp.npc[i].life <=0){
               gp.npc[i].checkDrop();
               gp.npc[i] = null;
           }
       }

}

public void pickUp(int index){
     if (index!=999)  {
         String objectName = gp.obj[index].name;

         switch (objectName) {
             case "Key":
                 gp.playSE(1);
                 if (inventory.size() !=maxInventorySize)
                 gp.obj[index] = null;
                 hasKey ++;
                 inventory.add(new Key());
                 break;
             case "Chest":
                 if (hasKey > 0){
                     hasKey --;
                     gp.obj[index] = null;
                 }
                 break;
             case "heal":

                     gp.obj[index] = null;
                 life = maxLife;
                 break;
             case "LavaPit":
                 if (invincible == false){
                     life = life-1;
                     invincible = true;
                 }
                 break;
             case "OrangeJuice":
                 if (inventory.size() !=maxInventorySize)
                     gp.obj[index] = null;

                 inventory.add(new Potion_Orange(gp));

                 break;
             case "Coin":
                 gp.obj[index].use();
                 gp.obj[index]=null;

         }
     }
}
public void draw(Graphics2D g2){
    BufferedImage image = null;
    switch(direction){

        case "right": if (isgrounded==false){
            image = jumpRight[1];

          /*  if (realjumpspeed > 5){
                image = jumpRight[0];
            }
            if (realjumpspeed > -5 && realjumpspeed < 5){
                image = jumpRight[1];
            }
            if (realjumpspeed < -5){
                image = jumpRight[2];
            } */

        }else{
            if (attacking == false){
            image = imageRight[spriteNum-1];
        }else {
            image = attackRight[animationNum-1];
        }
        }

            break;
        case "left":
            if (isgrounded==false){

                image = jumpRight[1];
                    /* if (realjumpspeed > 5) {
                        image = jumpRight[0];
                    }
                    if (realjumpspeed > -5 && realjumpspeed < 5) {
                        image = jumpRight[1];
                    }
                    if (realjumpspeed < -5) {
                        image = jumpRight[2];
                   } */


            }else {

                if (attacking == false) {
                    image = imageLeft[spriteNum - 1];
                } else {
                    image = attackLeft[animationNum - 1];
                }
            }

            break;
    }
    g2.drawImage(image, screenX, screenY, gp.tileSize*2,gp.tileSize*2, null);

}


}
