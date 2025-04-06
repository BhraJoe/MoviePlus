package com.example.movieplus;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailPage extends AppCompatActivity {

    TextView Name,Desc,Title,Image;

    WebView webView;

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


            });




        Intent intent = getIntent();
        String[] Product = intent.getStringArrayExtra("Product");

        Name = findViewById(R.id.textView12);
        imageView = findViewById(R.id.detailImage);
        webView = findViewById(R.id.webView);






        String Name = Product[0];
        String Desc = Product[1];
        String Title = Product[2];
        String Image = Product[3];
        imageView.setImageResource(Integer.parseInt(Image));
        String url = getIntent().getStringExtra("URL");
        webView.loadUrl("url");
//        textView.setText(Name);
//        textView.setText(Desc);





    }
}