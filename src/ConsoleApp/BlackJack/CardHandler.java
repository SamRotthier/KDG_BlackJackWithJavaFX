package ConsoleApp.BlackJack;

import java.util.ArrayList;
import java.util.Random;

public abstract class CardHandler {

        private ArrayList<Integer> Hand = new ArrayList<Integer>();

    public void dealCard(){
        Random randomGenerator = new Random();
        try {
            if (Hand.size() == 0) {
                for (int i = 1; i <= 2; i++) {
                    Hand.add(randomGenerator.nextInt(9) + 1);
                }
            } else{
                Hand.add(randomGenerator.nextInt(9) + 1);
            }

        }
        catch (Exception e){
            System.out.println("Something went wrong while dealing a card");
        }
    }

        public void showHand(){
            System.out.println("You have these cards in your hand");
            int score = 0;
            for (int value: Hand) {
                score +=value;
                System.out.println(value);
            }
            System.out.println("For a total score of " + score);
        }


        public  int Hit(int score){


            return score;
        }

        public  int Stand(int score){

            return score;
        }

        //Getter
        public ArrayList<Integer> getHand() {
            return Hand;
        }
        //Setter
        public void setHand(ArrayList<Integer> hand) {
            Hand = hand;
        }






    }



