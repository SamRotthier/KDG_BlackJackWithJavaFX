package MVPGlobal.View.BeginScreen;

import MVPGlobal.View.MainScreen.MainScreenView;
import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.MalformedURLException;

public class BeginScreenView extends BorderPane  {

    private UISettings uiSettings;
    private MainScreenView mainScreenView;
    private ImageView centralImage;

    private Button moreInfoBtn;

    private Button loadGameBtn;

    private Button startGameBtn;

    private Label welcomeText;
    private Label instructions;

    // private AudioClip blackjackStartSound;


    public BeginScreenView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.centralImage = new ImageView();
        this.mainScreenView = new MainScreenView(uiSettings);
        moreInfoBtn = new Button("MORE INFO");
        loadGameBtn = new Button("LOAD GAME");
        startGameBtn = new Button("START GAME");
        welcomeText = new Label("Welcome to Knights Of The Future - Blackjack!");
        instructions = new Label("Choose an option below");
    }

    private void layoutNodes() {
        //background
        try{
            this.setBackground(new Background(new BackgroundImage(new Image(uiSettings.getStartScreenBackground().toUri().toURL().toString()),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,new BackgroundSize(100, 100, true, true, false, true))));
        }
        catch (MalformedURLException ex){
        }

        //Css
        moreInfoBtn.getStyleClass().add("beginButtons");
        loadGameBtn.getStyleClass().add("beginButtons");
        startGameBtn.getStyleClass().add("beginButtons");
        welcomeText.getStyleClass().add("heading1");
        instructions.getStyleClass().add("heading2");



        int ImageSize = uiSettings.getLowestRes()/5;


           try {
                centralImage = new ImageView(new Image(uiSettings.getStartScreenImagePath().toUri().toURL().toString()));
                centralImage.setPreserveRatio(true);
                centralImage.setFitHeight(ImageSize*2.5*1.10);
                centralImage.setFitWidth(ImageSize*2.5*1.10);
                centralImage.setSmooth(true);
            }
            catch (MalformedURLException ex) {
                // do nothing, if toURL-conversion fails, program can continue
            }


        //VBox
        VBox splash = new VBox();
        splash.setAlignment(Pos.CENTER);
        splash.setSpacing(uiSettings.getSpacing()*1.5);
        splash.setPadding(new Insets(uiSettings.getInsetsMargin()*2.5));

        splash.getChildren().addAll(centralImage,welcomeText, instructions);
        this.setCenter(splash);

        //HBox
        HBox btnsBegin = new HBox(moreInfoBtn, loadGameBtn, startGameBtn);
        btnsBegin.setAlignment(Pos.CENTER);
        btnsBegin.setSpacing(uiSettings.getSpacing()*5);
        btnsBegin.setPadding(new Insets(uiSettings.getInsetsMargin()*2.5, uiSettings.getInsetsMargin()*2.5,uiSettings.getInsetsMargin()*4.5, uiSettings.getInsetsMargin()*2.5));

        this.setBottom(btnsBegin);
    }

    public Button getMoreInfoBtn() {
        return moreInfoBtn;
    }

    public Button getLoadGameBtn() {
        return loadGameBtn;
    }

    public Button getStartGameBtn() {
        return startGameBtn;
    }
}
