package MVPGlobal.View.MainScreen;

import MVPGlobal.View.StartScreen.StartScreenView;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.util.Duration;

/**
 * This is the class for the dealer transition
 * It is used to pause the game when the player stands and the dealer takes his cards
 * It is used so the player can see the dealers cards before the screen goes to the winloseview
 */
public class DealerTransition extends Transition {

    private final PlayerActionsView view;

    /**
     * This is the constructor
     * @param view
     * @param maxDuration
     */
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
