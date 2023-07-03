package Main;

import java.awt.*;

public class LevelBar {
    GamePanel gp;



    int rectanglex;
    public LevelBar(GamePanel gp){
        this.gp = gp;

    }
    public void update(){
rectanglex = gp.player.worldX / 48;
if (rectanglex >= 250){
    gp.ui.gameFinished = true;
}
    }
    public void draw(Graphics2D g2){
        g2.setStroke(new BasicStroke(4));
        g2.setColor(Color.black);
        g2.drawRect(gp.screenWidth/2-2 - 160,48,324,29);
        g2.setColor(Color.red);
        g2.fillRect(gp.screenWidth/2 - 160,50,rectanglex,25);
    }
}
