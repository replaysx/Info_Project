package entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX,worldY;
    public int speed;
    public BufferedImage[] imageRight,imageLeft, jumpRight,jumpLeft,attackRight,attackLeft;



    public String direction ;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(5,5,50,100);
    public boolean collisionon = false;

    public boolean isgrounded = false;
    public int solidAreaDefaultX,solidAreaDefaultY;
    public String name;
    public BufferedImage image;

    public int type;
    boolean attacking = false;
    public int animationCounter = 0;
    public int animationNum = 0;
    public Rectangle attackArea = new Rectangle(0,0,0,0);

    public int strength;
    public int attack;
    public int defense;
    public int level;
    public int coin;
    public Entity currentWeapon;
    public Entity currentShield;
    public int attackValue;
    public int defenseValue;
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
      boolean contactPlayer = gp.cChecker.checkPlayer(this);

      if (this.type == 1 && contactPlayer == true){
          if (gp.player.invincible == false){
              gp.player.life -= 1;
              gp.player.invincible = true;
          }
      }

        spriteCounter++;
        if (spriteCounter > 5) {
            if (spriteNum == 13){
                spriteNum = 0;
            }
            spriteNum ++;
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
    public void draw (Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        switch (direction) {

            case "right":
                image = imageRight[spriteNum - 1];
                break;
            case "left":
                image = imageLeft[spriteNum - 1];
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
        g2.drawImage(image, screenX, screenY, gp.tileSize*2, gp.tileSize * 2, null);

    }

}
