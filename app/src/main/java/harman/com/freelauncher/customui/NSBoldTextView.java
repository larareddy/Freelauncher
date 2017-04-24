package harman.com.freelauncher.customui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HAlavala on 4/20/2017.
 */

public class NSBoldTextView extends TextView {
    private static final String TAG = "RobotoTextView";

    public NSBoldTextView(Context context) {
        super(context);
        init();
    }

    public NSBoldTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NSBoldTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public NSBoldTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init()
    {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Bold.ttf");
        if(tf==null)
            Log.v(TAG,"RobotoTextView null");
        setTypeface(tf);
    }
}
