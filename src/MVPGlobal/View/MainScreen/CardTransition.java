package MVPGlobal.View.MainScreen;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.util.Duration;

public class CardTransition extends Transition {

    private final PlayerCardsView view;

    public CardTransition(PlayerCardsView view, int maxDuration) {
        this.view = view;
        this.setCycleDuration(Duration.seconds(maxDuration));
        this.setCycleCount(1);
        this.setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double v) {

    }
}
