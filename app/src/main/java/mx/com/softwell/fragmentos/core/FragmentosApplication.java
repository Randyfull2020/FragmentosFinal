package mx.com.softwell.fragmentos.core;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class FragmentosApplication extends Application {

    private static FragmentosApplication instance;
    private static Context appContext;

    public static FragmentosApplication getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static void setAppContext(Context context) {
        appContext = context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
