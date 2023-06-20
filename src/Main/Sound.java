package Main;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL[] soundURL = new URL[4];

    public Sound(){
        soundURL[0] = getClass().getResource("/Sound/Continue-Theme-_Full_.wav");
        soundURL[1] = getClass().getResource("/Sound/Picked Coin Echo.wav");
        soundURL[2] = getClass().getResource("/Sound/random-silly-chip-song.wav");
    }

    public void setFile (int i){
        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        }
        catch (Exception e){
            //
        }
    }

    public void play (){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }


}
