package entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile extends Entity{

    Entity user;
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

        boolean contactPlayer = gp.cChecker.checkPlayer(this);
        if (gp.player.invincible == false && contactPlayer == true){
            damagePlayer(attack);

            alive = false;
        }

        switch (direction){
            case "right": worldX += speed;
            break;
            case "left": worldY -= speed;
                break;
        }
        life --;
        if (life <= 0){
            alive = false;
        }
    }


}

