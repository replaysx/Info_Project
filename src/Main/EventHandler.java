package Main;

import java.awt.*;

public class EventHandler {
    GamePanel gp;
    EventRect eventRect [][];
    int previouseventX;
    int previouseventY;
    boolean cantouchevent=true;
    int damage = 1;


    public EventHandler(GamePanel gp){
        this.gp = gp;
        eventRect= new EventRect[gp.maxWorldCol][gp.maxWorldRow];
        int col =0;
        int row = 0;
        while (col<gp.maxWorldCol&&row<gp.maxWorldRow){
            eventRect[col][row] =new EventRect();
            eventRect[col][row].x = 23;
            eventRect[col][row].y = 23;
            eventRect[col][row].width = 2;
            eventRect[col][row].height = 2;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;
            col++;
            if (col==gp.maxWorldCol){
                col=0;
                row++;

            }
        }

    }
    public void checkEvent(){
        int xDistance = Math.abs(gp.player.worldX-previouseventX);
        int yDistance = Math.abs(gp.player.worldY-previouseventY);
        int distance = Math.max(xDistance,yDistance);
        if (distance>gp.tileSize){
            cantouchevent=true;
        }
        if (cantouchevent==true) {
            if (hit(98, 7, "any") == true) {
                damageFireLake(95, 7);
            } else {
                damage = 1;
            }
            if (hit(94, 7, "any") == true) {
                damageFireLake(94, 7);
            } else {
                damage = 1;
            }
            if (hit(100, 7, "any") == true) {
                teleport(100, 7);
            }
        }

    }
    public boolean hit(int col,int row, String reqDirection){
        boolean hit = false;
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect[col][row].x = col*gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row*gp.tileSize + eventRect[col][row].y;
        if (gp.player.solidArea.intersects(eventRect[col][row])&&eventRect[col][row].eventDone==false){
            if (gp.player.direction.contentEquals(reqDirection)|| reqDirection.contentEquals("any"))  {
                hit = true;

                previouseventX=gp.player.worldX;
                previouseventY=gp.player.worldY;
            }

        }
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;
        return  hit;
    }
    public void damageFireLake(int col, int row){


        gp.player.life = gp.player.life -damage ;
        damage = 0;
        eventRect[col][row].eventDone=false;
        cantouchevent=false;

    }
    public void teleport(int col, int row){

        gp.player.worldX = 100;
        gp.player.worldY = 100;
    }
}
