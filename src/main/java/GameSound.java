import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class GameSound {
    public static final String PATH_TO_BALL_SOUND = "C:\\Users\\Oleg_Chumin\\IdeaProjects\\ArkanoidNewGame\\src\\main\\java\\background.wav";
    public static final String PATH_TO_BACKGROUND_MUSIC = "C:\\Users\\Oleg_Chumin\\IdeaProjects\\ArkanoidNewGame\\src\\main\\java\\background.wav";
    public static final String PATH_TO_PAUSE_SOUND = "C:\\Users\\Oleg_Chumin\\IdeaProjects\\ArkanoidNewGame\\src\\main\\java\\pause.wav";
    public static final String PATH_TO_UNPAUSE_SOUND = "C:\\Users\\Oleg_Chumin\\IdeaProjects\\ArkanoidNewGame\\src\\main\\java\\unpause.wav";
    public static final String PATH_TO_Bonus_SOUND = "C:\\Users\\Oleg_Chumin\\IdeaProjects\\ArkanoidNewGame\\src\\main\\java\\bonus_lost.wav";

    public static final AudioClip BALL_SOUND;
    static {
        try {
            BALL_SOUND = Applet.newAudioClip(new URL("File:"+ PATH_TO_BALL_SOUND));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static final AudioClip BACKGROUND_MUSIC;

    static {
        try {
            BACKGROUND_MUSIC = Applet.newAudioClip(new URL("File:" + PATH_TO_BACKGROUND_MUSIC));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
