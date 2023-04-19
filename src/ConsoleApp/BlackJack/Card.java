package ConsoleApp.BlackJack;

import java.security.PrivateKey;

public class Card {
    private String Suit;
    private char icon;
    private String cardNumb;
    private int cardValue;

    public void setSuit(String suit) {
        Suit = suit;
    }

    public void setIcon(char icon) {
        this.icon = icon;
    }

    public void setCardNumb(String cardNumb) {
        this.cardNumb = cardNumb;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public String getSuit() {
        return Suit;
    }

    public char getIcon() {
        return icon;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public int getCardValue() {
        return cardValue;
    }






}
