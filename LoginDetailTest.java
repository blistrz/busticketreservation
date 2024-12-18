/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginDetailTest {
    
    public LoginDetailTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of search method, of class LoginDetail.
     */
    @Test
    public void testSearchbyTime() {
        System.out.println("time");
        String searchtype = "Time";
        String searchby="11:10:06.9697263";
        LoginDetail rd = new LoginDetail();
//        boolean expResult = false;
//        boolean result = instance.search(searchtype,searchby);
//        assertEquals(expResult, result);
assertTrue(rd.search(searchtype, searchby));
  
    }
    
     @Test
    public void testSearchbyIPaddressNotfound () {
        System.out.println("ipaddressNotfoundtest");
        String searchtype = "IPaddress";
        String searchby="127.0.0.2";
         LoginDetail rd = new LoginDetail();
//        boolean expResult = false;
//        boolean result = instance.search(searchtype,searchby);
//        assertEquals(expResult, result);
assertFalse(rd.search(searchtype, searchby));
  
    }

 @Test
    public void testSearchbyIpaddress () {
        System.out.println("IpaddressFound");
        String searchtype = "IPaddress";
        String searchby="127.0.0.1";
         LoginDetail rd = new LoginDetail();
//        boolean expResult = false;
//        boolean result = instance.search(searchtype,searchby);
//        assertEquals(expResult, result);
assertTrue(rd.search(searchtype, searchby));
  
    }
    
     @Test
    public void testSearchbyDate() {
        System.out.println("search");
        String searchtype = "Date";
        String searchby="2024-11-28";
         LoginDetail rd = new LoginDetail();
//        boolean expResult = false;
//        boolean result = instance.search(searchtype,searchby);
//        assertEquals(expResult, result);
assertTrue(rd.search(searchtype, searchby));
  
    }
    

    /**
     * Test of logindata method, of class LoginDetail.
     */
    @Test
    public void testLogindata() {
        System.out.println("logindata");
        LoginDetail instance = new LoginDetail();
        boolean x=instance.logindata();
        assertTrue(x);

    }


    
}
