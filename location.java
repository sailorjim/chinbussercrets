/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;

/**
 *
 * @author Thopte
 */
public class location {
    public String name;
    private String intro;
    private String description;
    private final ArrayList<item> items = new ArrayList<>();
    
    public void setIntro(String intro){
        this.intro=intro;
    }
    public void setname(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setDescription(String areaDescription){
        description= areaDescription;
    }
    public String getDescription(){
        return description;
    }
    public void addItems (item item){
        items.add(item);
    }
    public void removeItem(item item){
        items.remove(item);
    }
    public boolean checkItem(String itemName){
         boolean isItemhere = false;
        for(item e:items){
           if (itemName.equals(e.getName())){
               isItemhere = true;
           } 

         }
        return isItemhere;
    }
        public item getItem(String itemName){
            item pickedUpItem;
            for (item e:items){
              pickedUpItem=
                
            }
}}



