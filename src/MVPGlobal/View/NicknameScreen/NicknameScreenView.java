package MVPGlobal.View.NicknameScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.MalformedURLException;

/**
 * This is the view class for the nickname screen.
 * The player has to enter a nickname on this screen
 *
 * @author Sam Rotthier
 * @author Matthias Vermeiren
 * @version 3.0
 */

public class NicknameScreenView extends BorderPane {

    private UISettings uiSettings;
    private Label chooseNickname;
    private TextField nickname;
    private Button confirmButton;

    public NicknameScreenView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        nickname = new TextField();
        chooseNickname = new Label("Enter your nickname: ");
        confirmButton = new Button("CONFIRM");
        confirmButton.setPrefWidth(uiSettings.getLowestRes() / 29);
    }

    private void layoutNodes() {
        nickname.setPromptText("Nickname");
        nickname.setMaxWidth(uiSettings.getLowestRes() / 7);

        VBox nicknameBox = new VBox();
        nicknameBox.setSpacing(uiSettings.getSpacing());
        nicknameBox.getChildren().addAll(chooseNickname, nickname);
        setCenter(nicknameBox);

        setPadding(new Insets(uiSettings.getInsetsMargin()));
        BorderPane.setAlignment(confirmButton, Pos.CENTER_RIGHT);
        BorderPane.setMargin(confirmButton, new Insets(uiSettings.getInsetsMargin(), 0, 0, 0));
        setBottom(confirmButton);


        confirmButton.getStyleClass().add("confirmBtn");
        nickname.getStyleClass().add("nicknameTextfield");
        this.getStyleClass().add("nickname");
    }

    Button getBtnConfirm() {
        return confirmButton;
    }

    public TextField getNickname() {
        return nickname;
    }
}
