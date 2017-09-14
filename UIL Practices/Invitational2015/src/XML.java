import java.util.*;
import java.io.*;

public class XML {
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner (new File("xml.dat"));
        int probs = scan.nextInt();
        scan.nextLine();    // omitting this initially was the only thing wrong with my code. took me 30 minutes to find it.
        for (int i = 0; i < probs; i++)
        {
            String line1 = scan.nextLine();
            String line2 = scan.nextLine();
            
            ArrayList<Tag> tags1 = processLine(line1);
            ArrayList<Tag> tags2 = processLine(line2);
           // System.out.println("tags1 size: " + tags1.size());
            //System.out.println("tags2 size: " + tags2.size());
            if (tags1.size() != tags2.size())
            {
                System.out.println("CHANGE: size");
                System.out.println("different");
            }
            else
            {
                boolean same = true;
                for (int j = 0; j < tags1.size(); j++)
                {
//                    System.out.println("Here");
                    if (tags1.get(j).getName().equals(tags2.get(j).getName()))
                    {
                        if (tags1.get(j).getChildren() != tags2.get(j).getChildren())
                        {
                            same = false;
//                            System.out.println("CHANGE: children");
                        }
                    }
                    else
                    {
                        same = false;
//                        System.out.println("CHANGE: name");
                    }
                }
                
                System.out.println(same ? "same" : "different");
            }
        }    
    }
    
    static ArrayList<Tag> processLine(String line)
    {
        int numTags = 0;
        ArrayList<Tag> tags = new ArrayList<>();
        for (int i = 0; i < line.length(); i++)
        {
            if (line.charAt(i) == '/')
                numTags++;
        }
        
        for (int i = 0; i < numTags; i++)
        {
            String name;
            int startIndex = line.indexOf("<");
            int endIndex = line.indexOf(">");
            name = line.substring(startIndex+1,endIndex);
            Tag t = processTag(line, name);
            tags.add(t);
            line = line.substring(0,startIndex) + line.substring(endIndex+1);
        }
        
        return tags;
    }
    
    static Tag processTag(String line, String name)
    {
        String end = "/" + name;
        int startIndex = line.indexOf(name);
        int endIndex = line.indexOf(end);
        int numChildren = 0;
        for (int i = startIndex; i < endIndex; i++)
        {
            if (line.charAt(i) == '/')
                numChildren++;
        }
        
        return new Tag(name,numChildren);
    }
}

class Tag
{
    String name;
    int numChildren = 0;
    
    public Tag(String n, int c)
    {
        name = n;
        numChildren = c;
    }
    
    public void setChildren(int num)
    {
        numChildren = num;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getChildren()
    {
        return numChildren;
    }
    
    public void print()
    {
        System.out.println("TAG: " + name);
        System.out.println("CHILDREN: " + numChildren);
    }
}
