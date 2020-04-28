package main;

import java.util.ArrayList;

/**
 * @author Thopte
 */
public class Chinbu {
    static private Location currentLocation;
    static private final ArrayList<Item> inventory = new ArrayList<>();

    // Set current location of Chinbu.
    static public void setLocation(Location location) {
        currentLocation = location;
    }

    // Get current location of Chinbu.
    static public Location getLocation() {
        return currentLocation;
    }

    // Pickup item on current location if exists.
    static public void takeItem(String itemName) {
        boolean itemHere = currentLocation.checkItem(itemName);
        if (itemHere) {
            for (Item item: currentLocation.getItems()){
                if (item.getName().equals(itemName)){
                    inventory.add(item);
                    currentLocation.removeItem(item);
                    break;
                }
            }
        } else {
            System.out.println("Item is not here!");
        }

        // Game.playerInput();
    }

    // Print the players current inventory.
    static public void openInventory() {
        if (inventory.size() > 0 ){
            StringBuilder inventoryResponse = new StringBuilder("");

            for (int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                inventoryResponse.append(item.getName());

                // Make sure that the string doesn't end with ", "
                if (i + 1 != inventory.size()){
                    inventoryResponse.append(", ");
                }
            }

            System.out.println("Player Inventory:");
            System.out.println(inventoryResponse);
        } else {
            System.out.println("Your inventory is empty!");
        }

        Game.playerInput();
    }
}
