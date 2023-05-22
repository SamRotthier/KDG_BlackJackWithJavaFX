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
    private StringBuilder stringBuilder;

    private static final int NUM_DEAL = 5;

    public SoundsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.stringBuilder = new StringBuilder();
    }

    private void layoutNodes() {
        //
    }

    public void playBlackjackStart(){
        try{
            String blackjackStartSound = uiSettings.getBlackjackStartSound().toString();
            AudioClip blackjackStart = new AudioClip(new File(blackjackStartSound).toURI().toURL().toString());
            blackjackStart.play();
        }
        catch(MalformedURLException ex){}
    }

    public void playBackgroundMusic(){
        try{
            backgroundMusic = new MediaPlayer(new Media(uiSettings.getBackgroundMusicGame().toUri().toURL().toString()));
            backgroundMusic.play();
            backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);}
        catch (MalformedURLException ex) {
        }
    }

    public void playStartBtn(){

        String startBtnSound = uiSettings.getStartBtnSound().toString();
        try{
            AudioClip startBtn = new AudioClip(new File(startBtnSound).toURI().toURL().toString());
            startBtn.play();
        }
        catch(MalformedURLException ex){};
    };

    public void playLoadBtn(){
        String loadBtnSound = uiSettings.getLoadBtnSound().toString();
        try{
            AudioClip startBtn = new AudioClip(new File(loadBtnSound).toURI().toURL().toString());
            startBtn.play();
        }
        catch(MalformedURLException ex){};

    };

    public void playInfoBtn(){
        String infoBtnSound = uiSettings.getInfoBtnSound().toString();
        try{
            AudioClip startBtn = new AudioClip(new File(infoBtnSound).toURI().toURL().toString());
            startBtn.play();
        }
        catch(MalformedURLException ex){};
    };

    public void playDealCard(){
/*
        Random random = new Random();
        int dealSoundNumber = random.nextInt(NUM_DEAL) + 1;

        stringBuilder.append(uiSettings.getCardDealSound()).append(dealSoundNumber).append(".mp3");
        String dealSoundFile = stringBuilder.toString();

        try{
        AudioClip dealSound = new AudioClip(new File(dealSoundFile).toURI().toURL().toString());
        dealSound.play();
        }
        catch(MalformedURLException ex){};*/
    }

    public void setBackgroundMusic(MediaPlayer backgroundMusic) {
        this.backgroundMusic = backgroundMusic;
    }

    public MediaPlayer getBackgroundMusic() {
        return backgroundMusic;
    }
}
