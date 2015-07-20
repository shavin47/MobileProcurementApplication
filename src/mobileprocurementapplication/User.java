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
 * @author ShavinPC
 */
public class User implements Serializable{
    
    private int UserID; 
    private String FullName; 
    private String TelephoneNumber;
    private String Username; 
    private String Password; 
    private String UserType;
    
    private static int userCount = 0; 
    
    public User(String FullName, String TelephoneNumber, String Username, String Password, String UserType)
    {
        UserID = ++userCount;
        this.FullName = FullName; 
        this.TelephoneNumber = TelephoneNumber; 
        this.Username = Username;
        this.Password = Password; 
        this.UserType = UserType;
    }
    
    public int getUserID()
    {
        return this.UserID;
    }
    
    public String getUsername()
    {
        return this.Username;
    }
    
    public String getPassword()
    {
        return this.Password;
    }    
    
  private void writeObject(ObjectOutputStream oos) throws IOException
  {
      oos.defaultWriteObject();
      oos.writeObject(new Integer(userCount));      
  
  }
  
  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
  {
      ois.defaultReadObject();
      userCount = (Integer)ois.readObject();
  }
    
    
    
    
    
}