/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author Thopte
 */
public class ocarina{
    Scanner in= new Scanner(System.in);
      private final ArrayList<String> learnedSongs= new ArrayList<>();
      private String filepath;
      private String songselect;
      
    
     public String songSelect(){
        System.out.println("which song would you like to play:");
        for (String s: learnedSongs){
            System.out.print(s);
         };
          songselect = in.nextLine();
        switch(songselect){
            case "happy":
                filepath="song/beepSong.wav";
        }
            playMusic(filepath);
        return songselect;
        }

    public void playMusic(String filepath){
        try{
            File musicPath= new File(filepath);
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip= AudioSystem.getClip();
                clip.open(audioInput);
            clip.start();
            JOptionPane.showMessageDialog(null, "");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
 }
