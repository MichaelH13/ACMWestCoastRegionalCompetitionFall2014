import java.math.BigInteger;
import java.util.Scanner;

public class F
{

   private static final BigInteger ZERO = new BigInteger("0");

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int loops = Integer.parseInt(in.next());
      BigInteger ONE = new BigInteger("1");

      for (int i = 0; i < loops; i++)
      {
         BigInteger m = new BigInteger(in.next());
         BigInteger n = new BigInteger(in.next());
         BigInteger mn = m.multiply(n);

         BigInteger result = new BigInteger("0");

         // System.out.println(m.toString());
         // System.out.println(n.toString());
         // System.out.println(mn.toString());
         // System.out.println(n.subtract(mn).compareTo(mn));

         BigInteger startResult = new BigInteger("0");

         for (BigInteger j = new BigInteger(mn.toString()); j.compareTo(mn
                  .subtract(n)) > 0; j = j.subtract(ONE))
         {

            if (result.compareTo(ZERO) == 0)
            {
               for (BigInteger k = new BigInteger(j.toString()); k
                        .compareTo(ZERO) > 0; k = k.subtract(ONE))
               {
                  startResult = startResult.add(k);
               }
            }

            result = result.add(startResult);

            startResult = startResult.subtract(j);

            // System.out.println(j.toString());
         }

         System.out.println(result.mod(new BigInteger("1000000009")));
      }
   }
}
