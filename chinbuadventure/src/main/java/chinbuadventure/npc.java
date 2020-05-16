/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinbuadventure;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Thopte
 */
public class npc {
    private String name;
    private String description;
    private Item gift;
    private String hello;
    static Scanner in = new Scanner(System.in);
    static public ArrayList<Item> inventory = new ArrayList<>();
    static public Location currentLocation;

    public void setItem(Item item){
        inventory.add(item);
    } 
     public void setLocation(Location location) {
        currentLocation = location;
    }
 
    public void setName(String name){
       this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setHello(String hello){
        this.hello = hello;
    }
       public void addInventory(String additem){
        for (Item item: currentLocation.getItems()){
            if (item.getName().equals(additem)){
                    inventory.add(item);
                    currentLocation.removeItem(item);
                    break;
                }
            }
    }
    public void dropItem (String itemName){
        for (Item item : inventory){
            if (itemName.equals(item.getName())){
                 inventory.remove(item);
                 currentLocation.addItem(item);
                 break;
            }
        }
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    static public Location getLocation() {
        return currentLocation;
    }
        
    public void convo(){
        System.out.println(hello);
        if (this.name.equals("Santa")){
            shopman();
        }
        
    }
    public void shopman(){
        System.out.println("I've got a lot of yummy items for sale. Would you like to have a look? ----- buy/sell/exit--");
        String userin = in.nextLine();
        
        switch (userin) {
            case "buy":
                System.out.println("Take a Look");
                inventory.forEach((i) -> {
                    System.out.println(i.getName());
                });
                String buyItem = in.nextLine();
                if (inventory.stream().anyMatch((item)  -> (item.getName().equals(buyItem)))){
                    int foundItem = -1;
                    for (int i = 0 ; i < inventory.size() ; ++i){
                        if (inventory.get(i).getName().equals(buyItem)){
                            foundItem = i;
                            break;
                        } 
                    } 
                    System.out.println("A good choice, " +buyItem+ " will cost $1,000,000");
                    if (Chinbu.inventory.stream().anyMatch((item) -> (item.getName().equals("coconut cookies")))){
                        System.out.println("However, I can see you have some of your Mummy's Special Coconut Cookies, I'll gladly make this trade for " +buyItem+ " --- yes/no");
                        String yn = in.nextLine();
                        if (yn.equals("yes")){
                            dropItem(buyItem);
                            Chinbu.takeItem(buyItem);
                            Chinbu.dropItem("coconut cookies");
                            addInventory("coconut cookies");
                            break;
                        }
                    }
                    System.out.println("................But since you are a small baby. I would gladly give them to you, in return for some of your mummy's special coconut cookies");
                } else { //if shopman doesn't have item
                    System.out.println("I don't have that!");
                } 
                break;
             case "exit": 
                   Game.areaIntro();
                break;
            default:
                shopman();
                break;
        }
        
    } 
}