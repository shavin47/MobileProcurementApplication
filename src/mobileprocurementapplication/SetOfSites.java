/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.Serializable;
import java.util.Vector;

/**
 * This class is used to hold a list of sites
 * @author CSSD GROUP A
 * @param <Site> 
 */

public class SetOfSites<Site> extends Vector<Site> implements Serializable {
    
    /**
     * 
     */
    public SetOfSites()
    {
        super();
    }
    
    /**
     * 
     * @param aSite 
     */
    public void addSite(Site aSite)
    {
        super.add(aSite);
    }
    
    /**
     * 
     * @param aSite 
     */
    public void removeSite(Site aSite)
    {
        super.remove(aSite);
    }
}
