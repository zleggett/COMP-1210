/**
*Program extends Vehicle to trucks.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 14 November 2017
*/
public class Truck extends Vehicle
{
   protected double tons;
   
   /**
   *Tax rate for truck.
   */
   public static final double TAX_RATE = 0.02;
   /**
   *Alternative tax rate for truck.
   */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.01;
   /**
   *Threshold for large truck.
   */
   public static final double LARGE_TRUCK_TONS_THRESHOLD = 2.0;
   /**
   *Large reuck tax rate.
   */
   public static final double LARGE_TRUCK_TAX_RATE = 0.03;
   
   /**
   *Sets initial values owner, yearMakeModel, value, alternativeFuel, and tons.
   *@param ownerIn Owner of truck.
   *@param yearMakeModelIn Year, make, and model of truck.
   *@param valueIn Value of truck.
   *@param alternativeFuelIn Indicates if truck uses alternative fuel.
   *@param tonsIn Weight of truck in tons.
   *@throws NegativeValueException if negative value is entered.
   */
   public Truck(String ownerIn, String yearMakeModelIn, double valueIn, 
      boolean alternativeFuelIn, double tonsIn) 
      throws NegativeValueException
   {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn);
      if (tonsIn < 0)
      {
         throw new NegativeValueException();
      }
      tons = tonsIn;
   }
   
   /**
   *Gets tons.
   *@return tons Weight of truck.
   */
   public double getTons()
   {
      return tons;
   }
   
   /**
   *Sets tons.
   *@param tonsIn User inputted tons.
   */
   public void setTons(double tonsIn)
   {
      tons = tonsIn;
   }
   
   /**
   *Calculates use tax for truck.
   *@return tax Use tax for truck.
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
   
      if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
         tax += value * LARGE_TRUCK_TAX_RATE;
      }
      
      return tax;
   }
   
   /**
   *Outputs truck info.
   *@return output Truck info.
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
   
      if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
         output += " Large Truck Tax Rate: " + LARGE_TRUCK_TAX_RATE; 
      }
      
      return output;
   }
}