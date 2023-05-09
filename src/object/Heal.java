package object;


import javax.imageio.ImageIO;
import java.io.IOException;

public class Heal extends  SuperObject{
    public Heal(){
        name = "heal";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
