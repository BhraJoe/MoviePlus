package com.example.movieplus.webpages;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.movieplus.R;
import com.example.movieplus.ui.Favorites.FavoritesFragment;

import java.nio.charset.StandardCharsets;

public class YouTubeVideoActivity extends AppCompatActivity {

    TextView Name,Desc,Title,Image;
//    ImageView imageView;
    WebView webView;
    ImageButton favoriteButton;
    boolean isFavorite = false;
    String videoId; // To identify the video



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


        Intent intent = getIntent();
        String[] Product = intent.getStringArrayExtra("Product");

        Name = findViewById(R.id.textView13);
        Desc = findViewById(R.id.textView14);
//        Title = findViewById(R.id.textView15);
//        imageView = findViewById(R.id.detailImage2);

        webView = findViewById(R.id.webView2);
        favoriteButton = findViewById(R.id.favoriteButton);




//        String s = "file:///android_asset/add.php?bc=" + "bc";
//        webView.loadUrl(s);


//        webView.
//        webView.loadUrl("file:///android_asset/youtube.html");


        String[] videoData = intent.getStringArrayExtra("Product");

        String Name = Product[0];
        String Desc = Product[1];
        String Title = Product[2];
        String Image = Product[3];
        String Url = Product[4];

        // Extract video ID from URL for favorites tracking
        this.videoId = extractVideoId(Url);
        isFavorite = FavoritesFragment.isFavorite(this, videoId);
        updateFavoriteButton();

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String html = "<html><body>" +
                "<iframe width=\"366\" height=\"325\" src=\""+Url+"\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write;   encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>" +
                "</body></html>";
        String baseUrl = "https://example.com/";
        webView.loadDataWithBaseURL(baseUrl, html, "text/html", null, baseUrl);
//        imageView.setImageResource(Integer.parseInt(Image));
        this.Name.setText(Name);
        this.Desc.setText(Desc);
//        this.Title.setText(Title);


        favoriteButton.setOnClickListener(v -> {
            isFavorite = !isFavorite;
            if (isFavorite) {
                FavoritesFragment.addToFavorites(this, videoId);
                Toast.makeText(this, "Added to favorites", Toast.LENGTH_SHORT).show();
            } else {
                FavoritesFragment.removeFromFavorites(this, videoId);
                Toast.makeText(this, "Removed from favorites", Toast.LENGTH_SHORT).show();
            }
            updateFavoriteButton();
        });
    }

    private void updateFavoriteButton() {
        favoriteButton.setImageResource(
                isFavorite ? R.drawable.ic_launcher_foreground : R.drawable.ic_launcher_background
        );
    }




    private String extractVideoId(String url) {
        // Simple extraction - you might need a more robust solution
        if (url.contains("v=")) {
            return url.substring(url.indexOf("v=") + 2, url.indexOf("v=") + 13);
        }
        return String.valueOf(url.hashCode()); // Fallback
    }

}