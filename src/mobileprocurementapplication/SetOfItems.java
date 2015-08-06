/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.Serializable;
import java.util.Vector;

/**
 * This class extends the vector class, it is used to hold a list of items
 * 
 * @author CSSD GROUP A
 * @version 1.0
 * @param <Item> 
 */

public class SetOfItems<Item> extends Vector<Item> implements Serializable {
    
    /**
     * 
     */
    public SetOfItems()
    {
        super();
    }
    
    /**
     * This method adds an item to the item list
     * @param aItem 
     */
    public void addItem(Item aItem)
    {
        super.add(aItem);
    }
    
    /**
     * This method removes an item from the item list
     * @param aItem 
     */
    public void removeItem(Item aItem)
    {
        super.remove(aItem);
    }
    
}
