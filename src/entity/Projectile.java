package entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile extends Entity{

    public Projectile(GamePanel gp){
        super(gp);


    }
    public void set(int worldX,int worldY, String direction, boolean alive){
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction=direction;
        this.alive = alive;
        this.life = this.maxLife;
    }
    public void update(){
        solidArea.x = 100;
        boolean contactPlayer = gp.cChecker.checkPlayer(this);
        if (gp.player.invincible == false && contactPlayer == true){
            damagePlayer(attack);
            gp.projectileList.remove(this);
            alive = false;
        }



        switch (direction){
            case "right": worldX += speed;
            break;
            case "left": worldX -= speed;
                break;
        }
        life --;
        if (life <= 0){
            gp.projectileList.remove(this);
            alive = false;
        }

        spriteCounter++;
        if (spriteCounter > 5) {
            if (spriteNum == 0){
                spriteNum = 1;
            }else if (spriteNum == 1){
                spriteNum = 0;
            }
            spriteCounter = 0;

        }


    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction){
            case "right": image = imageRight[spriteNum];
                break;
            case "left":image = imageLeft[spriteNum];
                break;
        }
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY-gp.player.worldY + gp.player.screenY;

        g2.drawImage(image, screenX, screenY, gp.tileSize *3, gp.tileSize*3, null);
    }
}

