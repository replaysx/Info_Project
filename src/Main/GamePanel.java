package Main;

import Tile.TileManager;
import entity.Entity;
import entity.Player;
import entity.Shop;
import object.SuperObject;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize =16;
    final double scale = 3;
    public final int tileSize =  (int)(originalTileSize * scale);
    public final int maxScreenCol = 21;
    public final int maxScreenRow= 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final  int screenHeight = tileSize * maxScreenRow;
    public final int maxWorldCol = 250;
    public final int maxWorldRow = 50;


    int FPS = 60;
    public TileManager tileM = new TileManager(this);
   public KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker =new CollisionChecker(this);
    public AssetSetter aSet = new AssetSetter(this);
    public LevelBar levelbar = new LevelBar(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);

    Sound sound = new Sound();
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[20];
    public Entity npc[] = new Entity[10];

    //GAME STATE
    public int gameState;
    public  int level = 1;

    public final int characterState= 4;

    public final int titleState=0;
    public final int playState=1;
    public final int pauseState =2;

    public final int levelState = 3;
    public int tradeState = 5;
    public final int gameOverState=6;
    public final int chestState = 7;
    public ArrayList<Entity> projectileList = new ArrayList<>();



    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void setupGame(){
        aSet.setObject();
        aSet.setNPC();
        gameState=titleState;
        playMusic(2);


    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();


    }
    public void restart(){
        aSet.setObject();
        aSet.setNPC();
        player.setDefaultValues();
        player.setItems();
    }
    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta = delta + (currentTime - lastTime) / drawInterval;
            timer = timer + (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >=1000000000){
                System.out.println("FPS: "+drawCount);
                drawCount = 0;
                timer = 0;
            }





        }

    }



    public void update(){
        if (gameState == playState){

            player.update();
            tileM.update();
            levelbar.update();
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].update();
                }
            }
            obj[12].update();

        }
        if (gameState == pauseState){
            stopMusic(2);
        }
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].update();
            }
        }



    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (gameState == levelState) {
            ui.draw(g2);
        }
        if (gameState != titleState && gameState != levelState) {
            //Tile

            tileM.draw(g2);
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].draw(g2);
                }
            }
            player.draw(g2);
            levelbar.draw(g2);
            ui.draw(g2);

        }

        //Title Screen
        if (gameState == titleState) {
            ui.draw(g2);

        }
    }

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic (int i){
        sound.stop();
    }

    public void playSE (int i){
        sound.setFile(i);
        sound.play();
    }

}
