package ConsoleApp.BlackJack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJackGame {
     Player Player1 = new Player();

    public void gameHandler() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Random randomGenerator = new Random();
        boolean keepPlaying = true;
        ArrayList<Card> Deck = DeckBuilder.PlayDeck(1);

        while(keepPlaying) {

            Player1.placeBet();

            Player1.dealCard();

            Player1.showHand();

            hitOrStand();

            gameEnding (keepPlaying);

        }
    }

    public void hitOrStand(){
    boolean drawMoreCards = true;
    Scanner input = new Scanner(System.in);
                while (drawMoreCards) {
        System.out.println("What would you like to do? Hit or Stand");
        String playerChoice = input.nextLine();
        if (playerChoice.equals("Hit")) {
            Player1.dealCard();
            int newScore = 0;
            for (int value: Player1.getHand()) {
                newScore +=value;
                System.out.println(value);
            }
            System.out.println("For a total score of " + newScore);
        } else if (playerChoice.equals("Stand")) {
            drawMoreCards = false;

        }
    }
    }

    public boolean gameEnding(boolean keepPlaying) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you wish to play another round? Yes or No");
        String keepPlayingInput = input.nextLine();
        if (keepPlayingInput.equals("Yes")) {
            System.out.println("Let's start that next round");
            Player1.getHand().clear();
            Thread.sleep(2000);
        } else if (keepPlayingInput.equals("No")) {
            keepPlaying = false;
        }
        return keepPlaying;
    }
}

