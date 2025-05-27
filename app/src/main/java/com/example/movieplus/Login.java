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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    TextInputEditText email, password;
    private FirebaseAuth mAuth;




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

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();




        Boolean pass = UserPass.length() > 0;

        Boolean user = UserMail.length() > 0;

        if (pass.booleanValue() && user.booleanValue()){

            Toast.makeText(this, pass+" "+ user, Toast.LENGTH_SHORT).show();

            if (pass.booleanValue() && user.booleanValue()){


                try {
                    mAuth.signInWithEmailAndPassword(UserMail,UserPass)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        // Sign in success, update UI with the signed-in user's information

                                        FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
//
                                        Toast.makeText(getApplicationContext(), "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
//                                        updateUI(null);
                                    }
                                }
                            });
                } catch (Exception e) {
                    Toast.makeText(this,e.toString(), Toast.LENGTH_SHORT).show();
                }


            }

            }




        }

    private void updateUI(FirebaseUser firebaseUser) {

        try {
//            Toast.makeText(this, "Welcome Home", Toast.LENGTH_SHORT).show();

            Intent intent1 = new Intent(getApplicationContext(), MoviePlusActivity.class);
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

    public void  logout(){
        FirebaseAuth.getInstance().signOut();
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent(getApplicationContext(),Login.class);
//        startActivity(intent);
//    }
}
