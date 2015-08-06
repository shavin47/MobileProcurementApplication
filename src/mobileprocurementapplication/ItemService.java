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

/**
 * This class adds an item to the item list, serializes and deserialize the item file.
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */

public class ItemService {
    
    //defining the item file to serialize and deserialize
    private static final String ItemFile = "Item.ser";
    
    /**
     * This method adds an item to the item list and then serializes it
     * 
     * @param aItem
     * @param itemList
     * @throws IOException 
     */
    public void addItem(Item aItem, SetOfItems<Item> itemList) throws IOException{
        itemList.add(aItem);
        Serialize(itemList, ItemFile);
        System.out.println("Item " + aItem.getItemName() + " Successfully Added.");
    }
    
    /**
     * This method serializes the object to the file name
     * 
     * @param object
     * @param filename
     * @throws IOException 
     */
    public void Serialize(Object object, String filename) throws IOException{
        FileOutputStream out = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(object);
        oos.flush();
        out.close();
    }
    
    /**
     * This method retrieves the item object using the itemID
     * 
     * @param ItemID
     * @param itemList
     * @return 
     */
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
            
    /**
     * This method deserializes the file 
     * 
     * @param filename
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public SetOfItems<Item> Deserialize(String filename) throws IOException, ClassNotFoundException{
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        SetOfItems<Item> itemList = (SetOfItems<Item>) ois.readObject();
        in.close();
        
        return itemList;
    }
    
    
}
