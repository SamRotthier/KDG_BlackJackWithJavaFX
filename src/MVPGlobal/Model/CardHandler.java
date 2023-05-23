package MVPGlobal.Model;

import java.util.ArrayList;

/**
 * This is the Abstract class CardHandler.
 * A card handler is a person that interacts with the cards. This can either be a player or dealer.
 * Player and dealer need a lot of the same methods.
 */
 abstract class CardHandler {
    private ArrayList<Card> Hand = new ArrayList<Card>();

     void dealCard(ArrayList<Card> Deck){
        try {
            if (Hand.size() == 0) {
                for (int i = 1; i <= 2; i++) {
                        if (Deck.get(Deck.size()-1).getCardNumb().equals("A")){
                            checkStartAce(Deck.get(Deck.size()-1));
                        }
                            Hand.add(Deck.get(Deck.size() - 1));
                            Deck.remove(Deck.size() - 1);
                }
            }
        }
        catch (Exception e){
            System.out.println("You already have cards in your hand");
        }
    }
     void hitCard(ArrayList<Card> Deck){
         try {
                     Hand.add(Deck.get(Deck.size() - 1)); // Deck.size() - 1) gets last card in the list (top of deck)
                     Deck.remove(Deck.size() - 1);
                     checkAce();
         }
         catch (Exception e){
             System.out.println("Something went wrong while dealing a card");
         }
     }
     void checkStartAce(Card c) {
         if ((getTotalCardValue() + 11) > 21) {
             c.setCardValue(1);
         } else {
             c.setCardValue(11);
         }
     }
     void checkAce(){
         for(Card c: Hand) {
             if (c.getCardNumb().equals("A")) { // if we don't want the ace to be reversable  && c.getCardValue() !=11
                 if (getTotalCardValue() > 21){
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



