import java.util.*;
import java.io.*;

public class TypingTest {
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner (new File("typingtest.dat"));
        int probs = scan.nextInt();
        for (int i = 0; i < probs; i++)
        {
            int seconds = scan.nextInt();
            String str = scan.nextLine();
            str = str.trim();
            String[] sentence = str.split(" ");
            int wpm = (sentence.length/seconds)*60;
            System.out.println(wpm + " WPM");
        }
    }
}
