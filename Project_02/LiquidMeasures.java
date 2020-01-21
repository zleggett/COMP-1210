import java.util.Scanner;
/**
*Program that calculates the number of barrels, gallons, quarts,
*and ounces from a user inputed amount of liquid in ounces.
*
*Project 2
*@author Zachary Leggett - Computing 1210 - 007
*@version 2 September 2017
*/
public class LiquidMeasures
{
   /**
   *Prints various canversions from liquid in ounces.
   *@param args Command line arguments - not used.
   */
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      int liquidOunces = 0;
      int barrels = 0;
      int gallons = 0;
      int quarts = 0;
      int ounces = 0;
      System.out.print("Enter amount of liquid in ounces: ");
      liquidOunces = userInput.nextInt();
      if (liquidOunces <= 1000000000)
      {
         System.out.println("Measures by volume:");
      }
      else
      {
         System.out.print("Amount must not exceed 1,000,000,000.");
         return;
      }
      barrels = liquidOunces / 5376;
      System.out.println("\tBarrels: " + barrels);
      gallons = (liquidOunces - (5376 * barrels)) / 128;
      System.out.println("\tGallons: " + gallons);
      quarts = (liquidOunces - (5376 * barrels) - (128 * gallons)) / 32;
      System.out.println("\tQuarts: " + quarts);
      ounces = liquidOunces - (5376 * barrels) - (128 * gallons) 
         - (quarts * 32);
      System.out.println("\tOunces: " + ounces);
      System.out.print(liquidOunces + " oz = (" + barrels + " bl * 5376 oz) + ("
         + gallons + " gal * 128 oz) + (" + quarts + " qt * 32 oz) + ("
         + ounces + " oz)");
   }
}