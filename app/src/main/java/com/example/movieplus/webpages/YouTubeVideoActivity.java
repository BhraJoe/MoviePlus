package com.example.movieplus.webpages;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.movieplus.R;
import com.example.movieplus.ui.Favorites.DatabaseHelper;
import com.example.movieplus.ui.gallery.GalleryFragment;
import com.example.movieplus.ui.home.HomeFragment;

import java.io.ByteArrayOutputStream;


public class YouTubeVideoActivity extends AppCompatActivity {

    TextView Name, Desc;
    WebView webView;
    ImageButton favoriteButton;
    DatabaseHelper dbHelper;
    String videoUrl;
    boolean isFavorite = false;
    String movieName, movieImageUrl;
    private Button favoriteButton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_you_tube_video);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        String[] Product = intent.getStringArrayExtra("Product");

        Name = findViewById(R.id.textView13);
        Desc = findViewById(R.id.textView14);
        webView = findViewById(R.id.webView2);
        favoriteButton = findViewById(R.id.favoriteButton);
//        favoriteButton1 = findViewById(R.id.button6);

        movieName = Product[0];
        String movieDesc = Product[1];
        String movieImage = Product[3];
        String movieUrl = Product[4];
        movieImageUrl = movieImage; // Assuming this is the URL

        // Check if this movie is already a favorite
        isFavorite = dbHelper.isFavorite(movieName);
        updateFavoriteButton();

//        favoriteButton1.setOnClickListener(v -> {
//            Intent intent1 = new Intent(YouTubeVideoActivity.this, FragmentActivity.class);
//            startActivity(intent1);
//            finish();
//        });


        favoriteButton.setOnClickListener(v -> {
            if (isFavorite) {
                dbHelper.removeFavorite(movieName);
                Toast.makeText(this, "Removed from favorites", Toast.LENGTH_SHORT).show();
            } else {
                Log.d( "check", movieDesc );
                dbHelper.addFavorite(movieName, movieImageUrl, movieUrl, videoUrl, movieDesc);
                Toast.makeText(this, "Added to favorites", Toast.LENGTH_SHORT).show();
            }
            isFavorite = !isFavorite;
            updateFavoriteButton();
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String html = "<html><body>" +
                "<iframe width=\"100%\" height=\"100%\" src=\""+movieUrl+"\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>" +
                "</body></html>";
        String baseUrl = "https://example.com/";
        webView.loadDataWithBaseURL(baseUrl, html, "text/html", null, baseUrl);

        Name.setText(movieName);
        Desc.setText(movieDesc);
        videoUrl = movieUrl;


    }

    private void updateFavoriteButton() {
        if (isFavorite) {
            favoriteButton.setImageResource(R.drawable.ic_launcher_foreground);
        } else {
            favoriteButton.setImageResource(R.drawable.ic_launcher_background);
        }
    }





    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}