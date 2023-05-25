package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * This is the bottom label view
 * This is the part that gets displayed at the bottom of the game
 * It contains the player saldo, bet, cardvalue, name
 */
public class BottomLabelsView extends HBox {
    private UISettings uiSettings;
    private Label saldoLabel;
    private Label betAmountLabel;
    private Label cardScoreLabel;
    private Label saldoLabelPlayer;
    private Label betAmountLabelPlayer;
    private Label cardScorePlayer;
    private Label playerNameLabel;
    private Label playerName;

    /**
     * This is the constructor
     *
     * @param uiSettings
     */
    public BottomLabelsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    /**
     * All the right elements get initialized here
     */
    private void initialiseNodes() {
        this.saldoLabel = new Label("Saldo: ");
        this.betAmountLabel = new Label("Bet amount: ");
        this.cardScoreLabel = new Label("Card Score: ");
        this.playerNameLabel = new Label("Player Name: ");
        this.saldoLabelPlayer = new Label("");
        this.betAmountLabelPlayer = new Label("");
        this.cardScorePlayer = new Label("");
        this.playerName = new Label("");
    }

    /**
     * The nodes get the right layout in this method
     */
    private void layoutNodes() {
        this.setSpacing(uiSettings.getSpacing()/1.30);
        this.setPadding(new Insets(uiSettings.getInsetsMargin()/2.5, uiSettings.getInsetsMargin(), uiSettings.getInsetsMargin()/2.5, uiSettings.getInsetsMargin()));
        BackgroundFill bottomFill = new BackgroundFill(Color.web("#22222c"), CornerRadii.EMPTY, Insets.EMPTY);
        Background bottomBackground = new Background(bottomFill);
        this.setBackground(bottomBackground);
        this.getChildren().addAll(saldoLabel, saldoLabelPlayer, betAmountLabel, betAmountLabelPlayer,cardScoreLabel,cardScorePlayer,playerNameLabel,playerName);

        setMargin(this.getChildren().get(2), new Insets(0,0,0,uiSettings.getInsetsMargin()*4));
        setMargin(this.getChildren().get(4), new Insets(0,0,0,uiSettings.getInsetsMargin()*16));
        setMargin(this.getChildren().get(6), new Insets(0,0,0,uiSettings.getInsetsMargin()*18));
    }

    //Getters
    public Label getSaldoLabelPlayer() {
        return saldoLabelPlayer;
    }

    public Label getBetAmountLabelPlayer() {
        return betAmountLabelPlayer;
    }

    public Label getCardScorePlayer() {
        return cardScorePlayer;
    }

    public Label getPlayerName() {
        return playerName;
    }


}
