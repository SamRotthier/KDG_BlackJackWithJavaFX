package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class WinLoseView extends VBox {

    private Button nextRound;
    private Button saveGame;
    private Button quitGame;
    private Label  winGame;
    private Label  loseGame;

    public WinLoseView(/*UISettings uiSettings*/) {
        //this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();

    }

    private void initialiseNodes() {
        nextRound = new Button("NEXT"); //or Next Round
        saveGame = new Button("SAVE"); //or Save Game
        quitGame = new Button("QUIT"); //or Quit Game
        winGame = new Label("Congratulations, you've won!");
        loseGame = new Label("You Lose! Better luck next time");
    }

    private void layoutNodes() {
        HBox buttonsGame = new HBox(nextRound, saveGame, quitGame);
        buttonsGame.setSpacing(75);
        buttonsGame.setPadding(new Insets(40));
        buttonsGame.setAlignment(Pos.CENTER);

        winGame.getStyleClass().add("win");
        winGame.setPadding(new Insets(70));

        this.setAlignment(Pos.CENTER);
        this.setSpacing(200);
        this.getChildren().addAll(winGame, buttonsGame);
    }

    //Win method

    private void winOrLoseRound(){

    }

    //Lose method

    private void loseRound(){

    }

    //Getters

}
