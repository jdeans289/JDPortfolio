import java.util.*;
import java.io.*;

public class Mountain {
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner (new File("mountain.dat"));
        int probs = scan.nextInt();
        
        for (int i = 0; i < probs; i++)
        {
            int length = scan.nextInt();
            int[][] mount = new int[length][length];
            for (int m = 0; m < length; m++)
            {
                for (int n = 0; n < length; n++)
                {
                    mount[m][n] = scan.nextInt();
                }
            }
            
            
        }
    }
}

class Maze
{
    int[][] board;
    public Maze (int[][] b)
    {
        board = b;
    }
    
    public boolean traverse(int row, int col, int goal)
    {
        if (board[row][col] == goal)
            return true;
        
        if (validSpace(row,col+1)) // up
        {
            if (validMove(board[row][col], board[row][col+1]))
            {
                
            }
        }
    }
    
    public boolean validMove (int curr, int toMove)
    {
        return (curr == toMove || curr+1 == toMove || curr-1 == toMove || curr-2 == toMove);
    }
    
    public boolean validSpace (int row, int col)
    {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }
}