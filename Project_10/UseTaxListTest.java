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
   */
   @Test public void useTaxTest() throws FileNotFoundException
   {
      UseTaxList list = new UseTaxList();
      list.readVehicleFile("vehicles1.txt");
      
      Assert.assertEquals("sortByOwner Test",
                           true, 
                           list.listByOwner().contains("Brando, Marlon: "
                           + "Motorcycle 1964 Harley-Davidson Sportster"));
                           
      Assert.assertEquals("sortByUseTax Test",
                           true, 
                           list.listByUseTax().contains("Jones, Jo: Car 2017 "
                           + "Honda Accord (Alternative Fuel)"));
                           
      Assert.assertEquals("excludedRecordsList Test",
                           true, 
                           list.excludedRecordsList().contains("race car; "
                           + "Zinc, Zed; 2013 Custom Hot Rod; 61000; false"));
                           
      Assert.assertEquals("toString() Test",
                           true, 
                           list.toString().contains("Brando, Marlon: "
                           + "Motorcycle 1964 Harley-Davidson Sportster"));
      
      list.setTaxDistrict("Tax District 53");
      Assert.assertEquals("getdistrict Test",
                           true, 
                           list.getTaxDistrict().contains("Tax District 53"));
                           
      Assert.assertEquals("calculate use tax Test",
                           12010.0, list.calculateTotalUseTax(), 0.0001);
                           
      Assert.assertEquals("calculate total value Test",
                           393000.0, list.calculateTotalValue(), 0.0001);
                           
      Vehicle car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      list.addVehicle(car1);
      
      list.addExcludedRecord("Test");                   
                           
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
