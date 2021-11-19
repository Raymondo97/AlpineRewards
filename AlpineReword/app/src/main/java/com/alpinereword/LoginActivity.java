package com.alpinereword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.Password);
        MaterialButton button = (MaterialButton) findViewById(R.id.loginBtn);
        TextView link = (TextView) findViewById(R.id.registerLink);
        link.setMovementMethod(LinkMovementMethod.getInstance());

        //USer and Pass: admin and admin
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "All inputs required", Toast.LENGTH_SHORT).show();
                } else {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setUsername(username.getText().toString());
                    loginRequest.setPassword(password.getText().toString());
                    //Toast.makeText(LoginActivity.this, "Succesull", Toast.LENGTH_SHORT).show();
                    loginUser(loginRequest);

                }

            }


        });
    }
        public void loginUser(LoginRequest loginRequest){
            Call<LoginResponse> loginResponseCall = APIClient.getService().loginUser(loginRequest);
            loginResponseCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if(response.isSuccessful()){
                        LoginResponse loginResponse = response.body();
                        startActivity(new Intent(LoginActivity.this, Rewards.class).putExtra("data",loginResponse));
                        //finish();

                    }else {
                        String messaje = "User or Password is incorrect";
                        Toast.makeText(LoginActivity.this, messaje, Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    String message = t.getLocalizedMessage();
                    Toast.makeText(LoginActivity.this,message, Toast.LENGTH_LONG).show();
                }
            });
        }


    }
