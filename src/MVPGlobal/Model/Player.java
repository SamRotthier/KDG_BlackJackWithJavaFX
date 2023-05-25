package MVPGlobal.Model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the class for the player
 * The player is the main character in blackjack
 * You play against the dealer to get the most score
 * The player class also extends the abstract class card handler
 *
 * @author Sam Rotthier
 * @author Matthias Vermeiren
 * @version 3.0
 */
public class Player extends CardHandler {
    private int playerBet;
    private int bank = 0;

    private String playerName;

    /**
     * This is the place bet method
     * It functions so the player can place a bet, and it is retracted from his saldo
     * You play against the dealer to get the most score
     *
     * @param bettingAmount, this is the value of the bet
     */
    void placeBet(int bettingAmount) {
        boolean bettingAmountOk = true;
        while (bettingAmountOk) {
            if (bettingAmount <= 0) {
                System.out.println("The house doesn't play for free");
            } else if (bettingAmount > bank) {
                System.out.println("Looks like you're too broke, you are trying to bet more then what you have");
            } else {
                bettingAmountOk = false;
                bank -= bettingAmount;
            }
        }
    }

    /**
     * This is the win round method
     * it will add the winnings to the players saldo
     */
    void winRound() {
        bank += playerBet * 2;
    }

    /**
     * This is the push round method
     * it will add the push to the players saldo
     */
    void pushRound() {
        bank += playerBet;
    }

    /**
     * This is the player double method
     * it will double the players bet
     *
     * @param Deck, this is an ArrayList of Cards
     */
    void playerDouble(ArrayList<Card> Deck) {
        if (bank >= (playerBet * 2)) {
            bank -= playerBet;
            playerBet *= 2;
            hitCard(Deck);
        } else {
            System.out.println("Looks like you're too broke, you are trying to bet more then what you have");
        }
    }


    //Getter
    public int getBank() {
        return bank;
    }

    public int getPlayerBet() {
        return playerBet;
    }

    public String getPlayerName() {
        return playerName;
    }


    //setter
    public void setBank(int bank) {
        this.bank = bank;
    }

    public void setPlayerBet(int playerBet) {
        this.playerBet = playerBet;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    //Constructor
    Player() {
        playerBet = 0;
        bank = 500; //Standard we start with 500 unless you load a save file
    }
}
