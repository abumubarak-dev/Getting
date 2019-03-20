package com.example.user.getting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String KEY="data";


    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(set());
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setThemes("pink");


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setThemes("green");

            }
        });
    }

    public void setThemes(String color){

        SharedPreferences preferences= getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=preferences.edit();

        editor.putString(KEY,color);

        editor.apply();

        editor.commit();

        recreate();
    }

    public int set(){

        SharedPreferences preferences= getPreferences(Context.MODE_PRIVATE);

        String s=preferences.getString(KEY,"");

        switch (s){
            case "pink":
                return R.style.PinkTheme;
            case "green":
                return R.style.LightGreenTheme;
                default:
                    return R.style.AppTheme;

        }


    }

}

