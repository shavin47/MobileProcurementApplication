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


public class UserTestCases {
    
    private static final String UserFile = "User.ser";
    private static SetOfUsers<User> userList = new SetOfUsers();
    private static UserService userService = new  UserService();    
    
    public static User user1 = new User(100, "Shavin", "2727455", "shavin@live.com", "123", "Site Manager");
    public static User user2 = new User(101, "Dihanna", "2727455", "dihanna@live.com", "456", "Accountant");
    public static User user3 = new User(102, "Raneesha", "272455", "raneesha@gmail.com", "456", "Site Manager");

    static{
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);        
        try {
            UserTestCases.userService.Serialize(userList, UserFile);
        } catch (IOException ex) {
            Logger.getLogger(UserTestCases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void userTestCase()
    {         
        try {
            int i = 0;
            
            for(User user : UserTestCases.userService.Deserialize(UserFile))
            {
                Assert.assertEquals(user.getUserID(), userList.get(i).getUserID());
                Assert.assertEquals(user.getUserFullName(), userList.get(i).getUserFullName());
                Assert.assertEquals(user.getTelephoneNumber(), userList.get(i).getTelephoneNumber());
                Assert.assertEquals(user.getUsername(), userList.get(i).getUsername());
                Assert.assertEquals(user.getPassword(), userList.get(i).getPassword());
                Assert.assertEquals(user.getUserType(), userList.get(i).getUserType());
                
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(UserTestCases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserTestCases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test(expected = FileNotFoundException.class) 
    public void negativeTestCaseForDeserialize() throws ClassNotFoundException, IOException{
        UserTestCases.userService.Deserialize("Invalid Name");
    }      
    
}
