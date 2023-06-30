package entity;

import Main.GamePanel;
import object.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Shop extends SuperObject {

    BufferedImage[] image = new BufferedImage[6];
    GamePanel gp;
    public Shop(GamePanel gp){
       this.gp = gp;
        getImage();
        name = "Shop";
        setItems();


    }
    public void getImage(){
        try {
            image[0] = ImageIO.read(getClass().getResourceAsStream("/objects#/shop_anim.png"));
            image[1] = ImageIO.read(getClass().getResourceAsStream("/objects#/shop_anim(1).png"));
            image[2] = ImageIO.read(getClass().getResourceAsStream("/objects#/shop_anim(2).png"));
            image[3] = ImageIO.read(getClass().getResourceAsStream("/objects#/shop_anim(3).png"));
            image[4] = ImageIO.read(getClass().getResourceAsStream("/objects#/shop_anim(4).png"));
            image[5] = ImageIO.read(getClass().getResourceAsStream("/objects#/shop_anim(5).png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        animationCounter++;
        if (animationCounter > 10) {
            if (spriteNum == 5){
                spriteNum = -1;
            }
            spriteNum ++;
            animationCounter = 0;

        }

    }


    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        g2.drawImage(image[spriteNum],screenX,screenY,gp.tileSize*6,gp.tileSize*6,null);
    }
    public void setItems(){
        inventory.add(new Shield(gp));
        inventory.add(new Weapon(gp));
        inventory.add(new Potion_Orange(gp));
        inventory.add(new Key());


    }
    public void buyItem(){
        int itemIndex = gp.ui.getItemIndex();
        if (itemIndex <inventory.size()){
            SuperObject selectedItem = inventory.get(itemIndex);

                if (selectedItem.coinValue <= gp.player.coin) {
                    if (gp.player.canObtainItem(selectedItem)==true){
                    inventory.remove(itemIndex);
                     gp.player.coin -= selectedItem.coinValue;
                     }else {
                   gp.ui.ErrorText = "Inventory is full";
                    }
            }else{gp.ui.ErrorText ="Not enough Coins";
            }

        }
    }
}
