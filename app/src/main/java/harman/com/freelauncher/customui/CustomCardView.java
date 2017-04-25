package harman.com.freelauncher.customui;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

/**
 * Created by HAlavala on 4/24/2017.
 */

public class CustomCardView extends CardView {
    public CustomCardView(Context context) {
        super(context);
        init();
    }


    public CustomCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
//        setCardElevation(5.0f);
    }
}
