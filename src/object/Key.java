package object;


import javax.imageio.ImageIO;
import java.io.IOException;

public class Key extends  SuperObject{
    public Key(){
        name = "Key";
        stackable = true;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0(2).png"));
        }
        catch (IOException e){
            e.printStackTrace();
    }
    description = "["+name+"] \nYou need Keys \nto open chests";
        coinValue = 3;
        type = type_consumable;
    }
}
