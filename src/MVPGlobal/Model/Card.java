package MVPGlobal.Model;

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

     String getSuit() {
        return Suit;
    }

     char getIcon() {
        return icon;
    }

     String getCardNumb() {
        return cardNumb;
    }

     int getCardValue() {
        return cardValue;
    }






}
