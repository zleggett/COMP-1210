/**
*Program extends Truck to semi tractor trailers.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 14 November 2017
*/
public class SemiTractorTrailer extends Truck
{
   protected int axles;
   /**
   *Tax rate per axles.
   */
   public static final double PER_AXLE_TAX_RATE = 0.005;
   
   /**
   *Sets initial values owner, yearMakeModel, value, alternativeFuel, 
   *tons, and axles.
   *@param ownerIn Owner of semi.
   *@param yearMakeModelIn Year, make, and model of semi.
   *@param valueIn Value of semi.
   *@param alternativeFuelIn Indicates if semi uses alternative fuel.
   *@param tonsIn Weight of semi in tons.
   *@param axlesIn Number of axles on semi.
   *@throws NegativeValueException if negative value is entered.
   */
   public SemiTractorTrailer(String ownerIn, String yearMakeModelIn, 
      double valueIn, boolean alternativeFuelIn, double tonsIn, int axlesIn) 
      throws NegativeValueException
   {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn, tonsIn);
      if (axlesIn < 0)
      {
         throw new NegativeValueException();
      }
      axles = axlesIn;
   }
   
   /**
   *Gets axles.
   *@return axles Number of axles on semi.
   */
   public int getAxles()
   {
      return axles;
   }
   
   /**
   *Sets axles.
   *@param axlesIn Number of axles inputted by users.
   */
   public void setAxles(int axlesIn)
   {
      axles = axlesIn;
   }
   
   /**
   *Calculates use tax for semis.
   *@return Use tax for semi.
   */
   public double useTax()
   {
      double tax = super.useTax();
      tax += value * PER_AXLE_TAX_RATE * axles;
      return tax;
   }
   
   /**
   *Outputs semi info.
   *@return output Semi info.
   */
   public String toString()
   {
      String output = super.toString();
      output += " Axle Tax Rate: " + (PER_AXLE_TAX_RATE * axles);
      return output;
   }
}