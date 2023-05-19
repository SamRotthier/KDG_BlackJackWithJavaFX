package MVPGlobal.Model;

import java.security.PublicKey;
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
            dealer1.dealCard(Deck);
            dealer1.toHitOrNotToHit(Deck);

        }
    }

     public void dealingCards (){
        player1.dealCard(Deck);
        dealer1.dealCard(Deck);
    }

    public void btnHit (){
         if (player1.getTotalCardValue() < 21) {
             player1.hitCard(Deck);
         }else{
             checkingScore();
         }
    }
     public void btnDouble(){
         player1.playerDouble(Deck);
     }
    public void btnStand(){
         dealer1.toHitOrNotToHit(Deck);
         checkingScore();

         //message who won and how much
    }

     public void checkingScore(){
         if(dealer1.getTotalCardValue() == 21 && player1.getTotalCardValue() != 21 ||(dealer1.getTotalCardValue() > player1.getTotalCardValue()) && (dealer1.getTotalCardValue() <22) ){
             //System.out.println("Dealer wins");
         }
         else if(player1.getTotalCardValue() == 21 && dealer1.getTotalCardValue() != 21 || ((player1.getTotalCardValue() > dealer1.getTotalCardValue()) && (player1.getTotalCardValue() <22) )){
             //System.out.println("Player wins");
             player1.winRound();
         }
         else {
             //System.out.println("No Winners");
         }
         //System.out.println("Do you wish to play another round? Yes or No");

         }

        public void savingStats(){

        }

        public void btnAddBet(){
         player1.setPlayerBet(player1.getPlayerBet()+5);
        }

        public void btnSubBet(){
         player1.setPlayerBet(player1.getPlayerBet()-5);
        }

        public void txtSetBet(int betAmount){
         player1.setPlayerBet(betAmount);
        }
 }

