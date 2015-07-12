/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author ShavinPC
 */
public class SetOfUsers<User> extends Vector<User> implements Serializable {
    
    public SetOfUsers()
    {
        super();
    }
    
    public void addUser(User aUser)
    {
        super.add(aUser);
    }
    
    public void removeUser(User aUser)
    {
        super.remove(aUser);
    }    
    
    
}
