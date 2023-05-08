package object;


import javax.imageio.ImageIO;
import java.io.IOException;

public class TubePortal extends  SuperObject{
    public TubePortal(){
        name = "TubePortal";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0(14).png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}