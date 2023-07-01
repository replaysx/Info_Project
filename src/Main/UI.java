package Main;

import object.Coin;
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
    Font Arcade;
    public boolean gameFinished = false;

    public int commandNum=0;

    BufferedImage heartfull, hearthalf, heartblank,coinImage;
    public int slotCol = 0;
    public int slotRow = 0;
    public String ErrorText ="";


    BufferedImage Title,LevelScreen;
    public  UI (GamePanel gp){
        this.gp = gp;
        Arcade = new Font("Arcade",Font.LAYOUT_NO_LIMIT_CONTEXT,40);
        arial_40 = new Font("Arial",Font.PLAIN,40);
        Coin coin = new Coin(gp);
        coinImage = coin.image;
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
            drawInventory(true);
        }
        if (gp.gameState == gp.gameOverState){
            drawGameOverScreen();
        }
        if (gp.gameState == gp.tradeState){
            drawInventory(false);
            drawShopInventory();
            if (ErrorText != ""){
                drawErrorScreen();
            }
        }
        if (gp.gameState == gp.chestState){
            drawInventory(false);
            drawChestInventory();
            if (ErrorText != ""){
                drawErrorScreen();
            }
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
            g2.drawString(">",330,340);
        }
        if (commandNum==1){
            g2.drawString(">",320,405);
        }
        if (commandNum==2){
            g2.drawString(">",385,470);
        }
    }
    public void drawLevelScreen(){
       g2.drawImage(LevelScreen,0,0,gp.screenWidth,gp.screenHeight,null);
        if (commandNum==0){
            g2.drawString(">",60,405);
        }
        if (commandNum==1){
            g2.drawString(">",370,405);
        }
        if (commandNum==2){
            g2.drawString(">",695,405);
        }


    }
    public void drawErrorScreen(){
        final int frameX = gp.tileSize*13;
        final int frameY= gp.tileSize*7;
        final int frameWidth= gp.tileSize*7;
        final int frameHeight= gp.tileSize*2;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        int x = 350 +getXforCenterText(ErrorText);
        int y = frameY+60;
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(2));
        g2.setFont(g2.getFont().deriveFont(30F));
        g2.drawString(ErrorText,x,y);
    }
    public void drawGameOverScreen(){
        drawSubWindow(50,50,gp.screenWidth-100, gp.screenHeight-100);
        int x ;
        int y;
        String text;
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110F));
        text = "Game Over";
        x = getXforCenterText(text);
        y = gp.tileSize*4;
        g2.drawString(text,x,y);


        g2.setFont(g2.getFont().deriveFont(Font.BOLD,60F));
        text = "Retry";
        x= getXforCenterText(text);
        y  += gp.tileSize*4;
        g2.drawString(text,x,y);
        if (commandNum==0){
            g2.drawString(">",x-40,y);
        }


        text = "Back to Menu";
        x= getXforCenterText(text);
        y  += gp.tileSize*2;
        g2.drawString(text,x,y);
        if (commandNum==1){
            g2.drawString(">",x-40,y);
        }

    }
    public void drawPauseScreen(){
        drawSubWindow(50,50,gp.screenWidth-100,gp.screenHeight-100);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,60F));

        int x ;
        int y;
        String text;
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110F));
        text = "PAUSED";
        x = getXforCenterText(text);
        y = gp.tileSize*4;
        g2.drawString(text,x,y);


        g2.setFont(g2.getFont().deriveFont(Font.BOLD,60F));
        if (gp.player.atShop == false) {
            text = "Continue";
            x = getXforCenterText(text);
            y += gp.tileSize * 2;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - 40, y);
            }
        }

        if (gp.player.atShop == false){
        text = "Shop";
        }else {
            text="Back to Game";
        }
        x= getXforCenterText(text);
        y  += gp.tileSize*2;
        g2.drawString(text,x,y);
        if (commandNum==1){
            g2.drawString(">",x-40,y);
        }
        text = "Back to Menu";
        x= getXforCenterText(text);
        y  += gp.tileSize*2;
        g2.drawString(text,x,y);
        if (gp.player.atShop==false){
        if (commandNum==2){
            g2.drawString(">",x-40,y);
        }
        }else{
            if (commandNum==0){
                g2.drawString(">",x-40,y);
            }
        }

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
    public void drawShopInventory(){
        final int frameX = gp.tileSize*2;
        final int frameY= gp.tileSize;
        final int frameWidth= gp.tileSize*7;
        final int frameHeight= gp.tileSize*3 +gp.tileSize/2-15;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);




        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;
        int slotSize = gp.tileSize +14;
        g2.setStroke(new BasicStroke(2));
        for (int i =0; i<gp.obj[12].maxInventorySize;i++) {


            g2.setColor(Color.black);
            g2.drawRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
            slotX+=slotSize;
            if (i==4){
                slotX = slotXstart;
                slotY += slotSize;
            }
        }
        slotX = slotXstart;
        slotY = slotYstart;

        for (int i = 0;i<gp.obj[12].inventory.size();i++){
            if(gp.obj[12].inventory.get(i).rarity != null){
                g2.setColor(gp.obj[12].inventory.get(i).rarity);
                g2.fillRoundRect(slotX,slotY,gp.tileSize,gp.tileSize,10,10);}

            g2.drawImage(gp.obj[12].inventory.get(i).image,slotX,slotY,gp.tileSize,gp.tileSize,null);
            slotX += slotSize;
            if (i==4){
                slotX=slotXstart;
                slotY += slotSize;
            }

        }

        int cursorX = slotXstart + (slotSize * slotCol);
        int cursorY = slotYstart + (slotSize * slotRow);
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(cursorX,cursorY,cursorWidth,cursorHeight,10,10);

        int dframeX = frameX;
        int dframeY= frameY+frameHeight+20;
        int dframeWidth= frameWidth;
        int dframeHeight= gp.tileSize*3;


        int textX = dframeX +20;
        int textY = dframeY +gp.tileSize;
        g2.setFont(Arcade);
        g2.setFont(g2.getFont().deriveFont(28F));
        int itemIndex = getItemIndex();

        if (itemIndex < gp.obj[12].inventory.size()){
            drawSubWindow(dframeX,dframeY,dframeWidth,dframeHeight);
            for (String line: gp.obj[12].inventory.get(itemIndex).description.split("\n")) {
                g2.drawString(line, textX, textY);
                textY += 32;
            }
            drawSubWindow(dframeX,dframeY+3* gp.tileSize,dframeWidth,75);
            g2.drawImage(coinImage,dframeX+10,dframeY+3* gp.tileSize+13,gp.tileSize,gp.tileSize,null);
            int CoinValueX = getXRightSide(""+gp.obj[12].inventory.get(itemIndex).coinValue,dframeX+dframeWidth-50);
            g2.setFont(g2.getFont().deriveFont(45F));
            g2.drawString(""+gp.obj[12].inventory.get(itemIndex).coinValue,CoinValueX,dframeY+4* gp.tileSize+5);

        }
    }
    public void drawInventory(boolean Cursor){
        final int frameX = gp.tileSize*13;
        final int frameY= gp.tileSize;
        final int frameWidth= gp.tileSize*7;
        final int frameHeight= gp.tileSize*5+32;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);


        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;
        int slotSize = gp.tileSize +14;
        g2.setStroke(new BasicStroke(2));
        for (int i =0; i<gp.player.maxInventorySize;i++) {
            g2.setColor(Color.black);
            g2.drawRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
            slotX+=slotSize;
            if (i==4||i==9||i==14){
                slotX = slotXstart;
                slotY += slotSize;
            }
        }
        slotX = slotXstart;
        slotY = slotYstart;

        for (int i = 0;i<gp.player.inventory.size();i++){

            if(gp.player.inventory.get(i).rarity != null){
                g2.setColor(gp.player.inventory.get(i).rarity);
            g2.fillRoundRect(slotX,slotY,gp.tileSize,gp.tileSize,10,10);}

            g2.drawImage(gp.player.inventory.get(i).image,slotX,slotY,gp.tileSize,gp.tileSize,null);

            if (gp.player.inventory.get(i).amount > 1){
                g2.setFont(g2.getFont().deriveFont(32F));
                int amountX;
                int amountY;
                String s = ""+ gp.player.inventory.get(i).amount;
                amountX = getXRightSide(s, slotX+44);
                amountY = slotY +gp.tileSize;
                g2.setColor(Color.white);
                g2.setStroke(new BasicStroke(4));
                g2.drawString(s,amountX,amountY);
            }

            slotX += slotSize;
            if (i==4||i==9||i==14){
                slotX=slotXstart;
                slotY += slotSize;
            }

        }
        int dframeX = frameX;
        int dframeY = frameY + frameHeight + 20;
        int dframeWidth = frameWidth;
        int dframeHeight = gp.tileSize * 3;
