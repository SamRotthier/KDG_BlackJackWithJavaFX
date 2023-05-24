package MVPGlobal.View.NicknameScreen;

import MVPGlobal.Model.BlackJackGame;
import MVPGlobal.Model.Dealer;
import MVPGlobal.Model.Player;
import MVPGlobal.View.AlertScreen.AlertBlackjack;
import MVPGlobal.View.MainScreen.MainScreenView;
import MVPGlobal.View.UISettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;


public class NicknameScreenPresenter {
    private NicknameScreenView view;
    private MainScreenView mainView;
    private Player player;


    public NicknameScreenPresenter(BlackJackGame blackJackGame, NicknameScreenView view,MainScreenView mainView) {
        this.player = blackJackGame.player;
        this.view = view;
        this.mainView = mainView;
        EventHandlers();
    }

    private void EventHandlers() {
        view.getBtnConfirm().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(view.getNickname().getText() != null && view.getNickname().getText().length() != 0){
                    player.setPlayerName(view.getNickname().getText());
                    mainView.getBottomLabels().getPlayerName().setText(player.getPlayerName());
                    view.getScene().getWindow().hide();
                } else{
                    AlertBlackjack nicknameError = new AlertBlackjack(Alert.AlertType.ERROR, "ERROR", "Please enter a username", "You have not entered a username yet.", "OK");
                    nicknameError.showAndWait();
                }
            }
        });
    }
}
