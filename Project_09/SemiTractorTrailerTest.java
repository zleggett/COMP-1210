import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*Tests for SemiTractorTrailer class.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 14 November 2017
*/
public class SemiTractorTrailerTest {


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
   @Test public void getAxlesTest()
   {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat", 
         "2012 International Big Boy", 45000, false, 5.0, 4);
   
      Assert.assertEquals("getAxles() Test",
                           4, semi1.getAxles(), 0.0001);
                           
      semi1.setAxles(6);
      Assert.assertEquals("getAxles() Test2",
                           6, semi1.getAxles(), 0.0001);
   }
   
   /**
   *Tests useTax.
   */
   @Test public void useTaxTest()
   {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat", 
         "2012 International Big Boy", 45000, false, 5.0, 4);
      Assert.assertEquals("useTax() Test",
                           3150, semi1.useTax(), 0.0001);
   }
   
   /**
   *Tests toString.
   */
   @Test public void toStringTest()
   {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat", 
         "2012 International Big Boy", 45000, false, 5.0, 4);
      Assert.assertEquals("semi toString() Test",
                           true, 
                           semi1.toString().contains("with Tax Rate: 0.02 "
                           + "Large Truck Tax Rate: 0.03 Axle Tax Rate: 0.02"));
   }
}
