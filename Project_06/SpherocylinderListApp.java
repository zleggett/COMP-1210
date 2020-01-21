import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
*Program that reads a user inputted file and displays the file name,
*list name, details of each spherocylinder, and a summary.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 8 October 2017
*/
public class SpherocylinderListApp
{
   /**
   *Prints file name, list name, details of each spherocylinder, and summary.
   *@param args Command line arguments - not used.
   *@throws FileNotFoundException Ensures that a valid file is inputted.
   */
   public static void main(String[] args) throws FileNotFoundException
   {
      ArrayList<Spherocylinder> myList = new ArrayList<Spherocylinder>();
    
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      
      Scanner scanFile = new Scanner(new File(fileName));
   
      String spherocylinderListName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         String labelIn = scanFile.nextLine();
         double radiusIn = Double.parseDouble(scanFile.nextLine());
         double cylinderHeightIn = Double.parseDouble(scanFile.nextLine());
         
         Spherocylinder s = new Spherocylinder(labelIn, radiusIn, 
            cylinderHeightIn);
         myList.add(s);          
      }
      scanFile.close();
      
      SpherocylinderList mySpherocylinderList = 
         new SpherocylinderList(spherocylinderListName, myList);
      System.out.println();
      System.out.println(mySpherocylinderList);
      System.out.println();
      System.out.println(mySpherocylinderList.summaryInfo());
   }
}