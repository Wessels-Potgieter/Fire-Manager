package za.co.mhlambanyathigroup.firemanager2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Moderate extends AppCompatActivity {
    private TextView MODERATETEXTVIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moderate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MODERATETEXTVIEW = (TextView)findViewById(R.id.fditextmoderate);
        String data = getIntent().getExtras().getString("keyName","defaultKey");
        MODERATETEXTVIEW.setText(data);

    }

    @Override public void onBackPressed() {

        Intent NEW=new Intent(Moderate.this, FDICalculator.class);
        super.onBackPressed();
        finish();
        startActivity(NEW);

    }


}
