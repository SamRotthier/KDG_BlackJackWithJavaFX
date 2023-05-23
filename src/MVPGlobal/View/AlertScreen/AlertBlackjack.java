package MVPGlobal.View.AlertScreen;

import javafx.scene.control.*;

public class AlertBlackjack extends Alert {

    private String title;
    private String buttonOk;
    private String header;

    public AlertBlackjack(AlertType alertType, String title, String header,String text, String buttonOk) {
        super(alertType, text);
        this.title = title;
        this.header = header;
        this.buttonOk = buttonOk;
        layoutNodes();
    }

    private void layoutNodes(){
        this.setTitle(title);
        this.setHeaderText(header);

        ((Button) this.getDialogPane().lookupButton(ButtonType.OK)).setText(buttonOk);

        //Css
        DialogPane dialogPane = this.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/stylesheets/BlackjackKnightsOfTheFuture.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog");

        this.setGraphic(null);
    }
}
