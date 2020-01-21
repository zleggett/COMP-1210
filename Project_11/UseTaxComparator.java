import java.util.Comparator;
    /**
 *Compares vehicles based on use tax.
 *
 *@author Zachary Leggett - COMP 1210 - 007
 *@version 26 November 2017
 */ 
public class UseTaxComparator implements Comparator<Vehicle>
{
   /**
   *Compares vehicles based on use tax.
   *@param v1 Vehicle to be compared.
   *@param v2 Vehicle v1 is compared to.
   *@return Int indicating if v1 is greater than,
   *equal to, or less than v2.
   */
   public int compare(Vehicle v1, Vehicle v2) {
      if (v1.useTax() > v2.useTax()) {
         return 1;
      }
      else if (v1.useTax() < v2.useTax()) {
         return -1;
      }
      return 0;
   }

}