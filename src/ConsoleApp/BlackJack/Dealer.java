package ConsoleApp.BlackJack;

import java.util.ArrayList;

public class Dealer extends CardHandler{

    public void toHitOrNotToHit(ArrayList<Card> Deck){
        int cardValue= getTotalCardValue();
        while(cardValue <= 18){
            hit(Deck);
            cardValue = getTotalCardValue();
        }
    }



}
