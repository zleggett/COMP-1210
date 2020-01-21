import java.text.DecimalFormat;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
*Program that calculates the name, total surface area, total volume,
*average surface area, average volume, and a summary of a list of 
*spherocylinders.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 31 October 2017
*/
public class SpherocylinderList2
{
//instance variables
   private String listName;
   private Spherocylinder[] sList;
   private int numberOfSpherocylinders;

//constructor

/**
*Intializes list name and sList values.
*@param listNameIn List name inputted from user.
*@param sListIn Array list inputted from user.
*@param numberOfSpherocylindersIn Number of spherocylinders in list.
*/
   public SpherocylinderList2(String listNameIn, 
      Spherocylinder[] sListIn, int numberOfSpherocylindersIn)
   {
      listName = listNameIn;
      sList = sListIn;
      numberOfSpherocylinders = numberOfSpherocylindersIn;
   }

//methods

/**
*Gets list name.
*@return listName Returns list name.
*/
   public String getName()
   {
      return listName;
   }

/**
*Determines number of spherocylinders in an array.
*@return sList.size() Returns size of array list.
*/
   public int numberOfSpherocylinders()
   {
      return numberOfSpherocylinders;
   }

/**
*Determines total surface area of spherocylinders.
*@return total Returns total surface area.
*/   
   public double totalSurfaceArea()
   {
      double total = 0;
      int index = 0;
   
      while (index < numberOfSpherocylinders) {
         total += sList[index].surfaceArea();
         index++;  
      }   
   
      return total;
   }

/**
*Determines total volume of spherocylinders.
*@return total Returns total volume.
*/
   public double totalVolume()
   {
      double total = 0;
      int index = 0;
   
      while (index < numberOfSpherocylinders) {
         total += sList[index].volume();
         index++;  
      }   
   
      return total;
   }

/**
*Determines the average surface area of spherocylinders.
*@return average Returns the average surface area.
*/
   public double averageSurfaceArea()
   {
      double average = 0;
      double total = 0;
      int index = 0;
   
      if (numberOfSpherocylinders == 0) {
         return 0;
      }
      
      while (index < numberOfSpherocylinders) {
         total += sList[index].surfaceArea();
         index++;  
      }   
   
      average = total / numberOfSpherocylinders;
      return average;
   }

/**
*Determines average volume of spherocylinders.
*@return average Returns average volume.
*/   
   public double averageVolume()
   {
      double average = 0;
      double total = 0;
      int index = 0;
      
      if (numberOfSpherocylinders == 0) {
         return 0;
      }
      
      while (index < numberOfSpherocylinders) {
         total += sList[index].volume();
         index++;  
      }   
   
      average = total / numberOfSpherocylinders;
      return average;
   }

/**
*Displays the list name and details of each spherocylinder.
*@return output Returns list name and details.
*/  
   public String toString()
   {
      String output = listName + "\n";
      int index = 0;
      while (index < numberOfSpherocylinders) {
         output += "\n" + sList[index] + "\n"; 
         index++;  
      }   
   
      return output;
   }

/**
*Displays list name and various methods.
*@return output Returns list name and methods.
*/
   public String summaryInfo()
   {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      String output = "";
      output += "----- Summary for " + getName() + " -----";
      output += "\nNumber of Spherocylinders: " + numberOfSpherocylinders();
      output += "\nTotal Surface Area: " + fmt.format(totalSurfaceArea());
      output += "\nTotal Volume: " + fmt.format(totalVolume());
      output += "\nAverage Surface Area: " + fmt.format(averageSurfaceArea());
      output += "\nAverage Volume: " + fmt.format(averageVolume());
      return output;
   }
   
//new methods
/**
*Prints spherocylinder list.
*@return sList Returns list.
*/
   public Spherocylinder[] getList()
   {
   
      return sList;
   }
 
 /**
 *Reads in file containing spherocylinders.
 *@return mySpherocylinderList Returns list from file.
 *@param fileNameIn Name of file.
 *@throws FileNotFoundException if the file cannot be opened.
 */  
   public SpherocylinderList2 readFile(String fileNameIn) 
                                 throws FileNotFoundException
   {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      Spherocylinder[] myList = new Spherocylinder[20];
      String spherocylinderListName = scanFile.nextLine();
      int numSpherocylinders = 0;
      
      while (scanFile.hasNext()) {
         String labelIn = scanFile.nextLine();
         double radiusIn = Double.parseDouble(scanFile.nextLine());
         double cylinderHeightIn = Double.parseDouble(scanFile.nextLine());
         
         Spherocylinder s = new Spherocylinder(labelIn, radiusIn, 
            cylinderHeightIn);
         myList[numSpherocylinders] = s;
         numSpherocylinders++;         
      }
      scanFile.close();
      
      SpherocylinderList2 sL = new SpherocylinderList2(
         spherocylinderListName, myList, numSpherocylinders);
      return sL;
   }
 
