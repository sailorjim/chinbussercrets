package chinbuadventure;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * @author Thopte
 */
public class Chinbu {
    static private Location currentLocation;
    static public  ArrayList<Item> inventory = new ArrayList<>();

    // Set current location of Chinbu.
    static public void setLocation(Location location) {
            currentLocation = location;
        }
        
   static public void movePlayer(Location location){
        if (!location.equals(Game.empty)){
            currentLocation = location;
        } else {
            System.out.println("Can't go this way sorry!");

        }
        }
        
   
    

    // Get current location of Chinbu.
    static public Location getLocation() {
        return currentLocation;
    }

    // Pickup item on current location if exists.
    static public void takeItem(Item item) {
            inventory.add(item);
            currentLocation.removeItem(item);
            System.out.println(item.getName() + " picked up."); 
    }
    
    static public void dropItem(Item item){
                 inventory.remove(item);
                 currentLocation.addItem(item);
    }
    
    

    // Print the players current inventory.
    static public void openInventory() {
        if (inventory.size() > 0 ){
            StringJoiner inventoryResponse = new StringJoiner(", ");

            for (int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                inventoryResponse.add(item.getName());
            }

            System.out.println("Player Inventory:");
            System.out.println(inventoryResponse);
        } else {
            System.out.println("Your inventory is empty!");
        } 
    }
    static public boolean checkItem(String itemName) {
        if (inventory.stream().anyMatch((item) -> (itemName.equals(item.getName())))) {
            return true;
        } 
        return false;
    } 

}
