package chinbuadventure;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Thopte
 */
public class Game {
    static Scanner in = new Scanner(System.in);

    public void createNewGame() {

        // Create items
        Item coconut = new Item();
        coconut.setName("coconut");
        coconut.setDescription("on the floor");

        // Create Locations
        Location bedroom = new Location();
        bedroom.setName("Your Bedroom");
        bedroom.setDescription("a small room with a bed");
        bedroom.addItem(coconut);

        Location woods = new Location();
        woods.setName("Dark Woods");
        woods.setDescription("very spooky and scary");

        // Create Ocarina
        Ocarina flute = new Ocarina();

        // Set initial player location.
        Chinbu.setLocation(bedroom);

        // Start game.
        System.out.println("hewwo Chimbu ur finally awake ! we're in a big danger. the princes climbed the mountains and won't stop crying and now the town is gonna drown. Will you wake up and save the town?");
        String input = in.nextLine();
        if (!input.equals("yes")) {
            gameOver();
        }
        areaIntro();
    }

    static void areaIntro() {
        Location playerLocation = Chinbu.getLocation();

        System.out.println("You are in " + playerLocation.getName() + ", " + playerLocation.getDescription() + ".");

        if (playerLocation.getItems().size() > 0) {
            for (Item item : playerLocation.getItems()) {
                System.out.println("There is a " + item.getName() + " on the ground.");
            }
        }

        playerInput();
    }

    static void playerInput() {
        Location currentLocation = Chinbu.getLocation();
        ArrayList<Item> currentLocationItems = currentLocation.getItems();

        String input = in.nextLine();
        String[] userInput = input.split(" ");
        String action = userInput[0];
        String actionOption = "";

        if (userInput.length > 1) {
            actionOption = userInput[1];
        }

        switch (action) {
            case "pickup":
                if (currentLocationItems.size() == 1) {
                    // If there is only 1 item on the ground, allow just "Pickup".
                    Item item = currentLocationItems.get(0);
                    Chinbu.takeItem(item.getName());
                    System.out.println(item.getName() + " picked up.");
                } else if (!actionOption.equals("")) {
                    // If user has entered an item name, and item exists in location, pick it up.
                    if (currentLocation.checkItem(actionOption)){
                        for (Item item : currentLocationItems){
                            if (item.getName().equals(actionOption)){
                                Chinbu.takeItem(item.getName());
                                System.out.println(item.getName() + " picked up.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Unknown item name, try again.");
                    }
                } else {
                    System.out.println("Please enter the name of the item you want to pickup.");
                }

                break;
            case "open":
            case "inventory":
                Chinbu.openInventory();
                break;
            default:
                // TODO: Add response if input action is unknown.
        }
    }

    public void gameOver() {
        System.out.println("help me mr obama i'm dwoning");
    }
}
