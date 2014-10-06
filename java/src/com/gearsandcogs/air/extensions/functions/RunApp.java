package com.gearsandcogs.air.extensions.functions;

import android.util.Log;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.gearsandcogs.air.extensions.PackageManagerEvents;
import com.gearsandcogs.air.extensions.SystemCalls;

/**
 * Created by jhilton on 10/2/14.
 */
public class RunApp implements FREFunction
{
    public static final String TAG = "RunApp";

    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects) {
        Log.d(TAG, "called");

        String app_name = "";
        String json_params = "";
        try {
            app_name = freObjects[0].getAsString();
            json_params = freObjects[1].getAsString();
        }catch (Exception e) {
            //something bad happened
        }

        if(SystemCalls.runApplication(freContext, app_name, json_params)){
            freContext.dispatchStatusEventAsync(PackageManagerEvents.SUCCESS_RUN_APP, app_name);
        } else {
            freContext.dispatchStatusEventAsync(PackageManagerEvents.ERROR_RUN_APP, app_name);
        }
        return null;
    }
}
