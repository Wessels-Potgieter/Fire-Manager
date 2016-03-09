package za.co.mhlambanyathigroup.firemanager2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class ReportFirePhoto extends Activity {
    Button capture_button;
    ImageView fireimageView;
    static final int CAM_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_fire_photo);
        capture_button = (Button) findViewById(R.id.capture_button);
        fireimageView = (ImageView)findViewById(R.id.fireimageView);
        capture_button.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                            public void onClick (View v)
                                             {
                                                Intent camera_intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                                                 File file = getFile();
                                                 camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                                                 startActivityForResult(camera_intent,CAM_REQUEST);


                                             }

                                          }
        );

    }

    private File getFile ()
    {

        File folder = new File("sdcard/Fire Manager");

        if (!folder.exists())
        {
            folder.mkdir();
        }

        File fireimage_file = new File (folder,"fire_image.jpg");
        return fireimage_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "sdcard/Fire Manager/fire_image.jpg";
        fireimageView.setImageDrawable(Drawable.createFromPath(path));
        super.onActivityResult(requestCode, resultCode, data);


    }


}
