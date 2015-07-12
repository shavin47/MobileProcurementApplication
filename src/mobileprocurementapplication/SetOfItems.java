/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.Serializable;
import java.util.Vector;


public class SetOfItems<Item> extends Vector<Item> implements Serializable {
    
    public SetOfItems()
    {
        super();
    }
    
    public void addItem(Item aItem)
    {
        super.add(aItem);
    }
    
    public void removeItem(Item aItem)
    {
        super.remove(aItem);
    }
    
}
