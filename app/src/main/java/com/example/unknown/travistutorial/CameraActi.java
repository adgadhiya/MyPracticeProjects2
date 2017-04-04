package com.example.unknown.travistutorial;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CameraActi extends AppCompatActivity{

    ImageView ivCamera;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ivCamera = (ImageView)findViewById(R.id.ivCamera);

        linearLayout = (LinearLayout) findViewById(R.id.ll);

    }

    public void onClick(View view) throws IOException {
        if(view == findViewById(R.id.take)){
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i,0);

        }
        else if(view == findViewById(R.id.set)){
            //getApplicationContext().setWallpaper(myImage);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){

            Uri uri = data.getData();

            String[] filepath = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(uri,filepath,null,null,null);

            cursor.moveToFirst();

            String s = cursor.getString(cursor.getColumnIndex(filepath[0]));

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bitmap =  BitmapFactory.decodeFile(s,options);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,50,baos);

            long size = bitmap.getByteCount();

            Toast.makeText(CameraActi.this,String.valueOf(size) , Toast.LENGTH_SHORT).show();

            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);



            ivCamera.setBackground(bitmapDrawable);
        }
    }
}
