import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Tests for Motorcycle class.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 14 November 2017
*/
public class MotorcycleTest {


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
   *Tests getters and setters.
   *@throws NegativeValueException if negative value is entered.
   */
   @Test public void getEngineSizeTest() throws NegativeValueException
   {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon", 
         "1964 Harley-Davidson Sportster", 14000, false, 750);
   
      Assert.assertEquals("getEngineSize() Test",
                           750, bike1.getEngineSize(), 0.0001);
                           
      bike1.setEngineSize(500);
      Assert.assertEquals("getEngineSize() Test",
                           500, bike1.getEngineSize(), 0.0001);
   }
   
   /**
   *Tests useTax.
   *@throws NegativeValueException if negative value is entered.
   */
   @Test public void useTaxTest() throws NegativeValueException
   {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon", 
         "1964 Harley-Davidson Sportster", 14000, false, 400);
      Motorcycle bike2 = new Motorcycle("Brando, Mike", 
         "1964 Harley-Davidson Sportster", 14000, true, 400);
      Motorcycle bike3 = new Motorcycle("Smith, Sam", 
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      Motorcycle bike4 = new Motorcycle("Smith, Simon", 
         "1964 Harley-Davidson Sportster", 14000, true, 750);
      
      Assert.assertEquals("non-engine false Test",
                           70, bike1.useTax(), 0.0001);
      Assert.assertEquals("non-engine true Test",
                           35, bike2.useTax(), 0.0001);
      Assert.assertEquals("lengine false Test",
                           280, bike3.useTax(), 0.0001);
      Assert.assertEquals("engine true Test",
                           245, bike4.useTax(), 0.0001);
   }
   
   /**
   *Tests toString.
   *@throws NegativeValueException if negative value is entered.
   */
   @Test public void toStringTest() throws NegativeValueException
   {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon", 
         "1964 Harley-Davidson Sportster", 14000, false, 400);
      Motorcycle bike2 = new Motorcycle("Brando, Mike", 
         "1964 Harley-Davidson Sportster", 14000, true, 400);
      Motorcycle bike3 = new Motorcycle("Smith, Sam", 
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      Motorcycle bike4 = new Motorcycle("Smith, Simon", 
         "1964 Harley-Davidson Sportster", 14000, true, 750);
      
      Assert.assertEquals("non-engine false Test",
                           true, 
                           bike1.toString().contains("Brando, Marlon: "
                           + "Motorcycle 1964 Harley-Davidson Sportster"));
      Assert.assertEquals("non-engine true Test",
                           true, 
                           bike2.toString().contains("Brando, Mike: "
                           + "Motorcycle 1964 Harley-Davidson Sportster "
                           + "(Alternative Fuel)"));
      Assert.assertEquals("engine false Test",
                           true, 
                           bike3.toString().contains("Smith, Sam: Motorcycle "
                           + "1964 Harley-Davidson Sportster"));
      Assert.assertEquals("engine true Test",
                           true, 
                           bike4.toString().contains("Smith, Simon: Motorcycle "
                           + "1964 Harley-Davidson Sportster "
                           + "(Alternative Fuel)"));
   
   
   }
}
