import java.text.DecimalFormat;
/**
*Program establishes with the owner, yearMakeModel, value, 
*and whether or not it uses alternative fuel.
*Also calculates the use tax of the vehicle.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 14 November 2017
*/
public abstract class Vehicle implements Comparable<Vehicle>
{
   protected String owner;
   protected String yearMakeModel;
   protected double value;
   protected boolean alternativeFuel;

   private static int vehicleCount = 0;
   
   /**
   *Sets initial values owner, yearMakeModel, value, and alternativeFuel.
   *@param ownerIn Owner of vehicle.
   *@param yearMakeModelIn Year, make, and model of vehicle.
   *@param valueIn Value of vehicle.
   *@param alternativeFuelIn Indicates if vehicle uses alternative fuel.
   */
   public Vehicle(String ownerIn, String yearMakeModelIn, 
      double valueIn, boolean alternativeFuelIn)
   {
      owner = ownerIn;
      yearMakeModel = yearMakeModelIn;
      value = valueIn;
      alternativeFuel = alternativeFuelIn;
      vehicleCount++;
   }
   
   /**
   *Gets owner.
   *@return owner Owner of vehicle.
   */
   public String getOwner()
   {
      return owner;
   }
   
   /**
   *Sets owner.
   *@param ownerIn User inputted owner.
   */
   public void setOwner(String ownerIn)
   {
      owner = ownerIn;
   }
   
   /**
   *Gets yearMakeModel.
   *@return yearMakeModel Year, make, and model of vehicle.
   */
   public String getYearMakeModel()
   {
      return yearMakeModel;
   }
   
   /**
   *Sets yearMakeModel.
   *@param yearMakeModelIn User inputted yearMakeModel.
   */
   public void setYearMakeModel(String yearMakeModelIn)
   {
      yearMakeModel = yearMakeModelIn;
   }
   
   /**
   *Gets value.
   *@return value Value of vehicle.
   */
   public double getValue()
   {
      return value;
   }
   
   /**
   *Sets value.
   *@param valueIn User inputted value.
   */
   public void setValue(double valueIn)
   {
      value = valueIn;
   }
   
   /**
   *Gets alternativeFuel.
   *@return alternativeFuel Indicates if vehicle uses alternative fuel.
   */
   public boolean getAlternativeFuel()
   {
      return alternativeFuel;
   }
   
   /**
   *Sets alternativeFuel.
   *@param alternativeFuelIn User inputted alternativeFuel.
   */
   public void setAlternativeFuel(boolean alternativeFuelIn)
   {
      alternativeFuel = alternativeFuelIn;
   }
   
   /**
   *Gets vehicle count.
   *@return vehicleCount Number of vehicles created.
   */
   public static int getVehicleCount()
   {
      return vehicleCount;
   }
   
   /**
   *Resets vehicle count.
   */
   public static void resetVehicleCount()
   {
      vehicleCount = 0;
   }
   
   /**
   *Calculates use tax of vehicle.
   *@return Reaturns use tax of vehicle.
   */
   public abstract double useTax();
   
   /**
   *Outputs vehicle info.
   *@return output Vehicle info.
   */
   public String toString()
   {
      DecimalFormat fmt = new DecimalFormat("$#,##0.00");
      String output = "";
      output = owner + ": " + this.getClass().getName() + " " + yearMakeModel;
      if (alternativeFuel)
      {
         output += " (Alternative Fuel)";
      }
      output += "\nValue: " + fmt.format(value) + " Use Tax: " 
         + fmt.format(useTax()); 
      return output;
   }
   
   /**
   *Compares vehicles based on owner.
   *@param other Vehicle to be compared to.
   *@return Int indicating whether other is equal to,
   *greater than, or less than.
   */
   public int compareTo(Vehicle other)
   {
      return owner.toLowerCase()  
                 .compareTo(other.getOwner().toLowerCase());
   }
}