package MVPGlobal.View.HighScoreScreen;

import MVPGlobal.Model.BlackJackGame;
import MVPGlobal.View.InfoScreen.InfoScreenView;
import MVPGlobal.View.UISettings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class HighScoreScreenPresenter {
    private BlackJackGame model;
    private InfoScreenView view;
    private UISettings uiSettings;

    public HighScoreScreenPresenter(BlackJackGame model, InfoScreenView view, UISettings uiSettings) {
        this.model = model;
        this.view = view;
        this.uiSettings = uiSettings;
        getPlayerDataFromFile();
    }

    public void getPlayerDataFromFile(){

        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(uiSettings.getHighScoreFile().toString()));
            //while(line = bufferReader != null){

            //}

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
