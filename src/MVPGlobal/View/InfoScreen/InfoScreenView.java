package MVPGlobal.View.InfoScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.net.MalformedURLException;

public class InfoScreenView extends BorderPane{

    private UISettings uiSettings;
    private TextArea InfoText;
    private Button okButton;

    public InfoScreenView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        InfoText = new TextArea("test");
        okButton = new Button("OK");
        okButton.setPrefWidth(60);
    }

    private void layoutNodes() {
        setCenter(InfoText);
        InfoText.setPrefWidth(1000);
        InfoText.setPrefHeight(1000);
        InfoText.setWrapText(true);
        InfoText.setFont(Font.font("Poppins", 12));
        InfoText.setEditable(false);

        try{
            Background infoBackground = (new Background(new BackgroundImage(new Image(uiSettings.getStartScreenBackground().toUri().toURL().toString()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,new BackgroundSize(100, 100, true, true, false, true))));
            setBackground(infoBackground);
        }
        catch (MalformedURLException ex){
        }
        //InfoText.setPrefWidth(uiSettings.getLowestRes() / 2);
        //InfoText.setPrefHeight(uiSettings.getLowestRes() / 2);
        setPadding(new Insets(uiSettings.getInsetsMargin()));
        BorderPane.setAlignment(okButton, Pos.CENTER_RIGHT);
        BorderPane.setMargin(okButton, new Insets(uiSettings.getInsetsMargin(), 0, 0, 0));
        setBottom(okButton);
        setPrefWidth(uiSettings.getLowestRes());
        setPrefHeight(uiSettings.getLowestRes());
    }

    TextArea getInfoText () {return InfoText;}

    Button getBtnOk() {
        return okButton;
    }
}
