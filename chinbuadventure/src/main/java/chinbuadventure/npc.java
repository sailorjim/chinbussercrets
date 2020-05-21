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
     public ArrayList<Item> inventory = new ArrayList<>();
     private Location currentLocation;

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
       public void addInventory(Item item){
                    inventory.add(item);
                    currentLocation.removeItem(item);

    }
       
    public void dropItem (Item item){
        inventory.remove(item);
        currentLocation.addItem(item);

    }
        
    
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
     public Location getLocation() {
        return currentLocation;
    }

    }

