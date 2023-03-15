package ConsoleApp.BlackJack;

import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

public class BlackJackGame {
    static Player Player1 = new Player();

    public void gameHandler() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Random randomGenerator = new Random();
        boolean keepPlaying = true;

        while(keepPlaying) {
            boolean bettingAmountOk = true;
            boolean drawMoreCards = true;

            //Dit moet terug in object player gestoken worden!
            while (bettingAmountOk) {
                System.out.println("What is the amount you want to bed this round?");
                int bettingAmount = input.nextInt();
                if (bettingAmount <= 0) {
                    System.out.println("The house doesn't play for free");
                } else if (bettingAmount > Player1.getBank()) {
                    System.out.println("Looks like you're too broke, you are trying to bet more then what you have");
                } else if (bettingAmount <= Player1.getBank()) {
                    bettingAmountOk = false;
                    Player1.setPlayerBet(bettingAmount);
                }
            }

            dealTwoCards();

            System.out.println("You have these cards in your hand");
            int score = 0;
            for (int value: Player1.getHand()) {
                score +=value;
                System.out.println(value);

            }
            System.out.println("For a total score of " + score);

            //System.out.println(Player1.getHand().size()); //debugging prints
            //System.out.println(Player1.getHand());        //debugging prints


            //Put in seperate method
            while (drawMoreCards) {
                System.out.println("What would you like to do? Hit or Stand");
                String playerChoice = input.nextLine();
                if (playerChoice.equals("Hit")) {
                    Player1.getHand().add(randomGenerator.nextInt(9) + 1);
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



            // Put this in a seperate method.
            System.out.println("Do you wish to play another round? Yes or No");
            String keepPlayingInput = input.nextLine();
            if (keepPlayingInput.equals("Yes")) {
                System.out.println("Let's start that next round");
                Player1.getHand().clear();
                Thread.sleep(2000);
            } else if (keepPlayingInput.equals("No")) {
                keepPlaying = false;
            }
        }
    }

    public static void dealTwoCards(){
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

}
