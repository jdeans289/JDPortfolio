import java.io.*;
import java.util.*;

public class Consonant {
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner (new File ("consonant.dat"));
        int probs = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < probs; i++)
        {
            String str = scan.nextLine();
            str = str.toLowerCase();
            ArrayList<Character> consonants = new ArrayList<>();
            for (int j = 0; j < str.length(); j++)
            {
                if (!(str.charAt(j) == 'a' || str.charAt(j) == 'e' || str.charAt(j) == 'i' ||
                      str.charAt(j) == 'o' || str.charAt(j) == 'u') && Character.isAlphabetic(str.charAt(j)))
                {
                    consonants.add(str.charAt(j));
                }
            }
            
            if (consonants.size() <= 1)
            {
                if (consonants.isEmpty())
                    System.out.println("0");
                else
                    System.out.println("1");
            }
            else
            {
                int maxRun = Math.max(getAscending(consonants),getDescending(consonants));
                System.out.println(maxRun);
            }
        }
    }
    
    static int getAscending(ArrayList<Character> consonants)
    {
        int maxRun = 1;
        int run = 1;
        for (int i = 1; i < consonants.size(); i++)
        {
            if (consonants.get(i) >= consonants.get(i-1))
            {
                run++;
                if (run > maxRun)
                    maxRun = run;
            }
            else
                run = 1;
        }
        
        return maxRun;
    }
    
    static int getDescending(ArrayList<Character> consonants)
    {
        int maxRun = 1;
        int run = 1;
        for (int i = 1; i < consonants.size(); i++)
        {
            if (consonants.get(i) <= consonants.get(i-1))
            {
                run++;
                if (run > maxRun)
                    maxRun = run;
            }
            else
                run = 1;
        }
        
        return maxRun;
    }
}
