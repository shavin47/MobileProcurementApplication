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


public class PurchaseOrder implements Serializable{
    
    int PurchaseOrderID; 
    SetOfItems<Item> ItemList; 
    double [] Quantity; 
    double TotalPriceOfItems;
    String RequiredDate;
    String PlacedDate;
    String ApprovalStatus;
    String ApprovedBy; 
    String ApprovedDate;
    String Comments;
    String SitemManagerUsername; 
    String SiteName;
    String SupplierEmail;
    boolean RaiseToManager;
    String ApproverComments; 
    
           
    private static int orderCount = 0;
    
    public PurchaseOrder(SetOfItems<Item> ItemList, double [] Quantity, double TotalPriceOfItems, String RequiredDate, String PlacedDate, String ApprovalStatus, String ApprovedBy, String ApprovedDate, String Comments, String SiteManagerUsername, String SiteName, String SupplierEmail, String ApproverComments)
    {
        PurchaseOrderID = ++orderCount;
        this.ItemList = ItemList;
        this.Quantity = Quantity; 
        this.TotalPriceOfItems = TotalPriceOfItems; 
        this.RequiredDate = RequiredDate; 
        this.PlacedDate = PlacedDate;
        this.ApprovalStatus = ApprovalStatus; 
        this.ApprovedBy = ApprovedBy; 
        this.ApprovedDate = ApprovedDate;
        this.Comments = Comments; 
        this.SitemManagerUsername = SiteManagerUsername;
        this.SiteName = SiteName;
        this.SupplierEmail = SupplierEmail;
        this.RaiseToManager = false;
        this.ApproverComments = ApproverComments;
    }
    
    public PurchaseOrder()
    {}   
    
    public void raiseToManager()
    {
        this.RaiseToManager = true;
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
