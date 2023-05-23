package MVPGlobal.View.MainScreen;

import MVPGlobal.View.StartScreen.StartScreenView;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.util.Duration;

public class DealerTransition extends Transition {

    private final PlayerActionsView view;

    public DealerTransition(PlayerActionsView view, int maxDuration) {
        this.view = view;
        this.setCycleDuration(Duration.seconds(maxDuration));
        this.setCycleCount(1);
        this.setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double v) {

    }
}
