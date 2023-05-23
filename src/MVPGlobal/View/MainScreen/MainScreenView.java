package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
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
import javafx.util.Duration;

import javax.management.loading.PrivateClassLoader;
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

    private PlayerActionsView actionButtons;

    private BetView betButtons;

    private SoundsView sounds;

    private PlayerCardsView playerCardsView;

    private DealerCardsView dealerCardsView;

    private BottomLabelsView bottomLabels;

    private VBox cardsPlayerDealerBox;

    private WinLoseView winLoseView;

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

        actionButtons = new PlayerActionsView(uiSettings);
        betButtons = new BetView(uiSettings);

        playerCardsView = new PlayerCardsView(uiSettings);
        dealerCardsView = new DealerCardsView(uiSettings);
        sounds = new SoundsView(uiSettings);
        bottomLabels = new BottomLabelsView(uiSettings);
        cardsPlayerDealerBox = new VBox();
        winLoseView = new WinLoseView(uiSettings);
    }

    private void layoutNodes() {
        //background
        try{
            this.setBackground(new Background(new BackgroundImage(new Image(uiSettings.getGameScreenBackground().toUri().toURL().toString()),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(100, 100, true, true, false, true))));
        }
        catch (MalformedURLException ex){}

        // music
        //getSounds().playBackgroundMusic();

        
        Menu menuFile = new Menu("File",null,loadMI, saveMI, new SeparatorMenuItem(), settingsMI, new SeparatorMenuItem(),exitMI);
        Menu menuHelp = new Menu("Help",null, aboutMI, infoMI);
        MenuBar menuBar = new MenuBar(menuFile,menuHelp);
        setTop(menuBar);


        //ButtonsLeft
        this.setLeft(betButtons);


        //ButtonsRight
        this.setRight(actionButtons);


        //Bottom

        this.setBottom(bottomLabels);

        // Center
        cardsPlayerDealerBox.setSpacing(uiSettings.getSpacing()*10);
        cardsPlayerDealerBox.setTranslateX(-60);
        cardsPlayerDealerBox.setPadding(new Insets(uiSettings.getInsetsMargin()*2.5, uiSettings.getInsetsMargin(), uiSettings.getInsetsMargin(), uiSettings.getInsetsMargin()));
        cardsPlayerDealerBox.setAlignment(Pos.CENTER);
        cardsPlayerDealerBox.getChildren().addAll(dealerCardsView, playerCardsView);

        //StackPane centerPane = new StackPane();
        //centerPane.getChildren().addAll(cardsPlayerDealerBox,winLoseView);

        this.setCenter(cardsPlayerDealerBox);

    }

    // Animation
    public Animation fadeInAnimation(VBox vbox){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(.7), vbox);
        //start position
        fadeIn.setFromValue(0.2);
        //end position
        fadeIn.setToValue(1.0);
        fadeIn.setInterpolator(Interpolator.EASE_IN);

        fadeIn.play();
        return fadeIn;
    }


    // Getters
    MenuItem getExitItem() {return exitMI;}

    MenuItem getSaveItem() {return saveMI;}

    MenuItem getLoadItem() {return loadMI;}

    MenuItem getSettingsItem() {return settingsMI;}

    MenuItem getAboutItem() {return aboutMI;}

    MenuItem getInfoItem() {return infoMI;}

    PlayerActionsView getActionButtons() {return actionButtons;}

    PlayerCardsView getPlayerCardsView() {
        return playerCardsView;
    }
    DealerCardsView getDealerCardsView() {
        return dealerCardsView;
    }

    public VBox getCardsPlayerDealerBox() {
        return cardsPlayerDealerBox;
    }
    public WinLoseView getWinLoseView() {
        return winLoseView;
    }



    BetView getBetButtons(){return betButtons;}
    public SoundsView getSounds() {return sounds;}

    public BottomLabelsView getBottomLabels() {
        return bottomLabels;
    }
}
