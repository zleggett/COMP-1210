import java.util.Scanner;
import java.io.FileNotFoundException;

/**
*Generates a menu that allows a user to read in a spherocylinder file,
*prints spherocylinder list, print summary info, add spherocylinders,
*delete spherocylinders, find spherocylinders, and/or edit spherocylinders.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 18 October 2017
*/
public class SpherocylinderList2MenuApp
{
/**
*Generates menu for user to view and manipulate list of spherocylinders 
*from a file.
*@param args Command line arguments - not us
*@throws FileNotFoundException Ensures that a valid file is inputted.
*/
   public static void main(String[] args) throws FileNotFoundException
   {
      String sListName = "*** no list name assigned ***";
      Spherocylinder[] myList = new Spherocylinder[20];
      SpherocylinderList2 mySList = 
         new SpherocylinderList2(sListName, myList, 0);
      String fileName = "no file name";
      
      String label = "";
      double radius = 0;
      double cylinderHeight = 0;
      
      String code = "";
   
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Spherocylinder List System Menu\n"
                       + "R - Read File and Create Spherocylinder List\n"
                       + "P - Print Spherocylinder List\n" 
                       + "S - Print Summary\n"
                       + "A - Add Spherocylinder\n"   
                       + "D - Delete Spherocylinder\n"   
                       + "F - Find Spherocylinder\n"
                       + "E - Edit Spherocylinder\n"
                       + "Q - Quit");
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = scan.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch(codeChar) {
            case 'R': // Read in File and Create Spherocylinder List
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
            
               mySList = mySList.readFile(fileName);
            
               System.out.println("\tFile read in and "
                              + "Spherocylinder List created\n");
               break;
            
            case 'P': // Print Spherocylinder List
               System.out.println("\n" + mySList);
               break;
               
            case 'S': // Prints Summary
               System.out.println("\n" + mySList.summaryInfo() + "\n");
               break;
               
            case 'A': //Adds Spherocylinder
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tRadius: ");
               radius = Double.parseDouble(scan.nextLine());
               System.out.print("\tCylinder Height: ");
               cylinderHeight = Double.parseDouble(scan.nextLine());
            
               mySList.addSpherocylinder(label, radius, cylinderHeight);
               System.out.println("\t*** Spherocylinder added ***\n");
               break;
               
            case 'D': // Deletes Spherocylinder
               System.out.print("\tLabel: ");
               label = scan.nextLine();
                  
               if (mySList.deleteSpherocylinder(label) != null) {
                  System.out.println("\t\"" + label + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'F': // Find Spherocylinder
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               Spherocylinder f = mySList.findSpherocylinder(label); 
               if (f != null) {
                  System.out.println(f.toString() + "\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'E': // Edit Spherocylinder
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tRadius: ");
               radius = Double.parseDouble(scan.nextLine());
               System.out.print("\tCylinder Height: ");
               cylinderHeight = Double.parseDouble(scan.nextLine());
                  
               if (mySList.editSpherocylinder(label, radius, cylinderHeight)) {
                  System.out.println("\t\"" + label 
                     + "\" successfully edited\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n"); 
               }
               break;
               
            case 'Q': // Quits menu
               break;
               
            default: // Invalid code entered
               System.out.println("\t*** invalid code ***\n");
         }
               
      } while (!code.equalsIgnoreCase("Q"));
   }
}