package MVPGlobal.Model;

import java.util.ArrayList;

/**
 *
 */
public class BlackJackGame {

    public Player player = new Player();
    public Dealer dealer = new Dealer();
    ArrayList<Card> deck = DeckBuilder.playDeck(2);

    public void dealingCards() {
        checkDeckSize(20);

        player.dealCard(deck);
        player.placeBet(player.getPlayerBet());
        dealer.dealCard(deck);
    }


    public void btnHit() {

        checkDeckSize(10);

        if (player.getTotalCardValue() < 21) {
            player.hitCard(deck);
        } else {
            checkingScore();
        }
    }

    public void btnDouble() {
      checkDeckSize(10);

        if (player.getTotalCardValue() < 21) {
            player.playerDouble(deck);
        } else {
            checkingScore();
        }
    }

    public void btnStand() {
        if (!(player.getTotalCardValue() > 21)) {
            dealer.toHitOrNotToHit(deck);
        }
        checkingScore();
    }

    private void checkDeckSize(int i){
        if (deck.size() < i) {
            deck = DeckBuilder.playDeck(2);
        }
    }

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

    public void btnAddBet() {
        player.setPlayerBet(player.getPlayerBet() + 5);
    }

    public void btnSubBet() {
        if ((player.getPlayerBet() - 5) >= 0) {
            player.setPlayerBet(player.getPlayerBet() - 5);
        } else if ((player.getPlayerBet() - 5) < 0) {
            player.setPlayerBet(0);
        }
    }
}

