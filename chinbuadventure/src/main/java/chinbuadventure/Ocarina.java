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
    static Scanner in = new Scanner(System.in);
    static public ArrayList<String> learnedSongs = new ArrayList<>();
    static private String filePath;
    
    static public void songList(){
           learnedSongs.add("happy");
           learnedSongs.add("sad");
            System.out.println("Learned Songs: ");
            learnedSongs.forEach((s) -> {
                System.out.println(s);
        });
    } 
    

    static public void selectSong() {
        boolean songExists = false;
  
        System.out.println("which song would you like to play:");
        String songName = in.nextLine();
            for (String s : learnedSongs) {
                if (songName.equals(s)){
                    songExists = true;
                } 
            }
        if(songExists){
           switch (songName) {
            case "happy":
                songName = "song/beepSong.wav";
                break;  
            //add more cases here for song names and their file paths.
            default: 
           }
        playMusic(songName);
        }
    }

    static public void playMusic(String filepath) {
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
