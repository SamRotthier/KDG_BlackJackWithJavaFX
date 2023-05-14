package ConsoleApp.BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends CardHandler {


    private boolean win = false;
    private int playerBet;
    private int bank = 0;


    public void placeBet(){
        Scanner input = new Scanner(System.in);
        boolean bettingAmountOk= true;
        System.out.println("What is the amount you want to bet this round?");
        int bettingAmount = input.nextInt();
        while (bettingAmountOk) {
            if (bettingAmount <= 0) {
                System.out.println("The house doesn't play for free");
            } else if (bettingAmount > bank) {
                System.out.println("Looks like you're too broke, you are trying to bet more then what you have");
            } else {
                bettingAmountOk = false;
                playerBet = bettingAmount;
                bank -= bettingAmount;
            }
        }
    }

    public void winRound(){
          bank += playerBet;
    }



    public  void playerDouble(ArrayList<Card> Deck){
        if(bank >= (playerBet*2)) {
            playerBet *= 2;
            hit(Deck);
        }
        else {
            System.out.println("Looks like you're too broke, you are trying to bet more then what you have");

        }
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


    public  int getPlayerBet() {
        return playerBet;
    }

    //setter
    public void setBank(int bank) {
        bank = bank;
    }

    public void setWin(boolean win) {
        win = win;
    }


    public void setPlayerBet(int playerBet) {
        playerBet = playerBet;
    }

    //Constructor
    public Player() {
      playerBet = 0;
      bank = 500;
    }
}
