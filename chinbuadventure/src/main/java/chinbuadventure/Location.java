/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinbuadventure;

import java.util.ArrayList;

/**
 * @author Thopte
 */
public class Location {
    private String name;
    private String intro;
    private String description;
    private final ArrayList<Item> items = new ArrayList<>();
    private Location n = Game.empty;
    private Location e = Game.empty;
    private Location w = Game.empty;
    private Location s = Game.empty;
    private Location building;
    private npc people;

    //set variables
    public void setNorth(Location location) {
        this.n=location;
    }
    public void setEast(Location location){
        this.e=location;
    }
    public void setWest(Location location){
        this.w=location;
    }
    public void setSouth(Location location){
        this.s=location;
    }
    public void setBuildings(Location location){
        this.building=location;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String areaDescription) {
        description = areaDescription;
    }
    public void addItem(Item item) {
        items.add(item);
    }
    public void addnpc(npc npc){
        people = npc;
    }
    
    public void removeItem(Item item) {
        items.remove(item);
    }

    public boolean checkItem(String itemName) {
        if (items.stream().anyMatch((item) -> (itemName.equals(item.getName())))) {
        } return true;
    }
    
    //get variables
    public String getName() {
        return name;
    }
    
    public String getIntro() {
        return intro;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public Item getItem(String itemName){
           Item founditem = null;
        for (Item item : items){
            if (itemName.equals(item.getName())){
                founditem = item;
            } 
        } return founditem;
    } 
    public Location getNorth(){
        return n;
    }
    public Location getEast(){
        return e;
    }
    public Location getWest(){
        return w;
    }
    public Location getSouth(){
        return s;
    }
    public Location getBuildings(){
        return building;
    }
    public npc getnpc(){
        return people;
    }
}
