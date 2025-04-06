package com.example.movieplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    TextInputEditText email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }

    public void login(View view) {
//        Intent intent = new Intent(getApplicationContext(), Register.class);
//        startActivity(intent);

        String UserMail = email.getText().toString();
        String UserPass = password.getText().toString();


        Boolean pass = UserPass.length() > 0;

        Boolean user = UserMail.length() > 0;

        if (pass.booleanValue() && user.booleanValue()){

            Toast.makeText(this, pass+" "+ user, Toast.LENGTH_SHORT).show();

            if (pass.booleanValue() && user.booleanValue()){

                Toast.makeText(this, UserMail+" "+ UserPass, Toast.LENGTH_SHORT).show();

                if (UserPass.equals("Admin")  && UserMail.equals("Admin@gmail.com") ){

                    Toast.makeText(this, "welcome Home", Toast.LENGTH_SHORT).show();

                    Intent intent1 = new Intent(getApplicationContext(), MoviePlusActivity.class);
                    startActivity(intent1);

                }else {

                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }

            }




        }


    }
}