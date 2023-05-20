package MVPGlobal.View.beginScreen;

import MVPGlobal.Model.BlackJackGame;
import MVPGlobal.View.AlertScreen.AlertBlackjack;
import MVPGlobal.View.InfoScreen.InfoScreenPresenter;
import MVPGlobal.View.InfoScreen.InfoScreenView;
import MVPGlobal.View.MainScreen.MainScreenPresenter;
import MVPGlobal.View.MainScreen.MainScreenView;
import MVPGlobal.View.StartScreen.StartScreenView;
import MVPGlobal.View.UISettings;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.MalformedURLException;
import java.nio.file.Files;

public class BeginScreenPresenter {

    private BlackJackGame blackJackGame;
    private BeginScreenView view;
    private UISettings uiSettings;

    public BeginScreenPresenter(BlackJackGame blackJackGame, BeginScreenView view, UISettings uiSettings) {
        this.blackJackGame = blackJackGame;
        this.view = view;
        this.uiSettings = uiSettings;
        updateView();
        addEventHandlers();
    }

    private void updateView() {
    }

    private void addEventHandlers() {

        view.getStartGameBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                blackJackGame = new BlackJackGame();

                MainScreenView msView = new MainScreenView(uiSettings);
                MainScreenPresenter msPresenter = new MainScreenPresenter(blackJackGame, msView, uiSettings);
                view.getScene().setRoot(msView);
                try {
                    msView.getScene().getStylesheets().add(uiSettings.getStyleSheetPath().toUri().toURL().toString());
                } catch (MalformedURLException ex) {
                    // // do nothing, if toURL-conversion fails, program can continue
                }
                msView.getScene().getWindow().sizeToScene();
                msView.getScene().getWindow().setHeight(uiSettings.getResY());
                msView.getScene().getWindow().setWidth(uiSettings.getResX());
                msPresenter.windowsHandler();

            }
        });

        view.getMoreInfoBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                InfoScreenView infoScreenView = new InfoScreenView(uiSettings);
                InfoScreenPresenter infoScreenPresenter = new InfoScreenPresenter(blackJackGame, infoScreenView, uiSettings);
                Stage infoScreenStage = new Stage();
                infoScreenStage.initOwner(view.getScene().getWindow());
                infoScreenStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(infoScreenView);
                infoScreenStage.setScene(scene);
                infoScreenStage.setTitle(uiSettings.getApplicationName()+ " - Info");
                infoScreenStage.setX(view.getScene().getWindow().getX() + uiSettings.getResX() / 6);
                infoScreenStage.setY(view.getScene().getWindow().getY() + uiSettings.getResY() / 10);
                if (Files.exists(uiSettings.getApplicationIconPath())) {
                    try {
                        infoScreenStage.getIcons().add(new Image(uiSettings.getApplicationIconPath().toUri().toURL().toString()));
                    }
                    catch (MalformedURLException ex) {
                        // do nothing, if toURL-conversion fails, program can continue
                    }
                } else { // do nothing, if ApplicationIconImage is not available, program can continue
                }
                infoScreenView.getScene().getWindow().setHeight((uiSettings.getResY())/1.4);
                infoScreenView.getScene().getWindow().setWidth((uiSettings.getResX())/1.5);
                if (uiSettings.styleSheetAvailable()){
                    infoScreenView.getScene().getStylesheets().removeAll();
                    try {
                        infoScreenView.getScene().getStylesheets().add(uiSettings.getStyleSheetPath().toUri().toURL().toString());
                    }
                    catch (MalformedURLException ex) {
                        // do nothing, if toURL-conversion fails, program can continue
                    }
                }
                infoScreenStage.showAndWait();
            }});
}


    public void windowsHandler() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) { handleCloseEvent(event); }});
    }

    private void handleCloseEvent(Event event){
        AlertBlackjack stopWindow = new AlertBlackjack(Alert.AlertType.CONFIRMATION, "Knights of the Future - Blackjack", "You're closing the application.", "Are you sure?", "");
        stopWindow.getButtonTypes().clear();
        ButtonType noButton = new ButtonType("No");
        ButtonType yesButton = new ButtonType("Yes");
        stopWindow.getButtonTypes().addAll(yesButton, noButton);
        stopWindow.showAndWait();
        if (stopWindow.getResult() == null || stopWindow.getResult().equals(noButton)) {
            event.consume();
        } else {
            view.getScene().getWindow().hide();
        }
    }

}
