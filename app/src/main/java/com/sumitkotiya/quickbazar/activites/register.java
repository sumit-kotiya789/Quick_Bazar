package com.sumitkotiya.quickbazar.activites;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.sumitkotiya.quickbazar.API_set_and_controller.Api_controller;
import com.sumitkotiya.quickbazar.R;
import com.sumitkotiya.quickbazar.models.SignupResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {

    TextInputEditText reg_email,reg_mobile,reg_password;
    Button reg_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        reg_email = findViewById(R.id.register_email);
        reg_mobile = findViewById(R.id.register_mobile);
        reg_password = findViewById(R.id.register_password);
        reg_submit = findViewById(R.id.register_submit);




        /*
        *
        * VALIDATION SECTION************************************************
        *
        *
        */






        /*
        *
        *
        * *******************************************************************
        *
        *
        */

        reg_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_email,user_password,user_mobile;
                user_email = reg_email.getText().toString().trim();
                user_password = reg_password.getText().toString().trim();
                user_mobile = reg_mobile.getText().toString().trim();
                user_register(user_email,user_mobile,user_password);
            }
        });

    }

    public void user_register(String email, String mobile, String password){
        String name = "NOT PROVIDED";
        String address = "NOT PROVIDED";

        //api ko call
        Call<SignupResponseModel> call = Api_controller.getInstance().getApi().getRegistered(name,email,password,mobile,address);

        //call ko retrofit queue mai lagata hai
        call.enqueue(new Callback<SignupResponseModel>() {
            @Override
            public void onResponse(Call<SignupResponseModel> call, Response<SignupResponseModel> response) {
                //yaha response ayaga
                SignupResponseModel obj = response.body();
                String result = obj.getMessage().trim();

                if(result.equals("inserted")){
                    Toast.makeText(register.this, "Acount created successfully", Toast.LENGTH_SHORT).show();
                    reg_email.setText("");
                    reg_mobile.setText("");
                    reg_password.setText("");
                }
                if(result.equals("exist")){
                    Toast.makeText(register.this, "Email already registered", Toast.LENGTH_SHORT).show();
                    reg_email.setText("");
                    reg_mobile.setText("");
                    reg_password.setText("");
                }
            }

            @Override
            public void onFailure(Call<SignupResponseModel> call, Throwable throwable) {
                Toast.makeText(register.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                reg_email.setText("");
                reg_mobile.setText("");
                reg_password.setText("");
            }
        });
    }
}