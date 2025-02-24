package com.sumitkotiya.quickbazar.activites;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sumitkotiya.quickbazar.R;

public class register extends AppCompatActivity {

    EditText reg_email,reg_mobile,reg_password;
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

        String user_email,user_password,user_mobile;
        user_email = reg_email.getText().toString();
        user_password = reg_password.getText().toString();
        user_mobile = reg_mobile.getText().toString();

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
                user_register(user_email,user_mobile,user_password);
            }
        });

    }

    public void user_register(String email, String mobile, String password){
        String name = "NOT PROVIDED";
        String address = "NOT PROVIDED";
    }
}