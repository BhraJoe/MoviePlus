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

import com.example.movieplus.databinding.ActivityRegisterBinding;
import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {

    ActivityRegisterBinding binding;
    TextInputEditText Email,Password,Cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Email = binding.Email;
        Password = binding.Password;
        Cpassword = binding.Cpassword;





//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_register);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    public void button(View view){

        String UserMail = Email.getText().toString();
        String UserPass = Password.getText().toString();
        String UserCpass = Cpassword.getText().toString();

        Boolean mail = UserMail.length() > 0;
        Boolean pass = UserCpass.length() > 0;
        Boolean cpass = UserPass.length() > 0;


        if (mail && pass && cpass){

            if (UserMail.contains("@") && UserMail.contains(".com")){

                if (UserPass.equals(UserCpass)){

                    Toast.makeText(this, "welcome Home", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);

                }else {

                    Toast.makeText(this, "Password Not Matched", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), LoginRegisterPage.class);
                    startActivity(intent);
                }

            }else {

                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            }

        }else {

            Toast.makeText(this, "All Fields Required", Toast.LENGTH_SHORT).show();

        }




    }
}
