package entity;


import Main.GamePanel;
import Main.KeyHandler;
import object.*;
import object.Shields.Shield_Wood;
import object.Sword.Sword_Wood;

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
   public boolean invincible;
   public boolean guard = false;
   public int invincibleCounter;
   public int damage = 1;

   public ArrayList<SuperObject> inventory = new ArrayList<>();
   public final int maxInventorySize = 20;
    public SuperObject currentWeapon;
    public SuperObject currentShield;
    public int shieldCounter;
    public int shieldNum;
public int realjumpspeed;
    public double jumpspeed;
    public double gravityspeed;
    public boolean moving = false;
    public boolean atShop = false;
    public int idleCounter=0;
    public int idleNum = 0;


    public Player(GamePanel gp,KeyHandler keyH){
        super(gp);
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2;
        screenY = gp.screenHeight/2;
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 0;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 48;
        solidArea.height = 52;
        setDefaultValues();
        setItems();
    }
public void setDefaultValues(){

        worldX = 15*gp.tileSize;
        worldY = 9*gp.tileSize;
        speed = 4;
        direction = "right";
        gravityspeed = 0.5;
        jumpspeed = 0;
        maxLife = 10;
        life = maxLife;
        imageLeft = new BufferedImage[8];
        imageRight = new BufferedImage[8];
        attackLeft = new BufferedImage[8];
        attackRight = new BufferedImage[8];
        jumpLeft = new BufferedImage[3];
        jumpRight = new BufferedImage[8];
        shieldLeft = new BufferedImage[2];
        shieldRight = new BufferedImage[2];
        idleRight = new BufferedImage[6];
        idleLeft = new BufferedImage[6];
        getPlayerImage();
        level = 1;
        strength =1;
        coin = 1000;

        currentWeapon = new Sword_Wood(gp);
        currentShield = new Shield_Wood(gp);
        attack = getAttack();
        defense = getDefense();


}
public void selectItem(){
        int itemIndex = gp.ui.getItemIndex();
        if (itemIndex <inventory.size()){
            SuperObject selectedItem = inventory.get(itemIndex);
            if (selectedItem.type == currentWeapon.type_weapon){
                inventory.remove(itemIndex);
                inventory.add(currentWeapon);
                currentWeapon = selectedItem;
                attack = getAttack();
            }
            if (selectedItem.type == currentShield.type_shield){
                inventory.remove(itemIndex);
                inventory.add(currentShield);
                currentShield = selectedItem;
                defense = getDefense();
            }
            if (selectedItem.type == currentShield.type_consumable){
                if (gp.player.life != 0){
                    selectedItem.use();
                    if (selectedItem.name != "Key"){
                    if (selectedItem.amount > 1 ){
                        selectedItem.amount --;
                    }else{
                        inventory.remove(itemIndex);}
                }
                }
            }

        }
}

public void setItems(){
        inventory.clear();

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

            jumpRight[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/midair.png"));

            jumpLeft[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/midairL.png"));


            shieldRight[0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield2.png"));
            shieldRight[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield3.png"));

            shieldLeft[0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shieldL2.png"));
            shieldLeft[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/shieldL3.png"));

            idleRight[0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idle1.png"));
            idleRight[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idle2.png"));
            idleRight[2] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idle3.png"));
            idleRight[3] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idle4.png"));
            idleRight[4] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idle5.png"));
            idleRight[5] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idle6.png"));

            idleLeft[0] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idleL1.png"));
            idleLeft[1] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idleL2.png"));
            idleLeft[2] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idleL3.png"));
            idleLeft[3] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idleL4.png"));
            idleLeft[4] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idleL5.png"));
            idleLeft[5] = ImageIO.read(getClass().getResourceAsStream("/playerImages/idleL6.png"));


        }catch (IOException e){
            e.printStackTrace();
        }
}

public void update() {
        if (guard == true){
            speed =0;
            shieldCounter++;
            if (shieldCounter > 8) {
                if (shieldNum == 1){
                    shieldNum = 0;
                }
                if (shieldNum == 0){
                    shieldNum = 1;
                }
                shieldCounter = 0;}
        }else {
            speed = 4;
        }
        if (keyH.enterPressed == true){
            attacking = true;
        }
        if (attacking == true){

            attacking();
        }
    idleCounter++;
    if (idleCounter > 4) {
        if (idleNum == 5){
            idleNum = 0;
        }
        idleNum ++;
        idleCounter = 0;

    }
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




    if (keyH.leftPressed || keyH.rightPressed ) {
        moving = true;
        if (keyH.leftPressed) {

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
        gp.cChecker.checkEntity(this,gp.npc);
        gp.cChecker.checkTile(this);
        objIndex = gp.cChecker.checkObject(this,true);
        pickUp(objIndex);
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
    }else{
        moving = false;}

if (life<=0 || worldY+gp.tileSize+gp.screenHeight/2> gp.tileSize*gp.maxWorldRow ){
    gp.gameState = gp.gameOverState;
}

}
public int searchItemInInventory(String itemName){
      int itemIndex =999;
    for (int i = 0; i < gp.player.inventory.size(); i++) {
        if (inventory.get(i).name == itemName){
            itemIndex = i;
            break;
        }
    }
    return itemIndex;
}
public boolean canObtainItem(SuperObject item){
        boolean canObtain = false;
        if (item.stackable == true){
            int index = searchItemInInventory(item.name);

            if (index!=999){
                inventory.get(index).amount++;
                canObtain = true;
            }
            else {
                if (inventory.size() != maxInventorySize){
                    inventory.add(item);
                    canObtain = true;
                }
            }
        }else{
            if (inventory.size() != maxInventorySize){
                inventory.add(item);
                canObtain = true;
            }
        }
        return canObtain;
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

public void damageMonster(int i){
       if (i!=999){
           if (animationNum==3){
           damage = attack;
           gp.npc[i].life -= damage;
           attack=0;
           }else {
               attack= getAttack();
           }



           if (gp.npc[i].life <=0){
               gp.npc[i].checkDrop();
               gp.npc[i] = null;
           }
       }

}

public void pickUp(int index){
     if (index!=999) {
         int objectType = gp.obj[index].type;
         if ((objectType == 0 || objectType == 1 || objectType == 2)&& canObtainItem(gp.obj[index])==true) {
             gp.obj[index] = null;
         }
         if (objectType == 3) {
             gp.playSE(1);
             gp.obj[index].use();
             gp.obj[index] = null;
         }

     }
}
public void draw(Graphics2D g2){
    BufferedImage image = null;


    switch(direction){

        case "right": if ((isgrounded==false  && gravityspeed >0.55) || keyH.jump == true){
            image = jumpRight[1];


        }else if (guard==true) {
            image = shieldRight[shieldNum];
        }else
            if (attacking == false){
                if (moving == true){
                    image = imageRight[spriteNum-1];
                }
                else {
                    image = idleRight[idleNum];
                }

        }else {
            image = attackRight[animationNum-1];
        }


            break;
        case "left":
            if ((isgrounded==false  && gravityspeed >0.55) || keyH.jump == true){

                image = jumpLeft[1];


            }else if (guard==true) {
                image = shieldLeft[shieldNum];
            }
               else if (attacking == false) {
                if (moving == true){
                    image = imageLeft[spriteNum-1];
                }
                else {
                    image = idleLeft[idleNum];
                }

                } else {
                    image = attackLeft[animationNum - 1];
                }


            break;
    }
    g2.drawImage(image, screenX, screenY, gp.tileSize*2,gp.tileSize*2, null);




}


}
