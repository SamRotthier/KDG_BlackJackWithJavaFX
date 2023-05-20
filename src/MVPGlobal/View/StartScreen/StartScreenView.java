package MVPGlobal.View.StartScreen;

import MVPGlobal.View.MainScreen.MainScreenView;
import MVPGlobal.View.UISettings;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.*;
import javafx.scene.canvas.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;

public class StartScreenView extends BorderPane  {

    private UISettings uiSettings;
    private Label timeDisplay;
    private ProgressBar timeProgress;
    private StartScreenTransition trans;
    private MainScreenView mainScreenView;

    private ImageView centralImage;

    private AudioClip blackjackStartSound;


    public StartScreenView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
        animate();
    }

    private void initialiseNodes() {
        this.timeDisplay = new Label("Loading: 0.0");
        this.timeProgress = new ProgressBar();
        this.centralImage = new ImageView();
        this.mainScreenView = new MainScreenView(uiSettings);
        String soundFile = "resources/music/BlackjackStartTest.mp3";
        this.blackjackStartSound = new AudioClip(new File(soundFile).toURI().toString());
    }

    private void layoutNodes() {
        //background
        try{
            this.setBackground(new Background(new BackgroundImage(new Image(uiSettings.getStartScreenBackground().toUri().toURL().toString()),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,new BackgroundSize(100, 100, true, true, false, true))));
        }
        catch (MalformedURLException ex){
        }

        //music
        //blackjackStartSound.play();


        int ImageSize = uiSettings.getLowestRes()/5;
        BorderPane progressPane = new BorderPane();
        progressPane.setCenter(this.timeProgress);
        progressPane.setBottom(this.timeDisplay);
        progressPane.setAlignment(this.timeDisplay, Pos.CENTER);
        timeProgress.setPrefSize(250,25);
        BorderPane.setMargin(this.timeDisplay, new Insets(0,10, 50, 10));
        BorderPane.setMargin(this.timeProgress, new Insets(uiSettings.getInsetsMargin()));


        //ImageView centralImage;
        //StackPane logoPane = new StackPane();
        //logoPane.setPadding(new Insets(20));
        if (Files.exists(uiSettings.getStartScreenImagePath())) {
           try {
                centralImage = new ImageView(new Image(uiSettings.getStartScreenImagePath().toUri().toURL().toString()));
                centralImage.setPreserveRatio(true);
                centralImage.setFitHeight(ImageSize*2.5);
                centralImage.setFitWidth(ImageSize*2.5);
                centralImage.setSmooth(true);


                //logoPane.getChildren().add(centralImage);
            }
            catch (MalformedURLException ex) {
                // do nothing, if toURL-conversion fails, program can continue
            }
        } else { // do nothing, if StartScreenImage is not available, program can continue
            }
        //

        //VBox
        VBox splash = new VBox();
        splash.setAlignment(Pos.CENTER);
        splash.setSpacing(30);
        splash.setPadding(new Insets(50));

        splash.getChildren().addAll(centralImage, new Label("This game was developed by Sam Rotthier and Matthias Vermeiren"), new Label("Version 1.5"));
        this.setCenter(splash);

        this.setBottom(progressPane);


    }

    Label getTimeDisplay () {return (timeDisplay);}

    ProgressBar getTimeProgress () {return (timeProgress);}

    StartScreenTransition getTransition() {return trans;}

    private void animate() {
        trans = new StartScreenTransition(this,5);
        trans.play();

        // logo image animation

        ScaleTransition logoTransition = new ScaleTransition(Duration.seconds(2), centralImage);
        logoTransition.setToX(1.15);
        logoTransition.setToY(1.15);
        logoTransition.play();
    }

}
