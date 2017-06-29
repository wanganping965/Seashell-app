package me.drakeet.seashell;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import org.litepal.LitePalApplication;

import me.drakeet.seashell.model.Word;
import me.drakeet.seashell.utils.MySharedpreference;

/**
 * Created by drakeet on 9/27/14.
 */
public class App extends LitePalApplication {

    private static Context sContext;
    private static RefWatcher sRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        sRefWatcher = LeakCanary.install(this);
    }

    public static Context getContext() {
        return sContext;
    }
    public static RefWatcher getRefWatcher() {
        return sRefWatcher;
    }
}
