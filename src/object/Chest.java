package object;

import Main.GamePanel;
import object.Shields.Shield;
import object.Shields.Shield_Epic;
import object.Shields.Shield_Legendary;
import object.Shields.Shield_Mystic;
import object.Sword.Sword_Legendary;
import object.Sword.Sword_Mystic;
import object.Sword.Weapon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Chest extends SuperObject{
    GamePanel gp;
    int item = new Random().nextInt(7)+1;
    int randomItem;


    public Chest(GamePanel gp){
        this.gp = gp;
        name = "Chest";
        spriteNum = 1;
        type = 4;
        setItems();


        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0(73).png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0(74).png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0(75).png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0(76).png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        collision = false;
    }
    public void update(){


        if (chestIsOpening==true){
            animationCounter++;
            if (animationCounter > 6) {
                if (spriteNum == 4){
                    spriteNum = 3;
                    chestIsOpening= false;

                }
                spriteNum ++;
                animationCounter = 0;

            }
        }
        if (chestIsClosing==true){
            animationCounter++;
            if (animationCounter > 6) {
                if (spriteNum == 1){
                    spriteNum = 2;
                    chestIsOpening= false;

                }
                spriteNum --;
                animationCounter = 0;

            }
        }



    }
    public void draw(Graphics2D g2, GamePanel gp){
        BufferedImage realimage = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        switch (spriteNum){
            case 1: realimage = image;
                break;
            case 2: realimage = image2;
                break;
            case 3: realimage = image3;
                break;
            case 4: realimage = image4;
                break;
        }

        g2.drawImage(realimage,screenX,screenY,gp.tileSize,gp.tileSize,null);
    }
    public void setItems(){
        for (int i = 0; i <= item; i++) {
            randomItem = new Random().nextInt(100)+1;
            if (randomItem <=2){
                inventory.add(new Shield_Mystic(gp));
            }
            if (randomItem <=4 && randomItem>2){
                inventory.add(new Sword_Mystic(gp));
            }
            if (randomItem <=8 && randomItem>4){
                inventory.add(new Sword_Legendary(gp));
            }
            if (randomItem <=12 && randomItem>8){
                inventory.add(new Shield_Legendary(gp));
            }
            if (randomItem <=20 && randomItem>12){
                inventory.add(new Shield_Epic(gp));
            }
            if (randomItem <=42 && randomItem>20){
                inventory.add(new Weapon(gp));
            }
            if (randomItem <=54 && randomItem>42){
                inventory.add(new Shield(gp));
            }
            if (randomItem <=74 && randomItem>54){
                inventory.add(new Potion_Orange(gp));
            }
            if (randomItem <=80 && randomItem>74){
                inventory.add(new Potion_Blue(gp));
            }
            if (randomItem>100){
                inventory.add(new Coin(gp));
            }


        }


    }
    public void getItem(){
        int itemIndex = gp.ui.getItemIndex();
        if (itemIndex <inventory.size()){
            SuperObject selectedItem = inventory.get(itemIndex);
            if (selectedItem.type == type_pickUponly){
                selectedItem.use();
                inventory.remove(itemIndex);
            } else if (gp.player.canObtainItem(selectedItem)==true){
                    inventory.remove(itemIndex);

                }else {
                    gp.ui.ErrorText = "Inventory is full";
                }


        }
    }
}
