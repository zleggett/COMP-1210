import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
*Tests for UseTaxList.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 26 November 2017
*/
public class UseTaxListTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   /*
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }
   */
   
   /**
   *Tests methods of UseTaxList.
   *@throws FileNotFoundException if the file cannot be opened.
   *@throws NegativeValueException if negative value is entered.
   */
   @Test public void useTaxTest() throws FileNotFoundException, 
      NegativeValueException
   {
      UseTaxList list = new UseTaxList();
      list.readVehicleFile("vehicles2.txt");
      
      Assert.assertEquals("sortByOwner Test",
                           true, 
                           list.listByOwner().contains("Brando, Marlon: "
                           + "Motorcycle 1964 Harley-Davidson Sportster"));
                           
      Assert.assertEquals("sortByUseTax Test",
                           true, 
                           list.listByUseTax().contains("Jones, Jo: Car 2014 "
                           + "Honda Accord (Alternative Fuel)"));
      
      list.addExcludedRecord("Test");                     
      Assert.assertEquals("excludedRecordsList Test",
                           true, 
                           list.excludedRecordsList().contains("Test"));
                           
      Assert.assertEquals("toString() Test",
                           true, 
                           list.toString().contains("Brando, Marlon: "
                           + "Motorcycle 1964 Harley-Davidson Sportster"));
      
      list.setTaxDistrict("Tax District 53");
      Assert.assertEquals("getdistrict Test",
                           true, 
                           list.getTaxDistrict().contains("Tax District 53"));
                           
      Assert.assertEquals("calculate use tax Test",
                           15310.0, list.calculateTotalUseTax(), 0.0001);
                           
      Assert.assertEquals("calculate total value Test",
                           503000.0, list.calculateTotalValue(), 
                           0.0001);                  
                           
   }
   
   /**
   *Tests getVeehicleList and getExcludedRecords.
   *@throws FileNotFoundException if the file cannot be opened.
   */
   @Test public void getArraysTest() throws FileNotFoundException
   {
      UseTaxList list = new UseTaxList();
      list.readVehicleFile("vehicles1.txt");
      Vehicle[] vehicleList = new Vehicle[8];
      vehicleList = list.getVehicleList();
      
      Assert.assertArrayEquals("vehicle list Test",
                           vehicleList, list.getVehicleList());
                           
      String[] excludedRecords = new String[2];
      excludedRecords = list.getExcludedRecords();
      Assert.assertArrayEquals("excludedRecords list Test",
                           excludedRecords, list.getExcludedRecords());
      
   }
}
