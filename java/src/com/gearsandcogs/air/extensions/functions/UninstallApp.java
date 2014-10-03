package com.gearsandcogs.air.extensions.functions;

import android.util.Log;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.gearsandcogs.air.extensions.PackageManagerEvents;
import com.gearsandcogs.air.extensions.SystemCalls;

/**
 * Created by jhilton on 10/3/14.
 */
public class UninstallApp implements FREFunction
{
    public static final String TAG = "UninstallApp";

    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects) {
        Log.d(TAG, "called");
        String app_name = "";
        try {
            app_name = freObjects[0].getAsString();
        }catch (Exception e) {
            //something bad happened
        }
        if(SystemCalls.uninstallApplication(freContext, app_name)){
            freContext.dispatchStatusEventAsync(PackageManagerEvents.SUCCESS_UNINSTALL_APP, app_name);
        } else {
            freContext.dispatchStatusEventAsync(PackageManagerEvents.ERROR_UNINSTALL_APP, app_name);
        }
        return null;
    }
}