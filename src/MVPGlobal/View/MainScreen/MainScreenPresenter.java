package MVPGlobal.View.MainScreen;


import MVPGlobal.Model.*;
import MVPGlobal.View.AboutScreen.*;
import MVPGlobal.View.AlertScreen.AlertBlackjack;
import MVPGlobal.View.InfoScreen.*;
import MVPGlobal.View.SettingsScreen.*;
import MVPGlobal.View.UISettings;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.List;

import static javafx.scene.control.Alert.*;


public class MainScreenPresenter {

    private BlackJackGame blackJackGame;
    private MainScreenView view;
    private UISettings uiSettings;
    private ActionEvent infoActionEvent;

    public MainScreenPresenter(BlackJackGame blackJackGame, MainScreenView view, UISettings uiSettings) {
        this.blackJackGame = blackJackGame;
        this.view = view;
        this.uiSettings = uiSettings;
        updateView();
        EventHandlers();
        addEventHandlerPlayerActions();
        //view.getWinLoseView().setVisible(false);
        view.getBottomLabels().getSaldoLabelPlayer().setText(Integer.toString(blackJackGame.player1.getBank()));
    }

    private void updateView() {
     }

    private void startEventHandler(){

    }

    private void EventHandlers() {
        view.getSettingsItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SettingsView settingsView = new SettingsView(uiSettings);
                SettingsPresenter presenter = new SettingsPresenter(blackJackGame, settingsView, uiSettings);
                Stage settingsStage = new Stage();
                settingsStage.setTitle("Settings");
                settingsStage.initOwner(view.getScene().getWindow());
                settingsStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(settingsView);
                settingsStage.setScene(scene);
                settingsStage.setTitle(uiSettings.getApplicationName() + " - Settings");
                settingsStage.setX(view.getScene().getWindow().getX() + uiSettings.getResX() / 10);
                settingsStage.setY(view.getScene().getWindow().getY() + uiSettings.getResY() / 10);
                if (Files.exists(uiSettings.getApplicationIconPath())) {
                    try {
                        settingsStage.getIcons().add(new Image(uiSettings.getApplicationIconPath().toUri().toURL().toString()));
                    } catch (MalformedURLException ex) {
                        // do nothing, if toURL-conversion fails, program can continue
                    }
                } else { // do nothing, if ApplicationIconImage is not available, program can continue
                }
                settingsView.getScene().getWindow().setHeight(7 * uiSettings.getResY() / 10);
                settingsView.getScene().getWindow().setWidth(7 * uiSettings.getResX() / 10);
                if (uiSettings.styleSheetAvailable()) {
                    settingsStage.getScene().getStylesheets().removeAll();
                    try {
                        settingsStage.getScene().getStylesheets().add(uiSettings.getStyleSheetPath().toUri().toURL().toString());
                    } catch (MalformedURLException ex) {
                        // do nothing, if toURL-conversion fails, program can continue
                    }
                }
                settingsStage.showAndWait();
                if (uiSettings.styleSheetAvailable()) {
                    view.getScene().getStylesheets().removeAll();
                    try {
                        view.getScene().getStylesheets().add(uiSettings.getStyleSheetPath().toUri().toURL().toString());
                    } catch (MalformedURLException ex) {
                        // do nothing, if toURL-conversion fails, program can continue
                    }
                }
            }
        });
        view.getLoadItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Load Data File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Textfiles", "*.txt"),
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                File selectedFile = fileChooser.showOpenDialog(view.getScene().getWindow());
                if ((selectedFile != null) ){ //^ (Files.isReadable(Paths.get(selectedFile.toURI())))) {
                    try {
                        List<String> input = Files.readAllLines(Paths.get(selectedFile.toURI()));
                        // begin implementeren ingelezen gegevens doorgeven aan model
                        for (int i = 0; i < input.size(); i++) {
                            String inputline = input.get(i);
                            String[] elementen = inputline.split(" ");
                            blackJackGame.player1.setBank(Integer.parseInt(inputline));
                            view.getBottomLabels().getSaldoLabelPlayer().setText(Integer.toString(blackJackGame.player1.getBank()));
                        }
                        // einde implementeren ingelezen gegevens doorgeven aan model
                    } catch (IOException e) {
                        //
                    }
                } else {
                    AlertBlackjack errorWindow = new AlertBlackjack(AlertType.ERROR, "ERROR", "Problem with the selected input file:", "File is not readable", "OK");
                    errorWindow.showAndWait();
                }
            }
        });
        view.getSaveItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Data File");
                //fileChooser.setInitialDirectory("resources/SaveData");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Textfiles", "*.txt"),
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                File selectedFile = fileChooser.showSaveDialog(view.getScene().getWindow());
                if ((selectedFile != null) ^ (Files.isWritable(Paths.get(selectedFile.toURI())))) {
                    try {
                        Files.deleteIfExists(Paths.get(selectedFile.toURI()));
                    } catch (IOException e) {
                        //
                    }
                    try (Formatter output = new Formatter(selectedFile)) {
                        // Begin implementeren wegschrijven model-gegevens
                       // output.format("%s%n", "Here comes the data!");
                       // output.format("%s%n", "First record");
                       // output.format("%s%n", "...");
                       // output.format("%s%n", "Last record");
                        output.format("%s%n",Integer.toString(blackJackGame.player1.getBank()));
                        //output.format(blackJackGame.player1.getBank() + "," + blackJackGame.player1.getHand());
                        // Einde implementeren wegschrijven model-gegevens
                    } catch (IOException e) {
                        //
                    }
                } else {
                    AlertBlackjack errorWindow = new AlertBlackjack(AlertType.ERROR, "ERROR", "Problem with the selected output file: ", "File is not writable", "OK");
                    errorWindow.showAndWait();
                }
            }
        });
        view.getExitItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleCloseEvent(event);
            }
        });
        view.getAboutItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AboutScreenView aboutScreenView = new AboutScreenView(uiSettings);
                AboutScreenPresenter aboutScreenPresenter = new AboutScreenPresenter(blackJackGame, aboutScreenView, uiSettings);
                Stage aboutScreenStage = new Stage();
                aboutScreenStage.initOwner(view.getScene().getWindow());
                aboutScreenStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(aboutScreenView);
                aboutScreenStage.setScene(scene);
                aboutScreenStage.setTitle(uiSettings.getApplicationName() + " - About");
                aboutScreenStage.setX(view.getScene().getWindow().getX() + uiSettings.getResX() / 10);
                aboutScreenStage.setY(view.getScene().getWindow().getY() + uiSettings.getResY() / 10);
                if (Files.exists(uiSettings.getApplicationIconPath())) {
                    try {
                        aboutScreenStage.getIcons().add(new Image(uiSettings.getApplicationIconPath().toUri().toURL().toString()));
                    } catch (MalformedURLException ex) {
                        // do nothing, if toURL-conversion fails, program can continue
                    }
                } else { // do nothing, if ApplicationIconImage is not available, program can continue
                }
                aboutScreenView.getScene().getWindow().setHeight(uiSettings.getResY() / 2);
                aboutScreenView.getScene().getWindow().setWidth(uiSettings.getResX() / 2);
                if (uiSettings.styleSheetAvailable()) {
                    aboutScreenView.getScene().getStylesheets().removeAll();
                    try {
                        aboutScreenView.getScene().getStylesheets().add(uiSettings.getStyleSheetPath().toUri().toURL().toString());
                    } catch (MalformedURLException ex) {
                        // do nothing, if toURL-conversion fails, program can continue
                    }
                }
                aboutScreenStage.showAndWait();
            }});
        view.getInfoItem().setOnAction(new EventHandler<ActionEvent>() {
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
                infoScreenView.getScene().getWindow().setHeight(uiSettings.getResY()/1.4);
                infoScreenView.getScene().getWindow().setWidth(uiSettings.getResX()/1.5);
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
                infoActionEvent = event;
            }});
    }

    private void addEventHandlerPlayerActions(){
        view.getBetButtons().getBetAmount().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String valueString = view.getBetButtons().getBetAmount().getText();
                try{
                    if (!valueString.isEmpty()) {
                        blackJackGame.txtSetBet(Integer.parseInt(valueString));
                        if (blackJackGame.player1.getPlayerBet() < 0){
                            view.getBetButtons().getArrowDown().setVisible(false);
                        }else{
                            view.getBetButtons().getArrowDown().setVisible(true);
                        }
                    }
                }
                catch(NumberFormatException e){
                    AlertBlackjack alertError = new AlertBlackjack(AlertType.ERROR, "ERROR", "Invalid bet!","Please enter a number. No letters or symbols are allowed.", "SORRY");
                    alertError.showAndWait();
                }
            }
        });

        view.getBetButtons().getArrowUp().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                blackJackGame.btnAddBet();
                view.getBetButtons().getBetAmount().setText(Integer.toString(blackJackGame.player1.getPlayerBet()));
                if (blackJackGame.player1.getPlayerBet() > 0){
                    view.getBetButtons().getArrowDown().setVisible(true);
                }
            }
        });
        view.getBetButtons().getArrowDown().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                blackJackGame.btnSubBet();
                view.getBetButtons().getBetAmount().setText(Integer.toString(blackJackGame.player1.getPlayerBet()));
                if (blackJackGame.player1.getPlayerBet() == 0){
                    view.getBetButtons().getArrowDown().setVisible(false);
                }
            }
        });
        view.getActionButtons().getButtonDeal().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!view.getBetButtons().getBetAmount().getText().isEmpty() && blackJackGame.player1.getPlayerBet() > 0 && blackJackGame.player1.getPlayerBet()<= blackJackGame.player1.getBank()) {
                blackJackGame.dealingCards();
                view.setCenter(null);
                view.setCenter(view.getCardsPlayerDealerBox());
                view.getCardsPlayerDealerBox().setVisible(true);
                view.getBottomLabels().getSaldoLabelPlayer().setText(Integer.toString(blackJackGame.player1.getBank()));
                view.getBottomLabels().getBetAmountLabelPlayer().setText(Integer.toString(blackJackGame.player1.getPlayerBet()));
                view.getBottomLabels().getCardScorePlayer().setText(Integer.toString(blackJackGame.player1.getTotalCardValue()));
                view.getPlayerCardsView().getPlayerCards().clear();
                view.getPlayerCardsView().getPlayerCards().addAll(blackJackGame.player1.getHand());
                view.getCardsPlayerDealerBox().setVisible(true);

                view.getDealerCardsView().getDealerCards().clear();
                view.getDealerCardsView().getDealerCards().addAll(blackJackGame.dealer1.getHand());
                    for (int i = 0; i < 2; i++) {
                        view.getSounds().playDealCard();
                    }
                view.getPlayerCardsView().addCard();
                    for (int i = 0; i < 2; i++) {
                        view.getSounds().playDealCard();
                    }

                view.getDealerCardsView().addCardStart();
                view.getActionButtons().getButtonHit().setVisible(true);
                view.getActionButtons().getButtonDouble().setVisible(true);
                view.getActionButtons().getButtonStand().setVisible(true);
                view.getActionButtons().getButtonDeal().setVisible(false);

                }else{
                    AlertBlackjack alertDeal = new AlertBlackjack(AlertType.ERROR, "ERROR", "Issues while dealing","Please give betting amount", "OK");
                    alertDeal.showAndWait();
                }
            }
        });

        view.getActionButtons().getButtonHit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (blackJackGame.player1.getTotalCardValue() < 22) {
                    blackJackGame.btnHit();
                    view.getBottomLabels().getCardScorePlayer().setText(Integer.toString(blackJackGame.player1.getTotalCardValue()));
                    view.getPlayerCardsView().getPlayerCards().add(blackJackGame.player1.getHand().get(blackJackGame.player1.getHand().size() - 1));
                    view.getPlayerCardsView().addCard();
                    view.getSounds().playDealCard();
               }else{
                    AlertBlackjack alertLost = new AlertBlackjack(AlertType.INFORMATION, "LOST", "Card value over 21","Your card value is over 21. You Lost!", "OK");
                    alertLost.showAndWait();
               }
            }
        });

        view.getActionButtons().getButtonDouble().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (blackJackGame.player1.getTotalCardValue() < 22 ) {
                if ((blackJackGame.player1.getPlayerBet() * 2) <= blackJackGame.player1.getBank()){
                    blackJackGame.btnDouble();
                    view.getBetButtons().getBetAmount().setText(Integer.toString(blackJackGame.player1.getPlayerBet()));
                    view.getBottomLabels().getSaldoLabelPlayer().setText(Integer.toString(blackJackGame.player1.getBank()));
                    view.getBottomLabels().getBetAmountLabelPlayer().setText(Integer.toString(blackJackGame.player1.getPlayerBet()*2));
                view.getBottomLabels().getCardScorePlayer().setText(Integer.toString(blackJackGame.player1.getTotalCardValue()));
                view.getPlayerCardsView().getPlayerCards().add(blackJackGame.player1.getHand().get(blackJackGame.player1.getHand().size()-1));
                view.getPlayerCardsView().addCard();
                view.getSounds().playDealCard();
                }else{
                    AlertBlackjack alertBroke = new AlertBlackjack(AlertType.INFORMATION, "BROKE", "Not enough points", "You don't have enough points for this", "OK");
                    alertBroke.showAndWait();
                }
                }else{
                    AlertBlackjack alertLost = new AlertBlackjack(AlertType.INFORMATION, "LOST", "Card value over 21", "Your card value is over 21. You Lost!", "OK");
                    alertLost.showAndWait();
                }
            }
        });

        view.getActionButtons().getButtonStand().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                blackJackGame.btnStand();
               if (blackJackGame.dealer1.getHand().size() <=2){
                   view.getDealerCardsView().getDealerCards().clear();
                   view.getDealerCardsView().getDealerCards().addAll(blackJackGame.dealer1.getHand());
                 }else {
                view.getDealerCardsView().getDealerCards().add(blackJackGame.dealer1.getHand().get(blackJackGame.dealer1.getHand().size()-1));
               }

               if(blackJackGame.whoWon().equals("Dealer")){
                   if(blackJackGame.player1.getBank() < 1){
                       view.setCenter(null);
                       view.getWinLoseView().getChildren().addAll(view.getWinLoseView().gameRound(3), view.getWinLoseView().getQuitGame());
                       view.setCenter(view.getWinLoseView());
                   }
                   else {
                   view.setCenter(null);
                   //view.getWinLoseView().getChildren().clear();
                   view.getWinLoseView().getChildren().addAll(view.getWinLoseView().gameRound(2), view.getWinLoseView().getButtonsGame());
                   view.setCenter(view.getWinLoseView());}

               }else if (blackJackGame.whoWon().equals("Player")){
                   view.setCenter(null);
                   //view.getWinLoseView().getChildren().clear();
                   view.getWinLoseView().getChildren().addAll(view.getWinLoseView().gameRound(1), view.getWinLoseView().getButtonsGame());
                   view.setCenter(view.getWinLoseView());

               }else{
                   view.setCenter(null);
                   //view.getWinLoseView().getChildren().clear();
                   view.getWinLoseView().getChildren().addAll(view.getWinLoseView().gameRound(4), view.getWinLoseView().getButtonsGame());
                   view.setCenter(view.getWinLoseView());
               }


                view.getDealerCardsView().addCardEnd();
                view.getActionButtons().getButtonHit().setVisible(false);
                view.getActionButtons().getButtonDouble().setVisible(false);
                view.getActionButtons().getButtonStand().setVisible(false);
                view.getActionButtons().getbuttonNextRound().setVisible(false); // Was for easy debugging
                view.getBottomLabels().getSaldoLabelPlayer().setText(Integer.toString(blackJackGame.player1.getBank()));
                view.getWinLoseView().setVisible(true);
            }
        });

        view.getActionButtons().getbuttonNextRound().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                blackJackGame.dealer1.getHand().clear();
                blackJackGame.player1.getHand().clear();

                view.getPlayerCardsView().getPlayerCards().clear();
                view.getDealerCardsView().getDealerCards().clear();
                view.getActionButtons().getButtonDeal().setVisible(true);
                view.getActionButtons().getbuttonNextRound().setVisible(false);
                view.getCardsPlayerDealerBox().setVisible(true);
                view.getWinLoseView().setVisible(false);
            }
        });
        view.getWinLoseView().getNextRound().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                blackJackGame.dealer1.getHand().clear();
                blackJackGame.player1.getHand().clear();

                view.getPlayerCardsView().getPlayerCards().clear();
                view.getDealerCardsView().getDealerCards().clear();
                view.getActionButtons().getButtonDeal().setVisible(true);
                view.getActionButtons().getbuttonNextRound().setVisible(false);
                view.getWinLoseView().setVisible(false);
            }
        });
    }

    public void windowsHandler() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) { handleCloseEvent(event); }});
    }

    private void handleCloseEvent(Event event){
        AlertBlackjack stopWindow = new AlertBlackjack(AlertType.CONFIRMATION, "TIRED OF LOSING?", "You're closing the application.", "Are you sure? Unsaved data may be lost.", "");
        stopWindow.getButtonTypes().clear();
        ButtonType noButton = new ButtonType("No");
        ButtonType yesButton = new ButtonType("Yes");
        stopWindow.getButtonTypes().addAll(yesButton, noButton);
        //stopWindow.getDialogPane().getStyleClass().add("alert");
        stopWindow.showAndWait();
        if (stopWindow.getResult() == null || stopWindow.getResult().equals(noButton)) {
            event.consume();
        } else {
            view.getScene().getWindow().hide();
        }
    }

    //Getter
    public ActionEvent getInfoActionEvent(){
        return infoActionEvent;
    }

}
