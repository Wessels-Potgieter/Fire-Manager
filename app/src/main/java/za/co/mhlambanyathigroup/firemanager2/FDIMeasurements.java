package za.co.mhlambanyathigroup.firemanager2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;



public class FDIMeasurements extends AppCompatActivity {

    private static Button button_sbmfdicalculator;
    private static Button button_sbmfdipro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdimeasurements);
        OnClickButtonListener();

    }
    public void OnClickButtonListener()

    {
        button_sbmfdicalculator = (Button) findViewById(R.id.fdicalculatorbutton);
        button_sbmfdicalculator.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent FDICalculator = new Intent("za.co.mhlambanyathigroup.firemanager2.FDICalculator");
                        startActivity(FDICalculator);
                    }
                }

        );

        button_sbmfdipro = (Button) findViewById(R.id.fdiprobutton);
        button_sbmfdipro.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Weather2 = new Intent("za.co.mhlambanyathigroup.firemanager2.Weather");
                        startActivity(Weather2);
                    }
                }

        );

    }

}
