package MVPGlobal.View.NicknameScreen;

import MVPGlobal.Model.BlackJackGame;
import MVPGlobal.View.AlertScreen.AlertBlackjack;
import MVPGlobal.View.MainScreen.MainScreenView;
import MVPGlobal.View.UISettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.FileReader;


public class NicknameScreenPresenter {

    private BlackJackGame blackJackGame;
    private NicknameScreenView view;
    private UISettings uiSettings;
    private MainScreenView mainView;


    public NicknameScreenPresenter(BlackJackGame blackJackGame, NicknameScreenView view, UISettings uiSettings,MainScreenView mainView) {
        this.blackJackGame = blackJackGame;
        this.view = view;
        this.uiSettings = uiSettings;
        this.mainView = mainView;
        view.getBtnConfirm().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(view.getNickname().getText() != null && view.getNickname().getText().length() != 0){

                    blackJackGame.player1.setPlayerName(view.getNickname().getText());
                    mainView.getBottomLabels().getPlayerName().setText(blackJackGame.player1.getPlayerName());
                    // setNickname in Model
                    view.getScene().getWindow().hide();
                } else{
                    AlertBlackjack nicknameError = new AlertBlackjack(Alert.AlertType.ERROR, "ERROR", "Please enter a username", "You have not entered a username yet.", "OK");
                    nicknameError.showAndWait();
                }
            }
        });
    }
}
