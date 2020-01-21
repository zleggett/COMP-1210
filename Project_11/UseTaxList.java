import java.util.Arrays;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
*Program that reads in vehicles from a file, adds them to
*an array, and sorts the array.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 26 November 2017
*/
public class UseTaxList
{
   protected String taxDistrict;
   protected Vehicle[] vehicleList;
   protected String[] excludedRecords;
   
   /**
   *Instantiates instance variables.
   */
   public UseTaxList()
   {
      taxDistrict = "not yet assigned";
      vehicleList = new Vehicle[0];
      excludedRecords = new String[0];
   }
   
   /**
   *Reads in file of vehicles and district.
   *@param fileNameIn File of vehicles.
   *@throws FileNotFoundException if the file cannot be opened.
   */
   public void readVehicleFile(String fileNameIn) throws FileNotFoundException
   {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      taxDistrict = scanFile.nextLine().trim();
      while (scanFile.hasNext())
      {
         String vehicleIn = scanFile.nextLine().trim();
         try 
         {
            Scanner s = new Scanner(vehicleIn).useDelimiter(";");
         
            String type = s.next().trim();
         
            String ownerIn = s.next().trim();
         
            String yearMakeModelIn = s.next().trim();
         
            double valueIn = Double.parseDouble(s.next().trim());
         
            boolean alternativeFuelIn = Boolean.parseBoolean(s.next().trim());
         
            char code = type.toUpperCase().charAt(0);
            switch(code) {
               case 'C':
                  Vehicle v1 = new Car(ownerIn, yearMakeModelIn, 
                     valueIn, alternativeFuelIn);
                  addVehicle(v1);
                  break;
               
               case 'M':
                  double engineSizeIn  = Double.parseDouble(s.next().trim());
                  Vehicle v2 = new Motorcycle(ownerIn, yearMakeModelIn, 
                     valueIn, alternativeFuelIn, engineSizeIn);
                  addVehicle(v2);
                  break;
               
               case 'T':
                  double tonsIn = Double.parseDouble(s.next().trim());
                  Vehicle v3 = new Truck(ownerIn, yearMakeModelIn, 
                     valueIn, alternativeFuelIn, tonsIn);
                  addVehicle(v3);
                  break;
               
               case 'S':
                  double tonsIn2 = Double.parseDouble(s.next().trim());
                  int axelsIn = Integer.parseInt(s.next().trim());
                  Vehicle v4 = new SemiTractorTrailer(ownerIn, yearMakeModelIn, 
                     valueIn, alternativeFuelIn, tonsIn2, axelsIn);
                  addVehicle(v4);
                  break;
               
               default:
                  addExcludedRecord("Invalid Vehicle Category in: \n" 
                     + vehicleIn);
                  break;
            }
         }
         catch (NegativeValueException e)
         {
            addExcludedRecord(e + " in:\n" + vehicleIn);
         }
         catch (NumberFormatException e2)
         {
            addExcludedRecord(e2 + " in:\n" + vehicleIn);
         }
         catch (NoSuchElementException e3)
         {
            addExcludedRecord(e3 + " in:\n" + vehicleIn);
         }
      }
      scanFile.close();
   }
   
   /**
   *Gets the tax district.
   *@return taxDistrict Tax district for vehicles.
   */
   public String getTaxDistrict()
   {
      return taxDistrict;
   }
   
   /**
   *Sets tax district.
   *@param districtIn User inputted tax district.
   */
   public void setTaxDistrict(String districtIn)
   {
      taxDistrict = districtIn;
   }
   
   /**
   *Gets list of vehicles.
   *@return vehicleList List of vehicles.
   */
   public Vehicle[] getVehicleList()
   {
      return vehicleList;
   }
   
   /**
   *Gets list of excluded records.
   *@return excludedRecords List of excluded records.
   */
   public String[] getExcludedRecords()
   {
      return excludedRecords;
   }
   
   /**
   *Adds vehicle to vehicleList.
   @param vehicleIn User inputted vehicle.
   */
   public void addVehicle(Vehicle vehicleIn)
   {
      vehicleList = Arrays.copyOf(vehicleList, vehicleList.length + 1);
      vehicleList[vehicleList.length - 1] = vehicleIn;
   }
   
   /**
   *Adds excluded record to excludedRecords.
   *@param excludedRecordIn User inputted excluded record.
   */
   public void addExcludedRecord(String excludedRecordIn)
   {
      excludedRecords = Arrays.copyOf(excludedRecords, 
         excludedRecords.length + 1);
      excludedRecords[excludedRecords.length - 1] = excludedRecordIn;
   }
   
   /**
   *Outputs vehicle list info.
   @return output Vehicle list info.
   */
   public String toString()
   {
      String output = "";
      for (Vehicle v : vehicleList) {
         output += "\n" + v + "\n";
      }
   
      return output;
   }
   
   /**
   *Calculates use tax rate of vehicle list.
   *@return tax Use tax of vehicle list.
   */
   public double calculateTotalUseTax()
   {
      double tax = 0;
      for (Vehicle v : vehicleList) {
         tax += v.useTax();
      }
      return tax;
   }
   
   /**
   *Calculates total value of vehicle list.
   *@return value Value of vehicle list.
   */
   public double calculateTotalValue()
   {
      double value = 0;
      for (Vehicle v : vehicleList) {
         value += v.getValue();
      }
      return value;
   }
   
   /**
   *Prints a summary of the tax district.
   *@return summary Summary of tax district.
   */
   public String summary()
   {
      DecimalFormat fmt = new DecimalFormat("$#,##0.00");
      String output = "------------------------------";
      output += "\nSummary for " + taxDistrict;
      output += "\n------------------------------";
      output += "\nNumber of Vehicles: " + vehicleList.length;
      output += "\nTotal Value: " + fmt.format(calculateTotalValue());
      output += "\nTotal Use Tax: " + fmt.format(calculateTotalUseTax()) + "\n";
   
      return output;
   }
   
   /**
   *Sorts vehicle list by owner.
   *@return Vehicle list by owner.
   */
   public String listByOwner()
   {
      Arrays.sort(vehicleList);
      String output = "------------------------------";
      output += "\nVehicles by Owner";
      output += "\n------------------------------\n";
      for (Vehicle v : vehicleList) {
         output += "\n" + v + "\n";
      }
   
      return output;
   }
   
   /**
   *Sorts vehicle list by use tax.
   *@return Vehicle list by use tax.
   */
   public String listByUseTax()
   {
      Arrays.sort(vehicleList, new UseTaxComparator());
      String output = "------------------------------";
      output += "\nVehicles by Use Tax";
      output += "\n------------------------------\n";
      for (Vehicle v : vehicleList) {
         output += "\n" + v + "\n";
      }
   
      return output;
   }
   
   /**
   *Prints list of excluded records.
   *@return List of excluded records.
   */
   public String excludedRecordsList()
   {
      String output = "------------------------------";
      output += "\nExcluded Records";
      output += "\n------------------------------\n";
      for (String v : excludedRecords) {
         output += "\n" + v + "\n";
      }
   
      return output;
   }
}