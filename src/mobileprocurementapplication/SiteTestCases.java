/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Test;

/**
 * This class is used hold the test cases for Site
 * @author CSSD GROUP A
 */

public class SiteTestCases {

    private static final String SiteFile = "Site.ser";
    private static SetOfSites<Site> siteList = new SetOfSites();
    private static SiteService siteService = new SiteService();
    
    public static Site site1 = new Site("Shavin's Construction Site", "Colombo", "shavin@live.com", "2727455");
    public static Site site2 = new Site("A's Construction Site", "Colombo", "a", "2749543");
    public static Site site3 = new Site("Dihanna's Construction Site", "Colombo", "dihanna@live.com", "2589023");
    public static Site site4 = new Site("RIQ Construction Co.", "Matara", "raneesha@gmail.com", "26123459");
    
    static
    {
        siteList.add(site1);
        siteList.add(site2);
        siteList.add(site3);
        siteList.add(site4);
        
        try {
            SiteTestCases.siteService.Serialize(siteList, SiteFile);
        } catch (IOException ex) {
            Logger.getLogger(SiteTestCases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void siteTestCase()
    {              
        try {
            int i = 0;
            
            for(Site site : SiteTestCases.siteService.Deserialize(SiteFile))
            {
                
                Assert.assertEquals(site.getSiteID(), siteList.get(i).getSiteID());
                Assert.assertEquals(site.getSiteName(), siteList.get(i).getSiteName());
                Assert.assertEquals(site.getSiteAddress(), siteList.get(i).getSiteAddress());
                Assert.assertEquals(site.getSiteTelephoneNumber(), siteList.get(i).getSiteTelephoneNumber());
                Assert.assertEquals(site.getSiteManagersUsername(), siteList.get(i).getSiteManagersUsername());
                
                i++;                
            }
        } catch (IOException ex) {
            Logger.getLogger(SiteTestCases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SiteTestCases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test(expected = FileNotFoundException.class) 
    public void negativeTestCaseForDeserialize() throws ClassNotFoundException, IOException{
        SiteTestCases.siteService.Deserialize("Invalid Name");
    } 
}
