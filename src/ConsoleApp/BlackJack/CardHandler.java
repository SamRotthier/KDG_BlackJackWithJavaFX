package ConsoleApp.BlackJack;

import java.util.ArrayList;
import java.util.Random;

public abstract class CardHandler {

    private ArrayList<Card> Hand = new ArrayList<Card>();

    public void dealCard(ArrayList<Card> Deck){
        //Random randomGenerator = new Random();


        try {
            if (Hand.size() == 0) {
                for (int i = 1; i <= 2; i++) {
                    if(Deck.size() <1) {
                        //int cardToDraw = randomGenerator.nextInt(Deck.size());
                        Hand.add(Deck.get(Deck.size() - 1));
                        Deck.remove(Deck.size() - 1);
                    }
                    else {
                        DeckBuilder.PlayDeck(1);
                        Hand.add(Deck.get(Deck.size() - 1));

                        Deck.remove(Deck.size() - 1);
                    }
                }
            } else{
                if(Deck.size() <1) {
                    //int cardToDraw = randomGenerator.nextInt(Deck.size());
                    Hand.add(Deck.get(Deck.size() - 1)); // Deck.size() - 1) gets last card in the list (top of deck)
                    Deck.remove(Deck.size() - 1);
                }
                else {
                    DeckBuilder.PlayDeck(1);
                    Hand.add(Deck.get(Deck.size() - 1)); // Deck.size() - 1) gets last card in the list (top of deck)

                    Deck.remove(Deck.size() - 1);
                }
            }
        }
        catch (Exception e){
            System.out.println("Something went wrong while dealing a card");
        }
    }
    public void showHand(){
        System.out.println("cards in hand");
        //int score = 0;
        for (Card c: Hand) {
            System.out.println(c.getSuit() + " "+ c.getCardNumb());
        }
        System.out.println("For a total score of " + getTotalCardValue());
    }


    public int getTotalCardValue(){
        int totalCardValue = 0;
        for (Card c: Hand) {
            totalCardValue +=c.getCardValue();
            //System.out.println(c.getCardValue());
        }
        return totalCardValue;
    }

    public void hit(ArrayList<Card> Deck){
        dealCard(Deck);
    }
    public void stand(){

    }



    //Getter
    public ArrayList<Card> getHand() {
        return Hand;
    }
    //Setter
    public void setHand(ArrayList<Card> hand) {
        Hand = hand;
    }






}



