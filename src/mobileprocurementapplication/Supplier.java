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
 * @author ShavinPC
 */
public class Supplier implements Serializable{
    
    int SupplierID; 
    String SupplierName; 
    String TelephoneNumber; 
    String Email;
    
    int supplierCount = 0;
    
    public Supplier(String SupplierName, String TelNo, String Email)
    {
        SupplierID = ++supplierCount;
        this.SupplierName = SupplierName;
        this.TelephoneNumber = TelNo; 
        this.Email = Email;
    }
    
    public Supplier()
    {}
    
    public int getSupplierID()
    {
        return this.SupplierID;
    }
    
    public String getSupplierName()
    {
        return this.SupplierName;
    }
    
    //Retrieving the count from the file
    private void writeObject(ObjectOutputStream oos) throws IOException
    {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(supplierCount));      

    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
    {
        ois.defaultReadObject();
        supplierCount = (Integer)ois.readObject();
    }
    
    
    
}
