package com.valiancy.phaseonechallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutALC = findViewById(R.id.btn_about_alc);

        aboutALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ALC", "About ALC");
                startActivity(new Intent(MainActivity.this, AboutALC.class));
            }
        });

        Button myProfile = findViewById(R.id.btn_my_profile);

        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ALC", "My Profile");
                startActivity(new Intent(MainActivity.this, MyProfile.class));
            }
        });

    }


}
