package MVPGlobal.Model;

import java.util.ArrayList;

/**
 * This is the class for
 */
 public class Dealer extends CardHandler {

     void toHitOrNotToHit(ArrayList<Card> Deck){
        int cardValue= getTotalCardValue();
        while(cardValue <= 18){
            hitCard(Deck);
            cardValue = getTotalCardValue();
        }
    }



}
