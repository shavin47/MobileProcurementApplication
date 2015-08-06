/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * This class is used to add a requisition order, serialize and deserialize the requisition order file
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */

public class RequisitionOrderTestCases {
    
    private static final String RequisitionOrderFile = "RequisitionOrder.ser";
    private static SetOfRequisitionOrders<RequisitionOrder> orderList = new SetOfRequisitionOrders();
    private static RequisitionOrderService orderService = new RequisitionOrderService();
    
    //Creating a new item to add to itemList and quantity, to be sent to RequisitionOrder Constructor
    public static SetOfItems<Item> itemList = new SetOfItems();        
    public static Item item1 = new Item("Pine", "Wood", 2);    
    public static double [] Quantity = {1};
    
    
    public static RequisitionOrder order = new RequisitionOrder(itemList, Quantity, 2, "07/08/2015", "20/08/2015", "No Comment", "shavin@live.com", "Shavin's Construction Site");
    
    static{
        itemList.add(item1);
        orderList.add(order);      
        
        try {
            RequisitionOrderTestCases.orderService.Serialize(orderList, RequisitionOrderFile);
        } catch (IOException ex) {
            Logger.getLogger(RequisitionOrderTestCases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void requisitionOrderTestCase()
    {
       
        
        try {
            int i = 0; 
            
            for(RequisitionOrder order : RequisitionOrderTestCases.orderService.Deserialize(RequisitionOrderFile))
            {
                Assert.assertEquals(order.getOrderID(), orderList.get(i).getOrderID());                
                Assert.assertEquals(order.getPlacedDate(), orderList.get(i).getPlacedDate());
                Assert.assertEquals(order.getRequiredDate(), orderList.get(i).getRequiredDate());
                Assert.assertEquals(order.getUsername(), orderList.get(i).getUsername());
                Assert.assertEquals(order.getSitename(), orderList.get(i).getSitename());               
                
                i++;
            }                              
        } catch (IOException ex) {
            Logger.getLogger(RequisitionOrderTestCases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RequisitionOrderTestCases.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
    
   @Test(expected = FileNotFoundException.class) 
   public void negativeTestCaseForDeserialize() throws ClassNotFoundException, IOException{
       RequisitionOrderTestCases.orderService.Deserialize("Invalid Name");
       
   }    
    
            
            
}
