package entity;

import Main.GamePanel;
import object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX,worldY;
    public int speed;
    public BufferedImage[] imageRight,imageLeft, jumpRight,jumpLeft,attackRight,attackLeft,shieldRight,shieldLeft,idleRight,idleLeft;
    public Projectile projectile;
    public boolean alive = true;

    public Rectangle attackArea = new Rectangle(0,0,0,0);

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
    public int animationNum = 1;
    public int shotAvailableCounter = 0;
    public int strength;
    public int attack;
    public int defense;
    public int level;
    public int coin;
    public int maxLife;
    public int life;
    public int npcWidth;
    public int npcHeight;
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
        gp.cChecker.checkObject(this,false);
      boolean contactPlayer = gp.cChecker.checkPlayer(this);
      if (attacking==true){
          animationCounter ++;
          if (animationCounter > 4){
              if (animationNum == 17){
                  attacking = false;
                  animationNum =0;

              }animationNum ++;
              animationCounter = 0;
          }


      }


      if (this.type == 1 && contactPlayer == true&&attacking==true){
          damagePlayer(attack);
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
        if (shotAvailableCounter<30){
            shotAvailableCounter++;
        }


    }
    public void damagePlayer(int attack){
        if (gp.player.invincible == false && gp.player.guard == false){
            int damage = attack - gp.player.defense;
            if (damage<0){
                damage = 0;
            }
            gp.player.life = gp.player.life-damage;
            gp.player.invincible = true;
        }

    }
    public void draw (Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;


        if (attacking==true){
            npcWidth = 110;
            npcHeight= 100;
            screenX = screenX -(105-59);
            screenY = screenY -(100-88);
        }else{
            npcWidth = 59;
            npcHeight =88;}

        switch (direction) {

            case "right":
                if (attacking == true){
                    image = attackRight[animationNum];
                }
                else {
                image = imageRight[spriteNum - 1];}
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
        g2.drawImage(image, screenX, screenY, npcWidth, npcHeight, null);

    }
    public void checkDrop(){}
    public void dropItem(SuperObject droppedIem){
        for (int i = 0;i<gp.obj.length;i++){
            if (gp.obj[i]==null){
                gp.obj[i] = droppedIem;
                gp.obj[i].worldX = worldX;
                gp.obj[i].worldY = worldY;
                break;

            }
        }
    }


}
