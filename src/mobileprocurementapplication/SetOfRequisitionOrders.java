/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.Serializable;
import java.util.Vector;


public class SetOfRequisitionOrders<RequisitionOrder> extends Vector<RequisitionOrder> implements Serializable {
    
    public SetOfRequisitionOrders()
    {
        super();
    }
    
    public void addOrder(RequisitionOrder aOrder)
    {
        super.add(aOrder);
    }
    
    public void removeOrder(RequisitionOrder aOrder)
    {
        super.remove(aOrder);
    }
    
    
}
