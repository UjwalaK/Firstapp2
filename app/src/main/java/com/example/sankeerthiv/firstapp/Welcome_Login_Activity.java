package com.example.sankeerthiv.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Welcome_Login_Activity extends AppCompatActivity {

    RelativeLayout relativeLogin1;
    public Button login_button;
    private TextView login_userid;
    private TextView login_userpassword;
    private EditText userName, password;


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            relativeLogin1.setVisibility(View.VISIBLE);


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__login_);
        relativeLogin1 = (RelativeLayout) findViewById(R.id.relativeLogin1);

        handler.postDelayed(runnable, 3000);
        userName = (EditText) findViewById(R.id.et_user_id);
        password = (EditText) findViewById(R.id.et_password);
        login_userid = (TextView) findViewById(R.id.login_userid);
        login_userpassword = (TextView) findViewById(R.id.login_userpassword);
        login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String userNameText = userName.getText().toString();
//                String passwordText = password.getText().toString();
                Log.v("USERNAME", userName.getText().toString());

//                    if(validate(userName.getText().toString(),password.getText().toString())){
//                        Intent intent = new Intent(Welcome_Login_Activity.this, MainActivity.class);
//                        startActivity(intent);
//
//                        Context context = Welcome_Login_Activity.this;
//                        String message= "login successful";
//                        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
//
//                    }
//                    else {
//
//                        Context context = Welcome_Login_Activity.this;
//                        String message= "Invalid Id or password";
//                        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
//
//
//                    }
                ApiData apiData = RetrofitClient.getInstance();

                Call<DataModel> dataModelCall = apiData.getData(userName.getText().toString(), password.getText().toString());

                dataModelCall.enqueue(new Callback<DataModel>() {
                    @Override
                    public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                        DataModel dataModel = response.body();
                        Log.v("RESPONSE", dataModel.isStatus() + "");

                    }

                    @Override
                    public void onFailure(Call<DataModel> call, Throwable t) {
                        Log.v("FAIL", t.getMessage());
                    }
                });


            }
        });


    }
}





