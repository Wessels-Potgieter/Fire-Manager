package za.co.mhlambanyathigroup.firemanager2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class FDIWeather extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdiweather);

        //identifies the webview
        WebView webView = (WebView) findViewById(R.id.fdiwebview);
        webView.setInitialScale(1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);

        //loads the url

        webView.loadUrl("http://mhlambanyathigroup.co.za/Weather.html");
        //cancels all hyperlinks
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Do stuff here

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            //Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            //setContentView(R.layout.activity_fdiweather);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent FDIWeather = new Intent("za.co.mhlambanyathigroup.firemanager2.Weather");
            startActivity(FDIWeather);
           // Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }






    }

}
