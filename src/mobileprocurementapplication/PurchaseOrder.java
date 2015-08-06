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
 * This method is used to hold information about the purchase order
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */

public class PurchaseOrder implements Serializable{
    
    public int PurchaseOrderID; 
    SetOfItems<Item> ItemList; 
    double [] Quantity; 
    public double TotalPriceOfItems;
    public String RequiredDate;
    String PlacedDate;
    public String ApprovalStatus;
    public String ApprovedBy; 
    public String ApprovedDate;
    public String Comments;
    String SitemManagerUsername; 
    public String SiteName;
    String SupplierEmail;    
    String ApproverCommentsToSupplier; 
    
           
    private static int orderCount = 0;  
    
    /**
     * 
     * @param ItemList
     * @param Quantity
     * @param TotalPriceOfItems
     * @param RequiredDate
     * @param PlacedDate
     * @param ApprovalStatus
     * @param ApprovedBy
     * @param ApprovedDate
     * @param Comments
     * @param SiteManagerUsername
     * @param SiteName 
     */
    public PurchaseOrder(SetOfItems<Item> ItemList, double [] Quantity, double TotalPriceOfItems, String RequiredDate, String PlacedDate, String ApprovalStatus, String ApprovedBy, String ApprovedDate, String Comments, String SiteManagerUsername, String SiteName)
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
    }
    
    /**
     * this method is used to set the supplier email and comments to the supplier
     * @param SupplierEmail
     * @param CommentsToSupplier 
     */
    public void setPlaceOrder(String SupplierEmail, String CommentsToSupplier)
    {
        this.SupplierEmail = SupplierEmail;
        this.ApproverCommentsToSupplier = CommentsToSupplier;
    }
    
    /**
     * 
     * @param Status 
     */
    public void setApprovalStatus(String Status)
    {
        this.ApprovalStatus = Status;
    }
    
    /**
     * 
     */
    public PurchaseOrder()
    {
    }         
    
    /**
     * 
     * @return 
     */
    public int getPurchaseOrderID() {
        return PurchaseOrderID;
    }
    
    /**
     * 
     * @return 
     */
    public String getApprovalStatus() {
        return ApprovalStatus;
    }

    /**
     * @return the TotalPriceOfItems
     */
    public double getTotalPriceOfItems() {
        return TotalPriceOfItems;
    }

    /**
     * @return the RequiredDate
     */
    public String getRequiredDate() {
        return RequiredDate;
    }

    /**
     * @return the ApprovedBy
     */
    public String getApprovedBy() {
        return ApprovedBy;
    }

    /**
     * @return the ApprovedDate
     */
    public String getApprovedDate() {
        return ApprovedDate;
    }

    /**
     * @return the Comments
     */
    public String getComments() {
        return Comments;
    }

    /**
     * @return the SiteName
     */
    public String getSiteName() {
        return SiteName;
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
