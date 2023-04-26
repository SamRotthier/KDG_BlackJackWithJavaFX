package ConsoleApp.BlackJack;

import java.util.ArrayList;

public class Dealer extends CardHandler{

    public void toHitOrNotToHit(ArrayList<Integer> Hand){
        int score= scoreCounter();
        if(score <= 18){
            hit();
        }
        else {
            stand();
        }
    }



}
