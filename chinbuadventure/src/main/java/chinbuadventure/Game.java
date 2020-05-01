package chinbuadventure;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Thopte
 */
public class Game {
    static Scanner in = new Scanner(System.in);
    public static Location empty= new Location();
    
    public void createNewGame() {

        // Create items
        Item coconut = new Item();
        coconut.setName("coconut");
        coconut.setDescription("on the ground");
        coconut.setType("food");

        // Create all Locations
   
        Location bedroom = new Location();
        Location beach= new Location();
        Location home = new Location();
        Location shopArea = new Location();
        Location shop= new Location();
 
        
        //set location attributes
        //bedroom
        bedroom.setName("in your Bedroom");
        bedroom.setDescription("there is a little snuggle bed in the corner and a door leading outside");
        bedroom.setSouth(home);
        
        //home
        home.setName("outside your house");
        home.setDescription("there is a beach stretching from the north to the east. To the south");
        home.setNorth(beach);
        home.setBuildings(bedroom);
        home.setSouth(shopArea);
       
      
        //beach
        beach.setName("on the beach");
        beach.setDescription("the sands stretch on for miles east and west of you");
        beach.addItem(coconut);
        beach.setSouth(home);
        
        //shoparea+shop
        shopArea.setName("in the town square");
        shopArea.setDescription("the shops are all abandoned except for the 7-Eleven");
        shopArea.setBuildings(shop);
        shopArea.setNorth(home);
        
        shop.setName("inside the 7-eleven");
        shop.setDescription("Santa sits at the counter brushing his teeth");
        shop.setSouth(shopArea);


        // Create Ocarina
        Ocarina flute = new Ocarina();
        flute.setName("flute");
        flute.setDescription("on the table");
        bedroom.addItem(flute);

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

        System.out.println("You are " + playerLocation.getName() + ", " + playerLocation.getDescription() + ".");

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
            case "use":
                for (Item item : Chinbu.inventory){
                    if (item.getName().equals(actionOption)){
                        Item.useItem(item);
                        break;
                    }
                    
                } System.out.println("you can't use that right now");
                    break;
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
            case "go": 
                switch (actionOption) {
                    case "north":
                        Chinbu.movePlayer(currentLocation.getNorth());
                        break;
                    case "east":
                        Chinbu.movePlayer(currentLocation.getEast());
                        break;
                    case "west":
                        Chinbu.movePlayer(currentLocation.getWest());
                        break;
                    case "south":
                        Chinbu.movePlayer(currentLocation.getSouth());
                        break;
                    case "outside":
                        Chinbu.movePlayer(currentLocation.getSouth());
                        break;
                    case "inside":
                        Chinbu.movePlayer(currentLocation.getBuildings());
                        break;
                    default: System.out.println("you can't go that way");

                }
                    break;

            case "inventory":
                Chinbu.openInventory();
                break;
            default:
                System.out.println("Please try enter action again!");
                
                        
                // TODO: Add response if input action is unknown.
        }
        areaIntro();
    }

    public void gameOver() {
        System.out.println("help me mr obama i'm dwoning");
    }
}
