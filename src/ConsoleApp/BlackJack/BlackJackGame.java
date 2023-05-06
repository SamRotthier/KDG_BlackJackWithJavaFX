package ConsoleApp.BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackGame {
     Player player1 = new Player();
     Dealer dealer1 = new Dealer();
    boolean keepPlaying = true;
    ArrayList<Card> Deck = DeckBuilder.PlayDeck(1);

    public void gameHandler() throws InterruptedException {

        keepPlaying = true;
        while(keepPlaying) {

            player1.placeBet();

            player1.dealCard(Deck);
            System.out.println("Player");
            player1.showHand();
            dealer1.dealCard(Deck);

            nextMove();

            dealer1.toHitOrNotToHit(Deck);
            System.out.println("Dealer");
            dealer1.showHand();

            gameEnding ();

        }
    }

    public void nextMove(){
    boolean drawMoreCards = true;
    Scanner input = new Scanner(System.in);
                while (drawMoreCards) {
        System.out.println("What would you like to do? Hit, double or Stand");
        String playerChoice = input.nextLine();
        int newScore = 0;
        if (playerChoice.equals("Hit")) {
            player1.hit(Deck);
            newScore = player1.getTotalCardValue();
            System.out.println("For a total score of " + newScore);
        } else if (playerChoice.equals("double")) {
            player1.playerDouble(Deck);
            newScore = player1.getTotalCardValue();
            System.out.println("For a total score of " + newScore);
        } else if (playerChoice.equals("Stand")) {
            drawMoreCards = false;
        }
    }
    }

    public void gameEnding() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        if(dealer1.getTotalCardValue() == 21 ||(dealer1.getTotalCardValue() > player1.getTotalCardValue()) && (dealer1.getTotalCardValue() <22) ){
            System.out.println("Dealer wins");
            System.out.println("Player has " + player1.getBank() + " in his bank");
        }
        else if(player1.getTotalCardValue() == 21 || ((player1.getTotalCardValue() > dealer1.getTotalCardValue()) && (player1.getTotalCardValue() <22) )){
            System.out.println("Player wins");
            player1.winRound();
            System.out.println("Player has " + player1.getBank() + " in his bank");
        }
        else {
            System.out.println("No Winners");
        }
        Thread.sleep(1000);


        System.out.println("Do you wish to play another round? Yes or No");
        String keepPlayingInput = input.nextLine();
        if (keepPlayingInput.equals("Yes")) {
            System.out.println("Let's start that next round");
            player1.getHand().clear();
            dealer1.getHand().clear();
            Thread.sleep(2000);
        } else if (keepPlayingInput.equals("No")) {
            keepPlaying = false;
            System.out.println("Thanks for playing");
        }

    }
}

