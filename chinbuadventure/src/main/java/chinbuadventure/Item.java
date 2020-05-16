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
    public int price;

    public void setName(String itemName) {
        name = itemName;
    }
    public void setDescription(String itemDesc) {
        description = itemDesc;
    }
    public void setPrice(int itemPrice) {
        price = itemPrice;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getPrice(){
        return price;
    }
    static public void useItem(Item item){
        switch (item.getName()){
            case "coconut":
                System.out.println("ate "+item.getName());
                Chinbu.dropItem(item.getName());
                break;
            case "flute":
                Ocarina.selectSong();
                break;
            case "music book":
                Ocarina.songList();
                break;
            case "walking shoes":
          
        }
        Game.areaIntro();
      
    }

}