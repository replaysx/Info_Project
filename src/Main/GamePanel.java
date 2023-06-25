package Main;

import Tile.TileManager;
import entity.Entity;
import entity.Player;
import object.SuperObject;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize =16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 20;
    public final int maxScreenRow= 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final  int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 250;
    public final int maxWorldRow = 50;

    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;
    BufferedImage tempScreen;
    Graphics2D g2;

    int FPS = 60;
    TileManager tileM = new TileManager(this);
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

        tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D) tempScreen.getGraphics();

        setFullScreen();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();


    }

    public void setFullScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.window);

        screenWidth2 = Main.window.getWidth();
        screenHeight2 = Main.window.getHeight();
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
                drawToTempScreen();
                drawToScreen();
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

        }
        if(gameState==pauseState) {
            stopMusic(2);
        }

        
    }

    public void drawToTempScreen(){

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

    public void drawToScreen(){
        Graphics g = getGraphics();
        g.drawImage(tempScreen, 0, 0, screenWidth2, screenHeight2, null);
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
