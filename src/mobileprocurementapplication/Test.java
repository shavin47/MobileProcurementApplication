/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


    

public class Test {
    
    private static final String ItemFile = "Item.ser";
    private SetOfItems<Item> itemList = new SetOfItems();
    private ItemService itemService;  
    
    public void add()
    {
        itemService = new ItemService();
        
        try {            
            itemList = this.itemService.Deserialize(ItemFile);
        } catch (IOException ex) {
            Logger.getLogger(RegisterUserUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterUserUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Item aItem = new Item("Marble", "Beads", 1.00);
        Item aItem1 = new Item("Bricks", "Pebble", 0.78);
        
        try {
            this.itemService.addItem(aItem, itemList);
            this.itemService.addItem(aItem1, itemList);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }    
    
}
