
public class Card {

    public int cardNumber;

    public String cardSuit;

    public Card()
    {

    }

    public Card(int cardNumber, String cardSuit)
    {
        this.cardNumber = cardNumber;
        this.cardSuit = cardSuit;
    }

    @Override
    public String toString() {
        return "{" + cardNumber + "," + cardSuit + '}';
    }
}
