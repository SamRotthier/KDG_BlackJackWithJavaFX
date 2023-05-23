package MVPGlobal.Model;

/**
 * This is the Card object.
 * It is the heart of our game.
 * A card has a suit (clubs, clovers, diamonds or hearts), an icon which is the first letter of the suit,
 * a card number (which can be A,2-10,J,Q,K), and the value (which is between 1 and 11).
 * It also has getters and setters for each of these values
 */
 public class Card {
    private String Suit;
    private char icon;
    private String cardNumb;
    private int cardValue;

     void setSuit(String suit) {
        Suit = suit;
    }

     void setIcon(char icon) {
        this.icon = icon;
    }

     void setCardNumb(String cardNumb) {
        this.cardNumb = cardNumb;
    }

     void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

     public String getSuit() {
        return Suit;
    }

     char getIcon() {
        return icon;
    }

     public String getCardNumb() {
        return cardNumb;
    }

     int getCardValue() {
        return cardValue;
    }






}
