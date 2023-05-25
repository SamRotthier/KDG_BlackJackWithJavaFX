package MVPGlobal.View.MainScreen;

import MVPGlobal.Model.Card;
import MVPGlobal.View.UISettings;
import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * This is the view class that shows the cards of the player.
 *
 * @author Sam Rotthier
 * @author Matthias Vermeiren
 * @version 3.0
 */

public class PlayerCardsView extends StackPane {

    private UISettings uiSettings;
    public ArrayList<Card> playerCards = new ArrayList<Card>();
    private Image card;
    private ImageView cardView;


    public PlayerCardsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
    }

    private void layoutNodes() {
        this.setAlignment(Pos.CENTER);
    }

    //Methods

    /**
     * This method adds a card to the screen for the player by looping through the arraylist.
     * Each card in the hand is added to an ImageView.
     * The x, r and y parameters are used to set the position and rotation of each card, to mimic a person holding cards.
     */
    public void addCard() {
        this.getChildren().clear();
        int x = 0;
        int r = -2;
        int y = 0;

        for (Card c : playerCards) {
            String cardNamePath = c.getSuit() + c.getCardNumb();
            try {
                card = new Image(uiSettings.getCardImage().toUri().toURL() + cardNamePath + ".png");
            } catch (MalformedURLException ex) {
            }

            cardView = new ImageView(card);
            cardView.setPreserveRatio(true);
            cardView.setFitWidth(uiSettings.getCardWidth());
            cardView.setFitHeight(uiSettings.getCardHeight());
            this.getChildren().add(cardView);

            cardView.setTranslateX(uiSettings.getCardOffsetX() * x);
            cardView.setTranslateY(-(uiSettings.getCardOffsetY() + (y * 5)));
            if (playerCards.size() <= 3 && r == -2) {
                r = -1;
            }
            cardView.setRotate(uiSettings.getCardRotate() * r);

            x++;
            r++;
            if (y < ((playerCards.size() / 2))) {
                y++;
            } else {
                y--;
            }
        }
    }

    // Getters
    ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public ImageView getCardView() {
        return cardView;
    }

}
