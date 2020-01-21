import java.util.Scanner;
/**
*Program that requests user input for label, radius,
*and cylinder height for a spherocylinder. These variables
*are then plugged in to the Spherocylinder class to generate 
*the cirmference, surface area, and volume.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 25 September 2017
*/
public class SpherocylinderApp
{
/**
*Request user input for label, radius, and cylinder height.
*@param args Command line arguments - not used.
*/
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      String label = "";
      double radius = 0;
      double cylinderHeight = 0;
      
      Spherocylinder user1 = new Spherocylinder(label, radius, cylinderHeight);
   
      System.out.print("Enter label, radius, and cylinder height" 
         + " for a spherocylinder.");
      System.out.print("\n\tlabel: ");
      label = userInput.nextLine();
      user1.setLabel(label);
      
      System.out.print("\tradius: ");
      radius = userInput.nextDouble();
      if (radius >= 0) {
         user1.setRadius(radius);
      }
      else {
         System.out.println("Error: radius must be non-negative.");
         return;
      }
      
      System.out.print("\tcylinder height: ");
      cylinderHeight = userInput.nextDouble();
      if (cylinderHeight >= 0) {
         user1.setCylinderHeight(cylinderHeight);
      }
      else {
         System.out.print("Error: cylinder height must be non-negative.");
         return;
      } 
      
      System.out.println("\n" + user1);  
   }
}