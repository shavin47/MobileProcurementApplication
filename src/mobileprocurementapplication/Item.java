/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * The item class is used to hold details of each item, such as the name, type and price. 
 * The item id increases automatically.
 * 
 * @author CSSD GROUP A
 * @version 1.0 
 * 
 */


public class Item implements Serializable{
    
    private int ItemID; 
    private String ItemName; 
    private String ItemType;    
    private double ItemPrice; 
    
    private static int itemCount = 0;
    
    /**
     * Constructor for adding a new item
     * @param ItemName
     * @param ItemType
     * @param ItemPrice 
     */
    public Item(String ItemName, String ItemType, double ItemPrice)
    {
        ItemID = ++itemCount; 
        this.ItemName = ItemName; 
        this.ItemType = ItemType;         
        this.ItemPrice = ItemPrice;        
    }
    
    /**
     * Constructor for adding an item without a type
     * @param ItemName
     * @param ItemPrice 
     */
    public Item(String ItemName, double ItemPrice)
    {
        ItemID = ++itemCount; 
        this.ItemName = ItemName; 
        this.ItemPrice = ItemPrice;
    }
    
    /**
     * Default Constructor
     */
    public Item()
    {}
    
    /**
     * 
     * @return int This returns the ItemID
     */
    public int getItemID()
    {
        return this.ItemID;
    }   
    
    /**
     * 
     * @return String This returns a concatenated string containing item name, type and price
     */
    public String toString()
    {
        return this.ItemName + " " + "(" + this.ItemType + ")" + " Price = " + this.ItemPrice;
        
    }
    
    /**
     * 
     * @return String This returns the item name
     */
    public String getItemName()
    {
        return this.ItemName;
    }
    
    /**
     * 
     * @return String This returns the item type
     */
    public String getItemType()
    {
        return this.ItemType;
    }
    
    /**
     * 
     * @return double This returns the item price
     */    
    public double getItemPrice()
    {
        return this.ItemPrice;
    }
  
    /**
     * This writes count to the file
     * @param oos
     * @throws IOException 
     */  
  private void writeObject(ObjectOutputStream oos) throws IOException
  {
      oos.defaultWriteObject();
      oos.writeObject(new Integer(itemCount));      
  
  }
  
  /**
   * This reads the count from the file
   * @param ois
   * @throws ClassNotFoundException
   * @throws IOException 
   */
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
  {
      ois.defaultReadObject();
      itemCount = (Integer)ois.readObject();
  }
}
