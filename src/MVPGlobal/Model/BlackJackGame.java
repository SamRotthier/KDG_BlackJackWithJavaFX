package MVPGlobal.Model;

import java.util.ArrayList;
import java.util.Scanner;

 public class BlackJackGame {
     public Player player1 = new Player();
     public Dealer dealer1 = new Dealer();
    boolean keepPlaying = true;
    ArrayList<Card> Deck = DeckBuilder.PlayDeck(1);

     void gameHandler() throws InterruptedException {

        keepPlaying = true;
        while(keepPlaying) {

            player1.placeBet();

            player1.dealCard(Deck);
            System.out.println("Player");
            //player1.showHand();
            dealer1.dealCard(Deck);

            //nextMove();

            dealer1.toHitOrNotToHit(Deck);
            System.out.println("Dealer");
            //dealer1.showHand();

            //gameEnding ();

        }
    }

     public void dealingCards (){
        player1.dealCard(Deck);
        dealer1.dealCard(Deck);
    }

    public void btnHit (){
        player1.hitCard(Deck);
    }


}

