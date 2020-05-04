/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinbuadventure;

/**
 * @author Thopte
 */
public class Item {
    private String name;
    private String description;

    public void setName(String itemName) {
        name = itemName;
    }
    public void setDescription(String itemDesc) {
        description = itemDesc;
    }
 
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    static public void useItem(Item item){
        switch (item.getName()){
            case "coconut":
                System.out.println("ate "+item.getName());
                Chinbu.dropItem(item);
                break;
            case "flute":
                Ocarina.selectSong();
            case "music book":
                Ocarina.songList();
        }
        Game.areaIntro();
      
    }

}