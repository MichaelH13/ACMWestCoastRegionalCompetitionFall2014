import java.math.BigInteger;
import java.util.Scanner;

public class E
{

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      int loops = in.nextInt();
      BigInteger num = new BigInteger("0");
      String stringNum = "";

      for (int j = 0; j < loops; j++)
      {
         if (loops != 0)
         {
            stringNum = in.next();
            num = new BigInteger(stringNum);
         }

         if (stringNum.length() >= 3)
         {
            for (int i = 1; i < stringNum.length(); i++)
            {
               if (!isHill(stringNum))
               {
                  System.out.println("-1");
               }
               else
               {
                  System.out.println(hillsBefore(num));
               }

               stringNum = in.next();
               num = new BigInteger(stringNum);
            }
         }
         else
         {
            System.out.println(stringNum);
         }
      }
   }

   private static boolean isHill(String num)
   {
      boolean hillNum = true;
      boolean ascending = true;
      int k = 0;

      for (int i = 0; i < num.length() - 1 && ascending; i++)
      {

         // if (num.charAt(i - 1) > num.charAt(i))
         if (num.charAt(i) > num.charAt(i + 1))
         {
            ascending = false;
            k = i;
         }
      }

      if (!ascending)
      {
         for (int j = k; j < num.length() - 1 && hillNum; j++)
         {

            if (num.charAt(j) < num.charAt(j + 1))
            {
               hillNum = false;
            }
         }
      }

      return hillNum;
   }

   private static long hillsBefore(BigInteger num)
   {
      long hillCount = 0;

      for (BigInteger i = new BigInteger("0"); 0 < num.compareTo(i); i
               .add(new BigInteger("1")))
      {
         if (isHill(i.toString()))
         {
            hillCount++;
         }
      }

      return hillCount;
   }
}
