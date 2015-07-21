/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


    

public class Test {
    
    private static final String ItemFile = "Item.ser";
    private SetOfItems<Item> itemList = new SetOfItems();
    private ItemService itemService;  
    
    private static final String SiteFile = "Site.ser";
    private SetOfSites<Site> siteList = new SetOfSites();
    private SiteService siteService;
    
    public void add()
    {
        itemService = new ItemService();
        siteService = new SiteService();
        
        try {            
            itemList = this.itemService.Deserialize(ItemFile);
            siteList = this.siteService.Deserialize(SiteFile);
        } catch (IOException ex) {
            Logger.getLogger(RegisterUserUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterUserUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Site aSite = new Site("abasd", "akdalsk", "shavin@hotmail.com", "123456");
        
        try {
            this.siteService.addSite(aSite, siteList);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }    
    
}
