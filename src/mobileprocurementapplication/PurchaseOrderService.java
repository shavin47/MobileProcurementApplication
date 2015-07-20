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


public class PurchaseOrderService {
    
    //defining the PurchaseOrder file to serialize and deserialize 
    
    private static final String PurchaseOrderFile = "PurchaseOrder.ser";
    
    public void addOrder(PurchaseOrder aOrder, SetOfPurchaseOrders<PurchaseOrder> orderList) throws IOException{
        orderList.add(aOrder);
        Serialize(orderList,PurchaseOrderFile);
        System.out.println("Purchase Order " + aOrder.toString() + " Successfully Added.");
    }
    
    public void Serialize(Object object, String filename) throws IOException{
        FileOutputStream out = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(object);
        oos.flush();
        out.close();
    }
    
    public SetOfPurchaseOrders<PurchaseOrder> Deserialize(String filename) throws IOException, ClassNotFoundException{
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        SetOfPurchaseOrders<PurchaseOrder> orderList = (SetOfPurchaseOrders<PurchaseOrder>) ois.readObject();
        in.close();
        
        return orderList;
    }
}
