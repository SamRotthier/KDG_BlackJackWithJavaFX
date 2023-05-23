package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


public class WinLoseView extends VBox {
    private UISettings uiSettings;
    private Button nextRound;
    private Button saveGame;
    private Button quitGame;
    private Label winGame;
    private Label loseGame;
    private Label gameOver;
    private Label pushGame;
    private Label dealerScore;


    private HBox buttonsGame;

    public WinLoseView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        nextRound = new Button("NEXT");
        saveGame = new Button("SAVE");
        quitGame = new Button("QUIT");

        winGame = new Label("Congratulations, you've won!");
        loseGame = new Label("You Lose! Better luck next time...");
        pushGame = new Label("Push! The game results in a tie");
        gameOver = new Label("GAME OVER");
        dealerScore = new Label("");
    }

    private void layoutNodes() {
        buttonsGame = new HBox(nextRound, saveGame, quitGame);
        buttonsGame.setSpacing(uiSettings.getSpacing() * 4);
        buttonsGame.setPadding(new Insets(uiSettings.getInsetsMargin() * 2));
        buttonsGame.setAlignment(Pos.CENTER);

        dealerScore.getStyleClass().add("dealerScore");
        dealerScore.setPadding(new Insets(0,0,uiSettings.getInsetsMargin()*10,0));
        this.setAlignment(Pos.CENTER);
    }

    //method
    public Label gameRound(int i) {
        if (i == 1) {
            winGame.getStyleClass().add("win");
            winGame.setPadding(new Insets(uiSettings.getInsetsMargin()*3.5,uiSettings.getInsetsMargin()*3.5,uiSettings.getInsetsMargin() * 2,uiSettings.getInsetsMargin()*3.5));
            return winGame;
        } else if (i == 2) {
            loseGame.getStyleClass().add("lose");
            loseGame.setPadding(new Insets(uiSettings.getInsetsMargin()*3.5,uiSettings.getInsetsMargin()*3.5,uiSettings.getInsetsMargin() * 2,uiSettings.getInsetsMargin()*3.5));
            return loseGame;
        } else if (i == 3) {
            gameOver.getStyleClass().add("gameover");
            gameOver.setPadding(new Insets(uiSettings.getInsetsMargin()*3.5,uiSettings.getInsetsMargin()*3.5,uiSettings.getInsetsMargin() * 2,uiSettings.getInsetsMargin()*3.5));
            return gameOver;
        } else {
            pushGame.getStyleClass().add("push");
            pushGame.setPadding(new Insets(uiSettings.getInsetsMargin()*3.5,uiSettings.getInsetsMargin()*3.5,uiSettings.getInsetsMargin() * 2,uiSettings.getInsetsMargin()*3.5));
            return pushGame;
        }
    }


    //Getters
    public Button getNextRound() {
        return nextRound;
    }

    public Button getSaveGame() {
        return saveGame;
    }

    public Button getQuitGame() {
        return quitGame;
    }

    public HBox getButtonsGame() {
        return buttonsGame;
    }

    public Label getDealerScore() {
        return dealerScore;
    }
}
