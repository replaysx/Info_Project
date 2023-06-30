package object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Chest extends SuperObject{
    GamePanel gp;
    int item = new Random().nextInt(7)+1;
    int randomItem;


    public Chest(GamePanel gp){
        this.gp = gp;
        name = "Chest";
        spriteNum = 1;
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
        System.out.println(chestIsOpening);

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
            randomItem = new Random().nextInt(4)+1;
            switch (randomItem){
                case 1: inventory.add(new Shield(gp));
                break;
                case 2: inventory.add(new Coin(gp));
                    break;
                case 3: inventory.add(new Weapon(gp));
                    break;
                case 4: inventory.add(new Potion_Orange(gp));
                    break;
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
