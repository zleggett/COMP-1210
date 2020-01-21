import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Test files for Car class.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 14 November 2017
*/
public class CarTest {


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
   *Tests for getters and setters.
   *@throws NegativeValueException if negative value is entered.
   */
   @Test public void getTest() throws NegativeValueException
   {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
   
      Assert.assertEquals("getOwner() Test",
                           "Jones, Sam", car1.getOwner());
      Assert.assertEquals("getyearMakeModel Test",
                           "2017 Honda Accord", car1.getYearMakeModel());
      Assert.assertEquals("getValue() Test",
                           22000, car1.getValue(), 0.0001);
      Assert.assertEquals("getAlternativeFuel Test",
                           false, 
                           car1.getAlternativeFuel());                    
      
                           
      car1.setOwner("Jones, Jo");
      car1.setYearMakeModel("2015 Mercedes-Benz Coupe");
      car1.setValue(110000);
      car1.setAlternativeFuel(true);
      
      Assert.assertEquals("getOwner() Test2",
                           "Jones, Jo", car1.getOwner());
      Assert.assertEquals("getyearMakeModel Test2",
                           "2015 Mercedes-Benz Coupe", car1.getYearMakeModel());
      Assert.assertEquals("getValue() Test2",
                           110000, car1.getValue(), 0.0001);
      Assert.assertEquals("getAlternativeFuel Test2",
                           true, car1.getAlternativeFuel());
   }
   /**
   *Tests for useTax.
   *@throws NegativeValueException if negative value is entered.
   */
   @Test public void useTaxTest() throws NegativeValueException
   {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe", 
         110000, false);
      Car car4 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe", 
         110000, true);
   
      Assert.assertEquals("non-luxury false Test",
                           220, car1.useTax(), 0.0001);
      Assert.assertEquals("non-luxury true Test",
                           110, car2.useTax(), 0.0001);
      Assert.assertEquals("luxury false Test",
                           3300, car3.useTax(), 0.0001);
      Assert.assertEquals("luxury true Test",
                           2750, car4.useTax(), 0.0001);
   }
   
   /**
   *Tests for toString.
   *@throws NegativeValueException if negative value is entered.
   */
   @Test public void toStringTest() throws NegativeValueException
   {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe", 
         110000, false);
      Car car4 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe", 
         110000, true);
   
      Assert.assertEquals("non-luxury false Test",
                           true, 
                           car1.toString().contains("Jones, Sam: Car "
                           + "2017 Honda Accord"));
      Assert.assertEquals("non-luxury true Test",
                           true, 
                           car2.toString().contains("Jones, Jo: Car "
                           + "2017 Honda Accord (Alternative Fuel)"));
      Assert.assertEquals("luxury false Test",
                           true, 
                           car3.toString().contains("Smith, Pat: Car "
                           + "2015 Mercedes-Benz Coupe"));
      Assert.assertEquals("luxury true Test",
                           true, 
                           car4.toString().contains("Smith, Jack: Car "
                           + "2015 Mercedes-Benz Coupe (Alternative Fuel)"));
   }
   
   /**
   *Tests for equals and hash code.
   *@throws NegativeValueException if negative value is entered.
   */
   @Test public void equalsTest() throws NegativeValueException
   {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car car2 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe", 
         110000, false);
         
      Assert.assertEquals("equals true Test",
                           true, car1.equals(car2));
      Assert.assertEquals("equals false Test",
                           false, car1.equals(car3));
      Assert.assertEquals("equals false Test2",
                           false, car1.equals("test"));
      Assert.assertEquals("hash code Test",
                           car2.hashCode(), car1.hashCode());
   }
   
}
