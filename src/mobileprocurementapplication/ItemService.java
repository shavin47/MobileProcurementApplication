/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ItemService {
    
    //defining the item file to serialize and deserialize
    private static final String ItemFile = "Item.ser";
    
    public void addItem(Item aItem, SetOfItems<Item> itemList) throws IOException{
        itemList.add(aItem);
        Serialize(itemList, ItemFile);
        System.out.println("Item " + aItem.getItemName() + " Successfully Added.");
    }
    
    public void Serialize(Object object, String filename) throws IOException{
        FileOutputStream out = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(object);
        oos.flush();
        out.close();
    }
    
    public Item getThisItem(int ItemID, SetOfItems<Item> itemList)
    {
        for (Item item : itemList)
        {
            if(item.getItemID() == ItemID)
            {
                return item;
            }
        }
        
        return null;
         
    }
            
    
    public SetOfItems<Item> Deserialize(String filename) throws IOException, ClassNotFoundException{
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        SetOfItems<Item> itemList = (SetOfItems<Item>) ois.readObject();
        in.close();
        
        return itemList;
    }
    
    
}
