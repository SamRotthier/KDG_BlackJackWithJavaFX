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

/**
 * This is the presenter for the nickname view, handling the input and confirmation of the nickname.
 *
 * @author Sam Rotthier
 * @author Matthias Vermeiren
 * @version 3.0
 */
public class NicknameScreenPresenter {
    private NicknameScreenView view;
    private MainScreenView mainView;
    private Player player;


    /**
     * The constructor to create the class and give all the properties a value.
     * @param blackJackGame
     * @param view
     * @param mainView
     */
    public NicknameScreenPresenter(BlackJackGame blackJackGame, NicknameScreenView view,MainScreenView mainView) {
        this.player = blackJackGame.player;
        this.view = view;
        this.mainView = mainView;
        EventHandlers();
    }

    /**
     * The eventhandler to record the entered nickname based on the action on the confirm button.
     */

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
