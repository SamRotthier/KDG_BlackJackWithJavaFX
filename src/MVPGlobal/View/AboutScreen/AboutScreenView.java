package MVPGlobal.View.AboutScreen;

import java.net.MalformedURLException;
import java.nio.file.Files;
import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * This is the view of the about screen
 *
 * @author Sam Rotthier
 * @author Matthias Vermeiren
 * @version 3.0
 */
public class AboutScreenView extends BorderPane {

    private UISettings uiSettings;
    private Button okButton;
    private ImageView logo;
    private Label devs;
    private Label version;

    /**
     * This is the constructor for this view
     *
     * @param uiSettings, this is the UI Settings
     */
    public AboutScreenView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    /**
     * This will initialize the nodes
     */
    private void initialiseNodes() {
        okButton = new Button("OK");
        okButton.setPrefWidth(uiSettings.getLowestRes()/29);
        devs = new Label("This game was developed by Sam Rotthier and Matthias Vermeiren");
        version = new Label("Version 3");
    }

    /**
     * This method will build up and make the node look the right way
     */
    private void layoutNodes() {
        try{
            this.setBackground(new Background(new BackgroundImage(new Image(uiSettings.getStartScreenBackground().toUri().toURL().toString()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,new BackgroundSize(100, 100, true, true, false, true))));
            this.setCenter(new Canvas(480, 360));
        }
        catch (MalformedURLException ex){
            //Do nothing if exception
        }

        BorderPane centralPane = new BorderPane();
        int ImageSize = uiSettings.getLowestRes()/3;
         if (Files.exists(uiSettings.getAboutImagePath())) {
            try {
                logo = new ImageView(new Image(uiSettings.getAboutImagePath().toUri().toURL().toString()));
                logo.setPreserveRatio(true);
                logo.setFitHeight(ImageSize*1.2);
                logo.setFitWidth(ImageSize*1.2);
                logo.setSmooth(true);
                centralPane.setCenter(logo);
            }
            catch (MalformedURLException ex) {
                // do nothing, if toURL-conversion fails, program can continue
            }
        } else {
             // do nothing, if AboutImage is not available, program can continue
        }
        VBox labelsPane = new VBox();
        labelsPane.getChildren().addAll(devs, version);
        labelsPane.setAlignment(Pos.CENTER);
        labelsPane.setSpacing(uiSettings.getSpacing()*1.5);

        centralPane.setBottom(labelsPane);
        setCenter(centralPane);
        BorderPane.setAlignment(okButton, Pos.CENTER_RIGHT);
        BorderPane.setMargin(okButton, new Insets(uiSettings.getInsetsMargin(), 0, 0, 0));
        setBottom(okButton);
        setPrefWidth(uiSettings.getLowestRes() / 4);
        setPrefHeight(uiSettings.getLowestRes() / 4);
    }

    Button getBtnOk() {
        return okButton;
    }
}
