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
import android.widget.Button;
import android.widget.ImageButton;

public class LiveSpotterFeed extends AppCompatActivity {

    private static Button button_sbmSpotterOneButton;
    private static Button button_sbmSpotterTwoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_spotter_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        OnClickButtonListener();
    }
    public void OnClickButtonListener()

    {
        button_sbmSpotterOneButton = (Button) findViewById(R.id.SpotterOneButton);
        button_sbmSpotterOneButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent Navigator = new Intent("za.co.mhlambanyathigroup.firemanager2.SpotterOneFeed");
                        startActivity(Navigator);
                    }
                }

        );

        button_sbmSpotterTwoButton = (Button) findViewById(R.id.SpotterTwoButton);
        button_sbmSpotterTwoButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCD1AYQCVAAEetLNYPFfgf3g/live")));
                        Log.i("Video", "Video Playing....");
                    }
                }

        );

    }

}
