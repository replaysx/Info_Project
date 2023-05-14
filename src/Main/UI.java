package Main;

import object.Heart;
import object.Key;
import object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;

    Graphics2D g2;
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
        this.g2 =g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);
        if (gp.gameState == gp.playState) {
            if (gameFinished == true) {
                g2.setFont(arial_40);
                g2.setColor(Color.white);
                String text;
                int textlength;
                int x;
                int y;
                text = "You won";
                textlength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth / 2 - textlength;
                y = 100;
                g2.drawString(text, x, y);
                gp.gameThread = null;
            } else {
                g2.setFont(arial_40);
                g2.setColor(Color.white);
                g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
                g2.drawString("" + gp.player.hasKey, 10, 65);
            }
            drawPlayerLife(g2);
        }
        if (gp.gameState == gp.pauseState){
            drawPauseScreen();
        }


    }
    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,60F));
        String text = "PAUSED";
        int x = getXforCenterText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);

    }
    public int getXforCenterText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x= gp.screenWidth/2 - length/2;
        return  x;
    }
    public void drawPlayerLife(Graphics2D g2){
        int x = gp.tileSize/2;
        int y = gp.screenHeight-2*gp.tileSize;
        int i = 0;
        while (i<gp.player.maxLife/2){
            g2.drawImage(heartblank,x,y,gp.tileSize,gp.tileSize,null);
            i++;
            x += gp.tileSize;
        }
         x = gp.tileSize/2;
         y = gp.screenHeight-2*gp.tileSize;
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
