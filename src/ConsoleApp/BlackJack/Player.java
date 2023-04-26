package ConsoleApp.BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends CardHandler {


    private static boolean win = false;
    private static boolean lose = false;
    private static int playerBet;
    private static int bank = 0;


    public void placeBet(){
        Scanner input = new Scanner(System.in);
        boolean bettingAmountOk= true;
        System.out.println("What is the amount you want to bed this round?");
        int bettingAmount = input.nextInt();
        while (bettingAmountOk) {
            if (bettingAmount <= 0) {
                System.out.println("The house doesn't play for free");
            } else if (bettingAmount > Player.bank) {
                System.out.println("Looks like you're too broke, you are trying to bet more then what you have");
            } else {
                bettingAmountOk = false;
                Player.playerBet = bettingAmount;
            }
        }
    }

    public int PlayerBank(int BettingAmount){

        if (win){
          bank += BettingAmount;
        } else if (lose) {
            bank -= BettingAmount;
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

    public static int getPlayerBet() {
        return playerBet;
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

    public  void setPlayerBet(int playerBet) {
        Player.playerBet = playerBet;
    }

    //Constructor
    public Player() {
      playerBet = 0;
      bank = 500;
    }
}
