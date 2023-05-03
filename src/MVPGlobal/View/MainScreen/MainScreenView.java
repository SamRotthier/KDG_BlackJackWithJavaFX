package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.net.MalformedURLException;

public class MainScreenView extends BorderPane  {

    private MenuItem exitMI;
    private MenuItem saveMI;
    private MenuItem loadMI;
    private MenuItem settingsMI;
    private MenuItem aboutMI;
    private MenuItem infoMI;
    private UISettings uiSettings;

    private Label player1;

    //ButtonHit Test
    private Button buttonHit;

    public MainScreenView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.exitMI = new MenuItem("Exit");
        this.saveMI = new MenuItem("Save");
        this.loadMI = new MenuItem("Load");
        this.settingsMI = new MenuItem("Settings");
        this.aboutMI = new MenuItem("About");
        this.infoMI = new MenuItem("Info");
        //buttonHit test
        this.buttonHit = new Button("HIT");
        // player 1 label
        this.player1 = new Label("Player 1");
    }

    private void layoutNodes() {
        //background
        try{
            this.setBackground(new Background(new BackgroundImage(new Image(uiSettings.getStartScreenBackground().toUri().toURL().toString()),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
            this.setCenter(new Canvas(480, 360));
        }
        catch (MalformedURLException ex){
        }
        
        Menu menuFile = new Menu("File",null,loadMI, saveMI, new SeparatorMenuItem(), settingsMI, new SeparatorMenuItem(),exitMI);
        Menu menuHelp = new Menu("Help",null, aboutMI, infoMI);
        MenuBar menuBar = new MenuBar(menuFile,menuHelp);
        setTop(menuBar);

        //ButtonHitTest
        this.setCenter(this.buttonHit);
        BorderPane.setMargin(this.buttonHit, new Insets(10));
        BorderPane.setAlignment(this.buttonHit, Pos.CENTER);

        //Bottom
        HBox saldoBetBox = new HBox();
        saldoBetBox.setSpacing(100);
        saldoBetBox.setPadding(new Insets(20));

        Label saldoLabel = new Label("Saldo: ");
        Label betAmountLabel = new Label("Bet amount:");
        saldoBetBox.getChildren().addAll(saldoLabel, betAmountLabel);
        this.setBottom(saldoBetBox);

    }

    MenuItem getExitItem() {return exitMI;}

    MenuItem getSaveItem() {return saveMI;}

    MenuItem getLoadItem() {return loadMI;}

    MenuItem getSettingsItem() {return settingsMI;}

    MenuItem getAboutItem() {return aboutMI;}

    MenuItem getInfoItem() {return infoMI;}


}
