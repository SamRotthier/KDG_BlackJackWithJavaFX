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
            player1.dealCard(Deck);
            dealer1.dealCard(Deck);
            dealer1.toHitOrNotToHit(Deck);

        }
    }

     public void dealingCards (){
        player1.dealCard(Deck);
        player1.placeBet(player1.getPlayerBet());
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
         if (player1.getTotalCardValue() < 21) {
         player1.playerDouble(Deck);
         }else{
             checkingScore();
         }
     }
    public void btnStand(){
         dealer1.toHitOrNotToHit(Deck);
         checkingScore();

         //message who won and how much
    }

     public void checkingScore(){
         int dealerScore = dealer1.getTotalCardValue();
         int playerScore = player1.getTotalCardValue();
         if((dealerScore == 21 && playerScore != 21) ||(dealerScore > playerScore && dealerScore <22)|| (playerScore>21 && dealerScore <22)){
             //System.out.println("Dealer wins");
         }
         else if((playerScore == 21 && dealerScore != 21 )||(playerScore > dealerScore && playerScore <22) || (dealerScore>21 && playerScore <22)){
             //System.out.println("Player wins");
             player1.winRound();
         } else if (dealerScore == 21 && playerScore == 21) {
             player1.pushRound();
         } else
         {
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
         if((player1.getPlayerBet()-5) >= 0){
         player1.setPlayerBet(player1.getPlayerBet()-5);
        }else if((player1.getPlayerBet()-5) < 0){
            player1.setPlayerBet(0);
         }
     }

        public void txtSetBet(int betAmount){
         player1.setPlayerBet(betAmount);
        }


 }

