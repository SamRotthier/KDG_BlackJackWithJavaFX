package MVPGlobal.Model;

import java.util.ArrayList;

/**
 *
 * This is the model for our Blackjack game.
 * In this class you'll find all the methods that get called from the presenters.
 *
 * @author Sam Rotthier
 * @author Matthias Vermeiren
 * @version 3.0
 */

public class BlackJackGame {

    public Player player = new Player();
    public Dealer dealer = new Dealer();
    public SoundsPlayer sounds = new SoundsPlayer();

    //When the deck is initialized it makes a package of cards that's 2 normal decks big.(changeable)
    ArrayList<Card> deck = DeckBuilder.playDeck(2);


    /**
     * This is the method for dealing the start cards to the player and the dealer.
     * It first checks the amount of cards that are still in the Deck and makes a new one if needed.
     * The players bet also get locked in here.
     */
    public void dealingCards() {
        checkDeckSize(20);

        player.dealCard(deck);
        player.placeBet(player.getPlayerBet());
        dealer.dealCard(deck);
    }

    /**
     * This is the method for dealing a card to the player.
     * It first checks the amount of cards that are still in the Deck and makes a new one if needed.
     * If the players total card value is under 21(no blackjack or bust), the player is allowed to take more cards.
     * If the total card value is 21 or higher we go to the cheching score method.
     */
    public void btnHit() {

        checkDeckSize(10);

        if (player.getTotalCardValue() < 21) {
            player.hitCard(deck);
        } else {
            checkingScore();
        }
    }

    /**
     * This is the method for dealing a card to the player and doubling the bet.
     * It first checks the amount of cards that are still in the Deck and makes a new one if needed.
     * If the players total card value is under 21(no blackjack or bust), the player is allowed to take more cards.
     * If the total card value is 21 or higher we go to the cheching score method.
     */
    public void btnDouble() {
      checkDeckSize(10);

        if (player.getTotalCardValue() < 21) {
            player.playerDouble(deck);
        } else {
            checkingScore();
        }
    }

    /**
     * This is the method for the player to tell the game he is done taking cards (or is not allowed to anymore).
     * When the player stops taking cards, it is the turn of the dealer if the player does not have a card score
     * over 21. Otherwise, the dealer will stand soo with the 2 cards from the dealing cards method.
     * After this we go to the checking score method.
     */
    public void btnStand() {
        if (!(player.getTotalCardValue() > 21)) {
            dealer.toHitOrNotToHit(deck);
        }
        checkingScore();
    }

    /**
     * This is the method for checking if the size of the deck is still large enough.
     * If the stack is not large enough we will assemble a new deck.
     * We do this so the game can be continuously played and to make card counting more difficult.
     *
     * @param i ,This is an integer to tell the check how large the size must be.
     */
    private void checkDeckSize(int i){
        if (deck.size() < i) {
            deck = DeckBuilder.playDeck(2);
        }
    }

    /**
     * This is the method for checking the score and determine the payout to the player.
     * If the player wins he gets to win the round.
     * if the player and the dealer both have 21 the game is a push.
     */
    public void checkingScore() {
        int dealerScore = dealer.getTotalCardValue();
        int playerScore = player.getTotalCardValue();
        if ((dealerScore == 21 && playerScore != 21) || (dealerScore > playerScore && dealerScore < 22) || (playerScore > 21 && dealerScore < 22)) {
            //System.out.println("Dealer wins");
        } else if ((playerScore == 21 && dealerScore != 21) || (playerScore > dealerScore && playerScore < 22) || (dealerScore > 21 && playerScore < 22)) {
            player.winRound();
        } else if ((playerScore < 22) && (playerScore == dealerScore)) {
            player.pushRound();
        } else {
        }
    }

    /**
     * This is the method for checking the score and determine who won (for the front-end).
     * It will return the name of the winner or push, so it can be displayed on the screen.
     *
     * @return a string with the winning person or push.
     */
    public String whoWon() {
        int dealerScore = dealer.getTotalCardValue();
        int playerScore = player.getTotalCardValue();
        if ((dealerScore == 21 && playerScore != 21) || (dealerScore > playerScore && dealerScore < 22) || (playerScore > 21 && dealerScore < 22)) {
            return "Dealer";
        } else if ((playerScore == 21 && dealerScore != 21) || (playerScore > dealerScore && playerScore < 22) || (dealerScore > 21 && playerScore < 22)) {
            return "Player";
        } else {
            return "Push";
        }
    }

    /**
     * This is the method for the player to tell the game to add 5 to the betting value.
     * If the player wants to add more than his bank value, it will take the bank value (as the max).
     * In other cases it adds 5 to the value.
     */
    public void btnAddBet() {
        if ((player.getPlayerBet() + 5)  >= player.getBank()){
            player.setPlayerBet(player.getBank());
        }else{
            player.setPlayerBet(player.getPlayerBet() + 5);
        }
    }


    /**
     * This is the method for the player to tell the game to subtract 5 to the betting value.
     * If the player wants to subtract more than 0, it will take 0 (as the min).
     * In other cases it subtracts 5 to the value.
     */
    public void btnSubBet() {
        if ((player.getPlayerBet() - 5) >= 0) {
            player.setPlayerBet(player.getPlayerBet() - 5);
        } else if ((player.getPlayerBet() - 5) < 0) {
            player.setPlayerBet(0);
        }
    }
}

