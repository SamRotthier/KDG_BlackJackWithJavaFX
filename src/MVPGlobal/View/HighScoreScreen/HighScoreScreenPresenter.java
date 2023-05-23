package MVPGlobal.View.HighScoreScreen;

import MVPGlobal.Model.BlackJackGame;
import MVPGlobal.Model.Card;
import MVPGlobal.Model.HighScoreContestants;
import MVPGlobal.Model.HighScoreHandler;
import MVPGlobal.View.InfoScreen.InfoScreenView;
import MVPGlobal.View.UISettings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
    String scanLine = "";

        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(uiSettings.getHighScoreFile().toString()));
            int i=0;
            while(scanLine != null){

            scanLine = bufferReader.readLine();
            model.highScoreHandler.highScores[i] = scanLine.split(",");
            model.highScoreHandler.getHighScores().
            i++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
