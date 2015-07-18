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


public class Item implements Serializable{
    
    private int ItemID; 
    private String ItemName; 
    private String ItemType;    
    private double ItemPrice; 
    
    private static int itemCount = 0;
    
    public Item(String ItemName, String ItemType, double ItemPrice)
    {
        ItemID = ++itemCount; 
        this.ItemName = ItemName; 
        this.ItemType = ItemType;         
        this.ItemPrice = ItemPrice;        
    }
    
    public Item(String ItemName, double ItemPrice)
    {
        ItemID = ++itemCount; 
        this.ItemName = ItemName; 
        this.ItemPrice = ItemPrice;
    }
    
    public Item()
    {}
    
    public int getItemID()
    {
        return this.ItemID;
    }   
    
    
    public String toString()
    {
        return this.ItemName + " " + "(" + this.ItemType + ")" + " Price = " + this.ItemPrice;
        
    }
    
    public String getItemName()
    {
        return this.ItemName;
    }
    
    public String getItemType()
    {
        return this.ItemType;
    }
    
    public double getItemPrice()
    {
        return this.ItemPrice;
    }
  
  //Retrieving the count from the file
  private void writeObject(ObjectOutputStream oos) throws IOException
  {
      oos.defaultWriteObject();
      oos.writeObject(new Integer(itemCount));      
  
  }
  
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
  {
      ois.defaultReadObject();
      itemCount = (Integer)ois.readObject();
  }
}
