package MVPGlobal.Model;

import java.util.ArrayList;

/**
 * This is the class for the dealer
 * The Dealer is the main "opponent" in blackjack
 * You play against the dealer to get the most score
 * The dealer class also extends the abstract class card handler
 *
 * @author Sam Rotthier
 * @author Matthias Vermeiren
 * @version 3.0
 */
 public class Dealer extends CardHandler {

    /**
     * When it is the dealers time to draw cards from the deck
     * The dealer will continue to take cards while his total score is lower than 17
     *
     * @param Deck, this is an ArrayList of Cards
     */
     void toHitOrNotToHit(ArrayList<Card> Deck){
        int cardValue= getTotalCardValue();
        while(cardValue < 17){
            hitCard(Deck);
            cardValue = getTotalCardValue();
        }
    }



}
