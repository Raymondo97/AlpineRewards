package com.alpinereword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Rewards extends AppCompatActivity {
    LoginResponse loginResponse;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        name = (TextView)findViewById(R.id.clientName);
        //Receiving data from login
        Intent intent= getIntent();
        if (intent.getExtras() != null){
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            name.setText(loginResponse.getUsername());
            Log.e("TAG", "====>" + loginResponse.getEmail());
            //Not sure why is not getting the firstName
            Log.e("TAG", "====>" + loginResponse.getFirst_name());

        }
    }

    //
}