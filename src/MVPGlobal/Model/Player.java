package MVPGlobal.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends CardHandler {
    private int playerBet;
    private int bank = 0;


     void placeBet(){
        Scanner input = new Scanner(System.in);
        boolean bettingAmountOk= true;
        int bettingAmount = input.nextInt();
        while (bettingAmountOk) {
            if (bettingAmount <= 0) {
                //System.out.println("The house doesn't play for free");
            } else if (bettingAmount > bank) {
                //System.out.println("Looks like you're too broke, you are trying to bet more then what you have");
            } else {
                bettingAmountOk = false;
                playerBet = bettingAmount;
                bank -= bettingAmount;
            }
        }
    }

     void winRound(){
          bank += playerBet;
    }



      void playerDouble(ArrayList<Card> Deck){
        if(bank >= (playerBet*2)) {
            playerBet *= 2;
            hitCard(Deck);
        }
        else {
            System.out.println("Looks like you're too broke, you are trying to bet more then what you have");

        }
    }

      int playerSplit(int score){

        return score;
    }

    //Getter
     int getBank() {
        return bank;
    }


      int getPlayerBet() {
        return playerBet;
    }

    //setter
     void setBank(int bank) {
        bank = bank;
    }

     void setPlayerBet(int playerBet) {
        playerBet = playerBet;
    }

    //Constructor
     Player() {
      playerBet = 0;
      bank = 500;
    }
}
