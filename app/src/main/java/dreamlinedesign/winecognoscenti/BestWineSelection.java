package dreamlinedesign.winecognoscenti;

import android.app.Application;

/**
 * Created by GeEEE on 2016-01-25.
 */
public class BestWineSelection extends Application {
    private FindBest best;

    public FindBest getBest() {
        return best;
    }

    public void setBest(FindBest best) {
        this.best = best;
    }
}
