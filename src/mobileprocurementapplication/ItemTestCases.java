/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Test;


public class ItemTestCases {
    private static final String ItemFile = "Item.ser";
    private static SetOfItems<Item> itemList = new SetOfItems();
    private static ItemService itemService = new ItemService();
    
    public static Item item1 = new Item("Copper", "Metal", 5);
    public static Item item2 = new Item("Maple", "Wood", 5);
    public static Item item3 = new Item("Mahogany", "Wood", 2.7);
    public static Item item4 = new Item("Marble", "Rock", 0.78);
    
    static{
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        
        try {
            ItemTestCases.itemService.Serialize(itemList, ItemFile);
        } catch (IOException ex) {
            Logger.getLogger(ItemTestCases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @Test
    public void itemTestCase()
    {        
        try {
            int i = 0;
            
            for(Item item : ItemTestCases.itemService.Deserialize(ItemFile))
            {
                Assert.assertEquals(item.getItemID(), itemList.get(i).getItemID());
                Assert.assertEquals(item.getItemName(), itemList.get(i).getItemName());
                Assert.assertEquals(item.getItemPrice(), itemList.get(i).getItemPrice());
                Assert.assertEquals(item.getItemType(), itemList.get(i).getItemType());
                
                i++;
                            
            }
        } catch (IOException ex) {
            Logger.getLogger(ItemTestCases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemTestCases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test(expected = FileNotFoundException.class) 
    public void negativeTestCaseForDeserialize() throws ClassNotFoundException, IOException{
        ItemTestCases.itemService.Deserialize("Invalid Name");
    }
}
