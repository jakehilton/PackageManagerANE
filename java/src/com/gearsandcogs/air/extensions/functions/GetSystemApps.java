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
public class GetSystemApps implements FREFunction
{
    public static final String TAG = "GetSystemApps";

    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects) {
        Log.d(TAG, "called");
        freContext.dispatchStatusEventAsync(PackageManagerEvents.GET_SYSTEM_APPS, SystemCalls.getApplications(freContext, "system").toString());
        return null;
    }
}