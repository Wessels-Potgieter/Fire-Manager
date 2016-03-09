package za.co.mhlambanyathigroup.firemanager2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;




public class FDICalculator extends AppCompatActivity {
    EditText TextTempMain;
    EditText TextHumMain;
    EditText TextWindMain;
    EditText TextLastRainMain;
    EditText TextRainMain;
    TextView addResult;
    Button btnAdd;
    double NumTemp,NumHum,wind,daysrain,rain,fdi,windfactor,BurnIndex,TempFactor,HumidityFactor,BurnFactor;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdicalculator);

        TextTempMain = (EditText)findViewById(R.id.TextTemp);
        TextHumMain = (EditText)findViewById(R.id.TextHum);
        TextWindMain = (EditText)findViewById(R.id.TextWind);
        TextLastRainMain = (EditText)findViewById(R.id.TextLastRain);
        TextRainMain = (EditText)findViewById(R.id.TextRain);

        addResult = (TextView)findViewById(R.id.textViewFDI);

        btnAdd = (Button)findViewById(R.id.CalculateButton);
        OnClickButtonListener();
    }
    public void OnClickButtonListener()
    {

        final Intent Safe = new Intent(this, Safe.class);
        final Intent Low = new Intent(this, Low.class);
        final Intent Moderate = new Intent(this, Moderate.class);
        final Intent High = new Intent(this, High.class);
        final Intent Extremely_High = new Intent(this, ExtremelyHigh.class);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String strTempMain = TextTempMain.getText().toString();
                if (TextUtils.isEmpty(strTempMain)) {
                    TextTempMain.setError("Cannot be empty. Please enter 40 or less");
                    return;
                }

                String strHumMain = TextHumMain.getText().toString();
                if (TextUtils.isEmpty(strHumMain)) {
                    TextHumMain.setError("Cannot be empty. Please enter 100 or less");
                    return;
                }


                String strWindMain = TextWindMain.getText().toString();
                if (TextUtils.isEmpty(strWindMain)) {
                    TextWindMain.setError("Cannot be empty. Please enter 0 or more");
                    return;
                }

                String strLastRain = TextLastRainMain.getText().toString();
                if (TextUtils.isEmpty(strLastRain)) {
                    TextLastRainMain.setError("Cannot be empty. Please enter 21 or less");
                    return;
                }


                String strRainMain = TextRainMain.getText().toString();
                if (TextUtils.isEmpty(strRainMain)) {
                    TextRainMain.setError("Cannot be empty. Please enter 1 or more");
                    return;
                }


                NumTemp = Double.parseDouble(TextTempMain.getText().toString());
                NumHum = Double.parseDouble(TextHumMain.getText().toString());
                wind = Double.parseDouble(TextWindMain.getText().toString());
                daysrain = Double.parseDouble(TextLastRainMain.getText().toString());
                rain = Double.parseDouble(TextRainMain.getText().toString());
                TempFactor = ((NumTemp - 3) * 6.7);
                HumidityFactor = ((90 - NumHum) * 2.6);
                BurnFactor = (TempFactor - HumidityFactor);
                BurnIndex = ((((BurnFactor) / 2) + (HumidityFactor)) / 3.3);
                new Thread(new Runnable() {
                    public void run() {
                        if ((wind >= 0) && (wind < 2))
                            windfactor = (BurnIndex + 0);
                        else if ((wind >= 2) && (wind < 5))
                            windfactor = (BurnIndex + 5);
                        else if ((wind >= 5) && (wind < 17))
                            windfactor = (BurnIndex + 10);
                        else if ((wind >= 17) && (wind < 26))
                            windfactor = (BurnIndex + 15);
                        else if ((wind >= 26) && (wind < 33))
                            windfactor = (BurnIndex + 20);
                        else if ((wind >= 33) && (wind < 37))
                            windfactor = (BurnIndex + 25);
                        else if ((wind >= 37) && (wind < 42))
                            windfactor = (BurnIndex + 30);
                        else if ((wind >= 42) && (wind < 46))
                            windfactor = (BurnIndex + 35);
                        else
                            windfactor = (BurnIndex + 40);
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {


                        if ((rain > 0) && (rain < 2.7)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.9);
                            else
                                fdi = (windfactor * 1);
                        } else if ((rain >= 2.7) && (rain < 5.3)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 3)
                                fdi = (windfactor * 1);
                        } else if ((rain >= 5.3) && (rain < 7.7)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.5);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.5);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 4)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 4)
                                fdi = (windfactor * 1);
                        } else if ((rain >= 7.7) && (rain < 10.3)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.4);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.4);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 4)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 5)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 5)
                                fdi = (windfactor * 1);
                        } else if ((rain >= 10.3) && (rain < 12.9)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.4);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.4);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 4)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 5)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 6)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 6)
                                fdi = (windfactor * 1);
                        } else if ((rain >= 12.9) && (rain < 15.4)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.3);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.3);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.5);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 4)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 5)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 6)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 6)
                                fdi = (windfactor * 1);
                        } else if ((rain >= 15.4) && (rain < 20.6)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.2);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.2);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.5);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 4)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 5)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 6)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 7)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 8)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 8)
                                fdi = (windfactor * 1);
                        } else if ((rain >= 20.6) && (rain < 25.6)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.2);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.2);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.4);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.5);
                            else if (daysrain == 4)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 5)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 6)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 7)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 8)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 8)
                                fdi = (windfactor * 1);
                        } else if ((rain >= 25.6) && (rain < 38.5)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.01);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.1);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.3);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.4);
                            else if (daysrain == 4)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 5)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 6)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 7)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 8)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 9)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 10)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 10)
                                fdi = (windfactor * 1);
                        } else if ((rain >= 38.5) && (rain < 51.2)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.01);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.01);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.2);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.4);
                            else if (daysrain == 4)
                                fdi = (windfactor * 0.5);
                            else if (daysrain == 5)
                                fdi = (windfactor * 0.5);
                            else if (daysrain == 6)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 7)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 8)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 9)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 10)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 11)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 12)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 12)
                                fdi = (windfactor * 1);
                        } else if ((rain >= 51.2) && (rain < 63.9)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.01);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.01);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.2);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.3);
                            else if (daysrain == 4)
                                fdi = (windfactor * 0.4);
                            else if (daysrain == 5)
                                fdi = (windfactor * 0.5);
                            else if (daysrain == 6)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 7)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 8)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 9)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 10)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 11)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 12)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 13)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 14)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 15)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 15)
                                fdi = (windfactor * 1);
                        } else if ((rain >= 63.9) && (rain < 76.6)) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.01);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.01);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.1);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.2);
                            else if (daysrain == 4)
                                fdi = (windfactor * 0.3);
                            else if (daysrain == 5)
                                fdi = (windfactor * 0.4);
                            else if (daysrain == 6)
                                fdi = (windfactor * 0.5);
                            else if (daysrain == 7)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 8)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 9)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 10)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 11)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 12)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 13)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 14)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 15)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 16)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 17)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 18)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 19)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 20)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 20)
                                fdi = (windfactor * 1);
                        } else if (rain >= 76.6) {
                            if (daysrain == 0)
                                fdi = (windfactor * 0.01);
                            else if (daysrain == 1)
                                fdi = (windfactor * 0.01);
                            else if (daysrain == 2)
                                fdi = (windfactor * 0.01);
                            else if (daysrain == 3)
                                fdi = (windfactor * 0.1);
                            else if (daysrain == 4)
                                fdi = (windfactor * 0.2);
                            else if (daysrain == 5)
                                fdi = (windfactor * 0.4);
                            else if (daysrain == 6)
                                fdi = (windfactor * 0.5);
                            else if (daysrain == 7)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 8)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 9)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 10)
                                fdi = (windfactor * 0.6);
                            else if (daysrain == 11)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 12)
                                fdi = (windfactor * 0.7);
                            else if (daysrain == 13)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 14)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 15)
                                fdi = (windfactor * 0.8);
                            else if (daysrain == 16)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 17)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 18)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 19)
                                fdi = (windfactor * 0.9);
                            else if (daysrain == 20)
                                fdi = (windfactor * 0.9);
                            else if (daysrain > 20)
                                fdi = (windfactor * 1);
                        }
                    }
                }).start();

                DecimalFormat precision = new DecimalFormat("0.00");
                addResult.setText(precision.format(fdi));


                TextView FDIColour = (TextView) findViewById(R.id.textViewFDI);

                String fdistring = (precision.format(fdi));


                if ((fdi > 0.0) && (fdi < 20.00)) {
                    startActivity(Safe);
                    finish();
                    FDIColour.setBackgroundColor(Color.parseColor("#0000FF"));


                    Intent intent = new Intent(FDICalculator.this, Safe.class);
                    intent.putExtra("keyName", fdistring);  // pass your values and retrieve them in the other Activity using keyName
                    startActivity(intent);
                }
                //blue
                else if ((fdi > 20.0) && (fdi < 45.00)) {
                    startActivity(Low);
                    finish();
                    FDIColour.setBackgroundColor(Color.parseColor("#32CD32"));

                    Intent intent = new Intent(FDICalculator.this, Low.class);
                    intent.putExtra("keyName", fdistring);  // pass your values and retrieve them in the other Activity using keyName
                    startActivity(intent);
                }
                //green
                else if ((fdi > 45.0) && (fdi < 60.00)) {
                    startActivity(Moderate);
                    finish();
                    FDIColour.setBackgroundColor(Color.parseColor("#FFFF00"));

                    Intent intent = new Intent(FDICalculator.this, Moderate.class);
                    intent.putExtra("keyName", fdistring);  // pass your values and retrieve them in the other Activity using keyName
                    startActivity(intent);

                }
                //yellow
                else if ((fdi > 60.0) && (fdi < 75.00)) {
                    startActivity(High);
                    finish();
                    FDIColour.setBackgroundColor(Color.parseColor("#FF8C00"));

                    Intent intent = new Intent(FDICalculator.this, High.class);
                    intent.putExtra("keyName", fdistring);  // pass your values and retrieve them in the other Activity using keyName
                    startActivity(intent);
                }
                //orange
                else if ((fdi > 75.0) && (fdi < 200.00)) {
                    startActivity(Extremely_High);
                    finish();
                    FDIColour.setBackgroundColor(Color.parseColor("#FF0000"));


                    Intent intent = new Intent(FDICalculator.this, ExtremelyHigh.class);
                    intent.putExtra("keyName", fdistring);  // pass your values and retrieve them in the other Activity using keyName
                    startActivity(intent);
                }
                //red


            }
        });

    }

   @Override
    public void onBackPressed() {
                        Intent intent = new Intent("za.co.mhlambanyathigroup.firemanager2.FDIMeasurements");
                        startActivity(intent);
                        finish();
                    }
}


