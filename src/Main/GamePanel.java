package Main;

import Tile.TileManager;
import entity.Player;
import object.SuperObject;


import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize =16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow= 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final  int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 320;
    public final int maxWorldRow = 12;

    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    int FPS = 60;
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker =new CollisionChecker(this);
    public AssetSetter aSet = new AssetSetter(this);
    public LevelBar levelbar = new LevelBar(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);

    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[10];

    //GAME STATE
    public int gameState;
    public final int playState=1;
    public final int pauseState =2;



    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void setupGame(){
        aSet.setObject();
        gameState=playState;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
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
        }
        if (gameState == pauseState){
            //nichts

        }



    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        for (int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2,this);
            }
        }
        player.draw(g2);
        levelbar.draw(g2);
        ui.draw(g2);

        g2.dispose();

    }
}
