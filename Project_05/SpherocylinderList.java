import java.util.ArrayList;
import java.text.DecimalFormat;

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
}
