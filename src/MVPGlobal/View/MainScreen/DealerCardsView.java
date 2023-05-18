package MVPGlobal.View.MainScreen;

import MVPGlobal.Model.Card;
import MVPGlobal.View.UISettings;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class DealerCardsView extends StackPane {

    private UISettings uiSettings;
    private Image backCard;
    private ImageView backCardView;

    public static ArrayList<Card> dealerCards = new ArrayList<Card>();
    private Image card;
    private ImageView cardView;

    private double offsetX;
    private double rotate;



    public DealerCardsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.card = new Image("images/cards/clubs2.png");
        cardView = new ImageView(card);

        this.backCard = new Image("images/cards/backCards.png");
        backCardView = new ImageView(backCard);

        offsetX = 70;
        rotate = 5;
    }

    private void layoutNodes() {
        cardView.setPreserveRatio(true);
        cardView.setFitWidth(uiSettings.getCardWidth());
        cardView.setFitHeight(uiSettings.getCardHeight());
        cardView.setRotate(-uiSettings.getCardRotate());

        backCardView.setPreserveRatio(true);
        backCardView.setFitWidth(uiSettings.getCardWidth());
        backCardView.setFitHeight(uiSettings.getCardHeight());
        backCardView.setTranslateX(uiSettings.getCardOffsetX());
        backCardView.setRotate(uiSettings.getCardRotate());

        getChildren().addAll(cardView, backCardView);

    }
    ArrayList<Card> getDealerCards() {
        return dealerCards;
    }
}
