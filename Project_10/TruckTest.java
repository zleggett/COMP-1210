import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Tests for Truck class.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 14 November 2017
*/
public class TruckTest {


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
   */
   @Test public void getTonsTest()
   {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado", 
         30000, false, 1.5);
   
      Assert.assertEquals("getTons() Test",
                           1.5, truck1.getTons(), 0.0001);
                           
      truck1.setTons(3.0);
      Assert.assertEquals("getTons() Test2",
                           3.0, truck1.getTons(), 0.0001);
   }
   
   /**
   *Tests for useTax.
   */
   @Test public void useTaxTest()
   {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado", 
         30000, false, 1.5);
      Truck truck2 = new Truck("Williams, John", "2012 Chevy Silverado", 
         30000, true, 1.5);
      Truck truck3 = new Truck("Williams, Sam", "2010 Chevy Mack", 
         40000, false, 2.5);
      Truck truck4 = new Truck("Williams, Bob", "2010 Chevy Mack", 
         40000, true, 2.5);
      
      Assert.assertEquals("non-large false Test",
                           600, truck1.useTax(), 0.0001);
      Assert.assertEquals("non-large true Test",
                           300, truck2.useTax(), 0.0001);
      Assert.assertEquals("large false Test",
                           2000, truck3.useTax(), 0.0001);
      Assert.assertEquals("large true Test",
                           1600, truck4.useTax(), 0.0001);
   }
   
   /**
   *Tests for toString.
   */
   @Test public void toStringTest()
   {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado", 
         30000, false, 1.5);
      Truck truck2 = new Truck("Williams, John", "2012 Chevy Silverado", 
         30000, true, 1.5);
      Truck truck3 = new Truck("Williams, Sam", "2010 Chevy Mack", 
         40000, false, 2.5);
      Truck truck4 = new Truck("Williams, Bob", "2010 Chevy Mack", 
         40000, true, 2.5);
      
      Assert.assertEquals("non-large false Test",
                           true, 
                           truck1.toString().contains("Williams, Jo: Truck "
                           + "2012 Chevy Silverado"));
      Assert.assertEquals("non-large true Test",
                           true, 
                           truck2.toString().contains("Williams, John: Truck "
                           + "2012 Chevy Silverado (Alternative Fuel)"));
      Assert.assertEquals("large false Test",
                           true, 
                           truck3.toString().contains("Williams, Sam: Truck "
                           + "2010 Chevy Mack"));
      Assert.assertEquals("large true Test",
                           true, 
                           truck4.toString().contains("Williams, Bob: Truck "
                           + "2010 Chevy Mack (Alternative Fuel)"));
   }
}
