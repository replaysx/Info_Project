package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean leftPressed, rightPressed, enterPressed;
    public  boolean jump = false;
    public int chestIndex = 999;
    public int itemIndex = 999;


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
        if(code == KeyEvent.VK_E){
            int distanceX = gp.player.worldX - gp.obj[12].worldX;
            if (distanceX <= gp.tileSize*6 && distanceX>=0){
                if (gp.gameState == gp.playState)
                    gp.gameState = gp.tradeState;
                else {
                    gp.gameState=gp.playState;
                }
            }






        }
        if (code == KeyEvent.VK_Q){
            for (int i = 0; i < gp.obj.length; i++) {
                if (gp.obj[i]!= null) {
                    if (gp.obj[i].name == "Chest") {
                        int distanceX = gp.player.worldX - gp.obj[i].worldX;
                        if (distanceX <= gp.tileSize + gp.tileSize / 2 && distanceX >= -gp.tileSize / 2) {
                            itemIndex = gp.player.searchItemInInventory("Key");
                            if (itemIndex !=999) {
                                if (gp.player.inventory.get(itemIndex).amount > 0) {
                                    gp.player.inventory.get(itemIndex).amount--;
                                    if (gp.player.inventory.get(itemIndex).amount <= 0) {
                                        gp.player.inventory.remove(itemIndex);
                                    }
                                    chestIndex = i;
                                    gp.obj[i].chestIsOpening = true;
                                    if (gp.gameState == gp.playState) {
                                        gp.gameState = gp.chestState;
                                    } else {
                                        gp.obj[i].chestIsClosing = true;
                                        gp.gameState = gp.playState;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        if (code == KeyEvent.VK_G){
            gp.player.guard = true;
        }

        if(code == KeyEvent.VK_I){

if (gp.gameState == gp.playState)
            gp.gameState = gp.characterState;
else {
    gp.gameState=gp.playState;
}

        }
        if(code == KeyEvent.VK_F){
            enterPressed = true;

        }
        if(code == KeyEvent.VK_SPACE){
            jump = true;

        }
        if (gp.gameState==gp.characterState){
            if (code == KeyEvent.VK_W){
                if (gp.ui.slotRow !=0){
                gp.ui.slotRow--;}
            }

            if (code == KeyEvent.VK_A){
                if (gp.ui.slotCol!=0){
                gp.ui.slotCol--;}
            }
            if (code == KeyEvent.VK_S){
                if (gp.ui.slotRow!=3){
                gp.ui.slotRow++;}
            }
            if (code == KeyEvent.VK_D){
                if (gp.ui.slotCol!=4){
                gp.ui.slotCol++;}
            }
            if (code == KeyEvent.VK_ENTER){
                gp.player.selectItem();

            }
        }
        if (gp.gameState==gp.tradeState || gp.gameState == gp.chestState){
            if (code == KeyEvent.VK_W){
                if (gp.ui.slotRow !=0){
                    gp.ui.slotRow--;}
                gp.ui.ErrorText ="";
            }

            if (code == KeyEvent.VK_A){
                if (gp.ui.slotCol!=0){
                    gp.ui.slotCol--;}
                gp.ui.ErrorText ="";
            }
            if (code == KeyEvent.VK_S){
                if (gp.ui.slotRow!=1){
                    gp.ui.slotRow++;}
                gp.ui.ErrorText ="";
            }
            if (code == KeyEvent.VK_D){
                if (gp.ui.slotCol!=4){
                    gp.ui.slotCol++;}
                gp.ui.ErrorText ="";
            }
            if (code == KeyEvent.VK_ENTER){
                if (gp.gameState == gp.tradeState){
                gp.obj[12].buyItem();}
                if (gp.gameState == gp.chestState){
                    gp.obj[chestIndex].getItem();
                }

            }
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
        /*if (gp.gameState== gp.gameOverState){
            if (code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if (gp.ui.commandNum<0){
                    gp.ui.commandNum=1;
                }
            }

         */
            if (code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if (gp.ui.commandNum>1){
                    gp.ui.commandNum=0;
                }
            }
            /*
            if (code == KeyEvent.VK_ENTER){
                if (gp.ui.commandNum ==0){
                    gp.gameState = gp.playState;
                    gp.restart();
                }
                if (gp.ui.commandNum ==1){
                    gp.gameState = gp.titleState;
                    gp.restart();
                }
            }


        }

             */
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
                    //gp.tileM.getTileImage2();
                    gp.tileM.loadMap();

                }
                if (gp.ui.commandNum==2){
                    gp.level = 3;
                    gp.gameState = gp.playState;
                    //gp.tileM.getTileImage2();
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
        if (code == KeyEvent.VK_G){
            gp.player.guard = false;
        }
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
