import java.util.Random;
public class Card
{
    private static Random generator = new Random();

    private int suit;
    private int value;

    public Card ()
    {
        value = generator.nextInt(13) + 1;
        suit = generator.nextInt(4) + 1;
    }

    public Card (int theValue, int theSuit)
    {
        value = theValue;
        suit = theSuit;
    }

    public String getSuit()
    {
        switch (suit)
        {
            case 1: return "Spades";
            case 2: return "Hearts";
            case 3: return "Diamonds";
            case 4: return "Clubs";
            default: return "error " + suit;
        }
    }

    public String getValue()
    {
        switch (value)
        {
            case 1: return "Ace";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            default: return "" + value;
        }
    }

    public static void main(String s[])
    {
        for (int i=1; i<6; i++)
        {
            Card c = new Card();
            System.out.println("Suit: " + c.getSuit());
            System.out.println("Value: " + c.getValue());
        }
    }
}