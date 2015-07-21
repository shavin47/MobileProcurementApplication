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


public class Site implements Serializable{
    
    private int SiteID; 
    private String SiteName; 
    private String SiteAddress; 
    private String SiteManagerUsername;
    private String TelephoneNumber;
    
    private static int siteCount = 0; 
    
    public Site(String SiteName, String SiteAddress, String SiteManagerUsername, String TelephoneNumber)
    {
        SiteID = ++siteCount;
        this.SiteName = SiteName; 
        this.SiteAddress = SiteAddress; 
        this.SiteManagerUsername = SiteManagerUsername; 
        this.TelephoneNumber = TelephoneNumber;
    }
    
    public String getSiteName()
    {
        return this.SiteName;
    }
    
    public String getSiteManagersUsername()
    {
        return this.SiteManagerUsername;
    }
    
    public String getSiteTelephoneNumber()
    {
        return this.TelephoneNumber;
    }
    
    public String getSiteAddress()
    {
        return this.SiteAddress;
    }
    //Retrieving the count from the file
    private void writeObject(ObjectOutputStream oos) throws IOException
    {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(siteCount));      

    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
    {
        ois.defaultReadObject();
        siteCount = (Integer)ois.readObject();
    }
}
