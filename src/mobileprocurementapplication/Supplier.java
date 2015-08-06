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
 * This class is used to hold information about the supplier
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */
public class Supplier implements Serializable{
    
    int SupplierID; 
    String SupplierName; 
    String TelephoneNumber; 
    String Email;
    
    int supplierCount = 0;
    
    /**
     * 
     * @param SupplierName
     * @param TelNo
     * @param Email 
     */
    public Supplier(String SupplierName, String TelNo, String Email)
    {
        SupplierID = ++supplierCount;
        this.SupplierName = SupplierName;
        this.TelephoneNumber = TelNo; 
        this.Email = Email;
    }
    
    /**
     * default constructor
     */
    public Supplier()
    {}
    
    /**
     * this method gets the supplier id
     * @return 
     */
    public int getSupplierID()
    {
        return this.SupplierID;
    }
    
    /**
     * this method gets the suppliers name
     * @return 
     */
    public String getSupplierName()
    {
        return this.SupplierName;
    }
    
    /**
     * this method gets the suppliers email
     * @return 
     */
    public String getSupplierEmail()
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
