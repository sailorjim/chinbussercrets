package chinbuadventure;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.Random;

/**
 * @author Thopte
 */
public class Game {
    static Scanner in = new Scanner(System.in);
    public static Location empty= new Location();
    
    public void createNewGame() {
     //creation
     
        // Create all items
        Item coconut = new Item();
        Item musicBook = new Item();
        Item walkingShoes = new Item();
        Item cookie = new Item();

        // Create Ocarina
        Ocarina flute = new Ocarina();

        // Create all Locations
   
        Location bedroom = new Location();
        Location beach = new Location();
        Location home = new Location();
        Location shopArea = new Location();
        Location shop = new Location();
        Location beach2 = new Location();
        Location beach3 = new Location();
        Location beach4 = new Location();
        Location beach5 = new Location();
        Location woods1 = new Location();
        Location woods2 = new Location();
        Location outsideQueen = new Location();
        Location queenHouse = new Location();
        Location mountain = new Location();
        Location upMountain = new Location();
        Location outsideMum = new Location();
        Location mumHouse =  new Location();
        Location crossroad = new Location();
        Location baseMountain = new Location();
        Location mountainTop = new Location();
        Location cave = new Location();
        
        //create all npc
        npc shopKeep = new npc();
        npc mummy = new npc();
        npc queen = new npc();
        npc princess = new npc();
   
     //set item attributes
        //flute 
        flute.setName("flute");
        flute.setDescription("on the table");
        
        //coconut
        coconut.setName("coconut");
        coconut.setDescription("on the ground");
        
        //musicbook
        musicBook.setName("music book");
        
        //walking shoes
        walkingShoes.setName("walking shoes");
        walkingShoes.setDescription("These would help you climb a mountain");
        
        //cookies
        cookie.setName("coconut cookies");
        cookie.setDescription("Wrapped in a napkin with a ribbon");
        
     //set location attributes
       //home
        home.setName("outside your house");
        home.setDescription("there is a beach stretching from the north to the east. To the south is a path");
        home.setNorth(beach);
        home.setBuildings(bedroom);
        home.setSouth(crossroad);
      
            //bedroom
            bedroom.setName("in your Bedroom");
            bedroom.setDescription("there is a little snuggle bed in the corner and a door leading outside");
            bedroom.setSouth(home);
            bedroom.addItem(flute);
        
        //beach
        Location[] beachs = {beach, beach2, beach3, beach4, beach5};
        beachs[new Random().nextInt(beachs.length)].addItem(coconut);
        
        beach.setName("on the beach");
        beach.setDescription("the sands stretch on for miles east and west of you");
        beach.setSouth(home);
        beach.setEast(beach2);
        beach.setWest(beach3);
        
        beach2.setName("on the beach");
        beach2.setDescription("the ocean looks so tempting, but a small guy like you can't swim.");
        beach2.setWest(beach);   
        beach2.setEast(beach5);

        beach3.setName(beach.getName());
        beach3.setDescription(beach.getDescription());
        beach3.setEast(beach2);
        beach3.setWest(beach4);
        
        beach4.setName(beach.getName());
        beach4.setDescription(beach.getDescription());
        beach4.setEast(beach3);
        
        beach5.setName(beach.getName());
        beach5.setDescription(beach2.getDescription());
        beach5.setWest(beach2);
       
        //crossroad 
        crossroad.setName("at a red brick path crossroad");
        crossroad.setDescription("north will take you back home, east leads to mummy's house, west is the Queen's abode and south will take you to the shopping area");
        crossroad.setNorth(home);
        crossroad.setEast(outsideMum);
        crossroad.setWest(outsideQueen);
        crossroad.setSouth(shopArea);
        
        //shoparea+shop
        shopArea.setName("in the town square");
        shopArea.setDescription("There are spooky woods surround you to the west and south, the shops are all abandoned except for a 7-Eleven");
        shopArea.setBuildings(shop);
        shopArea.setNorth(crossroad);
        shopArea.setWest(woods1);
        
            shop.setName("inside the 7-eleven");
            shop.setDescription("there are all kinds of exciting items and moldy muffinsm lining the shelves.");
            shop.setSouth(shopArea);
            shop.addnpc(shopKeep);
        
        //woods
        woods1.setName("in the spooky woods");
        woods1.setDescription("something");//TODO : add desc
        woods1.setEast(shopArea);
        woods1.setNorth(outsideQueen);
        woods1.setWest(woods2);
        
        woods2.setName("in the spooky woods");
        woods2.setDescription("the trees are so tall and you are so small.");
        woods2.setEast(woods1);
        woods2.setSouth(baseMountain);
        
        outsideMum.setName("outside mummy's house");
        outsideMum.setDescription("the sweet smell of freshly baked pie wafts through her open door");
        outsideMum.setBuildings(mumHouse);
        outsideMum.setWest(crossroad);
        
            mumHouse.setName("inside mummy's house");
            mumHouse.setDescription("there is silly pictures of a tiny baby Chinbu on the wall");
            mumHouse.addnpc(mummy);
            mumHouse.setSouth(outsideMum);
        
        //queen
        outsideQueen.setName("outside the Queen's cottage");
        outsideQueen.setDescription("");
        outsideQueen.setEast(crossroad);
        outsideQueen.setSouth(woods1);
        outsideQueen.setBuildings(queenHouse);
            queenHouse.setName("inside the queen's house");
            queenHouse.setDescription("there are baby photos of the princess on the walls, she used to be so happy...");
            queenHouse.addnpc(queen);
        
        baseMountain.setName("at the bottom of the mountain");
        baseMountain.setDescription("you can see dark clouds forming at it's peak");
        baseMountain.setNorth(woods2);
       
        mountainTop.setName("in a shady clearing at the top of the mountain");
        mountainTop.setDescription("the dark clouds are swirling around you but you can see a small cave in the middle of the clearing");
        mountainTop.setBuildings(cave);
        
        cave.setName("Inside a sad cave");
        cave.setDescription("the walls are damp and there is a echo as you walk");
        cave.addnpc(princess);
     //set npc attributes
        //shopkeep
        shopKeep.setName("Santa");
        shopKeep.setDescription("stands behind the counter.");
        shopKeep.setHello("'ello Chimbu! ");
        shopKeep.setItem(walkingShoes);
        shopKeep.setLocation(shop);
        
        //mummy
        mummy.setName("mummy");
        mummy.setDescription("MUMY HOUSE");
        mummy.setItem(cookie);
        
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
        if (playerLocation.getnpc() != null){
            npc locationnpc = playerLocation.getnpc();
            System.out.println(locationnpc.getName() +" "+ locationnpc.getDescription() );
        }
        
            

        playerInput();
    }

