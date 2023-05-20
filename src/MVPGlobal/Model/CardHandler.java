package MVPGlobal.Model;

import java.util.ArrayList;

 abstract class CardHandler {
    private ArrayList<Card> Hand = new ArrayList<Card>();

     void dealCard(ArrayList<Card> Deck){
        try {
            if (Hand.size() == 0) {
                for (int i = 1; i <= 2; i++) {
                        Hand.add(Deck.get(Deck.size() - 1));
                        Deck.remove(Deck.size() - 1);
                        checkAce();
                }
            }
        }
        catch (Exception e){
            System.out.println("You already have cards in your hand");
        }
    }
     void hitCard(ArrayList<Card> Deck){
         try {
                     //int cardToDraw = randomGenerator.nextInt(Deck.size());
                     Hand.add(Deck.get(Deck.size() - 1)); // Deck.size() - 1) gets last card in the list (top of deck)
                     Deck.remove(Deck.size() - 1);
                     checkAce();
         }
         catch (Exception e){
             System.out.println("Something went wrong while dealing a card");
         }
     }

     void checkAce(){
         for(Card c: Hand) {
             if (c.getCardNumb().equals("A")) { // if we don't want the ace to be reversable  && c.getCardValue() !=11
                 if ((getTotalCardValue() + 11) > 21){
                     c.setCardValue(1);
                 }else {
                     c.setCardValue(11);
                 }
             }
         }
     }
     public int getTotalCardValue(){
        int totalCardValue = 0;
        for (Card c: Hand) {
            totalCardValue +=c.getCardValue();
            //System.out.println(c.getCardValue());
        }
        return totalCardValue;
    }

    //Getter
    public ArrayList<Card> getHand() {
        return Hand;
    }

}



