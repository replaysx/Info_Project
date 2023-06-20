package Main;

import object.Heart;
import object.Key;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {
    GamePanel gp;

    Graphics2D g2;
    Font arial_40;
    public boolean gameFinished = false;

    public int commandNum=0;

    BufferedImage heartfull, hearthalf, heartblank;

    BufferedImage keyImage;

    BufferedImage Title,LevelScreen;
    public  UI (GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        Key key = new Key();
        keyImage = key.image;
        SuperObject heart = new Heart(gp);
        heartfull = heart.image;
        hearthalf = heart.image2;
        heartblank = heart.image3;
        try {
            Title = ImageIO.read(getClass().getResourceAsStream("/Map/Jump & RUn.png"));
            LevelScreen = ImageIO.read(getClass().getResourceAsStream("/Map/Jump & RUn(1).png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public void draw(Graphics2D g2){
        this.g2 =g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);
        //Titel State
        if(gp.gameState==gp.titleState){
            drawTitleScreen();
        }
        //Play State
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
        //Pause State
        if (gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        if (gp.gameState == gp.levelState){
            drawLevelScreen();
        }
        if (gp.gameState == gp.characterState){
            drawCharacterScreen();
        }


    }
    public void drawTitleScreen(){
        /*g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        //Titelname
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,72F));
        String text = "Johannes der Hüpfer";
        int x =getXforCenterText(text);
        int y=gp.tileSize*3;
        //Schatten
        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);
        //Main Color
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        //Titelbild
        x=gp.screenWidth/2- (gp.tileSize*2)/2;
        y=y+gp.tileSize*2;
        g2.drawImage(gp.player.right2, x,y,gp.tileSize*2,gp.tileSize*2,null);
        //Menü
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        text ="NEW GAME";
        x =getXforCenterText(text);
        y=y+gp.tileSize*4;
        g2.drawString(text,x,y);


        text ="LOAD GAME";
        x =getXforCenterText(text);
        y=y+gp.tileSize;
        g2.drawString(text,x,y);


        text ="QUIT";
        x =getXforCenterText(text);
        y=y+gp.tileSize;
        g2.drawString(text,x,y);*/

        g2.drawImage(Title,0,0,gp.screenWidth,gp.screenHeight,null);
        if (commandNum==0){
            g2.drawString(">",255,340);
        }
        if (commandNum==1){
            g2.drawString(">",245,405);
        }
        if (commandNum==2){
            g2.drawString(">",310,470);
        }
    }
    public void drawLevelScreen(){
       g2.drawImage(LevelScreen,0,0,gp.screenWidth,gp.screenHeight,null);
        if (commandNum==0){
            g2.drawString(">",40,405);
        }
        if (commandNum==1){
            g2.drawString(">",275,405);
        }
        if (commandNum==2){
            g2.drawString(">",520,405);
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
    public void drawCharacterScreen(){
        final int frameX = gp.tileSize;
        final int frameY= gp.tileSize;
        final int frameWidth= gp.tileSize*6;
        final int frameHeight= gp.tileSize*10;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));

        int textX = frameX + 20;
        int textY = frameY + gp.tileSize;
        final int lineHeight = 50;
        g2.drawString("Level",textX,textY);
        textY += lineHeight;
        g2.drawString("Life",textX,textY);
        textY += lineHeight;
        g2.drawString("Strength",textX,textY);
        textY += lineHeight;
        g2.drawString("Attack",textX,textY);
        textY += lineHeight;
        g2.drawString("Defense",textX,textY);
        textY += lineHeight;
        g2.drawString("Coins",textX,textY);
        textY += lineHeight + 20;
        g2.drawString("Weapon",textX,textY);
        textY += lineHeight + 15;
        g2.drawString("Shield",textX,textY);

        int rightX = (frameX +frameWidth) -30;
        textY = frameY + gp.tileSize;
        String value;
        value = String.valueOf(gp.player.level);
        textX = getXRightSide(value,rightX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
        textX = getXRightSide(value,rightX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.strength);
        textX = getXRightSide(value,rightX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.attack);
        textX = getXRightSide(value,rightX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.defense);
        textX = getXRightSide(value,rightX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.coin);
        textX = getXRightSide(value,rightX);
        g2.drawString(value,textX,textY);
        textY += lineHeight -20;

        g2.drawImage(gp.player.currentWeapon.image, rightX-gp.tileSize,textY,gp.tileSize,gp.tileSize,null);
        textY += gp.tileSize + 15;
        g2.drawImage(gp.player.currentShield.image, rightX-gp.tileSize,textY,gp.tileSize,gp.tileSize,null);


    }
    public void drawSubWindow(int x, int y ,int width,int height){
        Color c = new Color(96, 96, 96, 150);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,20,20);

        c = new Color(255, 255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,10,10);



    }
    public int getXRightSide(String text,int rightX){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x= rightX-length;
        return  x;
    }
}