    static void playerInput() {
         Location currentLocation = Chinbu.getLocation();
        ArrayList<Item> currentLocationItems = currentLocation.getItems();

        String input = in.nextLine();
        String[] userInput = input.split(" ");
        String action = userInput[0];
        String actionOption= "";
        StringJoiner options = new StringJoiner(" ");
        
            if (userInput.length > 1) {
                for (int i = 1; i < userInput.length; i++){ 
                options.add(userInput[i]);
                } 
                actionOption = options.toString();
            } 
    
        switch (action) {
            case "hello":
                if (actionOption.equals((currentLocation.getnpc()).getName())){
                    (currentLocation.getnpc()).convo();
                } else {
                    System.out.println("I'm sorry please check your name spelling and try again");
                    playerInput();
                }
                break;
            case "help":
                    help();
                    break;
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
                        System.out.println(actionOption);
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
 

        }
        areaIntro();
    } 

    public void gameOver() {
        System.out.println("help me mr obama i'm dwoning");
    }
    public  static void help(){
              System.out.println("use (itemname) = use an item");
                System.out.println("pickup (itemname) = add item to inventory");
                System.out.println("inventory = view your inventory");
                System.out.println("go (north/east/west/south) = move in chosen direction");
                System.out.println("go (inside/outside) = enter or leave a building");
                System.out.println("use (item) = use an item");
                System.out.println("hello (name) = talk to them!");
                playerInput();
    }
}

