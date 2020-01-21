import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
*Program that calculates the name, total surface area, total volume,
*average surface area, average volume, and a summary of a list of 
*spherocylinders.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 8 October 2017
*/
public class SpherocylinderList
{
//instance variables
   private String listName;
   private ArrayList<Spherocylinder> sList;

//constructor

/**
*Intializes list name and sList values.
*@param listNameIn List name inputted from user.
*@param sListIn Array list inputted from user.
*/
   public SpherocylinderList(String listNameIn, 
      ArrayList<Spherocylinder> sListIn)
   {
      listName = listNameIn;
      sList = sListIn;
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
*Determines number of spherocylinders in array list.
*@return sList.size() Returns size of array list.
*/
   public int numberOfSpherocylinders()
   {
      return sList.size();
   }

/**
*Determines total surface area of spherocylinders.
*@return total Returns total surface area.
*/   
   public double totalSurfaceArea()
   {
      double total = 0;
      int index = 0;
   
      while (index < sList.size()) {
         total += sList.get(index).surfaceArea();
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
   
      while (index < sList.size()) {
         total += sList.get(index).volume();
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
   
      if (sList.size() == 0) {
         return 0;
      }
      
      while (index < sList.size()) {
         total += sList.get(index).surfaceArea();
         index++;  
      }   
   
      average = total / sList.size();
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
      
      if (sList.size() == 0) {
         return 0;
      }
      
      while (index < sList.size()) {
         total += sList.get(index).volume();
         index++;  
      }   
   
      average = total / sList.size();
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
      while (index < sList.size()) {
         output += "\n" + sList.get(index) + "\n"; 
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
   public ArrayList<Spherocylinder> getList()
   {
   
      return sList;
   }
 
 /**
 *Reads in file containing spherocylinders.
 *@return mySpherocylinderList Returns list from file.
 *@param fileNameIn Name of file.
 *@throws FileNotFoundException if the file cannot be opened.
 */  
   public SpherocylinderList readFile(String fileNameIn) 
                                 throws FileNotFoundException
   {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      ArrayList<Spherocylinder> myList = new ArrayList<Spherocylinder>();
      String spherocylinderListName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         String labelIn = scanFile.nextLine();
         double radiusIn = Double.parseDouble(scanFile.nextLine());
         double cylinderHeightIn = Double.parseDouble(scanFile.nextLine());
         
         Spherocylinder s = new Spherocylinder(labelIn, radiusIn, 
            cylinderHeightIn);
         myList.add(s);          
      }
      scanFile.close();
      
      SpherocylinderList sL = new SpherocylinderList(
         spherocylinderListName, myList);
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
   
      sList.add(s);
   }
 
 /**
 *Finds a spherocylinder based on label.
 *@param labelIn Label of spherocylinder.
 *@return Returns null if label is not valid.
 */
   public Spherocylinder findSpherocylinder(String labelIn)
   {
      for (Spherocylinder s : sList) {
         String label = s.getLabel();
         if (s.getLabel().equalsIgnoreCase(labelIn)) {
         
            return s;
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
      if (s != null) {
         sList.remove(s);
      }
      return s;
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
         index = sList.indexOf(s);
         s.setRadius(radiusIn);
         s.setCylinderHeight(cylinderHeightIn);
         sList.set(index, s);
         result = true;
      }
      return result;  
   }
}
