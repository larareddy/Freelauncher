package harman.com.freelauncher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {


    ImageView profileImage;
    private TextView userName;
    private LinearLayout mealsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);
        mealsLayout=(LinearLayout)findViewById(R.id.meals);
    }

        private void changeMeal(int layoutRes, int mealCode) {
        CardView cardView = null;
        switch (mealCode)
        {
            case Constants.LEFT_MEAL:
                 cardView = (CardView) mealsLayout.findViewById(R.id.left_meal);
                break;
            case Constants.RIGHT_MEAL:
                cardView = (CardView) mealsLayout.findViewById(R.id.right_meal);
                break;
        }

        cardView.removeAllViews();
        View child = getLayoutInflater().inflate(layoutRes, null);
        cardView.addView(child);
    }
    public void navigationGo(View view) {
        changeMeal(R.layout.navigation_routeactive,Constants.LEFT_MEAL);
    }

    public void transferCall(View view) {
        changeMeal(R.layout.media_art,Constants.RIGHT_MEAL);
    }

    public void appointmentSelected(View view) {
        changeMeal(R.layout.maintainance_confirm_meal,Constants.LEFT_MEAL);
    }

    public void remindLater(View view) {
        changeMeal(R.layout.navigation_routeactive,Constants.LEFT_MEAL);
    }

    public void appointmentConfirmed(View view) {
        changeMeal(R.layout.navigation_routeactive,Constants.LEFT_MEAL);
    }
}
