package com.example.movieplus;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    Button button3, button4;
    EditText email;
    ProgressBar progressBar;
    FirebaseAuth mAuth;
    String emailAddress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        email = findViewById(R.id.email);
        progressBar = findViewById(R.id.progressBar);



        mAuth = FirebaseAuth.getInstance();

        button3.setOnClickListener(v -> {
            emailAddress = email.getText().toString();
            if (!TextUtils.isEmpty(emailAddress)) {
                ResetPassword();
            } else {
                email.setError("Email is required");
            }

        });
        button4.setOnClickListener(v -> {
            Intent intent = new Intent(ForgotPassword.this, Login.class);
            startActivity(intent);
            finish();
        });


    }

    private void ResetPassword() {
        progressBar.setVisibility(View.VISIBLE);
        button3.setVisibility(View.INVISIBLE);

       mAuth.sendPasswordResetEmail(emailAddress)


                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(ForgotPassword.this, "Email Sent", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ForgotPassword.this, Login.class);
                        startActivity(intent);
                        finish();

                    }

                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgotPassword.this, "Email Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                        button3.setVisibility(VISIBLE);
                    }
                });

    }
}





