import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Tests for VehiclePart1.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 14 November 2017
*/
public class VehiclesPart1Test {


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
   *Tests VehiclePart1.
   */
   @Test public void vehiclesPart1Test()
   {
      VehiclesPart1 vp1 = new VehiclesPart1();
      Vehicle.resetVehicleCount();
      VehiclesPart1.main(null);
      Assert.assertEquals("Vehicle.vehicleCount Test",
         7, Vehicle.getVehicleCount(), 0.0001);
   }
}
