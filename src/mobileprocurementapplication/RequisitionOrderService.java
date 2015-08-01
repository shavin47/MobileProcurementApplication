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
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequisitionOrderService {
    
    //defining the RequisitionOrder file to serialize and deserialize
    private static final String RequisitionOrderFile = "RequisitionOrder.ser";  
    
    public void addOrder(RequisitionOrder aOrder, SetOfRequisitionOrders<RequisitionOrder> orderList) throws IOException{
        orderList.add(aOrder);
        Serialize(orderList,RequisitionOrderFile);
        System.out.println("Order Successfully Added.");
    }
    
    public SetOfRequisitionOrders updateOrderByID(RequisitionOrder aOrder, SetOfRequisitionOrders<RequisitionOrder> orderList) throws IOException{
               
        for(RequisitionOrder theOrder : orderList)
        {
            if(theOrder.getOrderID() == aOrder.getOrderID())
            {
                theOrder.updateOrder(aOrder.getItems(), aOrder.getQuantity(), aOrder.getTotalPriceOfItems(), aOrder.getRequiredDate(), aOrder.getComments(), aOrder.getUsername(), aOrder.getSitename());                                
                
                //remove existing Requistion Order and insert new one to mimic update
                orderList = removeThisOrder(aOrder, orderList);
                int x = orderList.size();
                orderList.addOrder(theOrder);                
                System.out.println("Order Successfully Updated");
                return orderList;
            }
        }
        
        return null;
        
        
    }
    
    public SetOfRequisitionOrders removeThisOrder(RequisitionOrder aOrder, SetOfRequisitionOrders<RequisitionOrder> orderList)
    {
        SetOfRequisitionOrders<RequisitionOrder> modifiedList = new SetOfRequisitionOrders();
        modifiedList.addAll(orderList);
        
        for(RequisitionOrder order : orderList)
        {
            if(order.getOrderID() == aOrder.getOrderID())
            {
                modifiedList.remove(order);
                int x = modifiedList.size();
                
                try {
                    this.Serialize(modifiedList, RequisitionOrderFile);
                    return modifiedList;
                } catch (IOException ex) {
                    Logger.getLogger(RequisitionOrderService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return null;
    }
    
    public void removeOrder(RequisitionOrder aOrder, SetOfRequisitionOrders<RequisitionOrder> orderList) throws IOException{
        orderList.remove(aOrder);
        Serialize(orderList, RequisitionOrderFile);
        System.out.println("Order " + aOrder.toString() + " Successfully Removed.");
    }
    
    public void Serialize(Object object, String filename) throws IOException{
        FileOutputStream out = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(object);
        oos.flush();
        out.close();
    }
    
    public SetOfRequisitionOrders<RequisitionOrder> Deserialize(String filename) throws IOException, ClassNotFoundException{
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        SetOfRequisitionOrders<RequisitionOrder> orderList = (SetOfRequisitionOrders<RequisitionOrder>) ois.readObject();
        in.close();
        
        return orderList;
    }
    
}
