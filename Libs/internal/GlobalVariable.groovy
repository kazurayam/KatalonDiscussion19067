package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object Hostname
     
    /**
     * <p></p>
     */
    public static Object Username
     
    /**
     * <p></p>
     */
    public static Object Password
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['Hostname' : 'demoaut.katalon.com', 'Username' : 'John Doe', 'Password' : 'ThisIsNotAPassword'])
        allVariables.put('development', allVariables['default'] + ['Hostname' : 'demoaut.katalon.com', 'Username' : 'John Doe', 'Password' : 'ThisIsNotAPassword'])
        allVariables.put('production', allVariables['default'] + ['Hostname' : 'demoaut.katalon.com', 'Username' : 'John Doe', 'Password' : 'ThisIsNotAPassword'])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        Hostname = selectedVariables['Hostname']
        Username = selectedVariables['Username']
        Password = selectedVariables['Password']
        
    }
}
