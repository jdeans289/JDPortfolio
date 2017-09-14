import java.util.*;
import java.io.*;
public class Rectangles {
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner (new File("rectangles.dat"));
        int probs = scan.nextInt();
        
        for (int i = 0; i < probs; i++)
        {
            double r1UpperLeftX = scan.nextDouble();
            double r1UpperLeftY = scan.nextDouble();
            double r1LowerRightX = scan.nextDouble();
            double r1LowerRightY = scan.nextDouble();
            Rectangle r1 = new Rectangle(r1UpperLeftX, r1UpperLeftY, r1LowerRightX, r1LowerRightY);
            
            double r2UpperLeftX = scan.nextDouble();
            double r2UpperLeftY = scan.nextDouble();
            double r2LowerRightX = scan.nextDouble();
            double r2LowerRightY = scan.nextDouble();
            Rectangle r2 = new Rectangle(r2UpperLeftX, r2UpperLeftY, r2LowerRightX, r2LowerRightY);
            
            double pointX = scan.nextDouble();
            double pointY = scan.nextDouble();
            
            String status = isOverlapping(r1,r2);
            
            if (status.equals("overlapping"))
            {
                Rectangle overlap = getOverlapping(r1, r2);
                if (pointX > overlap.getLeftBound() && pointX < overlap.getRightBound() && pointY > overlap.getLowerBound() && pointY < overlap.getUpperBound())
                {
                    System.out.println("YES");
                }
                else
                {
                    System.out.println("NO");
                }
            }
            else
            {
                if (status.equals("touching"))
                {
                    System.out.println("NO");
                }
                else
                {
                    System.out.println("NO");
                }
            }
            
            
        }
    }
    
    static Rectangle getOverlapping (Rectangle r1, Rectangle r2)
    {
        double upperLeftX = Math.max(r1.getLeftBound(), r2.getLeftBound());
        double upperLeftY = Math.min(r1.getUpperBound(), r2.getUpperBound());
        double lowerRightX = Math.min(r1.getRightBound(), r2.getRightBound());
        double lowerRightY = Math.max(r1.getLowerBound(), r2.getLowerBound());
        
        return new Rectangle (upperLeftX, upperLeftY, lowerRightX, lowerRightY);
    }
    
    static String isOverlapping(Rectangle r1, Rectangle r2)
    {
        String status = "";
        if (r1.getUpperBound() > r2.getLowerBound() && r1.getLowerBound() < r2.getUpperBound()) // if y is overlapping
            {
                if (r1.getRightBound() > r2.getLeftBound() && r1.getLeftBound() < r1.getRightBound()) // if x is overlapping
                {
                    status = "overlapping";
                }
            }
        else
        {
            if (r1.getLeftBound() == r2.getLeftBound() || r1.getRightBound() == r2.getRightBound() || r1.getUpperBound() == r2.getUpperBound() || r1.getLowerBound() == r2.getLowerBound())
                status = "touching";
            else
                status = "not";
        }
        return status;
    }
}

class Rectangle
{
    public double upperLeftX;
    public double upperLeftY;
    public double lowerRightX;
    public double lowerRightY;
    
    public Rectangle (double ulx, double uly, double lrx, double lry)
    {
        upperLeftX = ulx; 
        upperLeftY = uly;
        lowerRightX = lrx;
        lowerRightY = lry;
    }
    
    public double getLowerBound()
    {
        return lowerRightY;
    }
    
    public double getUpperBound()
    {
        return upperLeftY;
    }
    
    public double getRightBound()
    {
        return lowerRightX;
    }
    
    public double getLeftBound()
    {
        return upperLeftX;
    }
}