package ConsoleApp.BlackJack;

import com.sun.source.tree.DoWhileLoopTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BlackJackGame currentGame = new BlackJackGame();


        System.out.println("Welcome to Matthias and sam's blackjack");
        System.out.println("Please enter \"Play\" to start the game");
        String startGame = input.nextLine();
        if (startGame.equals("Play")){
         BlackJackGame.playGame();
        }

    }
}