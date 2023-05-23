package MVPGlobal.View.BeginScreen;

import MVPGlobal.Model.BlackJackGame;
import MVPGlobal.Model.Player;
import MVPGlobal.View.AlertScreen.AlertBlackjack;
import MVPGlobal.View.InfoScreen.InfoScreenPresenter;
import MVPGlobal.View.InfoScreen.InfoScreenView;
import MVPGlobal.View.MainScreen.MainScreenPresenter;
import MVPGlobal.View.MainScreen.MainScreenView;
import MVPGlobal.View.NicknameScreen.NicknameScreenPresenter;
import MVPGlobal.View.NicknameScreen.NicknameScreenView;
import MVPGlobal.View.UISettings;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BeginScreenPresenter {

    private BlackJackGame blackJackGame;
    private BeginScreenView view;
    private UISettings uiSettings;
    private Player player;

    public BeginScreenPresenter(BlackJackGame blackJackGame, BeginScreenView view, UISettings uiSettings) {
        this.blackJackGame = blackJackGame;
        this.player = blackJackGame.player;
        this.view = view;
        this.uiSettings = uiSettings;
        updateView();
        EventHandlers();
    }

    private void updateView() {
    }

    private void EventHandlers() {
        view.getStartGameBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                blackJackGame = new BlackJackGame();

                MainScreenView msView = new MainScreenView(uiSettings);
                blackJackGame.sounds.playStartBtn();
                MainScreenPresenter msPresenter = new MainScreenPresenter(blackJackGame, msView, uiSettings);
                view.getScene().setRoot(msView);
                try {
                    msView.getScene().getStylesheets().add(uiSettings.getStyleSheetPath().toUri().toURL().toString());
                } catch (MalformedURLException ex) {
                    // // do nothing, if toURL-conversion fails, program can continue
                }
                msView.getScene().getWindow().sizeToScene();
                msView.getScene().getWindow().setHeight(uiSettings.getResY()/1.1);
                msView.getScene().getWindow().setWidth(uiSettings.getResX()/1.1);
                msPresenter.windowsHandler();

                //music
                blackJackGame.sounds.playBackgroundMusic();

                // Choose nickname
                NicknameScreenView nicknameScreenView = new NicknameScreenView(uiSettings);
                NicknameScreenPresenter nicknameScreenPresenter = new NicknameScreenPresenter(blackJackGame, nicknameScreenView, msView);
                Stage nicknameScreenStage = new Stage();
                nicknameScreenStage.initOwner(msView.getScene().getWindow());
                nicknameScreenStage.initModality(Modality.APPLICATION_MODAL);
                Scene nicknameScene = new Scene(nicknameScreenView);
                nicknameScreenStage.setScene(nicknameScene);
                nicknameScreenStage.setTitle("Choose a Nickname");
                nicknameScreenStage.setX(msView.getScene().getWindow().getX()+ (uiSettings.getResX()/2.7));
                nicknameScreenStage.setY(msView.getScene().getWindow().getY() + (uiSettings.getResY()/2.7));
                nicknameScreenView.getScene().getWindow().setHeight((uiSettings.getResY())/4.5);
                nicknameScreenView.getScene().getWindow().setWidth((uiSettings.getResX())/6);
                if (uiSettings.styleSheetAvailable()){
                    nicknameScreenView.getScene().getStylesheets().removeAll();
                    try {
                        nicknameScreenView.getScene().getStylesheets().add(uiSettings.getStyleSheetPath().toUri().toURL().toString());
                    }
                    catch (MalformedURLException ex) {
                        // do nothing, if toURL-conversion fails, program can continue
                    }
                }
                nicknameScreenStage.showAndWait();
            }
        });

        view.getMoreInfoBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainScreenView msView = new MainScreenView(uiSettings);
                blackJackGame.sounds.playInfoBtn();

                InfoScreenView infoScreenView = new InfoScreenView(uiSettings);
                InfoScreenPresenter infoScreenPresenter = new InfoScreenPresenter(blackJackGame, infoScreenView, uiSettings);
                Stage infoScreenStage = new Stage();
                infoScreenStage.initOwner(view.getScene().getWindow());
                infoScreenStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(infoScreenView);
                infoScreenStage.setScene(scene);
                infoScreenStage.setTitle(uiSettings.getApplicationName()+ " - Info");
                infoScreenStage.setX(view.getScene().getWindow().getX() + uiSettings.getResX() / 8);
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

        view.getLoadGameBtn().setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainScreenView msView = new MainScreenView(uiSettings);
                blackJackGame.sounds.playLoadBtn();

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Load Data File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Textfiles", "*.txt"),
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                File selectedFile = fileChooser.showOpenDialog(view.getScene().getWindow());
                if ((selectedFile != null)) { //^ (Files.isReadable(Paths.get(selectedFile.toURI())))) {
                    try {
                        List<String> input = Files.readAllLines(Paths.get(selectedFile.toURI()));
                        // begin implementeren ingelezen gegevens doorgeven aan model
                        for (int i = 0; i < input.size(); i++) {
                            String inputline = input.get(i);
                            String[] elementen = inputline.split(" ");
                            if (i == 0) {
                                player.setPlayerName(inputline);
                                msView.getBottomLabels().getPlayerName().setText(player.getPlayerName());
                            } else if (i == 1) {
                                player.setBank(Integer.parseInt(inputline));
                                msView.getBottomLabels().getSaldoLabelPlayer().setText(Integer.toString(player.getBank()));
                            }
                        }
                        // start game

                        MainScreenPresenter msPresenter = new MainScreenPresenter(blackJackGame, msView, uiSettings);
                        view.getScene().setRoot(msView);
                        try {
                            msView.getScene().getStylesheets().add(uiSettings.getStyleSheetPath().toUri().toURL().toString());
                        } catch (MalformedURLException ex) {
                            // // do nothing, if toURL-conversion fails, program can continue
                        }
                        msView.getScene().getWindow().sizeToScene();
                        msView.getScene().getWindow().setHeight(uiSettings.getResY()/1.1);
                        msView.getScene().getWindow().setWidth(uiSettings.getResX()/1.1);
                        msPresenter.windowsHandler();

                        //music
                        blackJackGame.sounds.playBackgroundMusic();
                    } catch (IOException e) {
                        //
                    }
                } else {
                    AlertBlackjack errorWindow = new AlertBlackjack(Alert.AlertType.ERROR, "ERROR", "Problem with the selected input file:", "File is not readable", "OK");
                    errorWindow.showAndWait();
                }

            }
        }));
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
