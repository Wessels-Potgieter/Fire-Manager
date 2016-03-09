package za.co.mhlambanyathigroup.firemanager2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Management extends AppCompatActivity {

    private static Button button_sbmSpotterFeed;
    private static Button button_sbmCreateRSSFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        OnClickButtonListener();
    }
    public void OnClickButtonListener()

    {

        button_sbmSpotterFeed = (Button) findViewById(R.id.LiveSpotterFeedButton);
        button_sbmSpotterFeed.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent Navigator = new Intent("za.co.mhlambanyathigroup.firemanager2.LiveSpotterFeed");
                        startActivity(Navigator);
                    }
                }

        );

        button_sbmCreateRSSFeed  = (Button) findViewById(R.id.CreateRSSFeed);
        button_sbmCreateRSSFeed.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent Navigator = new Intent("za.co.mhlambanyathigroup.firemanager2.CreateRSSFeed");
                        startActivity(Navigator);
                    }
                }

        );


    }
}
