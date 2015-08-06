/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.Serializable; 
import java.util.Vector;

/**
 * This class is used to hold a list of purchase orders
 * 
 * @author CSSD GROUP A
 * @param <PurchaseOrder> 
 */

public class SetOfPurchaseOrders<PurchaseOrder> extends Vector<PurchaseOrder> implements Serializable{
    public SetOfPurchaseOrders()
    {
        super();
    }
    
    public void addOrder(PurchaseOrder aOrder)
    {
        super.add(aOrder);
    }
    
    public void removeOrder(PurchaseOrder aOrder)
    {
        super.remove(aOrder);
    }
}
