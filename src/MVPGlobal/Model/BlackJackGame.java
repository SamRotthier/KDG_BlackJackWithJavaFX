package MVPGlobal.Model;

import java.util.ArrayList;

public class BlackJackGame {
     public Player player1 = new Player();
     public Dealer dealer1 = new Dealer();
    boolean keepPlaying = true;
    ArrayList<Card> deck = DeckBuilder.playDeck(2);

     public void dealingCards (){
         if (deck.size() < 20){
             deck = DeckBuilder.playDeck(2);
         }
        player1.dealCard(deck);
        player1.placeBet(player1.getPlayerBet());
        dealer1.dealCard(deck);
    }

    public void btnHit (){
        if (deck.size() < 10){
            deck = DeckBuilder.playDeck(2);
        }
         if (player1.getTotalCardValue() < 21) {
             player1.hitCard(deck);
         }else{
             checkingScore();
         }
    }
     public void btnDouble(){
         if (deck.size() < 10){
             deck = DeckBuilder.playDeck(2);
         }
         if (player1.getTotalCardValue() < 21) {
         player1.playerDouble(deck);
         }else{
             checkingScore();
         }
     }
    public void btnStand(){
         if (!(player1.getTotalCardValue()>21)) {
             dealer1.toHitOrNotToHit(deck);
         }
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
         } else if ((playerScore <22) && (playerScore == dealerScore)) {
             player1.pushRound();
         } else
         {
             //System.out.println("No Winners");
         }
         //System.out.println("Do you wish to play another round? Yes or No");
         }
     public String whoWon(){
         int dealerScore = dealer1.getTotalCardValue();
         int playerScore = player1.getTotalCardValue();
         if((dealerScore == 21 && playerScore != 21) ||(dealerScore > playerScore && dealerScore <22)|| (playerScore>21 && dealerScore <22)){
             return "Dealer";
         }
         else if((playerScore == 21 && dealerScore != 21 )||(playerScore > dealerScore && playerScore <22) || (dealerScore>21 && playerScore <22)){
             return "Player";
         } else {
             return "Push";
         }
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

