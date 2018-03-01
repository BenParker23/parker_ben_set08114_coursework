package com.ben.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.ben.R;

/**
 * Created by ben on 17/02/18.
 */

public class EmailCustomer extends AppCompatActivity implements View.OnClickListener{


    private Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailcustomer);
        /** Hide the keyboard on load of activity **/
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        sendEmail = (Button)findViewById(R.id.sendEmailBut);
        sendEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        sendEmail();
    }

    private void sendEmail(){

        Intent intent = new Intent(Intent.ACTION_SEND); // it's not ACTION_SEND
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject of email");
        intent.putExtra(Intent.EXTRA_TEXT, "Body of email");
        intent.setData(Uri.parse("mailto:benparker_93@outlook.com")); // or just "mailto:" for blank
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
        startActivity(intent);
    }
}
