package za.co.mhlambanyathigroup.firemanager2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.Toast;

public class Weather extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Do stuff here

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Intent FDIWeather = new Intent("za.co.mhlambanyathigroup.firemanager2.FDIWeather");
            startActivity(FDIWeather);
            //Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            //setContentView(R.layout.activity_fdiweather);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }






    }


}
