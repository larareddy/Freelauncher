package harman.com.freelauncher.asynctask;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import harman.com.freelauncher.models.PendingInfoProvider;

/**
 * Created by MShekhar on 4/30/2017.
 */

public class ImageProvider extends AsyncTask<String, Void, Drawable> {
    PendingInfoProvider info = new PendingInfoProvider();
    protected Drawable doInBackground(String... urls) {
        Drawable drawable = null;
        try {
//            String imgUrl = info.getProfilePicture();
//            URL myUrl = new URL(imgUrl);
//            InputStream inputStream = (InputStream)myUrl.getContent();
//            drawable = Drawable.createFromStream(inputStream, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  drawable;
    }
}
