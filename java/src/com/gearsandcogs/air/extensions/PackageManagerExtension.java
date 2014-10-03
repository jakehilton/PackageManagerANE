package com.gearsandcogs.air.extensions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

/**
 * Created by jhilton on 10/2/14.
 */
public class PackageManagerExtension implements FREExtension
{
    @Override
    public void initialize() {

    }

    @Override
    public FREContext createContext(String s) {
        return new PackageManagerContext();
    }

    @Override
    public void dispose() {

    }
}
