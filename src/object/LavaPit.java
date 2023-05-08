package object;


import javax.imageio.ImageIO;
import java.io.IOException;

public class LavaPit extends  SuperObject{
    public LavaPit(){
        name = "LavaPit";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0(15).png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}