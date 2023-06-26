package object;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image, image2, image3;
    public  String name;
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

    public String description = "";
    public int type;
    public final int type_weapon = 0;
    public final int type_shield = 1;
    public final int type_consumable = 2;

    public final int type_pickUponly= 3;
    double verticaleMovement = 1;
    int realvertical;
    boolean rising = true;
    public void use(){}

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        if (name == "OrangeJuice"){
            if (rising == true){
                verticaleMovement +=0.25;
                if (verticaleMovement == 10){
                    rising = false;
                }
            }else {
                verticaleMovement -= 0.25;
                if (verticaleMovement == -10){
                    rising = true;
                }
            }


            screenY = screenY + (int)verticaleMovement;
            System.out.println(verticaleMovement);
        }
        g2.drawImage(image,screenX,screenY,gp.tileSize, gp.tileSize, null);
    }

}
