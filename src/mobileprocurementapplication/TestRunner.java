/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobileprocurementapplication;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * This class is used to run the test suites
 * 
 * @author CSSD GROUP A
 * @version 1.0
 */

public class TestRunner {
    
    public static void main(String [] args)
    {
        Result result = JUnitCore.runClasses(JUnitUserTestSuite.class);
        
        for (Failure failure : result.getFailures()) 
        {
            System.out.println(failure.toString());           

        }
        
        if(result.wasSuccessful())
        {
            System.out.println("User Test Suite Ran Successfully");        
        }
        
        
        //------------------------------------------------------------------------------------
        
        Result result1 = JUnitCore.runClasses(JUnitRequisitionOrderTestSuite.class);
        
        for(Failure failure : result1.getFailures())
        {
            System.out.println(failure.toString());
        }
        
        if(result.wasSuccessful())
        {
            System.out.println("Requisition Order Test Suite Ran Successfully");        
        }
        
        //------------------------------------------------------------------------------------
        
        Result result2 = JUnitCore.runClasses(JUnitItemTestSuite.class);
        
        for(Failure failure : result2.getFailures())
        {
            System.out.println(failure.toString());
        }
        
        if(result.wasSuccessful())
        {
            System.out.println("Item Test Suite Ran Successfully");        
        }
        
        //------------------------------------------------------------------------------------
        
        Result result3 = JUnitCore.runClasses(JUnitSiteTestSuite.class);
        
        for(Failure failure : result3.getFailures())
        {
            System.out.println(failure.toString());
        }
        
        if(result.wasSuccessful())
        {
            System.out.println("Site Test Suite Ran Successfully");        
        }
                
    }
    
}
