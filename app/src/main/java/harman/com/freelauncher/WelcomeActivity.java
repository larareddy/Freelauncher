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

    private FrameLayout frameLayout;
ImageView profileImage;
    private TextView userName;
    private LinearLayout mealsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);
        mealsLayout=(LinearLayout)findViewById(R.id.meals);
       // frameLayout=   (FrameLayout)findViewById(R.id.left_meal);
       // frameLayout.removeAllViews();
      //  profileImage= (ImageView) findViewById(R.id.person_id);
       // userName= (TextView) findViewById(R.id.profile_name);

       // RelativeLayout relativeLayout=(RelativeLayout) layoutInflater.inflate(R.layout.profile_image,null);
      //  frameLayout.addView(relativeLayout);
       // Window window = getWindow();
       // window.setBackgroundDrawable(getDrawable(R.drawable.bg_city_skyline)); // avoid GPU overdraw
//        CardsProvider.getsInstance().loadCards(this);
//        mLauncherScreenManager = LauncherScreenManager.getInstance(this, (ViewGroup)window.getDecorView());
//        mLauncherScreenManager.start();
      //  updateProfile(R.drawable.profile_rashmi,"Rashmi");

    }

    public void navigationgo(View view) {
        changeMeal(R.layout.navigation_routeactive,Constants.LEFT_MEAL);
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

    public void mediaRoot(View view) {
        changeMeal(R.layout.skype_meal_views,Constants.RIGHT_MEAL);
    }

   /* public void updateProfile(int resourceId, String userId) {
        if(profileImage!=null && userName!=null)
        profileImage.setImageResource(resourceId);
        userName.setText(""+userId);
    }*/
}
