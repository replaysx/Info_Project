package entity;


import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenY;
    public final int screenX;
   public int hasKey = 0;




public int realjumpspeed;
    public double jumpspeed;
    double gravityspeed;



    public Player(GamePanel gp,KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2;
        screenY = gp.screenHeight/2;
        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 38;
        solidArea.height = 38;
        setDefaultValues();
        getPlayerImage();
    }
public void setDefaultValues(){
        worldX = 100;
        worldY = 100;
        speed = 4;
        direction = "right";
        gravityspeed = 0.5;
        jumpspeed = 0;
        maxLife = 6;
        life = maxLife;

}
public void getPlayerImage(){
        try {
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/pixilart-drawing(1).png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/pixil-frame-0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/pixilart-drawing(2).png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/pixilart-drawing.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
}
public void update() {
        int objIndex = gp.cChecker.checkObject(this,true);
    pickUp(objIndex);
gp.cChecker.checkTile(this);

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


    if (keyH.leftPressed || keyH.rightPressed || keyH.upPressed || keyH.downPressed) {
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
        if (spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        collisionon =false;
        gp.cChecker.checkTile(this);
        objIndex = gp.cChecker.checkObject(this,true);
        pickUp(objIndex);
        gp.eHandler.checkEvent();
        if (collisionon == false){
            switch (direction){
                case"up":
                    worldY = worldY - speed;
                    break;
                case"down":
                    worldY = worldY + speed;
                    break;
                case"right":
                    worldX = worldX + speed;
                    break;
                case"left":
                    worldX = worldX - speed;
                    break;
            }
        }
    }


}
public void pickUp(int index){
     if (index!=999)  {
         String objectName = gp.obj[index].name;

         switch (objectName) {
             case "Key":
                 gp.obj[index] = null;
                 hasKey ++;
                 break;
             case "Chest":
                 if (hasKey > 0){
                     hasKey --;
                 }
                 break;
         }
     }
}
public void draw(Graphics2D g2){
    BufferedImage image = null;
    switch(direction){
        case "up":
            if (spriteNum == 1){
                image = right1;
            }
            if (spriteNum == 2){
                image = right2;
            }
            break;
        case "down":
            if (spriteNum == 1){
                image = right1;
            }
            if (spriteNum == 2){
                image = right2;
            }
            break;
        case "right":
            if (spriteNum == 1){
                image = right1;
            }
            if (spriteNum == 2){
                image = right2;
            }
            break;
        case "left":
            if (spriteNum == 1){
                image = left1;
            }
            if (spriteNum == 2){
                image = left2;
            }
            break;
    }
    g2.drawImage(image, screenX, screenY, gp.tileSize,gp.tileSize, null);
}
}
