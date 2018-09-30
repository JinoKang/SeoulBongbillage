package kr.jinho.seoulmobilejava.init;

import android.app.Application;
import android.content.Context;



public class App extends Application {

    private static volatile App instance = null;

    public static App getContext() {
        if (instance == null)
            throw new IllegalStateException("this application does not inherit kr.sharenshare.carpool.driver");
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Logger.init("SeoulMobile", true);
    }
}