if (Cursor == true) {
    int cursorX = slotXstart + (slotSize * slotCol);
    int cursorY = slotYstart + (slotSize * slotRow);
    int cursorWidth = gp.tileSize;
    int cursorHeight = gp.tileSize;
    g2.setColor(Color.white);
    g2.setStroke(new BasicStroke(2));
    g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);


    int textX = dframeX + 20;
    int textY = dframeY + gp.tileSize;
    g2.setFont(Arcade);
    g2.setFont(g2.getFont().deriveFont(28F));
    int itemIndex = getItemIndex();

    if (itemIndex < gp.player.inventory.size()) {
        drawSubWindow(dframeX, dframeY, dframeWidth, dframeHeight);
        for (String line : gp.player.inventory.get(itemIndex).description.split("\n")) {
            g2.drawString(line, textX, textY);
            textY += 32;
        }

    }
}else {
    drawSubWindow(dframeX,dframeY,dframeWidth,75);
    g2.drawImage(coinImage,dframeX+10,dframeY+13,gp.tileSize,gp.tileSize,null);
    int CoinValueX = getXRightSide(""+gp.player.coin,dframeX+dframeWidth-50);
    g2.setFont(g2.getFont().deriveFont(45F));
    g2.drawString(""+gp.player.coin,CoinValueX,dframeY+ gp.tileSize+5);

}

}




    public void drawChestInventory(){
        final int frameX = gp.tileSize*2;
        final int frameY= gp.tileSize;
        final int frameWidth= gp.tileSize*6;
        final int frameHeight= gp.tileSize*3;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);




        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;
        int slotSize = gp.tileSize +3;
        g2.setStroke(new BasicStroke(2));

        for (int i =0; i<gp.obj[gp.keyH.chestIndex].maxInventorySize;i++) {


            g2.setColor(Color.black);
            g2.drawRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
            slotX+=slotSize;
            if (i==4){
                slotX = slotXstart;
                slotY += slotSize;
            }
        }
        slotX = slotXstart;
        slotY = slotYstart;

        for (int i = 0;i<gp.obj[gp.keyH.chestIndex].inventory.size();i++){
            if(gp.obj[gp.keyH.chestIndex].inventory.get(i).rarity != null){
                g2.setColor(gp.obj[gp.keyH.chestIndex].inventory.get(i).rarity );
                g2.fillRoundRect(slotX,slotY,gp.tileSize,gp.tileSize,10,10);}
            g2.drawImage(gp.obj[gp.keyH.chestIndex].inventory.get(i).image,slotX,slotY,gp.tileSize,gp.tileSize,null);
            slotX += slotSize;
            if (i==4){
                slotX=slotXstart;
                slotY += slotSize;
            }

        }

        int cursorX = slotXstart + (slotSize * slotCol);
        int cursorY = slotYstart + (slotSize * slotRow);
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(cursorX,cursorY,cursorWidth,cursorHeight,10,10);

        int dframeX = frameX;
        int dframeY= frameY+frameHeight+20;
        int dframeWidth= frameWidth;
        int dframeHeight= gp.tileSize*3;


        int textX = dframeX +20;
        int textY = dframeY +gp.tileSize;
        g2.setFont(Arcade);
        g2.setFont(g2.getFont().deriveFont(28F));
        int itemIndex = getItemIndex();

        if (itemIndex < gp.obj[gp.keyH.chestIndex].inventory.size()){
            drawSubWindow(dframeX,dframeY,dframeWidth,dframeHeight);
            for (String line: gp.obj[gp.keyH.chestIndex].inventory.get(itemIndex).description.split("\n")) {
                g2.drawString(line, textX, textY);
                textY += 32;
            }

        }
    }
    public int getItemIndex(){
        int ItemIndex = slotCol + (slotRow*5);
        return ItemIndex;
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
        g2.drawString("Life",textX,textY);
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

        value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
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
        g2.setColor(gp.player.currentWeapon.rarity);
        g2.fillRoundRect(gp.tileSize*6-30,textY,gp.tileSize,gp.tileSize,10,10);
        g2.drawImage(gp.player.currentWeapon.image, rightX-gp.tileSize,textY,gp.tileSize,gp.tileSize,null);
        textY += gp.tileSize + 15;
        g2.setColor(gp.player.currentShield.rarity);
        g2.fillRoundRect(gp.tileSize*6-30,textY,gp.tileSize,gp.tileSize,10,10);
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
