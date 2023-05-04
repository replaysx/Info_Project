package Main;

import object.Chest;
import object.Key;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new Key();
        gp.obj[0].worldX = 10 * gp.tileSize;
        gp.obj[0].worldY = 8* gp.tileSize;

        gp.obj[1] = new Key();
        gp.obj[1].worldX = 5* gp.tileSize;
        gp.obj[1].worldY = 8* gp.tileSize;

        gp.obj[2] = new Chest();
        gp.obj[2].worldX = 15* gp.tileSize;
        gp.obj[2].worldY = 10* gp.tileSize;

        gp.obj[3] = new Chest();
        gp.obj[3].worldX = 21* gp.tileSize;
        gp.obj[3].worldY = 8* gp.tileSize;
    }
}
