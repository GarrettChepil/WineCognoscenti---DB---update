package dreamlinedesign.winecognoscenti;

import android.app.Application;

/**
 * Created by GeEEE on 2016-01-25.
 */
public class BestWineSelection extends Application {
    private BestPairing best;

    public BestPairing getBest() {
        return best;
    }

    public void setBest(BestPairing best) {
        this.best = best;
    }
}
