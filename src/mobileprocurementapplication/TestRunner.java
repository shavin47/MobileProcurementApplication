/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    
    public static void main(String [] args)
    {
        Result result = JUnitCore.runClasses(JUnitUserTestSuite.class);
        
        for (Failure failure : result.getFailures()) 
        {
            System.out.println(failure.toString());           

        }
        
        System.out.println(result.wasSuccessful());
        
        //------------------------------------------------------------------------------------
        
        Result result1 = JUnitCore.runClasses(JUnitRequisitionOrderTestSuite.class);
        
        for(Failure failure : result1.getFailures())
        {
            System.out.println(failure.toString());
        }
        
        System.out.println(result1.wasSuccessful());
        
        //------------------------------------------------------------------------------------
        
        Result result2 = JUnitCore.runClasses(JUnitItemTestSuite.class);
        
        for(Failure failure : result2.getFailures())
        {
            System.out.println(failure.toString());
        }
        
        System.out.println(result2.wasSuccessful());
        
        //------------------------------------------------------------------------------------
        
        Result result3 = JUnitCore.runClasses(JUnitSiteTestSuite.class);
        
        for(Failure failure : result3.getFailures())
        {
            System.out.println(failure.toString());
        }
        
        System.out.println(result3.wasSuccessful());
                
    }
    
}
