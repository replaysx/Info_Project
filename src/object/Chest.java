package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Chest extends SuperObject{
    public Chest(){
        name = "Chest";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0(3).png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
