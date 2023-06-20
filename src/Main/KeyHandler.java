package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    public  boolean jump = false;




     GamePanel gp;
     KeyHandler(GamePanel gp){
         this.gp = gp;
     }




    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_I){

            if (gp.gameState ==gp.characterState){
                gp.gameState = gp.playState;
            }else {gp.gameState = gp.characterState;}

        }
        if(code == KeyEvent.VK_F){
            enterPressed = true;

        }
        if(code == KeyEvent.VK_SPACE){
            jump = true;

        }

        if(code == KeyEvent.VK_A){
            leftPressed = true;

        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;

        }
        if(code == KeyEvent.VK_ESCAPE){
            if (gp.gameState == gp.playState) {
                gp.gameState = gp.pauseState;
            } else if (gp.gameState == gp.pauseState) {
                gp.gameState = gp.playState;
            }


        }
        if (gp.gameState == gp.levelState){
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if (gp.ui.commandNum>2){
                    gp.ui.commandNum=0;
                }
            }
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if (gp.ui.commandNum<0){
                    gp.ui.commandNum=2;
                }
            }
            if (code == KeyEvent.VK_ENTER){
                if (gp.ui.commandNum==0){
                    gp.level = 1;
                    gp.gameState = gp.playState;
                    gp.tileM.getTileImage();
                    gp.tileM.loadMap();

                }
                if (gp.ui.commandNum==1){
                    gp.level = 2;
                    gp.gameState = gp.playState;
                    gp.tileM.getTileImage();
                    gp.tileM.loadMap();

                }
                if (gp.ui.commandNum==2){
                    gp.level = 3;
                    gp.gameState = gp.playState;
                    gp.tileM.getTileImage();
                    gp.tileM.loadMap();

                }
            }
        }
        if (gp.gameState==gp.titleState){
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if (gp.ui.commandNum>2){
                    gp.ui.commandNum=0;
                }
            }
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if (gp.ui.commandNum<0){
                    gp.ui.commandNum=2;
                }
            }
            if (code == KeyEvent.VK_ENTER){
                if (gp.ui.commandNum==0){
                    gp.gameState = gp.levelState;
                }
                if (gp.ui.commandNum==2){
                    System.exit(0);
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_F){
            enterPressed = false;

        }
        if(code == KeyEvent.VK_SPACE){
            jump = false;
        }

        if(code == KeyEvent.VK_A){
            leftPressed = false;

        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;

        }


    }
}
