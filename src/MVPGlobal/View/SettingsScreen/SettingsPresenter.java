package MVPGlobal.View.SettingsScreen;

import MVPGlobal.Model.*;
import MVPGlobal.View.MainScreen.MainScreenView;
import MVPGlobal.View.UISettings;
import javafx.beans.value.ChangeListener;
import javafx.event.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.WindowEvent;
import javafx.beans.value.ObservableValue; //moeten toevoegen
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Paths;

public class SettingsPresenter {

    private SettingsView view;
    private UISettings uiSettings;

    private BlackJackGame blackJackGame;

    public SettingsPresenter(BlackJackGame model, SettingsView view) {
        this.blackJackGame = model;
        this.view = view;
        this.uiSettings = new UISettings();
        MainScreenView mainScreenView = new MainScreenView(uiSettings);
        updateView();
        EventHandlers();
    }

    private void updateView() {
        view.setupSlider(view.getVolumeBackgroundMusic(), blackJackGame.sounds.getBackgroundMusicVolume());
        view.setupSlider(view.getVolumeSoundFx(), blackJackGame.sounds.getSoundFXVolume());
    }

    private void EventHandlers() {
        view.getExitItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleCloseEvent(event);
            }
        });
        view.getCssButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Style Sheet Files", "*.css"),
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                fileChooser.setInitialDirectory(new File("resources" + UISettings.FILE_SEPARATOR + "stylesheets"));
                File selectedFile = fileChooser.showOpenDialog(view.getScene().getWindow());
                if (selectedFile != null) {
                    URI uri = selectedFile.toURI();
                    uiSettings.setStyleSheetPath(Paths.get(uri));
                }
                if (uiSettings.styleSheetAvailable()) {
                    view.getScene().getStylesheets().removeAll();
                    try {
                        view.getScene().getStylesheets().add(uiSettings.getStyleSheetPath().toUri().toURL().toString());
                    } catch (MalformedURLException ex) {
                        // do nothing, if toURL-conversion fails, program can continue
                    }
                }
            }
        });

        view.getOkButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleCloseEvent(event);
            }
        });

        view.getVolumeBackgroundMusic().valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                blackJackGame.sounds.setBackgroundMusicVolume(t1.doubleValue() / 100);
            }
        });

         view.getVolumeSoundFx().valueProperty().addListener(new ChangeListener<Number>() {
             @Override
             public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                 blackJackGame.sounds.setSoundFXVolume(t1.doubleValue()/100);
             }
         });
    }

    public void windowsHandler() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                handleCloseEvent(event);
            }
        });
    }

    private void handleCloseEvent(Event event) {
        view.getScene().getWindow().hide();
    }
}
