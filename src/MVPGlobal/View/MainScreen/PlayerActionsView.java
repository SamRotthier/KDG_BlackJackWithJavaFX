package MVPGlobal.View.MainScreen;

import MVPGlobal.View.StartScreen.StartScreenTransition;
import MVPGlobal.View.UISettings;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class PlayerActionsView extends VBox {

    private UISettings uiSettings;
    private Button buttonHit;
    private Button buttonDouble;
    private Button buttonStand;
    private Button buttonDeal;
    private DealerTransition duration;

    public PlayerActionsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.buttonHit = new Button("HIT");
        this.buttonDouble = new Button("DOUBLE");
        this.buttonStand = new Button("STAND");
        this.buttonDeal = new Button("DEAL");
        //this.duration = new TranslateTransition(Duration.seconds(5));
    }

    private void layoutNodes() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(uiSettings.getSpacing() * 5);
        this.setPadding(new Insets(uiSettings.getInsetsMargin()));
        this.getChildren().addAll(buttonDeal);
    }

    public void standAnimation(){
        duration = new DealerTransition(this, 5);
        duration.play();
    }


    // Getters
    Button getButtonDeal() {
        return buttonDeal;
    }

    Button getButtonHit() {
        return buttonHit;
    }

    Button getButtonStand() {
        return buttonStand;
    }

    Button getButtonDouble() {
        return buttonDouble;
    }

    public DealerTransition getDuration() {
        return duration;
    }
}
