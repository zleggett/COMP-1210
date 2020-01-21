import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Tests for VehiclePart3.
*/
public class VehiclesPart3Test {


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
   *Tests valid file name.
   */
   @Test public void vehiclePart3Test1()
   {
      VehiclesPart3 vPart3Obj = new VehiclesPart3(); // test constructor
      Vehicle.resetVehicleCount();
      String[] args = {"vehicles2.txt"};
      VehiclesPart3.main(args);
      Assert.assertEquals(12, Vehicle.getVehicleCount());
   }
   
   /**
   *Tests invalid file name.
   */
   @Test public void vehiclePart3Test2()
   {
      VehiclesPart3 vPart3Obj2 = new VehiclesPart3(); // test constructor
      Vehicle.resetVehicleCount();
      String[] args = {"vehicles7.txt"};
      VehiclesPart3.main(args);
      Assert.assertEquals(0, Vehicle.getVehicleCount());
   }
   
   /**
   *Tests no file name.
   */
   @Test public void vehiclePart3Test3()
   {
      VehiclesPart3 vPart3Obj3 = new VehiclesPart3(); // test constructor
      Vehicle.resetVehicleCount();
      String[] args = new String[0];
      VehiclesPart3.main(args);
      Assert.assertEquals(0, Vehicle.getVehicleCount());
   }
}
