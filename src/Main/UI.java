package Main;

import object.Heart;
import object.Key;
import object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font arial_40;
    public boolean gameFinished = false;
    BufferedImage heartfull, hearthalf, heartblank;

    BufferedImage keyImage;
    public  UI (GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        Key key = new Key();
        keyImage = key.image;
        SuperObject heart = new Heart(gp);
        heartfull = heart.image;
        hearthalf = heart.image2;
        heartblank = heart.image3;
    }
    public void draw(Graphics2D g2){
        if (gameFinished == true){
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            String text;
            int textlength;
            int x;
            int y;
            text = "You won";
            textlength = (int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = gp.screenWidth/2 - textlength;
            y = 100;
            g2.drawString(text,x,y);
            gp.gameThread = null;
        } else {
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
            g2.drawString(""+gp.player.hasKey, 10,65);}
        drawPlayerLife(g2);


    }
    public void drawPlayerLife(Graphics2D g2){
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;
        while (i<gp.player.maxLife/2){
            g2.drawImage(heartblank,x,y,gp.tileSize,gp.tileSize,null);
            i++;
            x += gp.tileSize;
        }
         x = gp.tileSize/2;
         y = gp.tileSize/2;
         i = 0;
        while (i<gp.player.life){
            g2.drawImage(hearthalf,x,y,gp.tileSize,gp.tileSize,null);
            i++;
            if (i< gp.player.life){
                g2.drawImage(heartfull,x,y,gp.tileSize,gp.tileSize,null);
            }
            i++;
            x += gp.tileSize;
        }
    }
}
