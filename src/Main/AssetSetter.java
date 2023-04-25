package Main;

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
    }
}
