package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        nextRound = new Button();
        saveGame = new Button();
        quitGame = new Button();
        winGame = new Label("Congratulations, you've won!");
        loseGame = new Label("You Lose! Better luck next time");
    }

    private void layoutNodes() {

    }

    //Win method

    private void winRound(){

    }

    //Lose method

    private void loseRound(){

    }

    //Getters

    private void buttonsGame(){
        HBox buttonsGame = new HBox(nextRound, saveGame,quitGame);
        buttonsGame.setSpacing(75);

    }

}
