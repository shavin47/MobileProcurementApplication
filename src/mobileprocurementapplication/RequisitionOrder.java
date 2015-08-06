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
 * 
 * This class is used to hold information about the requisition order
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */

public class RequisitionOrder implements Serializable{
    
    int RequisitionOrderID; 
    SetOfItems<Item> ItemList;
    double [] Quantity;
    double TotalPriceOfItems;
    String RequiredDate;
    String PlacedDate;
    String ApprovalStatus;
    String Approver; 
    String Comments;
    String Username; 
    String SiteName;
    String DeclinedComments;
    int PurchaseOrderReferenceNumber;
    
    private static int orderCount = 0;
    
    /**
     * 
     * @param ItemList
     * @param Quantity
     * @param TotalPriceOfItems
     * @param PlacedDate
     * @param RequiredDate
     * @param Comments
     * @param Username
     * @param SiteName 
     */
    
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
        this.Approver = "";
        this.DeclinedComments = "";
        
    }
    
    /**
     * 
     * @param OrderID
     * @param ItemList
     * @param Quantity
     * @param TotalPriceOfItems
     * @param RequiredDate
     * @param Comments
     * @param Username
     * @param SiteName 
     */
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
    
    /**
     * 
     */
    public RequisitionOrder()
    {
    }
    
    /**
     * this method is used to set declined comments, carried out by the accountant when declining a requisition order
     * @param Comment 
     */
    public void setDeclinedComments(String Comment)
    {
        this.DeclinedComments = Comment;
    }
    
    /**
     * this method is used to set the purchase order reference to keep track of the purchase order
     * @param ReferenceNumber 
     */
    public void setPurchaseOrderReference(int ReferenceNumber)
    {
        this.PurchaseOrderReferenceNumber = ReferenceNumber;
    }
    
    /**
     * this method is used to get the purchase order reference number
     * @return 
     */
    public int getPurchaseOrderReferenceNumber()
    {
        return this.PurchaseOrderReferenceNumber;
    }
    
    /**
     * This method is used to set the approval status (pending/approved/declined/placed) 
     * @param Status 
     */
    public void setApprovalStatus(String Status)
    {
        this.ApprovalStatus = Status;
    }
    
    /**
     * this method is used to set the approval status and the approver 
     * @param ApprovalStatus
     * @param ApproverName 
     */
    public void setApproval(String ApprovalStatus, String ApproverName)
    {
        this.ApprovalStatus = ApprovalStatus;
        this.Approver = ApproverName;
    }
    
    /**
     * 
     * @param itemList
     * @param quantityList
     * @param totalPriceOfItems
     * @param requiredDate
     * @param comments
     * @param userName
     * @param siteName 
     */
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
    
    /**
     * This method is used to get the approver
     * @return 
     */
    public String getApprover()
    {
        return Approver;
    }
    
    /**
     * 
     * @return 
     */
    public String getDeclinedComments()
    {
        return DeclinedComments;
    }
    
    /**
     * 
     * @return 
     */
    public String getUsername()
    {
        return Username;
    }
    
    /**
     * 
     * @return 
     */
    public String getSitename()
    {
        return SiteName;
    }
    
    /**
     * 
     * @return an array of items
     */
    public SetOfItems<Item> getItems()
    {
        return ItemList;
    }
    
    /**
     * 
     * @return 
     */
    public String getComments()
    {
        return Comments;
    }
    
    /**
     * 
     * @return an array of quantity
     */
    public double[] getQuantity()
    {
        return Quantity;
    }
    
    /**
     * 
     * @return 
     */
    public int getQuantityArraySize()
    {
        return Quantity.length;        
    }
    
    /**
     * 
     * @return 
     */
    public int getOrderID()
    {
        return this.RequisitionOrderID;
    }
    
    /**
     * 
     * @return 
     */
    public double getTotalPriceOfItems()
    {
        return this.TotalPriceOfItems;
    }
    
    /**
     * 
     * @return 
     */
    public String getRequiredDate()
    {
        return this.RequiredDate;
    }
    
    /**
     * 
     * @return 
     */
    public String getStatusOfApproval()
    {
        return this.ApprovalStatus;
    }
    
    /**
     * 
     * @return 
     */
    public int getItemCount()
    {
        return this.ItemList.size();
    }
    
    /**
     * 
     * @return 
     */
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
