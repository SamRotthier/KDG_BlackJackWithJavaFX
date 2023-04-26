package ConsoleApp.BlackJack;

import java.util.ArrayList;


public class DeckBuilder {
     static String[] suits = {"spades", "hearts", "clubs", "diams"};
    //String[] numb = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};

    public static ArrayList<Card> AssemblingDeck() {
        ArrayList<Card> StartDeck = new ArrayList<Card>();
        for (String s : suits) {
            char suit = s.toUpperCase().charAt(0);
            for (int n = 1; n < 13; n++) { //13 na te kijken of het geen 12 moet zijn
                Card card = new Card();
                card.setIcon(suit);

                int cardValue = (n > 9) ? 10 : n + 1;
                card.setCardValue(cardValue);

                String cardNumb = "";
                if (n < 9) {
                    if(n == 1){
                        cardNumb = "A";
                    }
                    else {
                    cardNumb = Integer.toString(cardValue);
                    }
                } else if (n == 10) {
                    cardNumb = "J";
                } else if (n == 11) {
                    cardNumb = "Q";
                } else if (n == 12) {
                    cardNumb = "K";
                }
                card.setCardNumb(cardNumb);
                StartDeck.add(card);
            }
        }
        return StartDeck;
    }
    public static ArrayList<Card> ShuffleDeck(ArrayList<Card> StartDeck){
        ArrayList<Card> ShuffledDeck = new ArrayList<Card>();
        for(int i = StartDeck.size()-1; i>0;i--){
            int j2= (int) Math.floor(Math.random() * (i+1));
            Card j = StartDeck.get(j2);
            Card temp = StartDeck.get(i);
            StartDeck.set(i,j);
            StartDeck.set(j2,temp);
        }
        return ShuffledDeck;
    }

    public static ArrayList<Card> PlayDeck(int amountDeck){
        //ArrayList<Card> startDeck = DeckBuilder.AssemblingDeck();
        //ArrayList<Card> playDeck = DeckBuilder.ShuffleDeck(startDeck);
        //return playDeck;
        //Commented code is for easily making more bigger decks with the amount deck int
        return DeckBuilder.ShuffleDeck(DeckBuilder.AssemblingDeck());
    }


}


