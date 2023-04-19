package ConsoleApp.BlackJack;

import java.security.PublicKey;
import java.util.ArrayList;



public class DeckBuilder {
  String[] suits = {"spades", "hearts", "clubs", "diams"};
  String[] numb = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};

  public String[] AssemblingDeck(){
   for(String s : suits){
       String suit = s.toUpperCase()[0];

            for(String n : numb){


                var cardValue = (n > 9) ? 10 : parseInt(n) + 1;
                var card = {
                        suit: suit,
                        icon: suits[s],
                        bgcolor: bgcolor,
                        cardnum: numb[n],
                        cardValue: cardValue

            }



    }
      return new String[0];
  }

  }

