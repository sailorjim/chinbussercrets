/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;

/**
 *
 * @author Thopte
 */
public class chinbu {
         static location currentLocation;
        static final  ArrayList<item> inventory= new ArrayList<>();
        
      
         static void setLocation(location location){
             currentLocation=location;
         }
         static void takeItem(String checkItem){
            boolean itemHere = currentLocation.checkItem(checkItem);
             if(itemHere){
                 inventory.add(currentLocation.getItem(checkItem));
                 currentLocation.removeItem(currentLocation.getItem(checkItem));
                 game.playerInput();
           } else {
                    System.out.println("Item is not here!");
                    game.playerInput();
                   }
     
         };
         static location getLocation(){
             return currentLocation;
         }
         static void openInventory(){
             for (item e:inventory){
                 System.out.println (e.getName()+ ",");
                 game.playerInput();
             }
         }
    }
