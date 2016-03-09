package za.co.mhlambanyathigroup.firemanager2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Low extends AppCompatActivity {

    private TextView LOWTEXTVIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        LOWTEXTVIEW = (TextView)findViewById(R.id.fditextlow);
        String data = getIntent().getExtras().getString("keyName","defaultKey");
        LOWTEXTVIEW.setText(data);

    }

    @Override public void onBackPressed() {

        Intent NEW=new Intent(Low.this, FDICalculator.class);
        super.onBackPressed();
        finish();
        startActivity(NEW);

    }

}
