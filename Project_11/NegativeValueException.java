/**
*Creates an exception for negative values.
*
*@author Zachary Leggett - COMP 1210 - 007
*@version 4 December 2017
*/
public class NegativeValueException extends Exception
{
   /**
   *Generates error message for exception.
   */
   public NegativeValueException()
   {
      super("Numeric values must be nonnegative");
   }
}