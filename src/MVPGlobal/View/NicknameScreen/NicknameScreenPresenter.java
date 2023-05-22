package MVPGlobal.View.NicknameScreen;

import MVPGlobal.Model.BlackJackGame;
import MVPGlobal.View.AlertScreen.AlertBlackjack;
import MVPGlobal.View.UISettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.FileReader;


public class NicknameScreenPresenter {

    private BlackJackGame model;
    private NicknameScreenView view;
    private UISettings uiSettings;

    public NicknameScreenPresenter(BlackJackGame model, NicknameScreenView view, UISettings uiSettings) {
        this.model = model;
        this.view = view;
        this.uiSettings = uiSettings;
        view.getBtnConfirm().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(view.getNickname().getText() != null && view.getNickname().getText().toString().length() != 0){
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
