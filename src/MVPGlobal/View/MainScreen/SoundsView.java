package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.*;

import java.net.MalformedURLException;

public class SoundsView extends BorderPane  {

    private UISettings uiSettings;
    private MediaPlayer backgroundMusic;


    public SoundsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {

    }

    private void layoutNodes() {
       try{
            backgroundMusic = new MediaPlayer(new Media(uiSettings.getBackgroundMusicGame().toUri().toURL().toString()));
            backgroundMusic.play();
            backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);}
        catch (MalformedURLException ex) {
       }

    }

}
