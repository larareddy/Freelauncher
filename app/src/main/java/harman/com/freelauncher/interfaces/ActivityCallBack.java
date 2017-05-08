package harman.com.freelauncher.interfaces;

import android.graphics.drawable.Drawable;

import harman.com.freelauncher.models.PendingDataModel;

/**
 * Created by HAlavala on 5/4/2017.
 */

public interface ActivityCallBack {

 void callBack(PendingDataModel result, Drawable drawable);
void imageViewUpdate(Drawable drawable);
}
