import java.util.*;
import java.io.*;
public class Bishop {
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner (new File("bishop.dat"));
        int probs = scan.nextInt();
        for (int i = 0; i < probs; i++)
        {
            int rows = scan.nextInt();
            int cols = scan.nextInt();
            String[][] board = new String[rows][cols];
            
            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c < cols; c++)
                {
                    board[r][c] = ".";
                }
            }
            
            int numBishops = scan.nextInt();
            for (int j = 0; j < numBishops; j++)
            {
                int x = scan.nextInt();
                int y = scan.nextInt();
                board[x][y] = "B";
                
                int xIndex = x;
                int yIndex = y;
                xIndex--;
                yIndex--;
                while (xIndex >= 0 && yIndex >= 0)
                {
                    board[xIndex][yIndex] = "x";
                    xIndex--;
                    yIndex--;
                }
                
                xIndex = x;
                yIndex = y;
                xIndex++;
                yIndex--;
                while (xIndex < rows && yIndex >=0)
                {
                    board[xIndex][yIndex] = "x";
                    xIndex++;
                    yIndex--;
                }
                
                xIndex = x;
                yIndex = y;
                xIndex--;
                yIndex++;
                while (xIndex >= 0 && yIndex < cols)
                {
                    board[xIndex][yIndex] = "x";
                    xIndex--;
                    yIndex++;
                }
                
                xIndex = x;
                yIndex = y;
                xIndex++;
                yIndex++;
                while (xIndex < rows && yIndex < cols)
                {
                    board[xIndex][yIndex] = "x";
                    xIndex++;
                    yIndex++;
                }
            }
            
//            for (int r = 0; r < rows; r++)
//            {
//                for (int c = 0; c < cols; c++)
//                {
//                    System.out.print(board[r][c] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            int places = 0;
            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c < cols; c++)
                {
                    if (board[r][c].equals("."))
                        places++;
                }
            }
            System.out.println(places);
            
        }
    }
}
