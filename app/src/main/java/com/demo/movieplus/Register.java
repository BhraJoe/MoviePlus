package com.demo.movieplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.demo.movieplus.databinding.ActivityRegisterBinding;
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
    TextView textView;
    CheckBox termsCheckbox;
    TextView privacyPolicyLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Email = binding.Email;
        Password = binding.Password;
        Cpassword = binding.Cpassword;
        textView = binding.textView;

        // Initialize terms and privacy views
        termsCheckbox = binding.termsCheckbox; // Make sure to add this in your layout
        privacyPolicyLink = binding.privacyPolicyLink; // Make sure to add this in your layout

        // Navigate to Login activity
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        // Privacy policy link click listener
        privacyPolicyLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPrivacyPolicyDialog();
            }

        });


        // Terms and conditions text click listener (optional - if you want the text to be clickable too)
        TextView termsText = binding.termsText; // Add this TextView in your layout
        termsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTermsAndConditionsDialog();
            }
            });

        }

    private void showTermsAndConditionsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Terms and Conditions");
        builder.setMessage( "1. Acceptance of Terms\n" +
                "By creating an account, you agree to be bound by these Terms and Conditions.\n\n" +
                "2. Account Registration\n" +
                "You must provide accurate and complete information when creating an account.\n\n" +
                "3. User Responsibilities\n" +
                "You are responsible for:\n" +
                "• Maintaining the confidentiality of your account\n" +
                "• All activities under your account\n" +
                "• Complying with all applicable laws\n\n" +
                "4. Service Usage\n" +
                "You agree not to:\n" +
                "• Use the service for illegal purposes\n" +
                "• Attempt to gain unauthorized access\n" +
                "• Interfere with the service's operation\n\n" +
                "5. Termination\n" +
                "We reserve the right to terminate accounts that violate these terms.\n\n" +
                "6. Changes to Terms\n" +
                "We may modify these terms at any time. Continued use constitutes acceptance.\n\n" +
                "7. Limitation of Liability\n" +
                "We are not liable for any indirect damages arising from use of our service.");
        builder.setPositiveButton("OK", (dialog, which) -> {
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void showPrivacyPolicyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Privacy Policy");
        builder.setMessage( "1. Information We Collect\n" +
                "We collect information you provide directly to us, including:\n" +
                "• Email address\n" +
                "• Account credentials\n" +
                "• Usage data and preferences\n\n" +
                "2. How We Use Your Information\n" +
                "We use the information we collect to:\n" +
                "• Provide and maintain our services\n" +
                "• Authenticate your account\n" +
                "• Send you important updates\n" +
                "• Improve our application\n\n" +
                "3. Data Security\n" +
                "We implement appropriate security measures to protect your personal information.\n\n" +
                "4. Your Rights\n" +
                "You have the right to access, update, or delete your personal information.\n\n" +
                "5. Contact Us\n" +
                "If you have any questions about this Privacy Policy, please contact us at privacy@movieplus.com.");

        // You can set the privacy policy text here

        builder.setPositiveButton("OK", (dialog, which) -> {
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.show();


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

                    // Check if terms are accepted
                    if (termsCheckbox.isChecked()) {

                        if (isPasswordValid(UserPass)) {

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
                                                String errorMessage = task.getException().getMessage();
                                                Toast.makeText(getApplicationContext(), "Registration failed: " + errorMessage, Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });

                        } else {
                            Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_LONG).show();
                        }

                    } else {
                        Toast.makeText(this, "Please accept Terms & Conditions and Privacy Policy", Toast.LENGTH_LONG).show();
                    }

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

    private boolean isPasswordValid(String password) {
        // Firebase requires passwords to be at least 6 characters
        return password.length() >= 6;
    }


    private void updateUI(FirebaseUser user) {
        try {
            Toast.makeText(this, "Welcome Home", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(getApplicationContext(), Login.class);
            startActivity(intent1);
            finish();
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        try {
            if (mAuth != null) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
                    updateUI(currentUser);
                }
            }
        } catch (Exception e) {
            // Handle exception silently
        }
    }
}