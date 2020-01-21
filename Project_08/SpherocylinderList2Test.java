import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
*Tests for spherocylinderList2.
*
*@author Zachary Leggett
*@version 2 November 2017
*/
public class SpherocylinderList2Test {


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
   *Test for getName.
   */
   @Test public void getName()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 1, 2);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 1, 2);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      
      Assert.assertEquals("getName Test",
                           "test list", sList.getName());
   }
   
   /**
   *Test for numberOfSpherocylinders.
   */
   @Test public void numberOfSpherocylinders()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 1, 2);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 1, 2);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      
      Assert.assertEquals("numberOfSpherocylinders Test",
                           3, sList.numberOfSpherocylinders(), .0001);
   }
   
   /**
   *Test for totalSurfaceArea.
   */
   @Test public void totalSurfaceArea()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 1, 2);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 1, 2);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      
      Assert.assertEquals("totalSurfaceArea Test",
                           75.3982, sList.totalSurfaceArea(), .0001);
   }
   
   /**
   *Test for averageSurfaceArea.
   */
   @Test public void averageSurfaceArea()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 1, 2);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 1, 2);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      Assert.assertEquals("averageSurfaceArea Test",
                           25.1327, sList.averageSurfaceArea(), .0001);
                           
      SpherocylinderList2 sList2 = new 
         SpherocylinderList2("test list", null, 0);
      Assert.assertEquals("averageSurfaceArea Test2",
                           0, sList2.averageSurfaceArea(), .0001);
   }
   
   /**
   *Test for totalVolume.
   */
   @Test public void totalVolume()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 1, 2);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 1, 2);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      
      Assert.assertEquals("totalVolume Test",
                           31.4159, sList.totalVolume(), .0001);
   }
   
   /**
   *Test for averageVolume.
   */
   @Test public void averageVolume()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 1, 2);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 1, 2);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      Assert.assertEquals("averageVolume Test",
                           10.4719, sList.averageVolume(), .0001);
                           
      SpherocylinderList2 sList2 = new 
         SpherocylinderList2("test list", null, 0);
      Assert.assertEquals("averageVolume Test2",
                           0, sList2.averageVolume(), .0001);
   }
   
   /**
   *Test for toString.
   */
   @Test public void toStringTest()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 1, 2);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 1, 2);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
   
      Assert.assertEquals("toString test", 
                           true, 
                           sList.toString().contains("Spherocylinder \"test\""
                              + " with radius 1.0"));
   }
   
   /**
   *Test for summaryInfo.
   */
   @Test public void summaryInfo()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 1, 2);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 1, 2);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
   
      Assert.assertEquals("summaryInfo test", 
                           true, 
                           sList.summaryInfo().contains("----- Summary" 
                              + " for test list -----"));
   }
   
   /**
   *Test for getList.
   */
   @Test public void getList()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 1, 2);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 1, 2);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      
      Assert.assertArrayEquals("getList Test",
                           s, sList.getList());
   }
   
   /**
   *Test for readFile.
   *@throws FileNotFoundException if the file cannot be opened.
   */
   @Test public void readFileTest() throws FileNotFoundException
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("Small Example", 0.5, 0.25);
      s[1] = new Spherocylinder("Medium Example", 10.8, 10.1);
      s[2] = new Spherocylinder("Large Example", 98.32, 99.0);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", null, 0);
      sList = sList.readFile("spherocylinder_data_1.txt");
      
      Assert.assertEquals("readFile Test",
                           "Spherocylinder Test List", 
                           sList.getName());
   }
   
   /**
   *Test for addSpherocylinder.
   */
   @Test public void addSpherocylinder()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 8, 3);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 7, 4);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      
      Spherocylinder s2 = new Spherocylinder("test4", 1, 2);
      sList.addSpherocylinder("test4", 1, 2);
      Spherocylinder[] sA = sList.getList();
      
      Assert.assertEquals("addSpherocylinder Test",
                           s2, sA[3]);
   }
   
   /**
   *Test for deleteSpherocylinder.
   */
   @Test public void deleteSpherocylinder()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 8, 3);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 7, 4);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      
      Spherocylinder s2 = new Spherocylinder("test4", 1, 2);
      Spherocylinder s3 = new Spherocylinder("test", 8, 3);
      sList.addSpherocylinder("test4", 1, 2);
      Spherocylinder[] sA = sList.getList();
      
      Assert.assertEquals("pre deleteSpherocylinder Test",
                           s2, sA[3]);         
   
      Assert.assertEquals("deleteSpherocylinder true Test",
                           s3, sList.deleteSpherocylinder("test"));
   
      Assert.assertEquals("deleteSpherocylinder true Test",
                           s2, sA[2]);
   
      Assert.assertEquals("deleteSpherocylinder false Test",
                           null, sList.deleteSpherocylinder("false"));
   }
   
   /**
   *Test for findSpherocylinder.
   */
   @Test public void findSpherocylinder()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 8, 3);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 7, 4);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      Spherocylinder s2 = new Spherocylinder("test", 8, 3);
      
      Assert.assertEquals("findSpherocylinder true Test",
                           s2, sList.findSpherocylinder("test"));
                           
      Assert.assertEquals("findSpherocylinder false Test",
                           null, sList.findSpherocylinder("false"));
   
   }
   
   /**
   *Test for editSpherocylinder.
   */
   @Test public void editSpherocylinder()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 8, 3);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 7, 4);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      Spherocylinder s2 = new Spherocylinder("test", 8, 3);
      Spherocylinder s3 = new Spherocylinder("test", 9, 7);
      Spherocylinder[] sA = sList.getList();
      
      Assert.assertEquals("pre editSpherocylinder Test",
                           s2, sA[0]);
      Assert.assertEquals("editSpherocylinder true Test",
                           true, sList.editSpherocylinder("test", 9, 7));
      Assert.assertEquals("editSpherocylinder true Test",
                           s3, sA[0]);
      Assert.assertEquals("findSpherocylinder false Test",
                           false, sList.editSpherocylinder("false", 9, 7));
   }
   
   /**
   *Test for findSpherocylinderWithLongestRadius.
   */
   @Test public void findSpherocylinderWithLongestRadius()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 7, 4);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 8, 3);
      
      Spherocylinder s2 = new Spherocylinder("test", 7, 4);
      Spherocylinder s3 = new Spherocylinder("test2", 1, 2);
      Spherocylinder s4 = new Spherocylinder("test3", 8, 3);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      Assert.assertEquals("findSpherocylinderWithLongestRadius true Test",
                           s4, 
                           sList.findSpherocylinderWithLongestRadius());
                           
      SpherocylinderList2 sList2 = new 
         SpherocylinderList2("test list", null, 0);
      Assert.assertEquals("findSpherocylinderWithLongestRadius false Test",
                           null, 
                           sList2.findSpherocylinderWithLongestRadius());
   }
   
   /**
   *Test for findSpherocylinderWithShortestRadius.
   */
   @Test public void findSpherocylinderWithShortestRadius()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 8, 3);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 7, 4);
      
      Spherocylinder s2 = new Spherocylinder("test", 8, 3);
      Spherocylinder s3 = new Spherocylinder("test2", 1, 2);
      Spherocylinder s4 = new Spherocylinder("test3", 7, 4);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      Assert.assertEquals("findSpherocylinderWithShortestRadiusTrueTest",
                           s3, 
                           sList.findSpherocylinderWithShortestRadius());
                           
      SpherocylinderList2 sList2 = new 
         SpherocylinderList2("test list", null, 0);
      Assert.assertEquals("findSpherocylinderWithShortestRadiusFalseTest",
                           null, 
                           sList2.findSpherocylinderWithShortestRadius());
   }
   
   /**
   *Test for findSpherocylinderWithSmallestVolume.
   */
   @Test public void findSpherocylinderWithSmallestVolume()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 8, 3);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 7, 4);
      
      Spherocylinder s2 = new Spherocylinder("test", 8, 3);
      Spherocylinder s3 = new Spherocylinder("test2", 1, 2);
      Spherocylinder s4 = new Spherocylinder("test3", 7, 4);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      Assert.assertEquals("findSpherocylinderWithSmallestVolumeTrueTest",
                           s3, 
                           sList.findSpherocylinderWithSmallestVolume());
                           
      SpherocylinderList2 sList2 = new 
         SpherocylinderList2("test list", null, 0);
      Assert.assertEquals("findSpherocylinderWithSmallestVolumeFalseTest",
                           null, 
                           sList2.findSpherocylinderWithSmallestVolume());
   }
   
   /**
   *Test for findSpherocylinderWithLargestVolume.
   */
   @Test public void findSpherocylinderWithLargestVolume()
   {
      Spherocylinder[] s = new Spherocylinder[20];
      s[0] = new Spherocylinder("test", 7, 4);
      s[1] = new Spherocylinder("test2", 1, 2);
      s[2] = new Spherocylinder("test3", 8, 3);
      
      Spherocylinder s2 = new Spherocylinder("test", 7, 4);
      Spherocylinder s3 = new Spherocylinder("test2", 1, 2);
      Spherocylinder s4 = new Spherocylinder("test3", 8, 3);
      
      SpherocylinderList2 sList = new SpherocylinderList2("test list", s, 3);
      Assert.assertEquals("findSpherocylinderWithLargestVolumeTrueTest",
                           s4, 
                           sList.findSpherocylinderWithLargestVolume());
                           
      SpherocylinderList2 sList2 = new 
         SpherocylinderList2("test list", null, 0);
      Assert.assertEquals("findSpherocylinderWithLargestVolumeFalseTest",
                           null, 
                           sList2.findSpherocylinderWithLargestVolume());
   }
}
