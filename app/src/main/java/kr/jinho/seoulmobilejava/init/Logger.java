package kr.jinho.seoulmobilejava.init;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logger {

    private static String TAG;
    private static boolean DEBUG;
    private static SimpleDateFormat sdf;

    public static void init(String tag, boolean isDebug) {
        TAG = tag;
        DEBUG = isDebug;
        setDateFormat("MM-dd HH:mm:ss");
    }

    public static void setDateFormat(String format) {
        sdf = new SimpleDateFormat(format, Locale.KOREA);
    }

    public static void d(String message) {
        if (TAG == null) throw new IllegalStateException("init first");
        if (DEBUG) Log.d(TAG, buildMsg(message));
    }

    public static void e(String message) {
        if (TAG == null) throw new IllegalStateException("init first");
        if (DEBUG) Log.e(TAG, buildMsg(message));
    }

    public static void w(Throwable throwable) {
        if (TAG == null) throw new IllegalStateException("init first");
        if (DEBUG) Log.w(TAG, buildMsg(throwable.getMessage()), throwable);
    }

    private static String buildMsg(String message) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        StringBuilder log = new StringBuilder();
        log.append("[");
        log.append(stackTraceElement.getFileName().replace(".java", ""));
        log.append(" | ");
        log.append(stackTraceElement.getMethodName());
        log.append("() | ");
        log.append(sdf.format(new Date(System.currentTimeMillis())));
        log.append("] ");
        log.append(message);
        return log.toString();
    }

}
