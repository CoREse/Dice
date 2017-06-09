package com.cre.dice;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        DiceApplication ThisApp=(DiceApplication) getApplication();
        String CurrentLanguage=ThisApp.getLanguage();
        if (CurrentLanguage.equals("en"))
        {
            ((RadioButton)findViewById(R.id.radioEnglish)).setChecked(true);
        }
        else if (CurrentLanguage.equals("zh"))
        {
            ((RadioButton)findViewById(R.id.radioChinese)).setChecked(true);
        }
        else
        {
            ((RadioButton)findViewById(R.id.radioDefaultLanguage)).setChecked(true);
        }

        ((RadioGroup)findViewById(R.id.GroupLanguage)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            DiceApplication ThisApp=(DiceApplication) getApplication();
            @Override
            public void onCheckedChanged(RadioGroup RG, int CheckedID)
            {
                switch (CheckedID)
                {
                    case R.id.radioEnglish:
                        ThisApp.setLanguage("en");
                        Toast.makeText(ThisApp, "Changed language to English, will apply after app restart.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioChinese:
                        ThisApp.setLanguage("zh");
                        Toast.makeText(ThisApp, "已将语言设置为简体中文，重启应用后生效。", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioDefaultLanguage:
                        ThisApp.setLanguage("");
                        Toast.makeText(ThisApp, getString(R.string.set_default_language), Toast.LENGTH_SHORT).show();
                    case -1:
                        break;
                    default:
                        break;
                }
            }
        }
        );
    }

    public void onMenuRestart(MenuItem Item)
    {
        DiceApplication ThisApp=(DiceApplication) getApplication();
        ThisApp.restart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu M) {
        MenuInflater Inflater = getMenuInflater();
        Inflater.inflate(R.menu.menu_settings, M);
        return true;
    }

}
