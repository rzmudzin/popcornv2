package com.phoenixroberts.popcorn;

/**
 * Created by rzmudzinski on 8/27/17.
 */

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.phoenixroberts.popcorn.data.DataService;
import com.phoenixroberts.popcorn.data.DataServiceBroadcastReceiver;
import com.phoenixroberts.popcorn.logging.MetricDataType;
import com.phoenixroberts.popcorn.logging.MetricsEventType;

import net.hockeyapp.android.metrics.MetricsManager;

import java.util.HashMap;


public class AppMain extends Application {

    private static AppMain m_Instance;
    private static final String m_AppName = "popcorn";

    public void onCreate() {
        super.onCreate();
        m_Instance = this;
        MetricsManager.register(this);
        HashMap<String, String> properties = new HashMap<>();
        properties.put(MetricDataType.Info, "App onCreate Invoked");
        MetricsManager.trackEvent(MetricsEventType.AppStarted, properties, null);
        DataServiceBroadcastReceiver.getInstance().Register(getApplicationContext());
    }

    public static Context getAppContext() {
        return m_Instance!=null?m_Instance.getApplicationContext():null;
    }

    public static String getAppName() {
        return m_AppName;
    }

    public static class BundleExtraType {
        public static final String MovieId = "MovieId";
    }

}
