package ConsoleApp.BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends CardHandler {

    private static int bank = 0;
    private static boolean win = false;
    private static boolean lose = false;



    public  int Bet(int bank){
        Scanner bettingAmount = new Scanner(System.in);
        int amountBet = 0;

        System.out.println("Please enter the amount you want to bet");
        amountBet = bettingAmount.nextInt();

        while (amountBet>bank){
            System.out.println("You want to bet more then is in your bank, please enter a lower amount");
            amountBet = bettingAmount.nextInt();
        }

        return amountBet;
    }
    public int PlayerBank(int amountBet){

        if (win){
          bank += amountBet;
        } else if (lose) {
            bank -= amountBet;
        }
        return bank;
    }



    public  int playerDouble(int score){

        return score;
    }

    public  int playerSplit(int score){


        return score;
    }

    //Getter
    public int getBank() {
        return bank;
    }

    public boolean isWin() {
        return win;
    }

    public boolean isLose() {
        return lose;
    }

    //setter
    public void setBank(int bank) {
        Player.bank = bank;
    }

    public void setWin(boolean win) {
        Player.win = win;
    }

    public void setLose(boolean lose) {
        Player.lose = lose;
    }

    //Constructor
    public Player() {
    }
}
