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


public class SiteService {
    
    //defining the Site file to serialize and deserialize
    private static final String SiteFile = "Site.ser";
    
    public void addSite(Site aSite, SetOfSites<Site> siteList) throws IOException{
        siteList.add(aSite);
        Serialize(siteList, SiteFile);
        System.out.println("Site " + aSite.toString() + " Successfully Added.");
    }
    
    public void Serialize(Object object, String filename) throws IOException{
        FileOutputStream out = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(object);
        oos.flush();
        out.close();
    }
    
    public SetOfSites<Site> Deserialize(String filename) throws IOException, ClassNotFoundException{
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        SetOfSites<Site> siteList = (SetOfSites<Site>) ois.readObject();
        in.close();
        
        return siteList;
    }
    
    
}
