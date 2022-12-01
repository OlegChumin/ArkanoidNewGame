package Sound.forGame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class SoundTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        URL url = new URL("File:C:\\Users\\Oleg_Chumin\\IdeaProjects\\ArkanoidNewGame\\src\\main\\java\\Sound\\forGame\\ball.wav");
        AudioClip ballSound = Applet.newAudioClip(url);
//        ballSound.play();
        ballSound.loop();
        Thread.sleep(3000);
    }
}
