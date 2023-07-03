package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean leftPressed, rightPressed, enterPressed;
    public  boolean jump = false;
    public int chestIndex = 999;
    public int itemIndex = 999;
    public int previousWorldX;
    public  int getPreviousWorldY;


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
        if (gp.gameState == gp.playState){
            if(code == KeyEvent.VK_E){
            int distanceX = gp.player.worldX - gp.obj[12].worldX;
            if (distanceX <= gp.tileSize*6 && distanceX>=0){
                    gp.gameState = gp.tradeState;
            }
        }
            if (code == KeyEvent.VK_Q){
                for (int i = 0; i < gp.obj.length; i++) {
                    if (gp.obj[i]!= null) {
                        if (gp.obj[i].name == "Chest") {
                            int distanceX = gp.player.worldX - gp.obj[i].worldX;
                            if (distanceX <= gp.tileSize + gp.tileSize / 2 && distanceX >= -gp.tileSize / 2) {
                                if (gp.obj[i].chestIsAlreadyOpen==true){
                                    chestIndex = i;
                                    gp.obj[i].chestIsOpening = true;
                                    gp.obj[i].chestIsClosing = false;
                                    gp.gameState = gp.chestState;
                                }else {
                                    itemIndex = gp.player.searchItemInInventory("Key");
                                    if (itemIndex != 999) {
                                        if (gp.player.inventory.get(itemIndex).amount > 0) {
                                            gp.player.inventory.get(itemIndex).amount--;
                                            gp.obj[i].chestIsAlreadyOpen = true;
                                            if (gp.player.inventory.get(itemIndex).amount <= 0) {
                                                gp.player.inventory.remove(itemIndex);
                                            }
                                            gp.gameState = gp.chestState;
                                            chestIndex = i;
                                            gp.obj[i].chestIsOpening = true;
                                            gp.obj[i].chestIsClosing = false;


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
                    gp.gameState = gp.characterState;
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
                    gp.gameState = gp.pauseState;
            }
        }else{
            if(code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.playState;
            }
            if (code == KeyEvent.VK_E){
               gp.gameState = gp.playState;
            }
            if (code == KeyEvent.VK_Q){
                gp.obj[chestIndex].chestIsOpening = false;
                gp.obj[chestIndex].chestIsClosing = true;
                gp.gameState = gp.playState;
            }
            if (code==KeyEvent.VK_I){
                gp.gameState = gp.playState;
            }
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

        if (gp.gameState== gp.gameOverState){
            if (code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if (gp.ui.commandNum<0){
                    gp.ui.commandNum=1;
                }
            }
            if (code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if (gp.ui.commandNum>1){
                    gp.ui.commandNum=0;
                }
            }
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
        if (gp.gameState== gp.pauseState){
            if (code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if (gp.ui.commandNum<0){
                    gp.ui.commandNum=1;
                }
            }
            if (code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if (gp.player.atShop == false){
                    if (gp.ui.commandNum>2){
                        gp.ui.commandNum=0;
                    }
                } else {
                    if (gp.ui.commandNum>1){
                        gp.ui.commandNum=0;
                    }
                }

            }
            if (code == KeyEvent.VK_ENTER){
                if (gp.ui.commandNum ==0){
                    gp.gameState = gp.playState;
                }
                if (gp.ui.commandNum ==2){
                    gp.gameState = gp.titleState;
                    gp.restart();
                }
                if (gp.ui.commandNum ==1){
                    if (gp.player.atShop==false){
                    gp.gameState = gp.playState;
                    previousWorldX = gp.player.worldX;
                    getPreviousWorldY = gp.player.worldY;
                    gp.player.worldX=18*gp.tileSize;
                    gp.player.worldY =32*gp.tileSize;
                    gp.player.atShop = true;
                    }else{
                        gp.gameState= gp.playState;
                        gp.player.worldX=previousWorldX;
                        gp.player.worldY = getPreviousWorldY;
                        gp.player.atShop = false;

                    }
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
