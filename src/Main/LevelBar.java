package Main;

import java.awt.*;

public class LevelBar {
    GamePanel gp;

    Rectangle levelbar;

    int rectanglex;
    public LevelBar(GamePanel gp){
        this.gp = gp;

    }
    public void update(){
rectanglex = gp.player.worldX / 48;
    }
    public void draw(Graphics2D g2){
        g2.drawRect(gp.screenWidth/2 - 160,50,320,20);
        g2.setColor(Color.red);
        g2.fillRect(gp.screenWidth/2 - 160,50,rectanglex,20);
    }
}
