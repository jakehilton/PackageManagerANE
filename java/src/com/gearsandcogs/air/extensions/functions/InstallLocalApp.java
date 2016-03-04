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
public class InstallLocalApp implements FREFunction
{
    public static final String TAG = "InstallApp";

    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects) {
        Log.d(TAG, "called");
        String app_path = "";
        try {
        	app_path = freObjects[0].getAsString();
        }catch (Exception e) {
            //something bad happened
        }
        if(SystemCalls.installApplication(freContext, app_path)){
            freContext.dispatchStatusEventAsync(PackageManagerEvents.SUCCESS_INSTALL_APP, app_path);
        } else {
            freContext.dispatchStatusEventAsync(PackageManagerEvents.ERROR_INSTALL_APP, app_path);
        }
        return null;
    }
}