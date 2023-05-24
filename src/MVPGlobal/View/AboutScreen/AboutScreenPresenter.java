package MVPGlobal.View.AboutScreen;

import MVPGlobal.Model.*;
import MVPGlobal.View.UISettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This is the presenter for the about screen.
 * This links AboutScreenView with the model.
 */
public class AboutScreenPresenter {

    private BlackJackGame model;
    private AboutScreenView view;
    private UISettings uiSettings;

    /**
     * This is the constructor for this presenter.
     * @return It returns an array list of cards.
     */
    public AboutScreenPresenter(BlackJackGame model, AboutScreenView view, UISettings uiSettings) {
        this.model = model;
        this.view = view;
        this.uiSettings = uiSettings;
        EventHandlers();
    }

    /**
     * This method will assemble a deck in a normal order.
     * @return It returns an array list of cards.
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
