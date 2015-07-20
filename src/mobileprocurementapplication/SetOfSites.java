/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.Serializable;
import java.util.Vector;


public class SetOfSites<Site> extends Vector<Site> implements Serializable {
    
    public SetOfSites()
    {
        super();
    }
    
    public void addSite(Site aSite)
    {
        super.add(aSite);
    }
    
    public void removeSite(Site aSite)
    {
        super.remove(aSite);
    }
}
