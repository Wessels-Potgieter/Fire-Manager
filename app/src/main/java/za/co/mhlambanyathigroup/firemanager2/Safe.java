package za.co.mhlambanyathigroup.firemanager2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;




public class Safe extends AppCompatActivity {

    private TextView SAFETEXTVIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SAFETEXTVIEW = (TextView)findViewById(R.id.fditextsafe);
        String data = getIntent().getExtras().getString("keyName","defaultKey");
        SAFETEXTVIEW.setText(data);
    }
    @Override public void onBackPressed() {

        Intent NEW=new Intent(Safe.this, FDICalculator.class);
        super.onBackPressed();
        finish();
        startActivity(NEW);

    }

}
