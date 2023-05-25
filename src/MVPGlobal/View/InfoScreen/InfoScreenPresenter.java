package MVPGlobal.View.InfoScreen;

import MVPGlobal.Model.BlackJackGame;
import MVPGlobal.View.UISettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.*;

/**
 * This is the presenter for the info screen
 */
public class InfoScreenPresenter {

    private BlackJackGame model;
    private InfoScreenView view;
    private UISettings uiSettings;

    /**
     * This is the constructor for the info screen presenter
     *
     * @param model
     * @param view
     * @param uiSettings
     */
    public InfoScreenPresenter(BlackJackGame model, InfoScreenView view, UISettings uiSettings) {
        this.model = model;
        this.view = view;
        this.uiSettings = uiSettings;
        view.getInfoText().setText(ReadInfoFromFile());
        EventHandlers();
    }

    /**
     * This houses the events
     */
    private void EventHandlers() {
        view.getBtnOk().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getScene().getWindow().hide();
            }
        });
    }

    /**
     * This method will get the info text from a given file
     *
     * @return String
     */
    private String ReadInfoFromFile() {
        String infoTextInFile ="";
        try (BufferedReader reader = new BufferedReader(new FileReader(uiSettings.getInfoTextPath().toString()));){
            String line = "";
            //String testString;
            while ((line = reader.readLine())!= null){
                infoTextInFile += line + "\n";
            }
        } catch (Exception ex) {
            // do nothing, if BlackjackInfo.txt file can not be read or is incomplete, or ... a standard text will be return
        }
        return (infoTextInFile.compareTo("")==0)?"No info available":infoTextInFile;
    }
}
