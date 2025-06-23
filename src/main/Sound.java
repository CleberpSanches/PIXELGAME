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
    int volumeScale= 3;
    float volume;

    public Sound(){
        soundURL[0] = getClass().getResource("/sound/menusong1.wav");
        soundURL[1] = getClass().getResource("/sound/mapaslojaequarto.wav");
        soundURL[2] = getClass().getResource("/sound/mapainicio.wav");
        soundURL[3] = getClass().getResource("/sound/mapamatanebulosa.wav");
        soundURL[4] = getClass().getResource("/sound/mapacamposinfinitos.wav");
        soundURL[5] = getClass().getResource("/sound/mapamagmeria.wav");
        soundURL[6] = getClass().getResource("/sound/mapadesertodassombras.wav");

    }

    public void setFile( int i){
        try{
            if (clip != null) {
                clip.stop();
                clip.close();
            }
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
            clip.setFramePosition(0); // volta ao início
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
