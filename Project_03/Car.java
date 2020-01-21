
public class Car extends Vehicle
{
   public static final double TAX_RATE = 0.01;
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.005;
   public static final double LUXURY_THRESHOLD = 50_000;
   public static final double LUXURY_TAX_RATE = 0.02;

   public Car(String ownerIn, String yearMakeModelIn, double valueIn, boolean alternativeFuelIn)
   {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn);
   }
}