import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
/**
*Program that accepts a user inputted coded ticket and decodes ticket
*into date, time, seat, itinerary, price, category, cost, and a random 
*prize number.
*
*Project 3
*@author Zachary Leggett - Computing 1210 - 007
*@version 19 September 2017
*/
public class MoonTrip
{
   static final double STUDENT_DISCOUNT = .40;
   static final double EMPLOYEE_DISCOUNT = .20;
   /**
   *Program that interprets coded ticket information.
   *@param args Command line arguments - not used.
   */
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      String ticketCode = "";
      double price = 0;
      double cost = 0;
      int prize = 0;
   
      System.out.print("Enter ticket code: ");
      ticketCode = userInput.nextLine();
      ticketCode = ticketCode.trim();
      
      if (ticketCode.length() >= 26) {
         System.out.println();
      }
      else {
         System.out.println();
         System.out.println("*** Invalid ticket code ***");
         System.out.print("Ticket code must have at least 26 characters.");
         return;
      }
      
      System.out.println("Date: " + ticketCode.substring(0, 2) + "/"
         + ticketCode.substring(2, 4) + "/" 
         + ticketCode.substring(4, 8)
         + "   " + "Time: " + ticketCode.substring(8, 10) + ":" 
         + ticketCode.substring(10, 12)
         + "   " + "Seat: " + ticketCode.substring(22, 25));
      System.out.println("Itinerary: " + ticketCode.substring(25));
      
      DecimalFormat fmt = new DecimalFormat("#,##0.00");
      price = Double.parseDouble(ticketCode.substring(13, 20));
      
      if (ticketCode.charAt(12) == 's') {
         cost = price - (price * STUDENT_DISCOUNT);
      }
      else if (ticketCode.charAt(12) == 'e') {
         cost = price - (price * EMPLOYEE_DISCOUNT);
      }
      else {
         cost = price;
      }
      
      System.out.println("Price: $" + fmt.format(price) + "   " + "Category: "
         + ticketCode.charAt(12) + "   " + "Cost: $" + fmt.format(cost));
      
      Random generator = new Random();
      DecimalFormat fmt2 = new DecimalFormat("0000");
      prize = generator.nextInt(9999) + 1;
      System.out.print("Prize Number: " + fmt2.format(prize));
   }
}