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
 * This class is used to hold the information of the users of the system
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */
public class User implements Serializable{
    
    private int UserID; 
    private String FullName; 
    private String TelephoneNumber;
    private String Username; 
    private String Password; 
    private String UserType;
    
    private static int userCount = 0; 
    
    /**
     * 
     * @param FullName
     * @param TelephoneNumber
     * @param Username
     * @param Password
     * @param UserType 
     */
    public User(String FullName, String TelephoneNumber, String Username, String Password, String UserType)
    {
        UserID = ++userCount;
        this.FullName = FullName; 
        this.TelephoneNumber = TelephoneNumber; 
        this.Username = Username;
        this.Password = Password; 
        this.UserType = UserType;
    }
    
    /**
     * 
     * @param UserID
     * @param FullName
     * @param TelephoneNumber
     * @param Username
     * @param Password
     * @param UserType 
     */
    public User(int UserID, String FullName, String TelephoneNumber, String Username, String Password, String UserType)
    {
        this.UserID = UserID; 
        this.FullName = FullName; 
        this.TelephoneNumber = TelephoneNumber; 
        this.Username = Username; 
        this.Password = Password;
        this.UserType = UserType;
    }
    
    /**
     * 
     * @param FullName
     * @param TelephoneNumber
     * @param UserType 
     */
    public void updateUser(String FullName, String TelephoneNumber, String UserType)
    {
        this.FullName = FullName;
        this.TelephoneNumber = TelephoneNumber; 
        this.UserType = UserType;
    }
    
    /**
     * this method gets the users id
     * @return 
     */
    public int getUserID()
    {
        return this.UserID;
    }
    
    /**
     * this method gets the username
     * @return 
     */
    public String getUsername()
    {
        return this.Username;
    }
    
    /**
     * this method gets the password
     * @return 
     */
    public String getPassword()
    {
        return this.Password;
    }
    
    /**
     * this method gets the type of the user accountant/site manager
     * @return 
     */
    public String getUserType()
    {
        return this.UserType;
    }
    
    /**
     * this method gets the users full name
     * @return 
     */
    public String getUserFullName()
    {
        return this.FullName;
    }
    
    /**
     * this method gets the users telephone number
     * @return 
     */
    public String getTelephoneNumber()
    {
        return this.TelephoneNumber;
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
