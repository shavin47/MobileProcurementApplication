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
 * This class is used to add a site, serialize and deserialize the site file
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */

public class SiteService {
    
    //defining the Site file to serialize and deserialize
    private static final String SiteFile = "Site.ser";
    
    /**
     * this method adds a site and then serializes it
     * @param aSite
     * @param siteList
     * @throws IOException 
     */
    public void addSite(Site aSite, SetOfSites<Site> siteList) throws IOException{
        siteList.add(aSite);
        Serialize(siteList, SiteFile);
        System.out.println("Site " + aSite.toString() + " Successfully Added.");
    }
    
    /**
     * this method serializes the object to the file
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
     * this method deserializes the file
     * @param filename
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public SetOfSites<Site> Deserialize(String filename) throws IOException, ClassNotFoundException{
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        SetOfSites<Site> siteList = (SetOfSites<Site>) ois.readObject();
        in.close();
        
        return siteList;
    }
    
    
}
