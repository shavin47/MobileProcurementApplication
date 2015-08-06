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
 * This class adds a user, serializes and deserializes the user file
 *
 * @author CSSD GROUP A
 * @version 1.0
 */
public class UserService {
    
    //defining the user file to serialize and deserialize
    private static final String UserFile = "User.ser";  
    
    /**
     * this method adds a user to the list and then serializes it to the user file
     * @param aUser
     * @param userList
     * @throws IOException 
     */
    public void addUser(User aUser, SetOfUsers<User> userList) throws IOException{
        userList.add(aUser);
        Serialize(userList,UserFile);
        System.out.println("User " + aUser.toString() + " Successfully Added.");
    }
    
    /**
     * this method serializes the object 
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
     * this method deserializes the user file
     * @param filename
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public SetOfUsers<User> Deserialize(String filename) throws IOException, ClassNotFoundException{
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        SetOfUsers<User> userList = (SetOfUsers<User>) ois.readObject();
        in.close();
        
        return userList;
    }
    
    
    
    
}
