package entity;

import Main.GamePanel;
import object.*;
import object.Shields.Shield;
import object.Shields.Shield_Epic;
import object.Shields.Shield_Legendary;
import object.Shields.Shield_Mystic;
import object.Sword.Sword_Legendary;
import object.Sword.Sword_Mystic;
import object.Sword.Weapon;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Entity {
    GamePanel gp;
    public Projectile projectile;

    // Images
    public BufferedImage[] imageRight,imageLeft, jumpRight,jumpLeft,attackRight,attackLeft,shieldRight,shieldLeft,idleRight,idleLeft;
    public BufferedImage image;



    //Solid Area,Attack Area von Entity
    public Rectangle solidArea = new Rectangle(5,5,50,60);
    public int solidAreaDefaultX,solidAreaDefaultY;
    public Rectangle attackArea = new Rectangle(0,0,0,0);


    //Werte von Entity
    public int worldX,worldY;
    public String direction ;
    public int speed;
    public String name;
    public int type;
    public int strength;
    public int attack;
    public int defense;
    public int level;
    public int coin;
    public int maxLife;
    public int life;
    public int npcWidth;
    public int npcHeight;


    //Zustände von Entity
    boolean attacking = false;
    public boolean collisionon = false;
    public boolean isgrounded = false;
    public boolean alive = true;


    //Counter,etc. für Animationen;
    public int animationCounter = 0;
    public int animationNum = 1;
    public int shotAvailableCounter = 0;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Entity(GamePanel gp){
        this.gp = gp;
    }
    public void setAction(){

    }

    public void update(){
        // updated Entity in seperaten Methode
        setAction();


        //überprüft Kollision mit anderen Entity,MapTiles
        collisionon = false;
       gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this,false);
      boolean contactPlayer = gp.cChecker.checkPlayer(this);



      if (this.type == 1 && contactPlayer == true&&attacking==true&&animationNum==8){
          damagePlayer(attack);
      }
        if (shotAvailableCounter<300){
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
        // berechnet wo ein gegenstand gezeichnet werden muss
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

       // erstellt eine HP-Bar über Monster;
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
    public void checkDrop(){
        int randomItem = new Random().nextInt(100)+1;
        if (randomItem <=2){
            dropItem(new Shield_Mystic(gp));
        }
        if (randomItem <=4 && randomItem>2){
            dropItem(new Sword_Mystic(gp));
        }
        if (randomItem <=8 && randomItem>4){
            dropItem(new Sword_Legendary(gp));
        }
        if (randomItem <=12 && randomItem>8){
            dropItem(new Shield_Legendary(gp));
        }
        if (randomItem <=20 && randomItem>12){
            dropItem(new Shield_Epic(gp));
        }
        if (randomItem <=42 && randomItem>20){
            dropItem(new Weapon(gp));
        }
        if (randomItem <=54 && randomItem>42){
            dropItem(new Shield(gp));
        }
        if (randomItem <=74 && randomItem>54){
            dropItem(new Potion_Orange(gp));
        }
        if (randomItem <=80 && randomItem>74){
            dropItem(new Potion_Blue(gp));
        }
        if (randomItem>80){
            dropItem(new Coin(gp));
        }

    }
    public void dropItem(SuperObject droppedIem){
        for (int i = 0;i<gp.obj.length;i++){
            if (gp.obj[i]==null){
                gp.obj[i] = droppedIem;
                gp.obj[i].worldX = worldX+30;
                gp.obj[i].worldY = worldY+30;
                break;

            }
        }
    }


}
