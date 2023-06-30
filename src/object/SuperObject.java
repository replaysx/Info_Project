package object;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class SuperObject {
    public BufferedImage image, image2, image3,image4;

    public  String name = "";
    public int coinValue;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX =0;
    public int solidAreaDefaultY =0;
    public int attackValue;
    public int defenseValue;
    public int attackWidth;
    public int attackHeight;
    public Color rarity;
    public String rarityType;
    public boolean chestIsOpening=false;
    public boolean chestIsClosing=false;
    public boolean stackable = false;
    public int amount = 1;
    public String description = "";

    public int animationCounter = -1;
    public int spriteNum = 0;
    // Rarity Color
    public Color common = new Color(100,100,100);
    public Color rare = new Color(0,60,150);
    public Color epic = new Color(134, 69, 192);
    public Color legendary = new Color(255, 230, 0);
    public Color mystic = new Color(154, 0, 0);


    //verschiedene type für unterschiedliche Items
    public int type;
    public final int type_weapon = 0;
    public final int type_shield = 1;
    public final int type_consumable = 2;
    public final int type_pickUponly= 3;

    //Inventory
    public ArrayList<SuperObject> inventory = new ArrayList<>();
    public final int maxInventorySize = 10;



    public void use(){}

    public void update(){

    }
    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        g2.drawImage(image,screenX,screenY,gp.tileSize, gp.tileSize, null);
    }

    public void buyItem(){}
    public void getItem(){}

}
