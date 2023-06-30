package Main;

import entity.NPC_Wizard;
import entity.Shop;
import object.*;

import java.util.Random;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        gp.obj[0] = new Key();
        gp.obj[0].worldX = 5 * gp.tileSize;
        gp.obj[0].worldY = 20*gp.tileSize;

        gp.obj[1] = new Key();
        gp.obj[1].worldX = 10* gp.tileSize;
        gp.obj[1].worldY = 20*gp.tileSize;


        gp.obj[2] = new Chest(gp);
        gp.obj[2].worldX = 15* gp.tileSize;
        gp.obj[2].worldY = 20*gp.tileSize;

        gp.obj[5] = new Key();
        gp.obj[5].worldX = 20* gp.tileSize;
        gp.obj[5].worldY = 20*gp.tileSize;

        gp.obj[3] = new Chest(gp);
        gp.obj[3].worldX = 33* gp.tileSize;
        gp.obj[3].worldY = 20*gp.tileSize;

        gp.obj[4] = new TubePortal();
        gp.obj[4].worldX = 30* gp.tileSize;
        gp.obj[4].worldY = 20*gp.tileSize;

        gp.obj[6] = new LavaPit();
        gp.obj[6].worldX = 35* gp.tileSize;
        gp.obj[6].worldY = 21*gp.tileSize;

        gp.obj[7] = new LavaPit();
        gp.obj[7].worldX = 40* gp.tileSize;
        gp.obj[7].worldY = 21*gp.tileSize;

        gp.obj[8] = new Heal();
        gp.obj[8].worldX = 45* gp.tileSize;
        gp.obj[8].worldY = 20*gp.tileSize;

        gp.obj[9] = new Potion_Orange(gp);
        gp.obj[9].worldX = 50* gp.tileSize;
        gp.obj[9].worldY = 20*gp.tileSize;

        gp.obj[10] = new Potion_Orange(gp);
        gp.obj[10].worldX = 55* gp.tileSize;
        gp.obj[10].worldY = 20*gp.tileSize;

        gp.obj[11] = new Chest(gp);
        gp.obj[11].worldX = 60* gp.tileSize;
        gp.obj[11].worldY = 20*gp.tileSize;

        gp.obj[12] = new Shop(gp);
        gp.obj[12].worldX = 20* gp.tileSize ;
        gp.obj[12].worldY = 20*gp.tileSize-gp.tileSize*5;

        gp.obj[13] = new Shield(gp);
        gp.obj[13].worldX = 32* gp.tileSize ;
        gp.obj[13].worldY = 20*gp.tileSize;

        gp.obj[14] = new Coin(gp);
        gp.obj[14].worldX = 39* gp.tileSize ;
        gp.obj[14].worldY = 20*gp.tileSize;
    }
    public void setNPC(){
        gp.npc[0] = new NPC_Wizard(gp);
        gp.npc[0].worldX = 65* gp.tileSize ;
        gp.npc[0].worldY = 20*gp.tileSize -40;

        gp.npc[1] = new NPC_Wizard(gp);
        gp.npc[1].worldX = 70* gp.tileSize ;
        gp.npc[1].worldY = 20*gp.tileSize -40;


    }
}
