package Main;

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
        gp.obj[7].worldX = 98* gp.tileSize;
        gp.obj[7].worldY = 8*gp.tileSize;

        gp.obj[8] = new Heal();
        gp.obj[8].worldX = 96* gp.tileSize;
        gp.obj[8].worldY = 7*gp.tileSize;
    }
}
