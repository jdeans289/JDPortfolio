import java.util.*;
import java.io.*;
public class Timezones {
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner (new File("timezones.dat"));
        
        int numZones = scan.nextInt();
        int numConversions = scan.nextInt();
        
        Zone[] zones = new Zone[numZones];
        
        for (int i = 0; i < numZones; i++)
        {
            String n = scan.next();
            String o = scan.next();
            zones[i] = new Zone(n,o);
        }
        
        for (int i = 0; i < numConversions; i++)
        {
            String initialTime = scan.next();
//            System.out.println("Initial Time: " + initialTime);
            String from = scan.next();
            scan.next();
            String to = scan.next();
            Zone fromZone = new Zone("error","");
            Zone toZone = new Zone("error","");
            for (Zone zone : zones)
            {
                if (zone.getName().equals(from))
                    fromZone = zone;
                if (zone.getName().equals(to))
                    toZone = zone;
            }
            
            String fromOffset = fromZone.getOffset();
            String toOffset = toZone.getOffset();
            
            int minuteOffset = 0;
            int hourOffset = 0;
            String totalOffset = "";
            if (fromOffset.charAt(0) == '+' && toOffset.charAt(0) == '+')
            {
                minuteOffset = Integer.parseInt(toOffset.substring(4)) - (Integer.parseInt(fromOffset.substring(4)));
                hourOffset = Integer.parseInt(toOffset.substring(1,3)) - (Integer.parseInt(fromOffset.substring(1,3)));
            }
            if (fromOffset.charAt(0) == '-' && toOffset.charAt(0) == '+')
            {
                minuteOffset = Integer.parseInt(toOffset.substring(4)) + (Integer.parseInt(fromOffset.substring(4)));
                hourOffset = Integer.parseInt(toOffset.substring(1,3)) + (Integer.parseInt(fromOffset.substring(1,3)));
            }
            if (fromOffset.charAt(0) == '+' && toOffset.charAt(0) == '-')
            {
                minuteOffset = 0 - Integer.parseInt(toOffset.substring(4)) - (Integer.parseInt(fromOffset.substring(4)));
                hourOffset = 0 - Integer.parseInt(toOffset.substring(1,3)) - (Integer.parseInt(fromOffset.substring(1,3)));
            }
            if (fromOffset.charAt(0) == '-' && toOffset.charAt(0) == '-')
            {
                minuteOffset = 0 - Integer.parseInt(toOffset.substring(4)) + (Integer.parseInt(fromOffset.substring(4)));
                hourOffset = 0 - Integer.parseInt(toOffset.substring(1,3)) + (Integer.parseInt(fromOffset.substring(1,3)));
            }
            

            int newHour = Integer.parseInt(initialTime.substring(0,2)) + hourOffset;
            int newMinute = Integer.parseInt(initialTime.substring(3)) + minuteOffset;
            
            if (newMinute < 0)
            {
                newMinute += 60;
                newHour -= 1;
            }
            if (newMinute >= 60)
            {
                newMinute -= 60;
                newHour += 1;
            }
            if (newHour >= 24)
                newHour -= 24;
           
            String hr = newHour + "";
            if (hr.length() == 1)
                hr = 0 + hr;
            String min = newMinute + "";
            if (min.length() == 1)
                min = 0 + min;
            
            System.out.println(hr + ":" + min + " " + toZone.getName());
        }
    }
}

class Zone
{
    String name;
    String offset;
    
    public Zone (String n, String o)
    {
        name = n;
        offset = o;
    }
    
    public String getOffset()
    {
        return offset;
    }
    
    public String getName()
    {
        return name;
    }
}
