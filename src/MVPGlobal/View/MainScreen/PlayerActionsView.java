package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
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

public class PlayerActionsView extends VBox  {

    //private UISettings uiSettings;

    private Button buttonHit;
    private Button buttonDouble;
    private Button buttonStand;
    private Button buttonDeal;
    private Button buttonNextRound;




    public PlayerActionsView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.buttonHit = new Button("HIT");
        this.buttonDouble = new Button("DOUBLE");
        this.buttonStand = new Button("STAND");
        this.buttonDeal = new Button("DEAL");
        this.buttonNextRound = new Button("NEXT");

        buttonNextRound.setVisible(false);
    }

    private void layoutNodes() {
        //ButtonsRight
        this.setAlignment(Pos.CENTER);
        this.setSpacing(100);
        this.setPadding(new Insets(20));

        this.getChildren().addAll(buttonDeal,buttonHit, buttonDouble, buttonStand,buttonNextRound);

    }

    // Getters

    Button getButtonDeal() {return buttonDeal;}

    Button getButtonHit() {return buttonHit;}

    Button getButtonStand() {return buttonStand;}

    Button getButtonDouble() {return buttonDouble;}

    Button getbuttonNextRound() {return buttonNextRound;}

}
