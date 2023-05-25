package MVPGlobal.View.MainScreen;

import MVPGlobal.Model.Card;
import MVPGlobal.View.UISettings;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * This is the dealer cards view
 * It handles the logic that goes into displaying the dealer's cards
 */
public class DealerCardsView extends StackPane {

    private UISettings uiSettings;
    public static ArrayList<Card> dealerCards = new ArrayList<Card>();
    private Image card;
    private ImageView cardView;

    /**
     * This is the constructor
     *
     * @param uiSettings
     */
    public DealerCardsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
    }

    private void layoutNodes() {
    }

    /**
     * This method will add the cards to the dealers part of the node for the start cards
     */
    public void addCardStart() {
        getChildren().clear();
        int x = 0;
        int r = -2;
        int y = 0;
        int i = 1;

        for (Card c : dealerCards) {
            if (dealerCards.size() <= 2 && i == 2) {
                try {
                    card = new Image(uiSettings.getCardImage().toUri().toURL() + "backCards.png");
                } catch (MalformedURLException ex) {
                    //Do nothing if failed
                }
            } else {
                String cardNamePath = c.getSuit() + c.getCardNumb();
                try {
                    card = new Image(uiSettings.getCardImage().toUri().toURL() + cardNamePath + ".png");
                } catch (MalformedURLException ex) {
                    //Do nothing if failed
                }
            }

            cardView = new ImageView(card);
            cardView.setPreserveRatio(true);
            cardView.setFitWidth(uiSettings.getCardWidth());
            cardView.setFitHeight(uiSettings.getCardHeight());
            cardView.setTranslateX(uiSettings.getCardOffsetX() * x);

            if (dealerCards.size() <= 2 && r == -2) {
                r = -1;
            }
            cardView.setRotate(uiSettings.getCardRotate() * r);
            cardView.setTranslateY(-(uiSettings.getCardOffsetY() + (y * 4)));
            getChildren().add(cardView);
            i++;
            x++;
            r++;

            if (y < ((dealerCards.size() / 2) - 1)) {
                y++;
            } else {
                y--;
            };
        }
    }

    /**
     * This method will add the cards to the dealers part of the node
     */
    public void addCardEnd() {
        getChildren().clear();
        int x = 0;
        int r = -2;
        int y = 0;

        for (Card c : dealerCards) {
                String cardNamePath = c.getSuit() + c.getCardNumb();
                try {
                    card = new Image(uiSettings.getCardImage().toUri().toURL() + cardNamePath + ".png");
                } catch (MalformedURLException ex) {
                    //Do nothing if failed
                }

            cardView = new ImageView(card);
            cardView.setPreserveRatio(true);
            cardView.setFitWidth(uiSettings.getCardWidth());
            cardView.setFitHeight(uiSettings.getCardHeight());
            cardView.setTranslateX(uiSettings.getCardOffsetX() * x);

            if (dealerCards.size() <= 2 && r == -2) {
                r = -1;
            }
            cardView.setRotate(uiSettings.getCardRotate() * r);
            cardView.setTranslateY(-(uiSettings.getCardOffsetY() + (y * 4)));
            getChildren().add(cardView);
            //sounds.playDealCard();
            x++;
            r++;

            if (y < ((dealerCards.size() / 2) - 1)) {
                y++;
            } else {
                y--;
            };
        }
    }

    ArrayList<Card> getDealerCards() {
        return dealerCards;
    }

    public ImageView getCardView() {
        return cardView;
    }
}
