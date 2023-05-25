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

/**
 * This is the info screen view class.
 */
public class InfoScreenView extends BorderPane{

    private UISettings uiSettings;
    private TextArea InfoText;
    private Button okButton;

    /**
     * This the constructor.
     *
     * @param uiSettings
     */
    public InfoScreenView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    /**
     * This initializes the right attributes.
     */
    private void initialiseNodes() {
        InfoText = new TextArea();
        okButton = new Button("OK");
        okButton.setPrefWidth(uiSettings.getLowestRes()/29);
    }

    /**
     * This gives the nodes the right layout.
     */
    private void layoutNodes() {
        setCenter(InfoText);
        InfoText.setWrapText(true);
        InfoText.setEditable(false);

        try{
            Background infoBackground = (new Background(new BackgroundImage(new Image(uiSettings.getStartScreenBackground().toUri().toURL().toString()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,new BackgroundSize(100, 100, true, true, false, true))));
            setBackground(infoBackground);
        }
        catch (MalformedURLException ex){
            //Do nothing if failed
        }
        setPadding(new Insets(uiSettings.getInsetsMargin()));
        BorderPane.setAlignment(okButton, Pos.CENTER_RIGHT);
        BorderPane.setMargin(okButton, new Insets(uiSettings.getInsetsMargin(), 0, 0, 0));
        setBottom(okButton);
    }

    TextArea getInfoText () {return InfoText;}

    Button getBtnOk() {
        return okButton;
    }
}
