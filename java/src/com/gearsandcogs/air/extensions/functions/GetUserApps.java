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
public class GetUserApps implements FREFunction
{
    public static final String TAG = "GetUserApps";

    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects) {
        Log.d(TAG, "called");
        freContext.dispatchStatusEventAsync(PackageManagerEvents.GET_USER_APPS, SystemCalls.getApplications(freContext, "user").toString());
        return null;
    }
}
