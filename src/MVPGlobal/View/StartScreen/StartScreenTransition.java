package MVPGlobal.View.StartScreen;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.util.Duration;


/**
 * The transition class that handles the transition of the loading bar.
 *
 * @author Sam Rotthier
 * @author Matthias Vermeiren
 * @version 3.0
 */

public class StartScreenTransition extends Transition {

    private final StartScreenView view;

    public StartScreenTransition(StartScreenView view, int maxDuration) {
        this.view = view;
        this.setCycleDuration(Duration.seconds(maxDuration));
        this.setCycleCount(1);
        this.setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double frac) {
        this.view.getTimeDisplay().setText(String.format("Loading:  %.0f%%", frac * 100));
        this.view.getTimeProgress().setProgress(frac);
    }
}
