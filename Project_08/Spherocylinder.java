import java.text.DecimalFormat;
/**Program that uses the radius and cylinder height of a spherocylinder and
*calculates the circumference, area, and vloume. Results are formatted 
*and displayed.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 31 October 2017
*/
public class Spherocylinder
{

// instance variables

   private String label = "";
   private double radius = 0;
   private double cylinderHeight = 0;
   private static int count = 0;
   
// constructor

/**
*Establishes Spherocylinder class and sets the label, radius, and 
*cylinder height to the correct variables.
*@param labelIn Represents label inputted by user.
*@param radiusIn Represents radius inputted by user.
*@param cylinderHeightIn Represents cylinder height from user.
*/
   public Spherocylinder(String labelIn, double radiusIn, 
      double cylinderHeightIn)
   {
      setLabel(labelIn);
      setRadius(radiusIn);
      setCylinderHeight(cylinderHeightIn);
      count++;
   }
   
//methods

/**
*Establishes the getLabel method.
*@return label Returns the correct value for label.
*/
   public String getLabel()
   {
      return label;
   }
   
/**
*Determines if a valid string is inputted for label.
*@param labelIn Represents label inputted by user.
*@return isSet Returns true or false to indicate if label is set.
*/
   public boolean setLabel(String labelIn)
   {
      boolean isSet = false;
      if (labelIn != null) {
         label = labelIn.trim();
         isSet = true;
      }
      return isSet;
   }
   
/**
*Establishes getRadius method.
*@return radius Returns the correct value for radius.
*/ 
   public double getRadius()
   {
      return radius;
   }

/**
*Determines if radius is a positive number.
*@param radiusIn Radius as inputted by user.
*@return isSet Returns true or false to set radius value.
*/ 
   public boolean setRadius(double radiusIn)
   {
      boolean isSet = false;
      if (radiusIn >= 0) {
         radius = radiusIn;
         isSet = true;
      }
      return isSet;
   }

/**
*Establishes getCylinderHeight method.
*@return cylinderHeight Returns the correct value for cylinder height.
*/
   public double getCylinderHeight()
   {
      return cylinderHeight;
   }

/**
*Determines if cylinder height is a positive number.
*@param cylinderHeightIn Represents cylinder height inputted by user.
*@return isSet Returns true or false to set cylinder height value.
*/
   public boolean setCylinderHeight(double cylinderHeightIn)
   {
      boolean isSet = false;
      if (cylinderHeightIn >= 0) {
         cylinderHeight = cylinderHeightIn;
         isSet = true;
      }
      return isSet;
   }

/**
*Calculates the circumference.
*@return circumference Returns the calculated value for the circumference.
*/
   public double circumference()
   {
      double circumference = 2 * Math.PI * radius;
      return circumference;
   }

/**
*Calculates the surface area.
*@return surfaceArea Returns the calculated surface area.
*/
   public double surfaceArea()
   {
      double surfaceArea = (2 * Math.PI * radius)  
         * ((2 * radius) + cylinderHeight);
      return surfaceArea;
   }
   
/**
*Calculates the volume.
*@return volume Returns the calculated volume.
*/
   public double volume()
   {
      double volume = Math.PI * (Math.pow(radius, 2));
      volume = volume * ((((double) 4 / 3) * radius) + cylinderHeight);
      return volume;
   }

/**
*Converts varibles to strings and formats results to be displayed.
*@return output Returns formatted output to be displayed.
*/
   public String toString()
   {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      String output = "Spherocylinder \"" + label + "\" with radius " + radius 
         + " and cylinder height " + cylinderHeight + " has:\n";
      output += "\tcircumference = " + fmt.format(circumference()) + " units\n";
      output += "\tsurface area = " + fmt.format(surfaceArea()) 
         + " square units\n";
      output += "\tvolume = " + fmt.format(volume()) + " cubic units";
      return output;
   }
   
   //new methods
   
   /**
   *Gets the count of spherocylinder objects.
   *@return count Returns the count.
   */
   public static int getCount()
   {
      return count;
   }
   
   /**
   *Resets the count.
   */
   public static void resetCount()
   {
      count = 0;
   }
   
   /**
   *Determines if two spherocylinders are equal.
   *@param obj Object spherocylinder is compared to.
   *@return Indicates if spherocylinders are equal.
   */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Spherocylinder)) {
         return false;
      }
      else {
         Spherocylinder d = (Spherocylinder) obj;
         return (label.equalsIgnoreCase(d.getLabel())
                  && Math.abs(radius - d.getRadius()) < 0.000001
                  && Math.abs(cylinderHeight - d.getCylinderHeight())
                     < .000001);
      }
   }
   
   /**
   *@return 0 for no hash code.
   */
   public int hashCode() {
      return 0;
   }
}