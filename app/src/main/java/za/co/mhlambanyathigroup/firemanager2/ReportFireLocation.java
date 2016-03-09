package za.co.mhlambanyathigroup.firemanager2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ReportFireLocation extends AppCompatActivity {

    private static Button button_sbmrcl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_fire_location);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnClickButtonListener();
    }
    public void OnClickButtonListener()

    {
        button_sbmrcl = (Button) findViewById(R.id.findlocationbutton);
        button_sbmrcl.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent Navigator = new Intent("za.co.mhlambanyathigroup.firemanager2.GetCurrentLocation");
                        startActivity(Navigator);
                    }
                }

        );

}

}
