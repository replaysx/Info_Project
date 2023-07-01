package Main;

import entity.NPC_Ghost;
import entity.NPC_Wizard;
import entity.Shop;
import object.*;
import object.Shields.Shield;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        gp.obj[2] = new Chest(gp);
        gp.obj[2].worldX = 35* gp.tileSize;
        gp.obj[2].worldY = 23*gp.tileSize;

        gp.obj[3] = new Chest(gp);
        gp.obj[3].worldX = 65* gp.tileSize;
        gp.obj[3].worldY = 19*gp.tileSize;

        gp.obj[0] = new Chest(gp);
        gp.obj[0].worldX = 126* gp.tileSize;
        gp.obj[0].worldY = 20*gp.tileSize;

        gp.obj[1] = new Chest(gp);
        gp.obj[1].worldX = 173* gp.tileSize;
        gp.obj[1].worldY = 20*gp.tileSize;

        gp.obj[4] = new Chest(gp);
        gp.obj[4].worldX = 78* gp.tileSize;
        gp.obj[4].worldY = 19*gp.tileSize;

        gp.obj[12] = new Shop(gp);
        gp.obj[12].worldX = 20* gp.tileSize ;
        gp.obj[12].worldY = 33*gp.tileSize-gp.tileSize*5;

        gp.obj[5] = new Coin(gp);
        gp.obj[5].worldX = 23* gp.tileSize ;
        gp.obj[5].worldY = 20*gp.tileSize;

        gp.obj[6] = new Coin(gp);
        gp.obj[6].worldX = 24* gp.tileSize ;
        gp.obj[6].worldY = 20*gp.tileSize;

        gp.obj[7] = new Coin(gp);
        gp.obj[7].worldX = 22* gp.tileSize ;
        gp.obj[7].worldY = 20*gp.tileSize;

        gp.obj[8] = new Coin(gp);
        gp.obj[8].worldX = 55* gp.tileSize ;
        gp.obj[8].worldY = 19*gp.tileSize;

        gp.obj[9] = new Coin(gp);
        gp.obj[9].worldX = 56* gp.tileSize ;
        gp.obj[9].worldY = 19*gp.tileSize;

        gp.obj[10] = new Coin(gp);
        gp.obj[10].worldX = 54* gp.tileSize ;
        gp.obj[10].worldY = 19*gp.tileSize;

        gp.obj[11] = new Coin(gp);
        gp.obj[11].worldX = 80* gp.tileSize ;
        gp.obj[11].worldY = 22*gp.tileSize;

        gp.obj[13] = new Coin(gp);
        gp.obj[13].worldX = 81* gp.tileSize ;
        gp.obj[13].worldY = 22*gp.tileSize;

        gp.obj[14] = new Coin(gp);
        gp.obj[14].worldX = 82* gp.tileSize ;
        gp.obj[14].worldY = 22*gp.tileSize;

        gp.obj[15] = new Coin(gp);
        gp.obj[15].worldX = 83* gp.tileSize ;
        gp.obj[15].worldY = 22*gp.tileSize;

        gp.obj[16] = new Coin(gp);
        gp.obj[16].worldX = 84* gp.tileSize ;
        gp.obj[16].worldY = 22*gp.tileSize;

        gp.obj[17] = new Coin(gp);
        gp.obj[17].worldX = 124* gp.tileSize ;
        gp.obj[17].worldY = 20*gp.tileSize;

        gp.obj[18] = new Coin(gp);
        gp.obj[18].worldX = 125* gp.tileSize ;
        gp.obj[18].worldY = 20*gp.tileSize;

        gp.obj[19] = new Coin(gp);
        gp.obj[19].worldX = 126* gp.tileSize ;
        gp.obj[19].worldY = 20*gp.tileSize;

        gp.obj[20] = new Coin(gp);
        gp.obj[20].worldX = 123* gp.tileSize ;
        gp.obj[20].worldY = 20*gp.tileSize;

        gp.obj[21] = new Coin(gp);
        gp.obj[21].worldX = 152* gp.tileSize ;
        gp.obj[21].worldY = 23*gp.tileSize;

        gp.obj[22] = new Coin(gp);
        gp.obj[22].worldX = 151* gp.tileSize ;
        gp.obj[22].worldY = 23*gp.tileSize;

        gp.obj[23] = new Coin(gp);
        gp.obj[23].worldX = 208* gp.tileSize ;
        gp.obj[23].worldY = 19*gp.tileSize;
        gp.obj[24] = new Coin(gp);
        gp.obj[24].worldX = 209* gp.tileSize ;
        gp.obj[24].worldY = 19*gp.tileSize;
        gp.obj[25] = new Coin(gp);
        gp.obj[25].worldX = 207* gp.tileSize ;
        gp.obj[25].worldY = 19*gp.tileSize;
    }
    public void setNPC(){
        gp.npc[0] = new NPC_Wizard(gp);
        gp.npc[0].worldX = 23* gp.tileSize ;
        gp.npc[0].worldY = 20*gp.tileSize -40;

        gp.npc[1] = new NPC_Wizard(gp);
        gp.npc[1].worldX = 86* gp.tileSize ;
        gp.npc[1].worldY = 22*gp.tileSize -40;

        gp.npc[2] = new NPC_Wizard(gp);
        gp.npc[2].worldX = 120* gp.tileSize ;
        gp.npc[2].worldY = 21*gp.tileSize -40;

        gp.npc[3] = new NPC_Wizard(gp);
        gp.npc[3].worldX = 161* gp.tileSize ;
        gp.npc[3].worldY = 23*gp.tileSize -40;

        gp.npc[4] = new NPC_Wizard(gp);
        gp.npc[4].worldX = 209* gp.tileSize ;
        gp.npc[4].worldY = 19*gp.tileSize -40;

        gp.npc[5] = new NPC_Wizard(gp);
        gp.npc[5].worldX = 242* gp.tileSize ;
        gp.npc[5].worldY = 22*gp.tileSize -40;

        gp.npc[6] = new NPC_Ghost(gp);
        gp.npc[6].worldX = 53* gp.tileSize-40 ;
        gp.npc[6].worldY = 20*gp.tileSize-40 ;

        gp.npc[7] = new NPC_Ghost(gp);
        gp.npc[7].worldX = 148* gp.tileSize-40 ;
        gp.npc[7].worldY = 23*gp.tileSize-40 ;

        gp.npc[8] = new NPC_Ghost(gp);
        gp.npc[8].worldX = 66* gp.tileSize-40 ;
        gp.npc[8].worldY = 19*gp.tileSize-40 ;

        gp.npc[9] = new NPC_Ghost(gp);
        gp.npc[9].worldX = 238* gp.tileSize-40 ;
        gp.npc[9].worldY = 23*gp.tileSize-40 ;


    }
}
