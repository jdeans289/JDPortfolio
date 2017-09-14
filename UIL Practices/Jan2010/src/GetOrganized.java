import java.util.Scanner;
import java.io.*;

public class GetOrganized {
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner (new File("GetOrganized.in"));
        
        int probs = scan.nextInt();
        for (int i = 0; i < probs; i++)
        {
            int rows = scan.nextInt();
            int col = scan.nextInt();
            
            String del = scan.next();
            
            scan.nextLine();
            
            String[][] arr = new String[rows][];
            
            for (int j = 0; j < rows; j++)
            {
                String line = scan.nextLine();
                arr[j] = line.split(del);
            }
            
            sort (col, arr);
            
            for (String[] a : arr)
            {
                for (String s : a) {
                    System.out.print(s + " "); }
                System.out.println();
            }
        }
    }
    
    public static void sort (int col, String[][] arr)
    {
        int min;
        String[] temp;
        
        for (int i = 0; i < arr.length-1; i++)
        {
            min = i;
            for (int scan = i+1; scan < arr.length; scan++)
            {
                if (arr[scan][col].charAt(0) < arr[min][col].charAt(0))
                    min = scan;
                
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                
            }
        }
        
    }
}
