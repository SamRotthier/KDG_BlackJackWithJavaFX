package ConsoleApp.BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends CardHandler {

    private static int bank = 0;
    private static boolean win = false;
    private static boolean lose = false;

    private static int playerBet;



    //public  int Bet(int bank){
        //Scanner bettingAmount = new Scanner(System.in);
       // int amountBet = 0;

        //System.out.println("Please enter the amount you want to bet");
       // amountBet = bettingAmount.nextInt();

      //  while (amountBet>bank){
       //     System.out.println("You want to bet more then is in your bank, please enter a lower amount");
       //     amountBet = bettingAmount.nextInt();
      //  }

     //   return amountBet;
  //  }
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
