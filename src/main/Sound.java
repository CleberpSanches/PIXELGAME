package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];
    private boolean isPlaying = false;

    public Sound(){
        soundURL[0] = getClass().getResource("/sound/menusong1.wav");
        soundURL[1] = getClass().getResource("/sound/lavastage.wav");
        soundURL[2] = getClass().getResource("/sound/lavastage.wav");
    }

    public void setFile( int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void play (){
        if(clip != null) {
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            isPlaying = true;
        }
    }

    public void loop(){
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            isPlaying = true;
        }
    }

    public void stop(){
        if (clip != null && isPlaying) {
            clip.stop();
            isPlaying = false; // Marca como não tocando
        }
    }

    public void setVolume(float value){
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(value);
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
