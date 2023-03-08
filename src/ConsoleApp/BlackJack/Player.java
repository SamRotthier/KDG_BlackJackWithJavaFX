package ConsoleApp.BlackJack;

public class Player {
   private static int cardValue = 0;


    public static int playerBet(int score){


        score += cardValue;
        return score;
    }

    public static int playerHit(int score){


        score += cardValue;
        return score;
    }

    public static int playerStand(int score){

        return score;
    }

    public static int playerDouble(int score){

        return score;
    }

    public static int playerSplit(int score){

        score += cardValue;
        return score;
    }


}
