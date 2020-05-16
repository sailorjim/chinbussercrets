package chinbuadventure;

import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Thopte
 */
public class Index {
    static String input;
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> inventory = new ArrayList<>();

    public static void main(String[] args) {
        String[] options= {"New Game", "Exit"};
        int userIn= JOptionPane.showOptionDialog(null,"Welcome to Chinbu's Adventure", "Hewwo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
       if (userIn==0){
        Game newGame = new Game();
        newGame.createNewGame();
    } 
}}
