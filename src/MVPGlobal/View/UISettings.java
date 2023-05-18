package MVPGlobal.View;

import javafx.stage.Screen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UISettings {

    private int resX;
    private int resY;
    private int insetsMargin;
    public static final char FILE_SEPARATOR = System.getProperties().getProperty("file.separator").charAt(0);
    private String ApplicationName;
    private String homeDir;
    //private String defaultCss = "blackjackknightsofthefuture.css";
    private Path styleSheetPath = Paths.get("resources"+FILE_SEPARATOR+"stylesheets"+FILE_SEPARATOR+"blackjackknightsofthefuture.css");
    private Path AboutImagePath = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"logoblackjackmedievaloption3.png");
    private Path applicationIconPath = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"knightsofthefutureLogo.png");
    private Path startScreenImagePath = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"logoblackjackmedievaloption3.png");
    private Path infoTextPath = Paths.get("resources"+FILE_SEPARATOR+"other"+FILE_SEPARATOR+"blackjackinfo.txt");
    private Path startScreenBackground = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"medievalBackground.jpeg");
    private Path gameScreenBackground = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"BackgroundTableLogo.png");
    private Path backgroundMusicGame = Paths.get("resources"+FILE_SEPARATOR+"music"+FILE_SEPARATOR+"blackjackgameaudio.mp3");

    private Path cardsDealerTest = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"clubs2.png");

    private Path arrowUp = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"arrowup.png");
    private Path arrowDown = Paths.get("resources"+FILE_SEPARATOR+"images"+FILE_SEPARATOR+"arrowdown.png");

    public UISettings() {
        this.resX= (int) Screen.getPrimary().getVisualBounds().getWidth();
        this.resY = (int) Screen.getPrimary().getVisualBounds().getHeight();
        this.insetsMargin = this.getLowestRes()/100;
        this.homeDir = System.getProperties().getProperty("user.dir");
        this.ApplicationName = "Blackjack";
    };

    public int getResX () {return this.resX;}

    public int getResY () {return this.resY;}

    public int getInsetsMargin () {return this.insetsMargin;}

    public int getLowestRes () {return (resX>resY?resX:resY);}

    public boolean styleSheetAvailable (){return Files.exists(styleSheetPath);}

    public Path getStyleSheetPath () {return this.styleSheetPath;}

        public void setStyleSheetPath (Path styleSheetPath) {this.styleSheetPath = styleSheetPath;}

    public String getHomeDir () {return this.homeDir;}

    public Path getApplicationIconPath () {return this.applicationIconPath;}

    public Path getStartScreenImagePath () {return this.startScreenImagePath;}

    public Path getAboutImagePath () {return this.AboutImagePath;}

    public Path getInfoTextPath () {return this.infoTextPath;}

    public String getApplicationName () {return this.ApplicationName;}

    public Path getStartScreenBackground() {return this.startScreenBackground;};
    public Path getGameScreenBackground() {return this.gameScreenBackground;};
    public Path getBackgroundMusicGame() {return this.backgroundMusicGame;};

    public Path getArrowUp() {return this.arrowUp;};
    public Path getArrowDown() {return this.arrowDown;};

}
