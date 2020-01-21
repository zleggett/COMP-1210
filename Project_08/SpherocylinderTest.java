import org.junit.Assert;
/*import static org.junit.Assert.*;*/
import org.junit.Before;
import org.junit.Test;

/**
*Program to test the methods of Spherocylinder.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 31 October 2017
*/
public class SpherocylinderTest {


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
   /** Tests the set methods. */
   @Test public void gettersTest()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Assert.assertEquals("getLabel test", 
                           "test", s.getLabel());
      Assert.assertEquals("getRadius test", 
                           1, s.getRadius(), .0001);
      Assert.assertEquals("getCylinderHeighgt test", 
                           2, s.getCylinderHeight(), .0001);
   }
   
   /** Tets set label true. */
   @Test public void setLabelTrue()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Assert.assertEquals("setLabelTrue test", 
                           true, s.setLabel("newTest"));
   
   }
   
   /** Tests set labe false. */
   @Test public void setLabelFalse()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Assert.assertEquals("setLabelFalse test", 
                           false, s.setLabel(null));  
   }
   
   /** Tests set radius true. */
   @Test public void setRadiusTrue()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Assert.assertEquals("setRadiusTrue test", 
                           true, s.setRadius(5));
   }
   
   /** Tests set radius false. */
   @Test public void setRadiusFalse()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Assert.assertEquals("setRadiusFalse test", 
                           false, s.setRadius(-1));
   }
   
   /** Tests set cylinder height true. */
   @Test public void setCylinderHeightTrue()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Assert.assertEquals("setCylinderHeightTrue test", 
                           true, s.setCylinderHeight(5));
   }
   
   /** Tests set cylinder height false. */
   @Test public void setCylinderHeightFalse()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Assert.assertEquals("setCylinderHeightFalse test", 
                           false, s.setCylinderHeight(-1));
   }
   
   /** Tests cicumference. */
   @Test public void circumference()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Assert.assertEquals("cicumference test", 
                           6.2831, s.circumference(), .0001);
   }
   
   /** Tests surface area. */
   @Test public void surfaceArea()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Assert.assertEquals("surfaceArea test", 
                           25.1327, s.surfaceArea(), .0001);
   }
   
   /** Tests volume. */
   @Test public void volume()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Assert.assertEquals("volume test", 
                           10.4719, s.volume(), .0001);
   }
   
   /** Tests toString. */
   @Test public void toStringTest()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Assert.assertEquals("toString test", 
                           true, 
                           s.toString().contains("Spherocylinder \"test\""
                              + " with radius 1.0"));
   }
   
   /** Tests equals. */
   @Test public void equals()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      Spherocylinder s2 = new Spherocylinder("test", 1, 2);
      
      Assert.assertEquals("equalst true test", 
                           true, s.equals(s2));
                           
      s2 = new Spherocylinder("test2", 1, 2);
      Assert.assertEquals("equals false test", 
                           false, s.equals(s2));
                           
      s2 = new Spherocylinder("test", 3, 2);
      Assert.assertEquals("equals false test", 
                           false, s.equals(s2));
                           
      s2 = new Spherocylinder("test", 1, 3);
      Assert.assertEquals("equals false test", 
                           false, s.equals(s2));
                           
      Assert.assertEquals("equals false test",
                        false, s.equals("obj"));
                        
      Assert.assertEquals("equals false test",
                        0, s.hashCode());
   
   }
   
   /** Tests count. */
   @Test public void count()
   {
      Spherocylinder s = new Spherocylinder("test", 1, 2);
      s.resetCount();
      Assert.assertEquals("getCount test", 
                           0, s.getCount(), .0001);
   }
}
