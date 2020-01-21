import java.io.FileNotFoundException;

/**
*Driver program for Vehicle and associated classes.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 4 December 2017
*/
public class VehiclesPart3
{
   /**
   *Prints vehicle info from a file.
   *@param args Command line arguments - not used.
   *@throws FileNotFoundException if the file cannot be opened.
   */
   public static void main(String[] args)
   {
      if (args.length == 0)
      {
         System.out.println("*** File name not provided by command line "
            + "argument.");
         System.out.println("Program ending.");
      }
      else
      {
         try
         {
            String fileName = args[0];
            UseTaxList list = new UseTaxList();
            list.readVehicleFile(fileName);
            System.out.println(list.summary());
            System.out.println("\n" + list.listByOwner());
            System.out.println("\n" + list.listByUseTax());
            System.out.println("\n" + list.excludedRecordsList());
         }
         catch (FileNotFoundException e)
         {
            System.out.println("*** File not found.");
            System.out.println("Program ending.");
         }
      }
   }
}