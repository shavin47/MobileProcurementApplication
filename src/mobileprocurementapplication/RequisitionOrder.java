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


public class RequisitionOrder implements Serializable{
    
    int RequisitionOrderID; 
    SetOfItems<Item> ItemList;
    double [] Quantity;
    double TotalPriceOfItems;
    String RequiredDate;
    String PlacedDate;
    String ApprovalStatus;
    String ApprovedBy; 
    String Comments;
    String Username; 
    String SiteName;
    
    private static int orderCount = 0;
    
    public RequisitionOrder(SetOfItems<Item> ItemList, double [] Quantity, double TotalPriceOfItems, String PlacedDate, String RequiredDate, String Comments, String Username, String SiteName)
    {
        RequisitionOrderID = ++orderCount;
        this.ItemList = ItemList;
        this.Quantity = Quantity;
        this.TotalPriceOfItems = TotalPriceOfItems;
        this.PlacedDate = PlacedDate;
        this.RequiredDate = RequiredDate;
        this.Comments = Comments;
        this.Username = Username;
        this.SiteName = SiteName;
        this.ApprovalStatus = "Pending";
        this.ApprovedBy = "";        
    }
    
    public RequisitionOrder(int OrderID, SetOfItems<Item> ItemList, double [] Quantity, double TotalPriceOfItems, String RequiredDate, String Comments, String Username, String SiteName)
    {
        RequisitionOrderID = OrderID;
        this.ItemList = ItemList;
        this.Quantity = Quantity;
        this.TotalPriceOfItems = TotalPriceOfItems;        
        this.RequiredDate = RequiredDate;
        this.Comments = Comments;
        this.Username = Username;
        this.SiteName = SiteName;
                
    }
    
    public RequisitionOrder()
    {
    }
    
    public void updateOrder(SetOfItems<Item> itemList, double [] quantityList, double totalPriceOfItems, String requiredDate, String comments, String userName, String siteName)
    {
        this.ItemList = itemList;
        this.Quantity = quantityList;
        this.TotalPriceOfItems = totalPriceOfItems; 
        this.RequiredDate = requiredDate;
        this.Comments = comments;
        this.Username = userName;
        this.SiteName = siteName;
    }
    
    public String getUsername()
    {
        return Username;
    }
    
    public String getSitename()
    {
        return SiteName;
    }
    
    
    public SetOfItems<Item> getItems()
    {
        return ItemList;
    }
    
    public String getComments()
    {
        return Comments;
    }
    
    public double[] getQuantity()
    {
        return Quantity;
    }
    
    public int getQuantityArraySize()
    {
        return Quantity.length;        
    }
    
    public int getOrderID()
    {
        return this.RequisitionOrderID;
    }
    
    public double getTotalPriceOfItems()
    {
        return this.TotalPriceOfItems;
    }
    
    public String getRequiredDate()
    {
        return this.RequiredDate;
    }
    
    public String getStatusOfApproval()
    {
        return this.ApprovalStatus;
    }
    
    public int getItemCount()
    {
        return this.ItemList.size();
    }
    
    public String getPlacedDate()
    {
        return this.PlacedDate;
    }
    
    //Retrieving the count from the file
    private void writeObject(ObjectOutputStream oos) throws IOException
    {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(orderCount));      

    }
  
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
    {
        ois.defaultReadObject();
        orderCount = (Integer)ois.readObject();
    }
    
}
