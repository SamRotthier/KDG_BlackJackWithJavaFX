package ConsoleApp.BlackJack;

import java.util.ArrayList;
import java.util.Random;

public abstract class CardHandler {

    private ArrayList<Card> Hand = new ArrayList<Card>();

    public void dealCard(ArrayList<Card> Deck){
        Random randomGenerator = new Random();
        try {
            if (Hand.size() == 0) {
                for (int i = 1; i <= 2; i++) {
                    int cardToDraw = randomGenerator.nextInt(Deck.size());
                    Hand.add(Deck.get(cardToDraw));
                    Deck.remove(cardToDraw);
                }
            } else{
                int cardToDraw = randomGenerator.nextInt(Deck.size());
                Hand.add(Deck.get(cardToDraw));
                Deck.remove(cardToDraw);
            }

        }
        catch (Exception e){
            System.out.println("Something went wrong while dealing a card");
        }
    }
    public void showHand(){
        System.out.println("You have these cards in your hand");
        int score = 0;
        for (Card c: Hand) {
            System.out.println(c.getSuit() + c.getCardNumb());
        }
        System.out.println("For a total score of " + score);
    }

    public int scoreCounter(){
        int score = 0;
        for (Card c: Hand) {
            score +=c.getCardValue();
            System.out.println(score);
        }
        return score;
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



