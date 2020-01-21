/**
*Driver program for Vehicle amd sub classes.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 14 November 2017
*/
public class VehiclesPart1
{
    /**
    *Instantiates and prints each sub class of Vehicle.
    *@param args Command line arguments - not used.
    */
   public static void main(String[] args)
   {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car car2 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe", 
         110000, true);
      
      System.out.println(car1);
      System.out.println(car2);
      
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado", 
         30000, false, 1.5);
      Truck truck2 = new Truck("Williams, Bob", "2010 Chevy Mack", 
         40000, true, 2.5);
      
      System.out.println(truck1);
      System.out.println(truck2);
      
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat", 
         "2012 International Big Boy", 45000, false, 5.0, 4);
      
      System.out.println(semi1);
      
      Motorcycle bike1 = new Motorcycle("Brando, Marlon", 
         "1964 Harley-Davidson Sportster", 14000, false, 400);
      Motorcycle bike2 = new Motorcycle("Smith, Simon", 
         "1964 Harley-Davidson Sportster", 14000, true, 750);
      
      System.out.println(bike1);
      System.out.println(bike2);
   }
}