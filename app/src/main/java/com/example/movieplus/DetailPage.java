package com.example.movieplus;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.movieplus.R;
import com.example.movieplus.ui.Favorites.DatabaseHelper;
import com.example.movieplus.ui.Favorites.FavoritesAdapter;
import com.example.movieplus.ui.Favorites.Movie;

public class DetailPage extends AppCompatActivity {

    TextView Name,Desc,Title,Image;
    //    ImageView imageView;
    WebView webView;
    private Button favoriteButton;





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

        Name = findViewById(R.id.textView13);
        Desc = findViewById(R.id.textView14);
//        Title = findViewById(R.id.textView15);
//        imageView = findViewById(R.id.detailImage2);

        webView = findViewById(R.id.webView2);
//        favoriteButton = findViewById(R.id.button5);
//
//        favoriteButton.setOnClickListener(v -> {
//            Intent intent1 = new Intent(DetailPage.this, FragmentActivity.class);
//            startActivity(intent1);
//            finish();
//        });







//        String s = "file:///android_asset/add.php?bc=" + "bc";
//        webView.loadUrl(s);


//        webView.
//        webView.loadUrl("file:///android_asset/youtube.html");




        String Name = Product[0];
        String Desc = Product[1];
        String Title = Product[2];
        String Image = Product[3];
        String Url = Product[4];







        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String html = "<html><body>" +
                "<iframe width=\"100%\" height=\"100%\" src=\""+Url+"\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write;   encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>" +
                "</body></html>";
        String baseUrl = "https://example.com/";
        webView.loadDataWithBaseURL(baseUrl, html, "text/html", null, baseUrl);
//        imageView.setImageResource(Integer.parseInt(Image));
        this.Name.setText(Name);
        this.Desc.setText(Desc);
//        this.Title.setText(Title);

    }


}