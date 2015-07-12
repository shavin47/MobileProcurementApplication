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
 *
 * @author ShavinPC
 */
public class UserService {
    
    //defining the user file to serialize and deserialize
    private static final String UserFile = "User.ser";  
    
    public void addUser(User aUser, SetOfUsers<User> userList) throws IOException{
        userList.add(aUser);
        Serialize(userList,UserFile);
        System.out.println("User " + aUser.toString() + " Successfully Added.");
    }
    
    public void Serialize(Object object, String filename) throws IOException{
        FileOutputStream out = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(object);
        oos.flush();
        out.close();
    }
    
    public SetOfUsers<User> Deserialize(String filename) throws IOException, ClassNotFoundException{
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        SetOfUsers<User> userList = (SetOfUsers<User>) ois.readObject();
        in.close();
        
        return userList;
    }
    
    
    
    
}
