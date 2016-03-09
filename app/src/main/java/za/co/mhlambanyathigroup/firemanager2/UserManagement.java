package za.co.mhlambanyathigroup.firemanager2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class UserManagement extends AppCompatActivity {
    private static Button button_sbmusermanagement;
    private static Button button_sbmLiveSpotterFeedsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        OnClickButtonListener();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    public void OnClickButtonListener()

    {
        button_sbmusermanagement = (Button) findViewById(R.id.UserManagementButton);
        button_sbmusermanagement.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent Navigator = new Intent("za.co.mhlambanyathigroup.firemanager2.UserManagement");
                        startActivity(Navigator);
                    }
                }

        );

        button_sbmLiveSpotterFeedsButton = (Button) findViewById(R.id.LiveSpotterFeedButton);
        button_sbmLiveSpotterFeedsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent Navigator = new Intent("za.co.mhlambanyathigroup.firemanager2.LiveSpotterFeed");
                        startActivity(Navigator);
                    }
                }

        );


    }

}
