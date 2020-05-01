package chinbuadventure;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 * @author Thopte
 */
public class Ocarina extends Item{
    Scanner in = new Scanner(System.in);
    private final ArrayList<String> learnedSongs = new ArrayList<>();
    private String filePath;


    public void selectSong() {
        boolean songExists = false;

        System.out.println("which song would you like to play:");
        for (String s : learnedSongs) {
            System.out.print(s);
        }

        String selectedSong = in.nextLine();

        switch (selectedSong) {
            case "happy":
                filePath = "song/beepSong.wav";
                songExists = true;
                break;
            default:
                break;
        }

        if (songExists){
            System.out.println("Now playing: " + selectedSong);
            playMusic(filePath);
        } else {
            System.out.println(selectedSong + " is not a song I know, try again.");
        }
    }

    public void playMusic(String filepath) {
        try {
            File musicPath = new File(filepath);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            JOptionPane.showMessageDialog(null, "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