 /**
 *Adds a new spherocylinder to list.
 *@param labelIn Label for spherocylinder.
 *@param radiusIn Radius for spherocylinder.
 *@param cylinderHeightIn Cylinder height for spherocylinder.
 */ 
   public void addSpherocylinder(String labelIn, 
      double radiusIn, double cylinderHeightIn)
   {
      Spherocylinder s = new Spherocylinder(labelIn, 
         radiusIn, cylinderHeightIn);
   
      sList[numberOfSpherocylinders] = s;
      numberOfSpherocylinders++;
   }
 
 /**
 *Finds a spherocylinder based on label.
 *@param labelIn Label of spherocylinder.
 *@return Returns null if label is not valid.
 */
   public Spherocylinder findSpherocylinder(String labelIn)
   {
   
      for (int i = 0; i < numberOfSpherocylinders; i++) {
         String label = sList[i].getLabel();
         if (label.equalsIgnoreCase(labelIn)) {
         
            return sList[i];
         } 
      }
      return null;
   }
 
 /**
 *Deletes a spherocylinder.
 *@param labelIn Label of spherocylinder.
 *@return s Returns list.
 */  
   public Spherocylinder deleteSpherocylinder(String labelIn)
   {
      Spherocylinder s = findSpherocylinder(labelIn);
      for (int i = 0; i < numberOfSpherocylinders; i++) {
         if (sList[i].getLabel().equalsIgnoreCase(labelIn)) {
            for (int j = i; j < numberOfSpherocylinders - 1; j++) {
               sList[j] = sList[j + 1];
            }
            sList[numberOfSpherocylinders - 1] = null;
            numberOfSpherocylinders--;
            return s;
         }
      }
      return null;
   }
 
 /**
 *Edits an existing spherocylinder.
 *@param labelIn Label for spherocylinder.
 *@param radiusIn Radius for spherocylinder.
 *@param cylinderHeightIn Cylinder height for spherocylinder.
 *@return result Indicates whether label name is valid.
 */  
   public boolean editSpherocylinder(String labelIn, 
      double radiusIn, double cylinderHeightIn)
   {
      boolean result = false;
      int index = 0;
      Spherocylinder s = findSpherocylinder(labelIn);
      if (s != null) {
      
         for (int i = 0; i < numberOfSpherocylinders; i++) {
            if (sList[i].getLabel().equalsIgnoreCase(labelIn)) {
               index = i;
            }
         }
         
         s.setRadius(radiusIn);
         s.setCylinderHeight(cylinderHeightIn);
         sList[index] = s;
         result = true;
      }
      return result;  
   }
   
   //new methods project 8
   
   /**
   *Finds the spherocylinder with the shortest radius.
   *@return min Returns spherocylinder with shortest radius.
   */
   public Spherocylinder findSpherocylinderWithShortestRadius()
   {
      if (numberOfSpherocylinders > 0) {
         Spherocylinder min = sList[0];
         for (int i = 1; i < numberOfSpherocylinders; i++) {
            if (sList[i].getRadius() < min.getRadius()) {
            
               min = sList[i];
            } 
         }
         return min;
      }
      return null;
   }
   
   /**
   *Finds the spherocylinder with the longest radius.
   *@return min Returns spherocylinder with longest radius.
   */
   public Spherocylinder findSpherocylinderWithLongestRadius()
   {
      if (numberOfSpherocylinders > 0) {
         Spherocylinder max = sList[0];
         for (int i = 1; i < numberOfSpherocylinders; i++) {
            if (sList[i].getRadius() > max.getRadius()) {
            
               max = sList[i];
            } 
         }
         return max;
      }
      return null;
   }
   
   /**
   *Finds the spherocylinder with the smallest volume.
   *@return min Returns spherocylinder with smallest volume.
   */
   public Spherocylinder findSpherocylinderWithSmallestVolume()
   {
      if (numberOfSpherocylinders > 0) {
         Spherocylinder min = sList[0];
         for (int i = 1; i < numberOfSpherocylinders; i++) {
            if (sList[i].volume() < min.volume()) {
            
               min = sList[i];
            } 
         }
         return min;
      }
      return null;
   }
   
   /**
   *Finds the spherocylinder with the largest volume.
   *@return min Returns spherocylinder with largest volume.
   */
   public Spherocylinder findSpherocylinderWithLargestVolume()
   {
      if (numberOfSpherocylinders > 0) {
         Spherocylinder max = sList[0];
         for (int i = 1; i < numberOfSpherocylinders; i++) {
            if (sList[i].volume() > max.volume()) {
            
               max = sList[i];
            } 
         }
         return max;
      }
      return null;
   }
}
