package MVPGlobal.View.AlertScreen;

import javafx.scene.control.*;

/**
 * This class is the Blackjack alert class
 *
 * @author Sam Rotthier
 * @author Matthias Vermeiren
 * @version 3.0
 */
public class AlertBlackjack extends Alert {

    private String title;
    private String buttonOk;
    private String header;


    /**
     * This is the constructor for the alert
     *
     * @param alertType
     * @param title
     * @param header
     * @param text
     * @param buttonOk
     */
    public AlertBlackjack(AlertType alertType, String title, String header,String text, String buttonOk) {
        super(alertType, text);
        this.title = title;
        this.header = header;
        this.buttonOk = buttonOk;
        layoutNodes();
    }

    /**
     * This will make the node have the right layout
     */
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
