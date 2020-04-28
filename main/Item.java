/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * @author Thopte
 */
public class Item {
    private String name;
    private String description;

    public void setName(String itemName) {
        name = itemName;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String itemDesc) {
        description = itemDesc;
    }

    public String getDescription() {
        return description;
    }
}
