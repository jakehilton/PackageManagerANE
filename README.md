PackageManagerANE
=================

Native extension for Adobe AIR that allows for interaction with the Android PackageManager.

Available events:

``` ActionScript
    public static var ERROR_INSTALL_APP:String = "ERROR_INSTALL_APP";
    public static var ERROR_RUN_APP:String = "ERROR_RUN_APP";
    public static var ERROR_UNINSTALL_APP:String = "ERROR_UNINSTALL_APP";

    public static var GET_SYSTEM_APPS:String = "GET_SYSTEM_APPS";
    public static var GET_USER_APPS:String = "GET_USER_APPS";

    public static var SUCCESS_RUN_APP:String = "SUCCESS_RUN_APP";
    public static var SUCCESS_INSTALL_APP:String = "SUCCESS_INSTALL_APP";
    public static var SUCCESS_UNINSTALL_APP:String = "SUCCESS_UNINSTALL_APP";
```

Need to set a value in your app.xml for your air app

``` XML
    <extensions>
        <extensionID>com.gearsandcogs.air.extensions.PackageManager</extensionID>
    </extensions>
```

Use case is pretty simple::

``` ActionScript

        public function PackageManagerService() {
            var pm:PackageManager = new PackageManager();
            pm.addEventListener(PackageManagerEvent.GET_SYSTEM_APPS, systemAppsReturned);
            pm.addEventListener(PackageManagerEvent.GET_USER_APPS, userAppsReturned);
            pm.addEventListener(PackageManagerEvent.ERROR_RUN_APP, runAppError);
            pm.addEventListener(StatusEvent.STATUS, statusFired);
            pm.getUserApps();
            pm.getSystemApps();
            pm.runApp("com.google.android.GoogleCamera");
        }

        private function runAppError(e:PackageManagerEvent):void {
            trace("unable to run an event with it: " + e.param);
        }

        private function userAppsReturned(data:PackageManagerEvent):void {
            trace("got the user apps back");
            trace(data.param);
        }

        private function statusFired(e:StatusEvent):void {
            trace("status");
            trace(e.code);
            trace(e.level);
        }

        private function systemAppsReturned(data:PackageManagerEvent):void {
            trace("got the system apps back");
            trace(data.param);
        }

```