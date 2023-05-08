package Main;

import java.awt.*;

public class EventHandler {
    GamePanel gp;
    Rectangle eventRec;
    int eventRecDefaultX,eventRecDefaultY;
    int damage = 1;

    public EventHandler(GamePanel gp){
        this.gp = gp;
        eventRec = new Rectangle();
        eventRec.x = 23;
        eventRec.y = 23;
        eventRec.width = 2;
        eventRec.height = 2;
        eventRecDefaultX = eventRec.x;
        eventRecDefaultY = eventRec.y;
    }
    public void checkEvent(){
        if (hit(95,7,"any")==true){damageFireLake();}
        else {damage = 1;}
        if (hit(94,7,"any")==true){damageFireLake();}
        else {damage = 1;}
        if (hit(100,7,"any")==true){teleport();}

    }
    public boolean hit(int eventCol,int eventRow, String reqDirection){
        boolean hit = false;
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRec.x = eventCol*gp.tileSize + eventRec.x;
        eventRec.y = eventRow*gp.tileSize + eventRec.y;
        if (gp.player.solidArea.intersects(eventRec)){
            if (gp.player.direction.contentEquals(reqDirection)|| reqDirection.contentEquals("any"))  {
                hit = true;
            }

        }
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRec.x = eventRecDefaultX;
        eventRec.y = eventRecDefaultY;
        return  hit;
    }
    public void damageFireLake(){
        gp.player.life = gp.player.life -damage ;
        damage = 0;
    }
    public void teleport(){
        gp.player.worldX = 100;
        gp.player.worldY = 100;
    }
}
