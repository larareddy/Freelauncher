package harman.com.freelauncher;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class WelcomeActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);
       // frameLayout=   (FrameLayout)findViewById(R.id.left_meal);
       // frameLayout.removeAllViews();
        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // RelativeLayout relativeLayout=(RelativeLayout) layoutInflater.inflate(R.layout.profile_image,null);
      //  frameLayout.addView(relativeLayout);
       // Window window = getWindow();
       // window.setBackgroundDrawable(getDrawable(R.drawable.bg_city_skyline)); // avoid GPU overdraw
//        CardsProvider.getsInstance().loadCards(this);
//        mLauncherScreenManager = LauncherScreenManager.getInstance(this, (ViewGroup)window.getDecorView());
//        mLauncherScreenManager.start();

    }
}
