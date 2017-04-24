package harman.com.freelauncher.customui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 * Created by HAlavala on 4/20/2017.
 */

public class NSRegularButton extends Button {
    private static final String TAG = "RobotoTextView";

    public NSRegularButton(Context context) {
        super(context);
        init();
    }

    public NSRegularButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NSRegularButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public NSRegularButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init()
    {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Regular.ttf");
        if(tf==null)
            Log.v(TAG,"RobotoTextView null");
        setTypeface(tf);
    }
}
