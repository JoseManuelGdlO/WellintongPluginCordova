package cordova-plugin-refrigerators-skye;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.wdtl.scs.scstracksdk.ScsClientBuilder;
import com.wdtl.scs.scstracksdk.ScsClient;
import java.lang.Exception;
import android.util.Log;

/**
 * This class echoes a string called from JavaScript.
 */
public class SkyeSDKRefrigerators extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        switch (action) {
            case "coolMethod":
                String message = args.getString(0);
                this.coolMethod(message, callbackContext);
                return true;
            break;
            case "activationActivity":
                String message = args.getString(0);
                this.activationActivity(message, callbackContext);
                return true;
            break;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void activationActivity(String message, CallbackContext callbackContext) {

        Log.i("Message", message);
        try {
           ScsClient scsClient = ScsClientBuilder.builder().setContext(this.applicationContext)
            .setActivationCodeNow(message)
            .localLogging(true)
            .build();  
             callbackContext.success(true);
        } catch (Exception error) {
             callbackContext.error(error);
        }

    }


}
