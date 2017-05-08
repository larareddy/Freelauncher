package harman.com.freelauncher.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ruinvepc on 5/1/2017.
 */

public class PaResponseReceiver extends BroadcastReceiver {
    private final static String ACTION = "com.harman.speech.pa.VIEW";
    private final static String KEY_NOTIFY = "notify";
    private final static String KEY_REMINDER = "reminder";
    private final static String KEY_LIST_INDEX = "list_index";
    private final static String KEY_ORDINAL = "ordinal";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION.equalsIgnoreCase(intent.getAction())) {
            boolean notifyOnly = intent.getBooleanExtra(KEY_NOTIFY, true);
            if (notifyOnly) {
                //request list of appointments
                System.out.println("APPOINTMENT: request the list");
            } else {
                //select correct item in the list
                String reminderDate = intent.getStringExtra(KEY_REMINDER);
                String listIdx = intent.getStringExtra(KEY_LIST_INDEX);
                String ordinal = intent.getStringExtra(KEY_ORDINAL);
                System.out.println("APPOINTMENT: user selected appointment from PA reminderDate " + reminderDate + " listIdx " + listIdx + " ordinal "+ordinal);
            }

        }

    }
}
