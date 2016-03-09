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

public class Chat extends AppCompatActivity {

    private static Button button_sbmcontinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnClickButtonListener();


    }

    public void OnClickButtonListener()

    {
        button_sbmcontinue = (Button) findViewById(R.id.ContinueFireChatButton);
        button_sbmcontinue.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent firechat = new Intent("za.co.mhlambanyathigroup.firemanager2.firechat");
                        startActivity(firechat);
                    }
                }

        );

    }
}