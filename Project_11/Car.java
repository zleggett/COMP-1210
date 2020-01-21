/**
*Program extends Vehicle to cars.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 14 November 2017
*/
public class Car extends Vehicle
{
   /**
   *Tax rate of car.
   */
   public static final double TAX_RATE = 0.01;
   /**
   *Alternative fuel tax rate.
   */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.005;
   /**
   *Luxury car threshold.
   */
   public static final double LUXURY_THRESHOLD = 50_000;
   /**
   *Luxury car tax rate.
   */
   public static final double LUXURY_TAX_RATE = 0.02;
   
   /**
   *Sets initial values owner, yearMakeModel, value, and alternativeFuel.
   *@param ownerIn Owner of car.
   *@param yearMakeModelIn Year, make, and model of car.
   *@param valueIn Value of car.
   *@param alternativeFuelIn Indicates if car uses alternative fuel.
   *@throws NegativeValueException if negative value is entered.
   */
   public Car(String ownerIn, String yearMakeModelIn, double valueIn, 
      boolean alternativeFuelIn) throws NegativeValueException
   {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn);
   }
   
   /**
   *Calculates use tax of car.
   *@return tax Use tax of car.
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
   
      if (value > LUXURY_THRESHOLD) {
         tax += value * LUXURY_TAX_RATE;
      }
      
      return tax;
   }
   
   /**
   *Outputs car info.
   *@return output Car info. 
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
   
      if (value > LUXURY_THRESHOLD) {
         output += " Luxury Tax Rate: " + LUXURY_TAX_RATE; 
      }
      
      return output;
   }
}