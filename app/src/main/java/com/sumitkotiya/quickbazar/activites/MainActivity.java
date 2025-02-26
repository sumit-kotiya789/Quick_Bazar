package com.sumitkotiya.quickbazar.activites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sumitkotiya.quickbazar.API_set_and_controller.Api_controller;
import com.sumitkotiya.quickbazar.R;
import com.sumitkotiya.quickbazar.models.LoginResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView signupBtn;
    EditText login_email,login_password;
    Button login_loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signupBtn = findViewById(R.id.login_signup);
        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        login_loginBtn = findViewById(R.id.login_loginBtn);


        /*
        *
        *
        * VALIDATION**********************************
        *
        * */

        verifyLogin();

        login_loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser(login_email.getText().toString(), login_password.getText().toString());
            }
        });


        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, register.class));
            }
        });
    }

    public  void loginUser(String email,String password){
        Call<LoginResponseModel> call = Api_controller.getInstance().getApi().checkLogin(email,password);
        call.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                //yaha response ayaga
                LoginResponseModel obj = response.body();
                String result = obj.getMessage().trim();

                if(result.equals("exists")){
                    SharedPreferences sp = getSharedPreferences("loginDetails",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("email",email);
                    editor.putString("password",password);
                    editor.commit();
                    editor.apply();


                    Toast.makeText(MainActivity.this, "successfully logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, dashboard.class));
                    finish();
                    login_email.setText("");
                    login_password.setText("");
                }
                if(result.equals("not_exists")){
                    Toast.makeText(MainActivity.this, "wrong email or password", Toast.LENGTH_SHORT).show();
                    login_password.setText("");
                    login_email.setText("");
                }


            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void verifyLogin(){
        SharedPreferences sp = getSharedPreferences("loginDetails",MODE_PRIVATE);
        if(sp.contains("email"))
            startActivity(new Intent(MainActivity.this, dashboard.class));
    }
}