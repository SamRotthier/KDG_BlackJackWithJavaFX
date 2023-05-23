package MVPGlobal.View.HighScoreScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.MalformedURLException;

public class HighScoreScreenView extends BorderPane {
/*
    private UISettings uiSettings;
    private Button okButton;
    private ImageView logo;
    private Label highscore;
    private Label nickname;

    public HighScoreScreenView() {
        this.uiSettings = new UISettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        okButton = new Button("OK");
        okButton.setPrefWidth(uiSettings.getLowestRes()/29);
        highscore = new Label("Highscore:");
        nickname = new Label("Nickname:");
    }

    private void layoutNodes() {


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
        } else { // do nothing, if AboutImage is not available, program can continue
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
*/
}
