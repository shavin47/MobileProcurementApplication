/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * This class is used to hold the list of suppliers
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */
public class SetOfSuppliers<Supplier> extends Vector<Supplier> implements Serializable {
    
    public SetOfSuppliers()
    {
        super();
    }
    
    public void addSupplier(Supplier aSupplier)
    {
        super.add(aSupplier);
    }
    
    public void removeSupplier(Supplier aSupplier)
    {
        super.remove(aSupplier);
    }   
    
}
