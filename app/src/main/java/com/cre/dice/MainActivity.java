package com.cre.dice;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    long D6Times=1;
    long D10Times=1;
    long D20Times=1;
    long D100Times=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ResultDisplay=(TextView) findViewById(R.id.ResultDisplay);
        ResultDisplay.setMovementMethod(new ScrollingMovementMethod());

        findViewById(R.id.D6Times).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                {
                    cleanText(view);
                }
            }
        });
        findViewById(R.id.D10Times).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                {
                    cleanText(view);
                }
            }
        });
        findViewById(R.id.D20Times).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                {
                    cleanText(view);
                }
            }
        });
        findViewById(R.id.D100Times).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                {
                    cleanText(view);
                }
            }
        });
        findViewById(R.id.CustomTimes).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                {
                    cleanText(view);
                }
            }
        });
        findViewById(R.id.CustomSides).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                {
                    cleanText(view);
                }
            }
        });
    }

    void saveStatus()
    {
        SharedPreferences MyPref=this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor MyEditor=MyPref.edit();
        MyEditor.putLong("D6Times",D6Times);
        MyEditor.putLong("D10Times",D10Times);
        MyEditor.putLong("D20Times",D20Times);
        MyEditor.putLong("D100Times",D100Times);
        MyEditor.commit();
    }

    void readStatus()
    {
        SharedPreferences MyPref=this.getPreferences(Context.MODE_PRIVATE);
        D6Times=MyPref.getLong("D6Times",1);
        D10Times=MyPref.getLong("D10Times",1);
        D20Times=MyPref.getLong("D20Times",1);
        D100Times=MyPref.getLong("D100Times",1);
    }

    Vector<Integer> roll(int Sides, long Times)
    {
        assert(Times>0);
        assert(Sides>0);
        Vector<Integer> Result=new Vector<>();
        Random RG=new Random();
        for (long i=0;i<Times;++i)
        {
            Result.add(RG.nextInt(Sides)+1);
        }
        return Result;
    }

    String explainResult(Vector<Integer> Result)
    {
        String E="";
        long Total=0;
        for (int i=0;i<Result.size()-1;++i)
        {
            E+=Result.get(i)+", ";
            Total+=Result.get(i);
        }
        Total+=Result.get(Result.size()-1);
        E+=Result.get(Result.size()-1)+".\nTotal "+Total+".";
        return E;
    }

    void hideIME()
    {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    void onRoll6(View V)
    {
        TextView Display=(TextView)findViewById(R.id.ResultDisplay);
        EditText D6TimesV=(EditText)findViewById(R.id.D6Times);
        String D6TimesS=D6TimesV.getText().toString();
        if (D6TimesS.equals("")) D6Times=1;
        else D6Times=Integer.parseInt(D6TimesS);
        if (D6Times==0)
        {
            hideIME();
            cleanText(Display);
            return;
        }
        Vector<Integer> Result=roll(6,D6Times);
        hideIME();
        Display.scrollTo(0,0);
        Display.setText(explainResult(Result));
    }
    void onRoll10(View V)
    {
        TextView Display=(TextView)findViewById(R.id.ResultDisplay);
        EditText D10TimesV=(EditText)findViewById(R.id.D10Times);
        String D10TimesS=D10TimesV.getText().toString();
        if (D10TimesS.equals("")) D10Times=1;
        else D10Times=Integer.parseInt(D10TimesS);
        if (D10Times==0)
        {
            hideIME();
            cleanText(Display);
            return;
        }
        Vector<Integer> Result=roll(10,D10Times);
        hideIME();
        Display.scrollTo(0,0);
        Display.setText(explainResult(Result));
    }
    void onRoll20(View V)
    {
        TextView Display=(TextView)findViewById(R.id.ResultDisplay);
        EditText D20TimesV=(EditText)findViewById(R.id.D20Times);
        String D20TimesS=D20TimesV.getText().toString();
        if (D20TimesS.equals("")) D20Times=1;
        else D20Times=Integer.parseInt(D20TimesS);
        if (D20Times==0)
        {
            hideIME();
            cleanText(Display);
            return;
        }
        Vector<Integer> Result=roll(20,D20Times);
        hideIME();
        Display.scrollTo(0,0);
        Display.setText(explainResult(Result));
    }
    void onRoll100(View V)
    {
        TextView Display=(TextView)findViewById(R.id.ResultDisplay);
        EditText D100TimesV=(EditText)findViewById(R.id.D100Times);
        String D100TimesS=D100TimesV.getText().toString();
        if (D100TimesS.equals("")) D100Times=1;
        else D100Times=Integer.parseInt(D100TimesS);
        if (D100Times==0)
        {
            hideIME();
            cleanText(Display);
            return;
        }
        Vector<Integer> Result=roll(100,D100Times);
        hideIME();
        Display.scrollTo(0,0);
        Display.setText(explainResult(Result));
    }
    void onRollCustom(View V)
    {
        TextView Display=(TextView)findViewById(R.id.ResultDisplay);
        EditText CustomTimesV=(EditText)findViewById(R.id.CustomTimes);
        EditText CustomSidesV=(EditText)findViewById(R.id.CustomSides);
        String CustomTimesS=CustomTimesV.getText().toString();
        long CustomTimes=1;
        String CustomSidesS=CustomSidesV.getText().toString();
        if (CustomSidesS.equals("")) return;
        int CustomSides=Integer.parseInt(CustomSidesS);
        if (CustomTimesS.equals("")) CustomTimes=1;
        else CustomTimes=Integer.parseInt(CustomTimesS);
        if (CustomTimes==0||CustomSides==0)
        {
            hideIME();
            cleanText(Display);
            return;
        }
        Vector<Integer> Result=roll(CustomSides,CustomTimes);
        hideIME();
        Display.scrollTo(0,0);
        Display.setText(explainResult(Result));
    }

    void cleanText(View V)
    {
        ((TextView)V).setText("");
        //V.setVisibility(View.INVISIBLE);
        //V.setVisibility(View.VISIBLE);
    }
}
