package Main;

import entity.NPC_Wizard;
import object.*;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new Key();
        gp.obj[0].worldX = 75 * gp.tileSize;
        gp.obj[0].worldY = 7*gp.tileSize;

        gp.obj[1] = new Key();
        gp.obj[1].worldX = 80* gp.tileSize;
        gp.obj[1].worldY = 7*gp.tileSize;

        gp.obj[2] = new Chest();
        gp.obj[2].worldX = 83* gp.tileSize;
        gp.obj[2].worldY = 7*gp.tileSize;

        gp.obj[5] = new Key();
        gp.obj[5].worldX = 85* gp.tileSize;
        gp.obj[5].worldY = 7*gp.tileSize;

        gp.obj[3] = new Chest();
        gp.obj[3].worldX = 90* gp.tileSize;
        gp.obj[3].worldY = 7*gp.tileSize;

        gp.obj[4] = new TubePortal();
        gp.obj[4].worldX = 100* gp.tileSize;
        gp.obj[4].worldY = 7*gp.tileSize;

        gp.obj[6] = new LavaPit();
        gp.obj[6].worldX = 94* gp.tileSize;
        gp.obj[6].worldY = 8*gp.tileSize;

        gp.obj[7] = new LavaPit();
        gp.obj[7].worldX = 95* gp.tileSize;
        gp.obj[7].worldY = 8*gp.tileSize;

        gp.obj[8] = new Heal();
        gp.obj[8].worldX = 96* gp.tileSize;
        gp.obj[8].worldY = 7*gp.tileSize;

        gp.obj[9] = new Potion_Orange(gp);
        gp.obj[9].worldX = 78* gp.tileSize;
        gp.obj[9].worldY = 7*gp.tileSize;

        gp.obj[10] = new Potion_Orange(gp);
        gp.obj[10].worldX = 10* gp.tileSize;
        gp.obj[10].worldY = 8*gp.tileSize;

        gp.obj[11] = new Chest();
        gp.obj[11].worldX = 25* gp.tileSize;
        gp.obj[11].worldY = 11*gp.tileSize;
    }
    public void setNPC(){
        gp.npc[0] = new NPC_Wizard(gp);
        gp.npc[0].worldX = 85* gp.tileSize ;
        gp.npc[0].worldY = 7*gp.tileSize -70;

        gp.npc[1] = new NPC_Wizard(gp);
        gp.npc[1].worldX = 35* gp.tileSize ;
        gp.npc[1].worldY = 11*gp.tileSize -70;
    }
}
