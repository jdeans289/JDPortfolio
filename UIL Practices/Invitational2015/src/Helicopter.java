import java.util.*;
import java.io.*;

public class Helicopter {
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner (new File("Helicopter.dat"));
        int probs = scan.nextInt();
        for (int i = 0; i < probs; i++)
        {
            int width = scan.nextInt();
            int length = scan.nextInt();
            int[][] city = new int[length][width];
            for (int a = 0; a < length; a++)
            {
                for (int b = 0; b < width; b++)
                {
                    city[a][b] = scan.nextInt();
                }
            }
            
//            for (int a = 0; a < length; a++)
//            {
//                for (int b = 0; b < width; b++)
//                {
//                    System.out.print(city[a][b] + " ");
//                }
//                System.out.println("");
//            }
            
            Square maxSquare = new Square(0, 0, 1, 1);
            
            for (int x = 0; x < length; x++)
            {
                for (int y = 0; y < length; y++)
                {  // iterates through each starting location
                    for (int squareLength = 1; squareLength < (length-x)+1; squareLength++)
                    {
                        for (int squareWidth = 1; squareWidth < (width-y)+1; squareWidth++ )
                        {  // iterates through every size
                            if (isLevel(city, x, y, squareLength, squareWidth))
                            {
                                if (maxSquare.getArea() < (squareLength*squareWidth))
                                {
                                    maxSquare = new Square(x, y, squareWidth, squareLength);
                                    //System.out.println("MAXSQUARE CHANGE: Area " + (squareWidth*squareLength));
                                }
                                if (maxSquare.getArea() == squareLength * squareWidth)
                                {
                                    if (city[maxSquare.getStartX()][maxSquare.getStartY()] < city[x][y])
                                    {
                                        maxSquare = new Square(x, y, squareWidth, squareLength);
                                        //System.out.println("MAXSQUARE CHANGE: Height " + city[x][y]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            maxSquare.print();
            System.out.println();
        }
    }
    
    static boolean isLevel(int[][] city, int x, int y, int l, int w)
    {
        int check = city[x][y];
        boolean isFlat = true;
        for (int a = x; a < x + l; a++)
        {
            for (int b = y; b < y + w; b++)
            {
                if (city[a][b] != check)
                    isFlat = false;
            }
        }
        
        return isFlat;
    }
}

class Square 
{
    public int area;
    public int startX, startY;
    public int width, length;
    
    public Square(int x, int y, int w, int l)
    {
        area = w * l;
        startX = x;
        startY = y;
        width = w;
        length = l;
    }
    
    public int getArea()
    {
        return area;
    }
    
    public int getStartX()
    {
        return startX;
    }
    public int getStartY()
    {
        return startY;
    }
    
    public void print()
    {
        System.out.println("Area: " + area + " square blocks");
        System.out.println("Start location: " + startX + " " + startY);
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
    }
}
