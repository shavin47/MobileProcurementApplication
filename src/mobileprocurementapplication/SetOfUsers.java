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
 * This class is used to hold the list of users 
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */
public class SetOfUsers<User> extends Vector<User> implements Serializable {
    
    /**
     * 
     */
    public SetOfUsers()
    {
        super();
    }
    
    /**
     * adds a user to the list
     * @param aUser 
     */
    public void addUser(User aUser)
    {
        super.add(aUser);
    }
    
    /**
     * removes a user from the list
     * @param aUser 
     */
    public void removeUser(User aUser)
    {
        super.remove(aUser);
    }    
    
    
}
