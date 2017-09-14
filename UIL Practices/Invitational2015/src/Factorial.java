import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Factorial {
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner (new File ("factorial.dat"));
        int probs = scan.nextInt();
        for (int i = 0; i < probs; i++)
        {
            BigInteger product = BigInteger.ONE;
            int num = scan.nextInt();
            for (int j = 1; j <= num; j++)
            {
                product = product.multiply(BigInteger.valueOf((long)j));
            }
            
            String str = product + "";
            int count = 0;
            for (int j = 0; j < str.length(); j++)
            {
                if (str.charAt(j) == '0')
                    count++;
                else
                    count = 0;
            }
            
            System.out.println(count);
        }
    }
}
