package MVPGlobal.View.AlertScreen;

import javafx.scene.control.*;

public class AlertBlackjack extends Alert {
    private String title;
    private String buttonOk;


    public AlertBlackjack(AlertType alertType, String text, String title, String buttonOk) {
        super(alertType, text);
        this.title = title;
        this.buttonOk = buttonOk;
        layoutNodes();
    }

    private void layoutNodes(){
        this.setTitle(title);

        ((Button) this.getDialogPane().lookupButton(ButtonType.OK)).setText(buttonOk);

        //Css
        DialogPane dialogPane = this.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/stylesheets/BlackjackKnightsOfTheFuture.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog");

        this.setGraphic(null);
    }
}
