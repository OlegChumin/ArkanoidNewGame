package Sound.MusicPlayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WAV_player {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String soundPath = "C:\\Users\\Oleg_Chumin\\IdeaProjects\\ArkanoidNewGame\\src\\main\\java\\Sound\\" +
                "MusicPlayer\\09 Money for Nothing.wav";
        File file = new File(soundPath);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        String response = "";
        Scanner scanner = new Scanner(System.in);

        // P - play, S- Stop, R - reset, Q - quit

        while (!response.equals("Q")) {
            System.out.println("P - play, S- Stop, R - reset, Q - quit");
            System.out.println("Enter your choice: ");
            response = scanner.next();
            response = response.toUpperCase();

            switch (response) {
                case ("P"):
                    clip.start();
                    break;
                case ("S"):
                    clip.stop();
                    break;
                case ("R"):
                    clip.setMicrosecondPosition(0);
                    break;
                case ("Q"):
                    break;
                default:
                    System.out.println("Not a valid response!");
                    break;
            }
        }
        System.out.println("Byyeeeee!");
    }
}
