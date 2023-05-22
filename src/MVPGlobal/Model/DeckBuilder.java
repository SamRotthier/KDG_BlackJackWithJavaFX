package MVPGlobal.Model;

import java.util.ArrayList;


 class DeckBuilder {
     static String[] suits = {"spades", "hearts", "clubs", "diamonds"};
    //String[] numb = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};

     static ArrayList<Card> assemblingDeck() {
        ArrayList<Card> StartDeck = new ArrayList<>();
        for (String s : suits) {
            for (int n = 1; n < 13; n++) { //13 na te kijken of het geen 12 moet zijn
                Card card = new Card();
                card.setIcon(s.toUpperCase().charAt(0));
                card.setSuit(s);

                int cardValue = (n > 9) ? 10 : n + 1;
                card.setCardValue(cardValue);

                String cardNumb = "";
                if (n < 11) {
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

     static ArrayList<Card> playDeck(int amountDeck){
         ArrayList<Card> startDeck = assemblingDeck();
         ArrayList<Card> playDeck = new ArrayList<>();
         for(int i = 1; i<=amountDeck;i++) {
             playDeck.addAll(shuffleDeck(startDeck));
         }
        return playDeck;
        //Commented code is for easily making bigger decks with the amount deck int
        //ArrayList<Card> StartDeck = AssemblingDeck();
         ////ArrayList<Card> playDeck = ShuffleDeck(startDeck);
        //return ShuffleDeck(AssemblingDeck());
    }


}


