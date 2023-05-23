package MVPGlobal.View.SettingsScreen;

import MVPGlobal.View.UISettings;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;

public class SettingsView extends BorderPane {

    private UISettings uiSettings;
    private MenuItem exitMI;
    private TextField cssName;
    private Button cssButton;
    private Button okButton;

    private Label cssLabel;

    private Label cssTitel;
    private Label volumeTitel;

    private Label backgroundMusicLabel;
    private Label soundFXLabel;

    private Slider volumeBackgroundMusic;
    private Slider volumeSoundFx;

    public SettingsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.exitMI = new MenuItem("Exit");
        this.cssTitel = new Label("CSS Options");
        this.cssButton = new Button("Select File");
        this.cssLabel = new Label("Style Sheet File Name:");
        this.cssName = new TextField();
        this.cssName.setPrefWidth(uiSettings.getLowestRes() / 3);
        this.cssName.setText(uiSettings.getStyleSheetPath().toString());

        this.volumeTitel = new Label("Volume Options");
        this.backgroundMusicLabel = new Label("Background Music: ");
        this.volumeBackgroundMusic = new Slider(0, 100, 80);
        this.soundFXLabel = new Label("Sound Effects:               ");
        this.volumeSoundFx = new Slider(0, 100, 80);
        this.okButton = new Button("OK");
    }

    private void layoutNodes() {
        Menu menuFile = new Menu("File");
        menuFile.getItems().addAll(exitMI);
        MenuBar menuBar = new MenuBar(menuFile);
        setTop(menuBar);

        HBox cssSettings = new HBox();
        cssSettings.setSpacing(uiSettings.getSpacing());
        cssSettings.setPadding(new Insets(uiSettings.getInsetsMargin()));
        cssSettings.getChildren().addAll(cssLabel, cssName, cssButton);

        HBox backgroundMusic = new HBox();
        volumeSlider(volumeBackgroundMusic);
        backgroundMusic.getChildren().addAll(backgroundMusicLabel, volumeBackgroundMusic);
        backgroundMusic.setSpacing(uiSettings.getSpacing());
        backgroundMusic.setPadding(new Insets(uiSettings.getInsetsMargin()));

        HBox soundFX = new HBox();
        volumeSlider(volumeSoundFx);
        soundFX.getChildren().addAll(soundFXLabel, volumeSoundFx);
        soundFX.setSpacing(uiSettings.getSpacing());
        soundFX.setPadding(new Insets(uiSettings.getInsetsMargin()));

        VBox settings = new VBox();
        settings.getChildren().addAll(cssTitel, cssSettings, volumeTitel, backgroundMusic, soundFX);
        cssButton.getStyleClass().add("settingsBtn");
        cssLabel.getStyleClass().add("settingsLbl");
        cssTitel.getStyleClass().add("settingsTitle");
        volumeTitel.getStyleClass().add("settingsTitle");
        backgroundMusicLabel.getStyleClass().add("settingsLbl");
        soundFXLabel.getStyleClass().add("settingsLbl");
        menuBar.getStyleClass().add("backgroundField");
        cssName.getStyleClass().add("backgroundField");

        this.getStyleClass().add("settings");

        this.setCenter(settings);
        this.setBottom(okButton);
    }

    private void volumeSlider(Slider volumeSlider) {
        volumeSlider.setPrefWidth(uiSettings.getLowestRes() / 5.75);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setMajorTickUnit(20);
        volumeSlider.setMinorTickCount(5);
        volumeSlider.setBlockIncrement(5);
        volumeSlider.setSnapToTicks(true);
        volumeSlider.setPadding(new Insets(uiSettings.getInsetsMargin() / 4, uiSettings.getInsetsMargin(), uiSettings.getInsetsMargin() / 4, uiSettings.getInsetsMargin() * 2));
    }

    public void setupSlider(Slider volumeSlider, double volume){
        volumeSlider.setValue(volume);
    }

    //Getters & Setters

    MenuItem getExitItem() {
        return exitMI;
    }

    Button getCssButton() {
        return cssButton;
    }

    TextField getCssName() {
        return cssName;
    }

    Button getOkButton() {
        return okButton;
    }

    Slider getVolumeBackgroundMusic() {
        return volumeBackgroundMusic;
    }

    Slider getVolumeSoundFx() {
        return volumeSoundFx;
    }


}
