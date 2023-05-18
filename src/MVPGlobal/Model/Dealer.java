package MVPGlobal.Model;

import java.util.ArrayList;

 public class Dealer extends CardHandler {

     void toHitOrNotToHit(ArrayList<Card> Deck){
        int cardValue= getTotalCardValue();
        while(cardValue <= 18){
            hitCard(Deck);
            cardValue = getTotalCardValue();
        }
    }



}
