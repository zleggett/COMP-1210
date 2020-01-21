import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
*Tests for VehiclesPart2.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 26 November 2017
*/
public class VehiclesPart2Test {


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
   *Tests VehiclePart2.
   *@throws FileNotFoundException if the file cannot be opened.
   */
   @Test public void vehicles2Test() throws FileNotFoundException
   {
      VehiclesPart2 vPart2Obj = new VehiclesPart2(); // test constructor
      Vehicle.resetVehicleCount();
      String[] args = {"vehicles1.txt"};
      VehiclesPart2.main(args);
      Assert.assertEquals(8, Vehicle.getVehicleCount());
   }
}
