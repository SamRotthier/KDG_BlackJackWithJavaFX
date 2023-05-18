package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.net.MalformedURLException;

import static javafx.scene.paint.Color.*;

public class MainScreenView extends BorderPane  {

    private MenuItem exitMI;
    private MenuItem saveMI;
    private MenuItem loadMI;
    private MenuItem settingsMI;
    private MenuItem aboutMI;
    private MenuItem infoMI;
    private UISettings uiSettings;

    private Label saldoLabel;
    private Label betAmountLabel;


    private PlayerActionsView actionButtons;

    private BetView betButtons;

    // private MediaPlayer backgroundMusic;

    private PlayerCardsView playerCards;
    private DealerCardsView dealerCards;

    public MainScreenView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.exitMI = new MenuItem("Exit");
        this.saveMI = new MenuItem("Save");
        this.loadMI = new MenuItem("Load");
        this.settingsMI = new MenuItem("Settings");
        this.aboutMI = new MenuItem("About");
        this.infoMI = new MenuItem("Info");

        actionButtons = new PlayerActionsView();
        betButtons = new BetView(uiSettings);

        this.saldoLabel = new Label("Saldo: ");
        this.betAmountLabel = new Label("Bet amount: ");

        playerCards = new PlayerCardsView(uiSettings);
        dealerCards = new DealerCardsView(uiSettings);
    }

    private void layoutNodes() {
        //background
        try{
            this.setBackground(new Background(new BackgroundImage(new Image(uiSettings.getGameScreenBackground().toUri().toURL().toString()),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(100, 100, true, true, false, true))));
        }
        catch (MalformedURLException ex){}

        
        Menu menuFile = new Menu("File",null,loadMI, saveMI, new SeparatorMenuItem(), settingsMI, new SeparatorMenuItem(),exitMI);
        Menu menuHelp = new Menu("Help",null, aboutMI, infoMI);
        MenuBar menuBar = new MenuBar(menuFile,menuHelp);
        setTop(menuBar);

        //music
       /* try{
            backgroundMusic = new MediaPlayer(new Media(uiSettings.getBackgroundMusicGame().toUri().toURL().toString()));
            backgroundMusic.play();
            backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);}
        catch(MalformedURLException ex){} */

        //ButtonsLeft
        this.setLeft(betButtons);


        //ButtonsRight
        this.setRight(actionButtons);


        //Bottom
        HBox saldoBetBox = new HBox();
        saldoBetBox.setSpacing(100);
        saldoBetBox.setPadding(new Insets(7, 20, 7, 20));
        BackgroundFill bottomFill = new BackgroundFill(Color.web("#22222c"), CornerRadii.EMPTY, Insets.EMPTY);
        Background bottomBackground = new Background(bottomFill);
        saldoBetBox.setBackground(bottomBackground);


        saldoBetBox.getChildren().addAll(saldoLabel, betAmountLabel);
        this.setBottom(saldoBetBox);

        // Center Cards
        VBox cardsPlayerDealerBox = new VBox();
        cardsPlayerDealerBox.setSpacing(200);
        cardsPlayerDealerBox.setTranslateX(-30);
        cardsPlayerDealerBox.setPadding(new Insets(20));
        cardsPlayerDealerBox.setAlignment(Pos.CENTER);
        cardsPlayerDealerBox.getChildren().addAll(dealerCards, playerCards);

        this.setCenter(cardsPlayerDealerBox);


    }

    MenuItem getExitItem() {return exitMI;}

    MenuItem getSaveItem() {return saveMI;}

    MenuItem getLoadItem() {return loadMI;}

    MenuItem getSettingsItem() {return settingsMI;}

    MenuItem getAboutItem() {return aboutMI;}

    MenuItem getInfoItem() {return infoMI;}

    PlayerActionsView getActionButtons() {return actionButtons;};
}
