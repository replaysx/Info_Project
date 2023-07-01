package object;

import Main.GamePanel;
import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Potion_Blue extends SuperObject{
    GamePanel gp;

    public Potion_Blue(GamePanel gp){

        this.gp = gp;
        name = "Full Healing Potion";
        coinValue = 10;
        stackable = true;
        rarity = legendary;



        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/Orange.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        description = "["+name+"] \nFull Heal";
        type = type_consumable;
    }
    public void use(){
        gp.player.life = gp.player.maxLife;
    }




}