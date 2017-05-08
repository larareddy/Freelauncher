package harman.com.freelauncher.asynctask;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import harman.com.freelauncher.activities.WelcomeActivity;
import harman.com.freelauncher.interfaces.ActivityCallBack;
import harman.com.freelauncher.models.PendingDataModel;
import harman.com.freelauncher.models.PendingInfoProvider;
import harman.com.freelauncher.models.StaticPendingModelData;

/**
 * Created by HAlavala on 5/4/2017.
 */

public class JSONTask extends AsyncTask<String, String, PendingDataModel> {
    PendingInfoProvider info = new PendingInfoProvider();
    ActivityCallBack mCallback;
    private Drawable drawable;

    public JSONTask(ActivityCallBack callBack){
        mCallback=callBack;
    }
    @Override
    protected PendingDataModel doInBackground(String... params) {
        PendingDataModel pendingDataModel=getPendingInfo();
        String imgUrl = pendingDataModel.getProfilePictureUri();
        URL myUrl = null;
        try {
            myUrl = new URL(imgUrl);
            InputStream inputStream = (InputStream)myUrl.getContent();
            drawable = Drawable.createFromStream(inputStream, null);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pendingDataModel;

    }

    @Override
    protected void onPostExecute(PendingDataModel result) {

        mCallback.callBack(result,drawable);

//        startActivity(i);
    }
    private PendingDataModel getPendingInfo() {
//            final String URL = "https://hpf-usersprofileapp.azurewebsites.net/api/GetUserDetails?code=tRuR4NZaaPBFvw/rcpy66mNnPrQ0uLj/8tfuzQTcd6PJvYvzWy9GSw==";
        final String URL = "http://carignitionservice.azurewebsites.net/api/userDevice/onCarStart";
        HttpURLConnection connection = null;
        Log.v("00000000000000000000000", "Before connection");
        try {
            java.net.URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();
//                connection.setDoOutput(true);
//                connection.setDoInput(true);
            connection.addRequestProperty("Content-Type", "application/json");
//                connection.setRequestMethod("POST");
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                return info.GetAllData(buffer.toString());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }
}
