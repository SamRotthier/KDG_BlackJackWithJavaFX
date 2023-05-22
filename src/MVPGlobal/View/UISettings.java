package MVPGlobal.View;

import javafx.stage.Screen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UISettings {
    private int resX;
    private int resY;
    private int insetsMargin;
    private int spacing;
    private int cardWidth;
    private int cardHeight;
    private int cardOffsetX;
    private int cardOffsetY;
    private int cardRotate;
    public static final char FILE_SEPARATOR = System.getProperties().getProperty("file.separator").charAt(0);
    private String ApplicationName;
    private String homeDir;

    // CSS Path
    private Path styleSheetPath = Paths.get("resources"+FILE_SEPARATOR+"stylesheets"+FILE_SEPARATOR+"blackjackknightsofthefuture.css");

    //Images Paths
    private Path AboutImagePath = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"logoblackjackmedievaloption3.png");
    private Path applicationIconPath = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"knightsofthefutureLogo.png");
    private Path startScreenImagePath = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"logoblackjackmedievaloption3.png");
    private Path startScreenBackground = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"medievalBackground.jpeg");
    private Path gameScreenBackground = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"BackgroundTableLogo.png");
    private Path cardImage = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"cards"+FILE_SEPARATOR);
    private Path arrowUp = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"arrowup.png");
    private Path arrowDown = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"arrowdown.png");

    // Txt Path
    private Path infoTextPath = Paths.get("resources"+FILE_SEPARATOR+"other"+FILE_SEPARATOR+"blackjackinfo.txt");

    // Audio Paths
    private Path backgroundMusicGame = Paths.get("resources"+FILE_SEPARATOR+"music"+FILE_SEPARATOR+"blackjackgameaudio.mp3");
    private Path blackjackStartSound = Paths.get("resources"+FILE_SEPARATOR+"music"+FILE_SEPARATOR+"blackjackstart.mp3");
    private Path startBtnSound = Paths.get("resources"+FILE_SEPARATOR+"music"+FILE_SEPARATOR+"SwordStartBtn.mp3");
    private Path loadBtnSound = Paths.get("resources"+FILE_SEPARATOR+"music"+FILE_SEPARATOR+"SwordLoadBtn.mp3");
    private Path infoBtnSound = Paths.get("resources"+FILE_SEPARATOR+"music"+FILE_SEPARATOR+"SwordInfoBtn.mp3");
    private Path cardDealSound = Paths.get("resources"+FILE_SEPARATOR+"music"+FILE_SEPARATOR+"CardDeal");


    public UISettings() {
        this.resX= (int) Screen.getPrimary().getVisualBounds().getWidth();
        this.resY = (int) Screen.getPrimary().getVisualBounds().getHeight();
        this.insetsMargin = this.getLowestRes()/85;
        this.spacing = this.getLowestRes() / 85;
        System.out.println(getLowestRes());

        this.homeDir = System.getProperties().getProperty("user.dir");
        this.ApplicationName = "Knights Of The Future - Blackjack";

        // Cards
        this.cardWidth = 150;
        this.cardHeight = 180;
        this.cardOffsetX = 70;
        this.cardOffsetY = 5;
        this.cardRotate = 5;
    };

    // Getters & Setters

    public int getResX () {return this.resX;}

    public int getResY () {return this.resY;}

    public int getInsetsMargin () {return this.insetsMargin;}

    public int getSpacing() {return spacing;}

    public int getLowestRes () {return (resX>resY?resX:resY);}

    public int getCardWidth() {return this.cardWidth;};
    public int getCardHeight() {return this.cardHeight;};

    public int getCardOffsetX() {return this.cardOffsetX;};
    public int getCardOffsetY() {return this.cardOffsetY;};
    public int getCardRotate() {return this.cardRotate;};

    public String getHomeDir () {return this.homeDir;}

    public Path getInfoTextPath () {return this.infoTextPath;}

    public String getApplicationName () {return this.ApplicationName;}

        //CSS
    public boolean styleSheetAvailable (){return Files.exists(styleSheetPath);}

    public Path getStyleSheetPath () {return this.styleSheetPath;}

    public void setStyleSheetPath (Path styleSheetPath) {this.styleSheetPath = styleSheetPath;}

        //Images
    public Path getApplicationIconPath () {return this.applicationIconPath;}
    public Path getStartScreenImagePath () {return this.startScreenImagePath;}
    public Path getAboutImagePath () {return this.AboutImagePath;}
    public Path getStartScreenBackground() {return this.startScreenBackground;};
    public Path getGameScreenBackground() {return this.gameScreenBackground;};
    public Path getArrowUp() {return this.arrowUp;};
    public Path getArrowDown() {return this.arrowDown;};

    public Path getCardImage(){return this.cardImage;};

        // Audio
    public Path getBackgroundMusicGame() {return this.backgroundMusicGame;};

    public Path getBlackjackStartSound() {return blackjackStartSound;}

    public Path getCardDealSound(){return this.cardDealSound;};

    public Path getStartBtnSound() {return startBtnSound;}

    public Path getLoadBtnSound() {return loadBtnSound;}

    public Path getInfoBtnSound() {return infoBtnSound;}



}
