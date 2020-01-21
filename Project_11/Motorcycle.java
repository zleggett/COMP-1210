/**
*Program extends vehicle to motorcycles.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 14 November 2017
*/
public class Motorcycle extends Vehicle
{
   protected double engineSize;
   /**
   *Tax rate for bikes.
   */
   public static final double TAX_RATE = 0.005;
   /**
   *Alternative tax rate for bikes.
   */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.0025;
   /**
   *Large bike treshold.
   */
   public static final double LARGE_BIKE_CC_THRESHOLD = 499;
   /**
   *Large bike tax rate.
   */
   public static final double LARGE_BIKE_TAX_RATE = 0.015;
   
   /**
   *Sets initial values owner, yearMakeModel, value, alternativeFuel, 
   *and engineSize.
   *@param ownerIn Owner of bike.
   *@param yearMakeModelIn Year, make, and model of bike.
   *@param valueIn Value of bike.
   *@param alternativeFuelIn Indicates if bike uses alternative fuel.
   *@param engineSizeIn Size of engine in bike.
   *@throws NegativeValueException if negative value is entered.
   */
   public Motorcycle(String ownerIn, String yearMakeModelIn, double valueIn, 
      boolean alternativeFuelIn, double engineSizeIn) 
      throws NegativeValueException
   {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn);
      if (engineSizeIn < 0)
      {
         throw new NegativeValueException();
      }
      engineSize = engineSizeIn;
   }
   
   /**
   *Gets engineSize.
   *@return engineSize Engine size of bike.
   */
   public double getEngineSize()
   {
      return engineSize;
   }
   
   /**
   *Sets engineSize.
   *@param engineSizeIn User inputted engine size.
   */
   public void setEngineSize(double engineSizeIn)
   {
      engineSize = engineSizeIn;
   }
   
   /**
   *Calculates use tax for bikes.
   *@return tax Use tax for bike.
   */
   public double useTax()
   {
      double tax = 0;
      if (alternativeFuel) {
         tax = value * ALTERNATIVE_FUEL_TAX_RATE; 
      }
      else {
         tax = value *  TAX_RATE;
      }
   
      if (engineSize > LARGE_BIKE_CC_THRESHOLD) {
         tax += value * LARGE_BIKE_TAX_RATE;
      }
      
      return tax;
   }
   
   /**
   *Outputs bike info.
   *@return output Bike info.
   */
   public String toString()
   {
      String output = super.toString() + "\nwith Tax Rate: ";
      if (alternativeFuel) {
         output += ALTERNATIVE_FUEL_TAX_RATE;
      }
      else {
         output += TAX_RATE;
      }
   
      if (engineSize > LARGE_BIKE_CC_THRESHOLD) {
         output += " Large Bike Tax Rate: " + LARGE_BIKE_TAX_RATE; 
      }
      
      return output;
   }
}