package MVPGlobal.Model;

import java.util.ArrayList;

/**
 * This is the Abstract class CardHandler.
 * A card handler is a person that interacts with the cards. This can either be a player or dealer.
 * Player and dealer need a lot of the same methods, therefor we made this class.
 */
 abstract class CardHandler {
    private ArrayList<Card> Hand = new ArrayList<Card>();

    /**
     * When a card handler starts a round, the first thing to do is to deal the first 2 cards.
     * We loop this 2 times and check if the cardhandler gets an ace or not.
     * The checks start ace method will give the ace the right value.
     * after this we add the card to the cardhandlers hand and remove the card from the top of the deck
     */
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

    /**
     * When a card handler wants a hit, we add the last card of the deck to their hand.
     * After this we also remove the card from the back of the stack.
     * Then we check if the hand for aces, we give them value according to their total score.
     */
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

    /**
     * In this method we check if the (start card) aces need to have the card value of 1 or 11.
     * We do this according to the total card value of the cardhandlers hand.
     */
     void checkStartAce(Card c) {
         if ((getTotalCardValue() + 11) > 21) {
             c.setCardValue(1);
         } else {
             c.setCardValue(11);
         }
     }

    /**
     * In this method we check if the aces in the card handlers hand have the right value.
     * We calculate this with the total value of their hand and determine if it has to be 1 or 11.
     */
     void checkAce(){
         for(Card c: Hand) {
             if (c.getCardNumb().equals("A")  && c.getCardValue() !=1) { // if we don't want the ace to be reversable  && c.getCardValue() !=11
                 if (getTotalCardValue() > 21){
                     c.setCardValue(1);
                 }else {
                     c.setCardValue(11);
                 }
            }
         }
     }

    /**
     * This method will loop through the hand (all cards) of the card handler, and it adds up the values.
     * This way you can get a total score of all the cards from a card handler.
     * @return It returns an integer, this is the total score of all the cards added togheter.
     */
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



