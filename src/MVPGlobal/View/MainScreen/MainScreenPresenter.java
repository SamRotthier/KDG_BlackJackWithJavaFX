package MVPGlobal.View.MainScreen;


import MVPGlobal.MVPMain;
import MVPGlobal.Model.*;
import MVPGlobal.View.AboutScreen.*;
import MVPGlobal.View.AlertScreen.AlertBlackjack;
import MVPGlobal.View.BeginScreen.BeginScreenPresenter;
import MVPGlobal.View.BeginScreen.BeginScreenView;
import MVPGlobal.View.InfoScreen.*;
import MVPGlobal.View.SettingsScreen.*;
import MVPGlobal.View.UISettings;
import javafx.animation.PauseTransition;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;

import static javafx.scene.control.Alert.*;


public class MainScreenPresenter {

    private BlackJackGame blackJackGame;
    private MainScreenView view;
    private UISettings uiSettings;
    private ActionEvent infoActionEvent;
    private Player player;
    private Dealer dealer;
    private PlayerCardsView playerCardsView;

    private PauseTransition pause;


    public MainScreenPresenter(BlackJackGame blackJackGame, MainScreenView view, UISettings uiSettings) {
        this.blackJackGame = blackJackGame;
        this.player = blackJackGame.player;
        this.dealer = blackJackGame.dealer;
        this.view = view;
        this.playerCardsView = view.getPlayerCardsView();
        this.uiSettings = uiSettings;
        updateView();
        EventHandlers();
        addEventHandlerPlayerActions();
        view.getBottomLabels().getSaldoLabelPlayer().setText(Integer.toString(player.getBank()));

    }

    private void updateView() {
    }

    private void startEventHandler() {

    }

