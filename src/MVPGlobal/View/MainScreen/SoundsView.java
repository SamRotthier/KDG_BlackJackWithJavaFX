package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.*;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

public class SoundsView{

    private UISettings uiSettings;
    private MediaPlayer backgroundMusic;

    private static final int NUM_DEAL = 5;

    public SoundsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
        //playBackgroundMusic();
    }

    private void initialiseNodes() {
        //
    }

    private void layoutNodes() {
        //
    }

    public void playBackgroundMusic(){
        try{
            backgroundMusic = new MediaPlayer(new Media(uiSettings.getBackgroundMusicGame().toUri().toURL().toString()));
            backgroundMusic.play();
            backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);}
        catch (MalformedURLException ex) {
        }
    }

    public void playDealCard(){
        Random random = new Random();
        int dealSoundNumber = random.nextInt(NUM_DEAL) + 1;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(uiSettings.getCardDealSound()).append(dealSoundNumber).append(".mp3");
        String dealSoundFile = stringBuilder.toString();

        //try{
        //AudioClip dealSound = new AudioClip(new File(dealSoundFile).toURI().toURL().toString());
        //dealSound.play();
        //}
        //catch(MalformedURLException ex){};
    }

}
