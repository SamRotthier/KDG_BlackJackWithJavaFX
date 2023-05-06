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
            player1.showHand();
            dealer1.dealCard(Deck);

            nextMove();


            dealer1.showHand();
            gameEnding ();

        }
    }

    public void nextMove(){
    boolean drawMoreCards = true;
    Scanner input = new Scanner(System.in);
                while (drawMoreCards) {
        System.out.println("What would you like to do? Hit or Stand");
        String playerChoice = input.nextLine();
        if (playerChoice.equals("Hit")) {
            player1.hit(Deck);
            int newScore = 0;
            for (Card c: player1.getHand()) {
                newScore +=c.getCardValue();
                System.out.println(c.getCardValue());
            }
            System.out.println("For a total score of " + newScore);
        } else if (playerChoice.equals("Stand")) {
            drawMoreCards = false;
        }
    }
    }

    public void gameEnding() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you wish to play another round? Yes or No");
        String keepPlayingInput = input.nextLine();
        if (keepPlayingInput.equals("Yes")) {
            System.out.println("Let's start that next round");
            player1.getHand().clear();
            Thread.sleep(2000);
        } else if (keepPlayingInput.equals("No")) {
            keepPlaying = false;
        }

    }
}

