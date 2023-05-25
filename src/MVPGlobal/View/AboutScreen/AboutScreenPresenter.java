package MVPGlobal.View.AboutScreen;

import MVPGlobal.Model.*;
import MVPGlobal.View.UISettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This is the presenter for the about screen.
 * This links AboutScreenView with the model.
 *
 * @author Sam Rotthier
 * @author Matthias Vermeiren
 * @version 3.0
 */
public class AboutScreenPresenter {

    private BlackJackGame model;
    private AboutScreenView view;
    private UISettings uiSettings;

    /**
     * This is the constructor for this presenter.
     *
     * @param model, this is the Blackjack Game
     * @param view, this is the AboutScreen View
     * @param uiSettings, this is the UI Settings
     */
    public AboutScreenPresenter(BlackJackGame model, AboutScreenView view, UISettings uiSettings) {
        this.model = model;
        this.view = view;
        this.uiSettings = uiSettings;
        EventHandlers();
    }

    /**
     * In this method are the event handlers.
     */
    private void EventHandlers() {
        view.getBtnOk().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getScene().getWindow().hide();
            }
        });
    }
}
