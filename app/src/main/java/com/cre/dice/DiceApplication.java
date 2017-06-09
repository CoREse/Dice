package com.cre.dice;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Created by CRE on 2017/6/9.
 */

public class DiceApplication extends Application {
    String Language="";

    @Override
    public void onCreate() {
        readStatus();
        setLocale();
        super.onCreate();
    }

    public void setLocale() {
        if (Language.equals("")) return;
        Locale myLocale = new Locale(Language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }
    public void setLanguage(String L)
    {
        Language=L;
        saveStatus();
    }

    public String getLanguage()
    {
        return Language;
    }

    public void restart()
    {
        restart();
    }

    void saveStatus()
    {
        SharedPreferences MyPref=this.getSharedPreferences("Default",Context.MODE_PRIVATE);
        SharedPreferences.Editor MyEditor=MyPref.edit();
        MyEditor.putString("Language",Language);
        MyEditor.commit();
    }
    void readStatus()
    {
        SharedPreferences MyPref=this.getSharedPreferences("Default",Context.MODE_PRIVATE);
        Language=MyPref.getString("Language","");
    }
}
