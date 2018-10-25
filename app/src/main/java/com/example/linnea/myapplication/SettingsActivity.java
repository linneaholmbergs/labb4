package com.example.linnea.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.design.internal.NavigationMenu;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity {


    Switch mPink;
    Switch mBlue;
    Switch mYellow;
    Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        mBlue = findViewById(R.id.blue);
        mPink = findViewById(R.id.rosa);
        mYellow = findViewById(R.id.yellow);
        backButton = findViewById(R.id.backButton);

        

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SettingsActivity.this,MainActivity.class);
                startActivityForResult(myIntent,0);
            }
        });


        mYellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                storeColor(getResources().getColor(R.color.colorYellow));
            }
            }

        });
        mBlue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    storeColor(getResources().getColor(R.color.colorBlue));
                }
            }

        });
        mPink.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    storeColor(getResources().getColor(R.color.colorPink));
                }
            }

        });


    }

    private void storeColor(int color){
        SharedPreferences mSharedPreferences =  getSharedPreferences("Toolbarcolor",MODE_PRIVATE);
        SharedPreferences.Editor mEditor =  mSharedPreferences.edit();
        mEditor.putInt("color",color);
        mEditor.apply();
    }

}
