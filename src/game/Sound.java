package game;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.net.URL;

public class Sound {








    Clip clip;
    URL soundURL[] = new URL[30];
    //File sound1 = new File()

    public Sound(){

        soundURL[0] = getClass().getResource("/res/sounds/area1music.wav");
        soundURL[1] = getClass().getResource("/res/sounds/click_x.wav");
        soundURL[2] = getClass().getResource("/res/sounds/obj_interaction.wav");
        soundURL[3] = getClass().getResource("/res/sounds/obj_open1.wav");
        soundURL[4] = getClass().getResource("/res/sounds/sword_slash.wav");
        soundURL[5] = getClass().getResource("/res/sounds/damage_player.wav");
        soundURL[6] = getClass().getResource("/res/sounds/sword_miss.wav");
        soundURL[7] = getClass().getResource("/res/sounds/level_up.wav");
        soundURL[8] = getClass().getResource("/res/sounds/click_x.wav");

    }
    public void setFile(int i){

            try {

                AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
                clip = AudioSystem.getClip();
                clip.open(ais);

            }catch(Exception e) {
            }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();

    }

}
