package harman.com.freelauncher.activities;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;

import harman.com.freelauncher.R;
import harman.com.freelauncher.animation.ResizeAnimation;
import harman.com.freelauncher.asynctask.JSONTask;
import harman.com.freelauncher.interfaces.ActivityCallBack;
import harman.com.freelauncher.models.PendingDataModel;
import harman.com.freelauncher.models.StaticPendingModelData;
import harman.com.freelauncher.utils.Constants;

public class WelcomeActivity extends AppCompatActivity implements ActivityCallBack {


    ImageView profileImage;
    private TextView userName;
    private LinearLayout mealsLayout;
    private View goMap;
    private Button go;
    private String TAG="WelcomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);
        mealsLayout=(LinearLayout)findViewById(R.id.meals);
        changeCardViewDimen(924,772, Constants.LEFT_MEAL);
        changeCardViewDimen(924,772,Constants.RIGHT_MEAL);
      //  goMap=findViewById(R.id.go_map_include);
        go= (Button) findViewById(R.id.go);
        getProfileDetails();
        Toast.makeText(this,"width "+mealsLayout.getLayoutParams().width+" height "+mealsLayout.getLayoutParams().height,Toast.LENGTH_LONG).show();
    }

     private void getProfileDetails() {
        new JSONTask(this).execute();
    }

    private void changeCardViewDimen(int height, int width, int mealCode) {
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
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                height,
                width
        );
        params.setMargins(24,0,0,24);
//        card.setLayoutParams(params);
        cardView.setLayoutParams(params);
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
       changeToMap();
    }

    private void changeToMap() {
        go= (Button) findViewById(R.id.go);
        go.setText("Map");
        go.setAllCaps(false);
        go.setBackgroundColor(Color.parseColor("#ffffff"));
        go.setTextColor(Color.parseColor("#000000"));
    }


    public void transferCall(View view) {
        changeMeal(R.layout.media_art,Constants.RIGHT_MEAL);
    }

    public void appointmentSelected(View view) {
        changeMeal(R.layout.navigation_itenary_meal,Constants.RIGHT_MEAL);
        changeToMap();
    }

    public void remindLater(View view) {
        changeMeal(R.layout.navigation_routeactive,Constants.LEFT_MEAL);
    }

    public void appointmentConfirmed(View view) {
        changeMeal(R.layout.navigation_routeactive,Constants.LEFT_MEAL);

    }

    @Override
    public void callBack(PendingDataModel result, Drawable drawable) {
        StaticPendingModelData.Data = result;
        String fName = result.getProfileName();
        String uri = result.getProfilePictureUri();
        String radioUri = result.getRadioUri();
        String elapsedTime = result.getRadioElapsedTime();
        Log.v(TAG+"  Radio URL", radioUri);
        Log.v(TAG+"  ON_POST_EXECUTE", fName + " AND " + uri);
        updateProfile(fName,drawable);
        startPlaying(radioUri,elapsedTime);
    }

    @Override
    public void imageViewUpdate(Drawable drawable) {

    }

    private void updateProfile(String fName, Drawable drawable) {
        ImageView profileView=(ImageView)findViewById(R.id.person_id);
        TextView profileTV=(TextView)findViewById(R.id.profile_name);
        profileTV.setText("Hi, "+fName);
        profileView.setImageDrawable(drawable);
       // startAnimation(profileView);
    }

    private void startAnimation(ImageView profileView) {
        ResizeAnimation resizeAnimation=new ResizeAnimation(profileView,305,305,178,178);
        profileView.setAnimation(resizeAnimation);
    }

    public void startPlaying(String radioUri, String elapsedTime){
        try {
            Uri myUri1 = Uri.parse(radioUri);
            StaticPendingModelData.mediaPlayer = new MediaPlayer();
            StaticPendingModelData.mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                StaticPendingModelData.mediaPlayer.setDataSource(getApplicationContext(), myUri1);
            } catch (IllegalArgumentException e) {
                Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            } catch (SecurityException e) {
                Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            } catch (IllegalStateException e) {
                Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                StaticPendingModelData.mediaPlayer.prepare();
            } catch (IllegalStateException e) {
                Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
            }
            int miliSecs = Integer.parseInt(elapsedTime) * 1000;
            StaticPendingModelData.mediaPlayer.seekTo(miliSecs);
            int m = StaticPendingModelData.mediaPlayer.getCurrentPosition();
            Log.v("Media player position", String.valueOf(m));
            StaticPendingModelData.mediaPlayer.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playRadio(View view) {
        if(StaticPendingModelData.mediaPlayer!=null && StaticPendingModelData.mediaPlayer.isPlaying()){
            StaticPendingModelData.mediaPlayer.pause();
        }
        else if(!StaticPendingModelData.mediaPlayer.isPlaying()){
            StaticPendingModelData.mediaPlayer.start();
        }
    }

    public void leftMailWelcome(View view) {
        changeMeal(R.layout.navigation_itenary_meal,Constants.LEFT_MEAL);
    }
}
