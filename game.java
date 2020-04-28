/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thopte
 */
 public class game {
      static Scanner in = new Scanner(System.in);
     //create new player
     //create locations

    public void createNewGame(){
        //assign player starting location
        location bedroom= new location();
        location woods= new location();
    //create items
        item coconut= new item();
     //create new ocarina
        ocarina flute= new ocarina();
    
     
        chinbu.setLocation(bedroom);
        
        //assign item details
        coconut.setName("coconut");
        coconut.setDescription("on the floor");

     
      //create location details
        bedroom.setname("Your Bedroom");
        bedroom.setDescription("a small room with a bed");
        bedroom.addItems(coconut);
        
        woods.setname("Dark Woods");
        woods.setDescription("very spooky and scary");
        
        //starts game
     System.out.println("hewwo Chimbu ur finally awake ! we're in a big danger. the princes climbed the mountains and won't stop crying and now the town is gonna drown. Will you wake up and save the town?");
        String input = in.nextLine();
        if(!input.equals("yes")){
        gameOver();
         }
        areaIntro();
        }
    //this will run a dialogue for first time entering an area
    static void areaIntro(){
        location playerLocation =  chinbu.getLocation();
        
        System.out.println("You are in " +playerLocation.getName()+ ", " +playerLocation.getDescription()+ ".");
        System.out.println ("There is a "+(playerLocation.getItems()).getName());
        playerInput();
    }
        
    static void playerInput(){
         String input = in.nextLine();
  
          if (input.contains("take")){
              String[] userInput= input.split(" ");
              String action= userInput[0];
              String actionOption= userInput[1];
               chinbu.takeItem(actionOption);
                         
          } else if (input.contains("inventory")){
                  chinbu.openInventory();
                  
          }
     }

       
    public void gameOver(){
    System.out.println("help me mr obama i'm dwoning");
    }

}


