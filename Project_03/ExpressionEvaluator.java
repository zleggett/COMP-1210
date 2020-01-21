import java.util.Scanner;
import java.text.DecimalFormat;
/**
*Program that runs user inputted number through a mathematical equation 
*and returns the result. The program also returns the number of digits 
*to the left and right of the decimal as well as the result formatted 
*to five decimal places.
*
*Project 3
*@author Zachary Leggett - COMP 1210 - 007
*@version 18 September 2017
*/
public class ExpressionEvaluator
{
   /**
   *Program that runs user data through equation and returns result as well as
   *number of decimal places and formatted reult.
   *@param args Command line arguments - not used.
   */
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      double x = 0;
      double result = 0;
      String result2 = "";
      
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
      
      result = (Math.abs(23.7 * Math.pow(x, 9)) - x);
      result = Math.sqrt(result);
      result = result / ((7.3 * Math.pow(x, 2)) + (5.2 * x) + 3.1);
      System.out.println("Result: " + result);
      
      result2 = Double.toString(result);
      System.out.println("# digits to left of decimal point: "
         + result2.indexOf('.'));
      
      System.out.println("# digits to right of decimal point: "
         + ((result2.length() - result2.indexOf('.')) - 1));
         
      DecimalFormat fmt = new DecimalFormat("#,##0.0####");
      System.out.print("Formatted Result: " + fmt.format(result));
   }
}