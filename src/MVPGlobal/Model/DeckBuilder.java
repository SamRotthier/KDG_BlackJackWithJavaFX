package MVPGlobal.Model;

import java.util.ArrayList;

/**
 * This is the class the deck builder.
 * In this class the play deck (shuffeled deck on the table) gets assembled.
 */
 class DeckBuilder {
     static String[] suits = {"spades", "hearts", "clubs", "diamonds"};
    //String[] numb = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};

    /**
     * This method will assemble a deck in a normal order.
     * @return It returns an array list of cards.
     */
     static ArrayList<Card> assemblingDeck() {
        ArrayList<Card> StartDeck = new ArrayList<>();
        for (String s : suits) {
            for (int n = 1; n < 14; n++) {
                Card card = new Card();
                card.setIcon(s.toUpperCase().charAt(0));
                card.setSuit(s);

                int cardValue = (n > 9) ? 10 : n;
                card.setCardValue(cardValue);

                String cardNumb = "";
                if (n < 11) {
                    if(n == 1){
                        cardNumb = "A";
                        card.setCardValue(11);
                    }
                    else {
                    cardNumb = Integer.toString(cardValue);
                    }
                } else if (n == 11) {
                    cardNumb = "J";
                } else if (n == 12) {
                    cardNumb = "Q";
                } else if (n == 13) {
                    cardNumb = "K";
                }
                card.setCardNumb(cardNumb);
                StartDeck.add(card);
            }
        }
        return StartDeck;
    }

    /**
     * This method will shuffle a previously assembled deck randomly.
     * In java there is also a shuffle function for arraylists but in this case we chose to do it ourselves.
     * @return It returns an array list of cards.
     */
     static ArrayList<Card> shuffleDeck(ArrayList<Card> StartDeck){
        for(int i = StartDeck.size()-1; i>0;i--){
            int j2= (int) Math.floor(Math.random() * (i+1));
            Card j = StartDeck.get(j2);
            Card temp = StartDeck.get(i);
            StartDeck.set(i,j);
            StartDeck.set(j2,temp);
        }
        return StartDeck;
    }

    /**
     * This get multiple shuffeled decks and assemble them into a play deck.
     * This play deck will be used on the poker table
     * @return It returns an array list of cards.
     */
     static ArrayList<Card> playDeck(int amountDeck){
         ArrayList<Card> startDeck = assemblingDeck();
         ArrayList<Card> playDeck = new ArrayList<>();
         for(int i = 1; i<=amountDeck;i++) {
             playDeck.addAll(shuffleDeck(startDeck));
         }
        return playDeck;
    }


}


