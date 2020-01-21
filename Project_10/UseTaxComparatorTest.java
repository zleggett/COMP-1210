import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
*Tests for UseTaxComparator.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 26 November 2017
*/
public class UseTaxComparatorTest {


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
   *Tests compare.
   *@throws FileNotFoundException if the file cannot be opened.
   */
   @Test public void compareTest() throws FileNotFoundException
   {
      UseTaxList list = new UseTaxList();
      list.readVehicleFile("vehicles1.txt");
      Vehicle car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      list.addVehicle(car1);
      
      Vehicle car2 = new Car("Jones, Sam", "2017 Honda Accord", 20000, false);
      list.addVehicle(car2);
   
      
      Assert.assertEquals("sortByUseTax Test",
                           true, 
                           list.listByUseTax().contains("Jones, Jo: Car "
                           + "2017 Honda Accord (Alternative Fuel)"));
   }
}
