import java.util.*;
import java.io.*;
public class SpanishQuiz {
    public static void main (String[] args) throws Exception
    {
        String[] cities = {"Mexico D.F.", "Guatemala", "Tegucigalpa", "San Salvador",
                           "Managua", "San Jose", "Panama", "Caracas", "Bogota", "Quito",
                           "Lima", "La Paz", "Asuncion", "Santiago", "Buenos Aires", 
                           "Montevideo", "Brasilia"};
        
        String[] countries = {"Mexico", "Guatemala", "Honduras", "El Salvador", "Nicaragua",
                    "Costa Rica", "Panama", "Venezuela", "Colombia", "Ecuador","Peru", 
                    "Bolivia", "Paraguay", "Chile", "Argentina", "Uruguay", "Brazil"};
        
        Flashcard[] cards = new Flashcard[17];
        for (int i = 0; i < cards.length; i++)
        {
            cards[i] = new Flashcard(cities[i],countries[i]);
        }
        
        
        Scanner scan = new Scanner (new File("spanishquiz.dat"));
        int probs = scan.nextInt();
        scan.nextLine();
        
        for (int i = 0; i < probs; i++)
        {
            String str = scan.nextLine();
            String[] sentence = str.split(" ");
            String answer = "error";
            if (sentence[0].equals("What"))
            {
                String country = sentence[sentence.length-1];
                country = country.substring(0,country.length()-1);
                for (int j = 0; j < cards.length; j++)
                {
                    if (country.equals(cards[j].getCountry()))
                    {
                        answer = cards[j].getCard();
                    }
                }
            }
            else
            {
                String city = sentence[0];
                for (int j = 0; j < cards.length; j++)
                {
                    if (city.equals(cards[j].getCity()))
                    {
                        answer = cards[j].getCard();
                    }
                }
            }
            
            System.out.println(answer);
        }
        
        
    }
}

class Flashcard
{
    public String city;
    public String country;
    
    public Flashcard (String ci, String co)
    {
        city = ci;
        country = co;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public String getCard()
    {
        return city + " is the capital city of " + country + ".";
    }
}
