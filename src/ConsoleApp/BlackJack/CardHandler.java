package ConsoleApp.BlackJack;

import java.util.ArrayList;

    public abstract class CardHandler {

        private ArrayList<Integer> Hand = new ArrayList<Integer>();

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


