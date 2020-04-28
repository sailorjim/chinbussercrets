package main;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Thopte
 */
public class Index {
    static String input;
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> inventory = new ArrayList<>();

    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.createNewGame();
    }
}