    private void EventHandlers() {
        view.getSettingsItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SettingsView settingsView = new SettingsView(uiSettings);
                SettingsPresenter presenter = new SettingsPresenter(blackJackGame, settingsView);
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
                LoadingPlayerNameAndScore();
            }
        });
        view.getSaveItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                savingPlayerNameAndScore();
            }
        });
        view.getWinLoseView().getSaveGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                savingPlayerNameAndScore();
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
            }
        });
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
                infoScreenStage.setTitle(uiSettings.getApplicationName() + " - Info");
                infoScreenStage.setX(view.getScene().getWindow().getX() + uiSettings.getResX() / 8);
                infoScreenStage.setY(view.getScene().getWindow().getY() + uiSettings.getResY() / 10);
                if (Files.exists(uiSettings.getApplicationIconPath())) {
                    try {
                        infoScreenStage.getIcons().add(new Image(uiSettings.getApplicationIconPath().toUri().toURL().toString()));
                    } catch (MalformedURLException ex) {
                        // do nothing, if toURL-conversion fails, program can continue
                    }
                } else { // do nothing, if ApplicationIconImage is not available, program can continue
                }
                infoScreenView.getScene().getWindow().setHeight(uiSettings.getResY() / 1.4);
                infoScreenView.getScene().getWindow().setWidth(uiSettings.getResX() / 1.5);
                if (uiSettings.styleSheetAvailable()) {
                    infoScreenView.getScene().getStylesheets().removeAll();
                    try {
                        infoScreenView.getScene().getStylesheets().add(uiSettings.getStyleSheetPath().toUri().toURL().toString());
                    } catch (MalformedURLException ex) {
                        // do nothing, if toURL-conversion fails, program can continue
                    }
                }
                infoScreenStage.showAndWait();
                infoActionEvent = event;
            }
        });
    }

    private void addEventHandlerPlayerActions() {
        view.getBetButtons().getBetAmount().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String valueString = view.getBetButtons().getBetAmount().getText();
                try {
                    if (!valueString.isEmpty()) {
                        player.setPlayerBet(Integer.parseInt(valueString));
                        if (player.getPlayerBet() < 0) {
                            view.getBetButtons().getArrowDown().setVisible(false);
                        } else {
                            view.getBetButtons().getArrowDown().setVisible(true);
                        }
                    }
                } catch (NumberFormatException e) {
                    AlertBlackjack alertError = new AlertBlackjack(AlertType.ERROR, "ERROR", "Invalid bet!", "Please enter a number. No letters or symbols are allowed.", "SORRY");
                    alertError.showAndWait();
                }
            }
        });

        view.getBetButtons().getArrowUp().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                blackJackGame.btnAddBet();
                view.getBetButtons().getBetAmount().setText(Integer.toString(player.getPlayerBet()));
                if (player.getPlayerBet() > 0) {
                    view.getBetButtons().getArrowDown().setVisible(true);
                }
            }
        });

        view.getBetButtons().getArrowDown().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                blackJackGame.btnSubBet();
                view.getBetButtons().getBetAmount().setText(Integer.toString(player.getPlayerBet()));
                if (player.getPlayerBet() == 0) {
                    view.getBetButtons().getArrowDown().setVisible(false);
                }
            }
        });

        view.getActionButtons().getButtonDeal().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!view.getBetButtons().getBetAmount().getText().isEmpty() && player.getPlayerBet() > 0 && player.getPlayerBet() <= player.getBank()) {
                    blackJackGame.dealingCards();
                    view.setCenter(null);
                    view.setCenter(view.getCardsPlayerDealerBox());
                    view.getCardsPlayerDealerBox().setVisible(true);

                    bottomLabelUpdate();

                    view.getPlayerCardsView().getPlayerCards().clear();
                    view.getPlayerCardsView().getPlayerCards().addAll(player.getHand());

                    view.getDealerCardsView().getDealerCards().clear();
                    view.getDealerCardsView().getDealerCards().addAll(dealer.getHand());
                    view.getSounds().playDealCard();
                    /*for (int i = 0; i < 2; i++) {
                        view.getSounds().playDealCard();
                    }*/
                    view.getPlayerCardsView().addCard();
                    /*for (int i = 0; i < 2; i++) {
                        view.getSounds().playDealCard();
                    }*/

                    view.getDealerCardsView().addCardStart();
                    view.setRight(null);
                    view.getActionButtons().getChildren().clear();
                    view.getActionButtons().getChildren().addAll(view.getActionButtons().getButtonHit(), view.getActionButtons().getButtonDouble(), view.getActionButtons().getButtonStand());
                    view.setRight(view.getActionButtons());
                    view.fadeInAnimation(view.getActionButtons());

                /* view.getActionButtons().getButtonHit().setVisible(true);
                view.getActionButtons().getButtonDouble().setVisible(true);
                view.getActionButtons().getButtonStand().setVisible(true);
                view.getActionButtons().getButtonDeal().setVisible(false);*/

                } else {
                    AlertBlackjack alertDeal = new AlertBlackjack(AlertType.ERROR, "ERROR", "Issues while dealing", "Please give betting amount", "OK");
                    alertDeal.showAndWait();
                }
            }
        });

        view.getActionButtons().getButtonHit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(player.getTotalCardValue() == 21){
                    AlertBlackjack alertAlready21 = new AlertBlackjack(AlertType.INFORMATION, "21", "Card value of 21", "Your card value is 21. You should stop taking cards", "OK");
                    alertAlready21.showAndWait();
                }
                else if (player.getTotalCardValue() < 22) {
                    blackJackGame.btnHit();

                    bottomLabelUpdate();

                    view.getPlayerCardsView().getPlayerCards().add(player.getHand().get(player.getHand().size() - 1));
                    view.getPlayerCardsView().addCard();
                    view.getSounds().playDealCard();
                } else {
                    AlertBlackjack alertLost = new AlertBlackjack(AlertType.INFORMATION, "LOST", "Card value over 21", "Your card value is over 21. You Lost!", "OK");
                    alertLost.showAndWait();
                }
            }
        });

        view.getActionButtons().getButtonDouble().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(player.getTotalCardValue() == 21){
                    AlertBlackjack alertAlready21 = new AlertBlackjack(AlertType.INFORMATION, "21", "Card value of 21", "Your card value is 21. You should stop taking cards", "OK");
                    alertAlready21.showAndWait();
                }
                else if (player.getTotalCardValue() < 22) {
                    if ((player.getPlayerBet() * 2) <= player.getBank()) {
                        blackJackGame.btnDouble();

                        bottomLabelUpdate();

                        view.getPlayerCardsView().getPlayerCards().add(player.getHand().get(player.getHand().size() - 1));
                        view.getPlayerCardsView().addCard();
                        view.getSounds().playDealCard();
                    } else {
                        AlertBlackjack alertBroke = new AlertBlackjack(AlertType.INFORMATION, "BROKE", "Not enough points", "You don't have enough points for this", "OK");
                        alertBroke.showAndWait();
                    }
                } else {
                    AlertBlackjack alertLost = new AlertBlackjack(AlertType.INFORMATION, "LOST", "Card value over 21", "Your card value is over 21. You Lost!", "OK");
                    alertLost.showAndWait();
                }
            }
        });

        view.getActionButtons().getButtonStand().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.getSounds().playInfoBtn();
                view.getActionButtons().setVisible(false);
                blackJackGame.btnStand();
                if (dealer.getHand().size() <= 2) {
                    view.getDealerCardsView().getDealerCards().clear();
                    view.getDealerCardsView().getDealerCards().addAll(dealer.getHand());
                } else {
                    view.getDealerCardsView().getDealerCards().add(dealer.getHand().get(dealer.getHand().size() - 1));
                }
                view.getDealerCardsView().addCardEnd();
                view.getActionButtons().standAnimation();
            }
        });

        view.getActionButtons().getDuration().setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.setCenter(null);
                if (blackJackGame.whoWon().equals("Dealer")) {
                    if (player.getBank() < 1) {
                        winLoseTextLoader(3);
                    } else {
                        winLoseTextLoader(2);
                    }
                } else if (blackJackGame.whoWon().equals("Player")) {
                    winLoseTextLoader(1);

                } else {
                    winLoseTextLoader(4);
                }

                bottomLabelUpdate();
                view.getWinLoseView().setVisible(true);
            }
        });

        view.getWinLoseView().getNextRound().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                nextRoundClearing();

                view.setRight(null);
                view.getActionButtons().getChildren().clear();
                view.getActionButtons().getChildren().add(view.getActionButtons().getButtonDeal());
                view.setRight(view.getActionButtons());
                view.getWinLoseView().setVisible(false);
                view.getActionButtons().setVisible(true);
                view.fadeInAnimation(view.getActionButtons());
            }
        });

        view.getWinLoseView().getQuitGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //view.getSounds().stopBackgroundMusic();
                nextRoundClearing();
                //view.getBottomLabels().getSaldoLabelPlayer().setText(Integer)
                BeginScreenView beginView = new BeginScreenView(uiSettings);
                BeginScreenPresenter bsPresenter = new BeginScreenPresenter(blackJackGame, beginView, uiSettings);
                view.getScene().setRoot(beginView);
                beginView.getScene().getWindow().sizeToScene();
                beginView.getScene().getWindow().setHeight(uiSettings.getResY() / 1.1);
                beginView.getScene().getWindow().setWidth(uiSettings.getResX() / 1.1);

                bsPresenter.windowsHandler();
            }
        });
    }

    public void windowsHandler() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                handleCloseEvent(event);
            }
        });
    }

    private void handleCloseEvent(Event event) {
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

    //Methods to cleanup the code
    private void bottomLabelUpdate() {
        view.getBottomLabels().getSaldoLabelPlayer().setText(Integer.toString(player.getBank()));
        view.getBottomLabels().getBetAmountLabelPlayer().setText(Integer.toString(player.getPlayerBet()));
        view.getBottomLabels().getCardScorePlayer().setText(Integer.toString(player.getTotalCardValue()));
    }

    private void nextRoundClearing() {
        player.getHand().clear();
        dealer.getHand().clear();

        view.getPlayerCardsView().getPlayerCards().clear();
        view.getDealerCardsView().getDealerCards().clear();
        view.getBottomLabels().getBetAmountLabelPlayer().setText(Integer.toString(0));
        view.getBottomLabels().getCardScorePlayer().setText(Integer.toString(player.getTotalCardValue()));
    }

    private void winLoseTextLoader(int i) {
        view.setCenter(null);
        view.getWinLoseView().getChildren().clear();
        if (i == 3){
            dealerScore();
            view.getWinLoseView().getChildren().addAll(view.getWinLoseView().gameRound(i), view.getWinLoseView().getDealerScore(), view.getWinLoseView().getQuitGame());
        }else {
            dealerScore();
            view.getWinLoseView().getChildren().addAll(view.getWinLoseView().gameRound(i), view.getWinLoseView().getDealerScore(),view.getWinLoseView().getButtonsGame());
        }
        view.setCenter(view.getWinLoseView());
        view.fadeInAnimation(view.getWinLoseView());
    }

    private void dealerScore(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The dealer's card score was ").append(blackJackGame.dealer.getTotalCardValue());
        String dealerScore = stringBuilder.toString();
        view.getWinLoseView().getDealerScore().setText(dealerScore);
    }

    private void LoadingPlayerNameAndScore() {
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
                        view.getBottomLabels().getPlayerName().setText(player.getPlayerName());
                    } else if (i == 1) {
                        player.setBank(Integer.parseInt(inputline));
                        view.getBottomLabels().getSaldoLabelPlayer().setText(Integer.toString(player.getBank()));
                    }
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

    private void loadingHighscore() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load Data File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Textfiles", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(view.getScene().getWindow());
        if ((selectedFile != null)) { //^ (Files.isReadable(Paths.get(selectedFile.toURI())))) {
            try {
                List<String> input = Files.readAllLines(Paths.get(selectedFile.toURI()));
                ArrayList<String> scores = new ArrayList<String>();
                // begin implementeren ingelezen gegevens doorgeven aan model
                for (int i = 0; i < input.size(); i++) {
                    String inputline = input.get(i);
                    String[] elementen = inputline.split(" ");
                    scores.add(inputline);
                }
                Collections.sort(scores);
                // einde implementeren ingelezen gegevens doorgeven aan model
            } catch (IOException e) {
                //
            }
        } else {
            AlertBlackjack errorWindow = new AlertBlackjack(AlertType.ERROR, "ERROR", "Problem with the selected input file:", "File is not readable", "OK");
            errorWindow.showAndWait();
        }
    }
    private void savingPlayerNameAndScore() {
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
                output.format("%s%n", player.getPlayerName());
                output.format("%s%n", player.getBank());
                // Einde implementeren wegschrijven model-gegevens
            } catch (IOException e) {
                //
            }
        } else {
            AlertBlackjack errorWindow = new AlertBlackjack(AlertType.ERROR, "ERROR", "Problem with the selected output file: ", "File is not writable", "OK");
            errorWindow.showAndWait();
        }
    }

    //Getter
    public ActionEvent getInfoActionEvent() {
        return infoActionEvent;
    }

}
