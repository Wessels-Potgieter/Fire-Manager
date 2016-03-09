package za.co.mhlambanyathigroup.firemanager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class PostFeed extends AppCompatActivity {

    private static Button button_sbmPostFeed;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_feed);
        OnClickButtonListener();
    }
    public void OnClickButtonListener()

    {

        button_sbmPostFeed = (Button) findViewById(R.id.CreateRSSFeed);
        button_sbmPostFeed.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://mhlambanyathigroup.co.za/feeds/wp-admin/post-new.php")));
                    }
                }

        );

    }

}



