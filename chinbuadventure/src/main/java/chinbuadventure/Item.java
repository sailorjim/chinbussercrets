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
    private String type;
    private String name;
    private String description;

    public void setName(String itemName) {
        name = itemName;
    }
    public void setDescription(String itemDesc) {
        description = itemDesc;
    }
    public void setType(String itemType){
        type = itemType;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public static void useItem(Item item){
        switch (item.type){
            case "food":
                System.out.println("ate "+item.getName());
                Chinbu.dropItem(item);
                break;
        }
        Game.areaIntro();
      
    }
}
