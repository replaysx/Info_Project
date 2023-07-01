package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    public String level;





    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[20];

        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

    }

    public void loadMap(){
        switch (gp.level){
            case 1: level = "/Map/MapDemo.txt";
                break;
            case 2: level = "/Map/World2.txt";
                break;
            case 3: level = "/Map/World3.txt";
                break;
        }
        try {
            InputStream is = getClass().getResourceAsStream(level);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col<gp.maxWorldCol && row<gp.maxWorldRow){
                String line = br.readLine();
                while (col<gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row]=num;
                    col++;
                }
                if (col == gp.maxWorldCol){
                    col=0;
                    row++;
                }


            }
            br.close();


        } catch (Exception e) {

        }
    }

    public void getTileImage(){
        try {

            tile[0]= new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/MapTiles/pixil-frame-0 20.png"));
            tile[0].collision = true;

            tile[1]= new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/MapTiles/pixil-frame-0 11.png"));
            tile[1].collision = true;

            tile[2]= new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/MapTiles/pixil-frame-0 17.png"));
            tile[2].collision = true;

            tile[3]= new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/pixil-frame-0(6).png"));
                 /*
                          //Neuen Tiles eingefügt
             tile[0]= new Tile();
             tile[0].image = ImageIO.read(getClass().getResourceAsStream("/NewTiles.Map/000.png"));


             tile[2]= new Tile();
             tile[2].image = ImageIO.read(getClass().getResourceAsStream("/NewTiles.Map/gras1.png"));
             tile[2].collision = true;

             tile[3]= new Tile();
             tile[3].image = ImageIO.read(getClass().getResourceAsStream("/NewTiles.Map/gras2.png"));
             tile[3].collision = true;

             tile[5]= new Tile();
             tile[5].image = ImageIO.read(getClass().getResourceAsStream("/NewTiles.Map/grass4.png"));
             tile[5].collision = true;

             tile[6]= new Tile();
             tile[6].image = ImageIO.read(getClass().getResourceAsStream("/NewTiles.Map/grass5.png"));
             tile[6].collision = true;

             tile[7]= new Tile();
             tile[7].image = ImageIO.read(getClass().getResourceAsStream("/NewTiles.Map/grass6.png"));
             tile[7].collision = true;

             tile[8]= new Tile();
             tile[8].image = ImageIO.read(getClass().getResourceAsStream("/NewTiles.Map/grass7.png"));
             tile[8].collision = true;

             tile[9]= new Tile();
             tile[9].image = ImageIO.read(getClass().getResourceAsStream("/NewTiles.Map/grass8.png"));
             tile[9].collision = true;

             tile[10]= new Tile();
             tile[10].image = ImageIO.read(getClass().getResourceAsStream("/NewTiles.Map/grass9.png"));
             tile[10].collision = true;

             tile[15]= new Tile();
             tile[15].image = ImageIO.read(getClass().getResourceAsStream("/NewTiles.Map/grassl.png"));
             tile[15].collision = true;

             tile[16]= new Tile();
             tile[16].image = ImageIO.read(getClass().getResourceAsStream("/NewTiles.Map/grassr.png"));
             tile[16].collision = true;

         */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int worldCol=0;
        int worldRow=0;
        while (worldCol<gp.maxWorldCol && worldRow<gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize, gp.tileSize, null);
            worldCol++;

            if (worldCol == gp.maxWorldCol){
                worldCol=0;
                worldRow++;

            }


        }



    }
    public void update(){


    }
}
