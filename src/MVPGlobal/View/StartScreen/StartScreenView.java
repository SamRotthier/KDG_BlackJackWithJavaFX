package MVPGlobal.View.StartScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.geometry.*;
import javafx.scene.canvas.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.MalformedURLException;
import java.nio.file.Files;

public class StartScreenView extends BorderPane  {

    private UISettings uiSettings;
    private Label timeDisplay;
    private ProgressBar timeProgress;
    private StartScreenTransition trans;

    public StartScreenView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
        animate();
    }

    private void initialiseNodes() {
        this.timeDisplay = new Label("Loading: 0.0");
        this.timeProgress = new ProgressBar();
    }

    private void layoutNodes() {
        //background
        try{
            this.setBackground(new Background(new BackgroundImage(new Image(uiSettings.getStartScreenBackground().toUri().toURL().toString()),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
            this.setCenter(new Canvas(480, 360));
        }
        catch (MalformedURLException ex){
        }
        int ImageSize = uiSettings.getLowestRes()/5;
        BorderPane progressPane = new BorderPane();
        progressPane.setCenter(this.timeProgress);
        progressPane.setBottom(this.timeDisplay);
        progressPane.setAlignment(this.timeDisplay, Pos.CENTER);
        BorderPane.setMargin(this.timeDisplay, new Insets(0,10, 50, 10));
        BorderPane.setMargin(this.timeProgress, new Insets(uiSettings.getInsetsMargin()));
        ImageView centralImage;
        if (Files.exists(uiSettings.getStartScreenImagePath())) {
           try {
                centralImage = new ImageView(new Image(uiSettings.getStartScreenImagePath().toUri().toURL().toString()));
                centralImage.setPreserveRatio(true);
                centralImage.setFitHeight(ImageSize);
                centralImage.setFitWidth(ImageSize);
                //centralImage.setSmooth(true);
                this.setCenter(centralImage);
            }
            catch (MalformedURLException ex) {
                // do nothing, if toURL-conversion fails, program can continue
            }
        } else { // do nothing, if StartScreenImage is not available, program can continue
            }
        this.setBottom(progressPane);


    }

    Label getTimeDisplay () {return (timeDisplay);}

    ProgressBar getTimeProgress () {return (timeProgress);}

    StartScreenTransition getTransition() {return trans;}

    private void animate() {
        trans = new StartScreenTransition(this,3);
        trans.play();
    }

}
