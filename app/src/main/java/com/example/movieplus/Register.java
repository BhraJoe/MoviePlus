package com.example.movieplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.movieplus.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    ActivityRegisterBinding binding;
    TextInputEditText Email, Password, Cpassword;

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

    public void button(View view) {

        String UserMail = Email.getText().toString().trim();
        String UserPass = Password.getText().toString().trim();
        String UserCpass = Cpassword.getText().toString().trim();

        Boolean mail = UserMail.length() > 0;
        Boolean pass = UserPass.length() > 0;
        Boolean cpass = UserCpass.length() > 0;

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        if (mail && pass && cpass) {

            if (UserMail.contains("@") && UserMail.contains(".com")) {

                if (UserPass.equals(UserCpass)) {


                    mAuth.createUserWithEmailAndPassword(UserMail, UserPass)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        // Sign in success, update UI with the signed-in user's information

                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
                                        updateUI(user);

                                    } else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(getApplicationContext(), task.getException().toString(), Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });


                } else {

                    Toast.makeText(this, "Password Not Matched", Toast.LENGTH_SHORT).show();


                }

            } else {

                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            }

        } else {

            Toast.makeText(this, "All Fields Required", Toast.LENGTH_SHORT).show();

        }


    }

    private void updateUI(FirebaseUser user) {
        try {
            Toast.makeText(this, "Welcome Home", Toast.LENGTH_SHORT).show();

            Intent intent1 = new Intent(getApplicationContext(), Login.class);
            startActivity(intent1);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        try {
            FirebaseUser currentUser = mAuth.getCurrentUser();
            updateUI(currentUser);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
