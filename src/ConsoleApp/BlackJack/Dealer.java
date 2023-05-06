package ConsoleApp.BlackJack;

import java.util.ArrayList;

public class Dealer extends CardHandler{

    public void toHitOrNotToHit(ArrayList<Integer> Hand, ArrayList<Card> Deck){
        int score= scoreCounter();
        if(score <= 18){
            hit(Deck);
        }
        else {
            stand();
        }
    }



}
