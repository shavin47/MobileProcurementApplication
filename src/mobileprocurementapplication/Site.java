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
 * This class is used to hold the construction site details
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */

public class Site implements Serializable{
    
    private int SiteID; 
    private String SiteName; 
    private String SiteAddress; 
    private String SiteManagerUsername;
    private String TelephoneNumber;
    
    private static int siteCount = 0; 
    
    /**
     * 
     * @param SiteName
     * @param SiteAddress
     * @param SiteManagerUsername
     * @param TelephoneNumber 
     */
    public Site(String SiteName, String SiteAddress, String SiteManagerUsername, String TelephoneNumber)
    {
        SiteID = ++siteCount;
        this.SiteName = SiteName; 
        this.SiteAddress = SiteAddress; 
        this.SiteManagerUsername = SiteManagerUsername; 
        this.TelephoneNumber = TelephoneNumber;
    }
    
    /**
     * 
     */
    public Site()
    {
    }
    
    /**
     * this method is used to get the site name
     * @return 
     */
    public String getSiteName()
    {
        return this.SiteName;
    }
    
    /**
     * this method is used to get the site id
     * @return 
     */
    public int getSiteID()
    {
        return this.SiteID;
    }
    
    /**
     * this method is used to get the site managers username
     * @return 
     */
    public String getSiteManagersUsername()
    {
        return this.SiteManagerUsername;
    }
    
    /**
     * this method is used to get the site telephone number
     * @return 
     */
    public String getSiteTelephoneNumber()
    {
        return this.TelephoneNumber;
    }
    
    /**
     * this method is used to get the site address
     * @return 
     */
    public String getSiteAddress()
    {
        return this.SiteAddress;
    }
    
    /**
     * 
     * @param oos
     * @throws IOException 
     */
    private void writeObject(ObjectOutputStream oos) throws IOException
    {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(siteCount));      

    }

    /**
     * 
     * @param ois
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
    {
        ois.defaultReadObject();
        siteCount = (Integer)ois.readObject();
    }
}
