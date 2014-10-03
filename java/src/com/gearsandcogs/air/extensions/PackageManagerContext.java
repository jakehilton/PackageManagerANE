package com.gearsandcogs.air.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.gearsandcogs.air.extensions.functions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jhilton on 10/2/14.
 */
public class PackageManagerContext extends FREContext
{
    @Override
    public Map<String, FREFunction> getFunctions() {
        Map<String, FREFunction> functionMap = new HashMap<String, FREFunction>();
        functionMap.put("GetSystemApps", new GetSystemApps());
        functionMap.put("GetUserApps", new GetUserApps());
        functionMap.put("RunApp", new RunApp());
        functionMap.put("InstallApp", new InstallApp());
        functionMap.put("UninstallApp", new UninstallApp());
        return functionMap;
    }

    @Override
    public void dispose() {

    }
}
