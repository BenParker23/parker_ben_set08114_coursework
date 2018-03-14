package com.ben.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ben.R;
import com.ben.model.X_SalesChatter;

/**
 * Created by ben on 13/03/18.
 */

public class Reply extends AppCompatActivity implements View.OnClickListener{

    Button galleryImgBut;
    Button cameraImgBut;
    Button submit;
    ImageView img;
    TextView userId;
    private EditText message;
    private int c_BPartner_ID;
    private int x_SalesChat_Parent_ID;
    private String imagePath;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_reply);
            galleryImgBut = (Button)findViewById(R.id.galleryImageBut);
            galleryImgBut.setOnClickListener(this);
            submit = (Button)findViewById(R.id.submitBut);
            submit.setOnClickListener(this);
            if (getIntent().getStringExtra("X_SalesChatter_ID") != null) {
                x_SalesChat_Parent_ID = Integer.parseInt(getIntent().getStringExtra("X_SalesChatter_ID"));
            }
            if (getIntent().getStringExtra("C_BPartner_ID") != null){
                c_BPartner_ID = Integer.parseInt(getIntent().getStringExtra("C_BPartner_ID"));
            }
            cameraImgBut = (Button)findViewById(R.id.cameraImageBut);
            cameraImgBut.setOnClickListener(this);
            img = (ImageView)findViewById(R.id.imageAttach);
            img.setOnClickListener(this);
            message = (EditText)findViewById(R.id.messageET);
        }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.galleryImageBut){
            Intent intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            intent.setType("image/*");
            intent.putExtra("crop", "true");
            intent.putExtra("scale", true);
            intent.putExtra("outputX", 256);
            intent.putExtra("outputY", 256);
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("return-data", true);
            startActivityForResult(intent, 2);
        }
        else if (view.getId() == R.id.cameraImageBut){
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, 1);
            }
        }
        else if (view.getId() == R.id.submitBut){
            try {
                X_SalesChatter salesRecord = new X_SalesChatter();
                salesRecord.setC_BPartner_ID(c_BPartner_ID);
                salesRecord.setX_SalesChatter_Parent_ID(submit.getId());
                salesRecord.setMessage(message.getText().toString());
               // salesRecord.setX_SalesChatter_ID(20);
                if (imagePath != null)
                    salesRecord.setLinkedImagePath(imagePath);
                salesRecord.save();
                finish();
            }
            catch (Exception e){
                Log.e("SavingSalesChatter", e.getLocalizedMessage());
            }

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Uri imageUri = data.getData();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        }
        else if (requestCode == 2) {
            final Bundle extras = data.getExtras();
            if (extras != null) {
                //Get image
                Bitmap ProfilePic = extras.getParcelable("data");
                img.setImageBitmap(ProfilePic);

            }
        }
    }



}
