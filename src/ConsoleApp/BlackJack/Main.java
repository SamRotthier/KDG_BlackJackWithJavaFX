package ConsoleApp.BlackJack;

import com.sun.source.tree.DoWhileLoopTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        BlackJackGame game = new BlackJackGame();

        System.out.println("Welcome to Matthias and sam's blackjack");
        System.out.println("Please enter \"Play\" to start the game or \"Rules\" to get the rules of blackjack ");
        String startInput = input.nextLine();
        if (startInput.equals("Play")){
            game.gameHandler();
        }
        else if (startInput.equals("Rules")){
            //Set in own method
            System.out.println("In BlackJack you play against the dealer. ");
            System.out.println("the goal is to get a card score of 21.");
            System.out.println("If you are not lucky and get over 21, you lose the round.");
            System.out.println("If you have a score lower then 21 you can chose hit or stand:");
            System.out.println("When you chose hit you get another card.");
            System.out.println("when you chose stand you stay with the cards that you have.");
            System.out.println("if neither you or the dealer have 21 the closest score to 21 wins.");
            System.out.println("");
            System.out.println("Would you like to play the game now? Yes or No");
            startInput = input.nextLine();
            if (startInput.equals("Yes")){
                game.gameHandler();
            } else if (startInput.equals("No")) {
                System.out.println("We hope to see you another time!");
            }
        }
    }
}