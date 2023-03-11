package ConsoleApp.BlackJack;

import java.util.Formatter;
import java.util.Random;

public class BlackJackGame {
        static Player Player1 = new Player();

        static boolean test = true;

    public static void playGame() {
        dealTwoCards();

        System.out.println(Player1.getHand().size());
        System.out.println(Player1.getHand());

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
    System.out.println("Player already had cards in his hand.");
}
    }

}
