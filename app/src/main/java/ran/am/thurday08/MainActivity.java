package ran.am.thurday08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URLEncoder;

import is.arontibo.library.ElasticDownloadView;

public class MainActivity extends AppCompatActivity {
// Explict and
// Implict
    ImageView imageView;
    ElasticDownloadView elasticDownloadView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        elasticDownloadView=findViewById(R.id.elastic_download_view);
        elasticDownloadView.startIntro();
    }

    public void asd(View view) {
        elasticDownloadView.success();
        //Intent  intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //startActivityForResult(intent,22);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if (requestCode==22){
        Bitmap bitmap  = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
        }
    }

    public void openwp(View view) {
     sendWhatsapp();
    }

    private void sendWhatsapp(){
        elasticDownloadView.fail();
        Intent obj = new Intent();
        obj.setAction(Intent.ACTION_SEND);
        obj.setType("text/plain");
        obj.setPackage("com.whatsapp");
        if (obj.resolveActivity(getPackageManager()) != null) {
            //startActivity(obj);
        }
    }
}