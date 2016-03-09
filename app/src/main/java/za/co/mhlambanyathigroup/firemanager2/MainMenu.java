package za.co.mhlambanyathigroup.firemanager2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity {

    private static ImageButton button_sbmnav;
    private static ImageButton button_sbmweather;
    private static ImageButton button_sbmevs;
    private static ImageButton button_sbmchat;
    private static ImageButton button_sbmreport;
    private static ImageButton button_sbmfeeds;
    private static ImageButton button_sbmfdim;
    private static ImageButton button_sbmactfires;
    private static ImageButton button_sbmreqper;
    private static Button button_sbmman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        OnClickButtonListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);

        return true;

    }

    public void OnClickButtonListener()

    {
        button_sbmnav = (ImageButton) findViewById(R.id.NavigatorButton);
        button_sbmnav.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent Navigator = new Intent("za.co.mhlambanyathigroup.firemanager2.navigation");
                startActivity(Navigator);
            }
        }

        );

        button_sbmman = (Button) findViewById(R.id.Management);
        button_sbmman.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent Management = new Intent("za.co.mhlambanyathigroup.firemanager2.Management");
                        startActivity(Management);
                    }
                }

        );
        button_sbmweather = (ImageButton) findViewById(R.id.WeatherButton);
        button_sbmweather.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent Weather = new Intent("za.co.mhlambanyathigroup.firemanager2.Weather");
                        startActivity(Weather);
                    }
                }

        );
        button_sbmevs = (ImageButton) findViewById(R.id.EVSButton);
        button_sbmevs.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent EVS = new Intent("za.co.mhlambanyathigroup.firemanager2.EVS");
                        startActivity(EVS);
                    }
                }

        );
        button_sbmchat = (ImageButton) findViewById(R.id.ChatButton);
        button_sbmchat.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent Chat = new Intent("za.co.mhlambanyathigroup.firemanager2.Chat");
                        startActivity(Chat);
                    }
                }

        );
        button_sbmreport = (ImageButton) findViewById(R.id.ReportButton);
        button_sbmreport.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent Report = new Intent("za.co.mhlambanyathigroup.firemanager2.Report");
                        startActivity(Report);
                    }
                }

        );
        button_sbmfeeds = (ImageButton) findViewById(R.id.FeedsButton);
        button_sbmfeeds.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent Feeds = new Intent("za.co.mhlambanyathigroup.firemanager2.Feeds");
                        startActivity(Feeds);
                    }
                }

        );
        button_sbmfdim = (ImageButton) findViewById(R.id.FDIMeasurementsButton);
        button_sbmfdim.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent FDIMeasurements = new Intent("za.co.mhlambanyathigroup.firemanager2.FDIMeasurements");
                        startActivity(FDIMeasurements);
                    }
                }

        );
        button_sbmactfires = (ImageButton) findViewById(R.id.ActiveFiresButton);
        button_sbmactfires.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent ActiveFires = new Intent("za.co.mhlambanyathigroup.firemanager2.activefires");
                        startActivity(ActiveFires);
                    }
                }

        );
        button_sbmreqper = (ImageButton) findViewById(R.id.RequestPermitButton);
        button_sbmreqper.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent RequestPermit = new Intent("za.co.mhlambanyathigroup.firemanager2.RequestPermit");
                        startActivity(RequestPermit);
                    }
                }

        );

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
