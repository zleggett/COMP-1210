import java.util.Scanner;
/**
*Program that calculates the area of a pyramid given the base and slant height.
*
*Project 2
*@author Zachary Leggett - Computing 1210 - 007
*@version 2 September 2017
*/
public class AreaOfPyramid
{
   /**
   *Prints area of a pyramid from user input.
   *@param args Command line arguments - not used.
   */
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      double base = 0;
      double slantHeight = 0;
      double area = 0;
      System.out.println("Enter values for base and slant" 
         + "height of a pyramid:");
      System.out.print("\tbase = ");
      base = userInput.nextDouble(); 
      //new base value assigned
      System.out.print("\tslant height = ");
      slantHeight = userInput.nextDouble(); 
      //new slantHeight value assigned
      System.out.println();
      area = base * base + 4 * ((base * slantHeight) / 2); 
      //new area value assigned
      System.out.println("A pyramid with base = " + base + " and slant height "
         + "= " + slantHeight + "\nhas an area of " + area + " square units.");
   }
}