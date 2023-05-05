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


    private Button buttonHit;
    private Button buttonDouble;
    private Button buttonStand;
    private Button buttonDeal;

    private Label setBetAmount;
    private TextField betAmount;

    private Button arrowUp;
    private Button arrowDown;

    private MediaPlayer backgroundMusic;


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

        this.buttonHit = new Button("HIT");
        this.buttonDouble = new Button("DOUBLE");
        this.buttonStand = new Button("STAND");
        this.buttonDeal = new Button("DEAL");

        this.saldoLabel = new Label("Saldo: ");
        this.betAmountLabel = new Label("Bet amount: ");
        this.setBetAmount = new Label("Your bet: ");
        this.betAmount = new TextField("");
        Image arrowUpIcon = new Image("/images/arrowup.png", 18, 18, false, false);
        this.arrowUp = new Button("", new ImageView(arrowUpIcon));
        Image arrowDownIcon = new Image("/images/arrowdown.png", 18, 18, false, false);
        this.arrowDown = new Button("", new ImageView(arrowDownIcon));
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
        try{
            backgroundMusic = new MediaPlayer(new Media(uiSettings.getBackgroundMusicGame().toUri().toURL().toString()));
            backgroundMusic.play();
            backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);}
        catch(MalformedURLException ex){}

        //ButtonsLeft
        HBox arrowButtonsBox = new HBox(arrowUp, arrowDown);
        arrowButtonsBox.setSpacing(20);
        arrowButtonsBox.setPadding(new Insets(10));

        VBox inputLeftBox = new VBox();
        inputLeftBox.setAlignment(Pos.CENTER);
        inputLeftBox.setSpacing(10);
        inputLeftBox.setPadding(new Insets(20));
        inputLeftBox.setPrefWidth(20);

        inputLeftBox.getChildren().addAll(setBetAmount, betAmount, arrowButtonsBox);
        this.setLeft(inputLeftBox);


        //ButtonsRight
        VBox buttonsRightBox = new VBox();
        buttonsRightBox.setAlignment(Pos.CENTER);
        buttonsRightBox.setSpacing(100);
        buttonsRightBox.setPadding(new Insets(20));

        buttonsRightBox.getChildren().addAll(buttonDeal,buttonHit, buttonStand, buttonDouble);
        this.setRight(buttonsRightBox);


        //Bottom
        HBox saldoBetBox = new HBox();
        saldoBetBox.setSpacing(100);
        saldoBetBox.setPadding(new Insets(20));
        BackgroundFill bottomFill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background bottomBackground = new Background(bottomFill);
        saldoBetBox.setBackground(bottomBackground);


        saldoBetBox.getChildren().addAll(saldoLabel, betAmountLabel);
        this.setBottom(saldoBetBox);


    }

    MenuItem getExitItem() {return exitMI;}

    MenuItem getSaveItem() {return saveMI;}

    MenuItem getLoadItem() {return loadMI;}

    MenuItem getSettingsItem() {return settingsMI;}

    MenuItem getAboutItem() {return aboutMI;}

    MenuItem getInfoItem() {return infoMI;}

}
