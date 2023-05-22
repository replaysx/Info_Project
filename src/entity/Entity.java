package entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX,worldY;
    public int speed;
    public BufferedImage left1,left2,right1,right2;
    public String direction ;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(5,5,38,38);
    public boolean collisionon = false;

    public boolean isgrounded = false;
    public int solidAreaDefaultX,solidAreaDefaultY;

    public int maxLife;
    public int life;
    public int actionLockCounter;
    public Entity(GamePanel gp){
        this.gp = gp;
    }
    public void setAction(){

    }
    public void update(){
        setAction();
        collisionon = false;
       gp.cChecker.checkTile(this);
        System.out.println(collisionon);
        gp.cChecker.checkObject(this,false);
       gp.cChecker.checkPlayer(this);

        spriteCounter++;
        if (spriteCounter > 7) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;

        }


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
    public void draw (Graphics2D g2){
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        switch(direction){

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
        g2.drawImage(image,screenX,screenY,gp.tileSize, gp.tileSize, null);
    }

}
