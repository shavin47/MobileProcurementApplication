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

/**
 *
 * This method is used to add a supplier, serialize and deserialize the supplier file
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */
public class SupplierService {
    
    //defining the supplier file to serialize and deserialize
    private static final String SupplierFile = "Supplier.ser";
    
    /**
     * this method is used to add a supplier to the list and serialize it to the file
     * @param aSupplier
     * @param supplierList
     * @throws IOException 
     */
    public void addSupplier(Supplier aSupplier, SetOfSuppliers<Supplier> supplierList) throws IOException{
        supplierList.add(aSupplier);
        Serialize(supplierList, SupplierFile);
        System.out.println("Supplier " + aSupplier.getSupplierName() + " Successfully Added.");       
        
    }
    
    /**
     * this method is used to serialize the object to the file
     * @param object
     * @param filename
     * @throws IOException 
     */
    public void Serialize(Object object, String filename) throws IOException{
        FileOutputStream out = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(object);
        oos.flush();
        out.close();
    }
    
    /**
     * this method is used to deserialize the file
     * @param filename
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public SetOfSuppliers<Supplier> Deserialize(String filename) throws IOException, ClassNotFoundException{
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        SetOfSuppliers<Supplier> supplierList = (SetOfSuppliers<Supplier>) ois.readObject();
        in.close();
        
        return supplierList;
    }
    
    
    
}
