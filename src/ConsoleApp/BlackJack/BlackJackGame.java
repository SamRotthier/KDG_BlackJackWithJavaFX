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

            dealCard();

            showHand();

            hitOrStand();

            gameEnding (keepPlaying);

        }
    }

    public void dealTwoCards(){
        Random randomGenerator = new Random();
        try {
            if (Player1.getHand().size() == 0) {
                for (int i = 1; i <= 2; i++) {
                    Player1.getHand().add(randomGenerator.nextInt(9) + 1);
                }

            }
        }
        catch (Exception e){
            System.out.println("Player already has cards in his hand.");
        }
    }

    public void dealCard(){
        Random randomGenerator = new Random();
        try {
            if (Player1.getHand().size() == 0) {
                for (int i = 1; i <= 2; i++) {
                    Player1.getHand().add(randomGenerator.nextInt(9) + 1);
                }
            } else{
                Player1.getHand().add(randomGenerator.nextInt(9) + 1);
            }

        }
        catch (Exception e){
            System.out.println("Something went wrong while dealing a card");
        }
    }

    public void showHand(){
            System.out.println("You have these cards in your hand");
    int score = 0;
            for (int value: Player1.getHand()) {
        score +=value;
        System.out.println(value);
    }
            System.out.println("For a total score of " + score);
    }
    public void hitOrStand(){
    boolean drawMoreCards = true;
    Scanner input = new Scanner(System.in);
                while (drawMoreCards) {
        System.out.println("What would you like to do? Hit or Stand");
        String playerChoice = input.nextLine();
        if (playerChoice.equals("Hit")) {
            dealCard();
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

