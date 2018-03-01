package com.ben.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ben.R;
import com.ben.database.DBQuery;
import com.ben.model.I_X_C_BPartner;
import com.ben.model.I_X_EmailTemplate;
import com.ben.model.I_X_Trigger;

/**
 * Created by ben on 17/02/18.
 */

public class EmailCustomer extends AppCompatActivity implements View.OnClickListener{
    private Button sendEmail;
    private Button meetingTempBut;
    private Button newAccBut;
    private Button introBut;
    private Button promoBut;
    private TextView emailBody;
    private TextView emailSubject;
    private Button addEmail;
    private EditText emailAddr;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailcustomer);
        /** Hide the keyboard on load of activity **/
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        sendEmail = (Button)findViewById(R.id.sendEmailBut);
        meetingTempBut = (Button)findViewById(R.id.meetingTempBut);
        newAccBut = (Button)findViewById(R.id.newCustTempBut);
        introBut = (Button)findViewById(R.id.introTempBut);
        promoBut = (Button)findViewById(R.id.promoTempBut);
        addEmail = (Button)findViewById(R.id.addEmailBut);
        sendEmail.setOnClickListener(this);
        meetingTempBut.setOnClickListener(this);
        newAccBut.setOnClickListener(this);
        introBut.setOnClickListener(this);
        promoBut.setOnClickListener(this);
        addEmail.setOnClickListener(this);
        emailAddr = (EditText)findViewById(R.id.emailAddrValue);

        emailBody = (TextView)findViewById(R.id.emailBodyValue);
        emailSubject = (TextView)findViewById(R.id.tvSubjectValue);
    }

    @Override
    public void onClick(View view) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT EmailBody, EmailSubject FROM X_EmailTemplate WHERE X_EmailTemplate_ID = ");
        if (view.getId() == R.id.sendEmailBut){
            sendEmail();
            return;
        }
        else if (view.getId() == R.id.meetingTempBut){
            sb.append(I_X_EmailTemplate.MEETING);
        }
        else if (view.getId() == R.id.newCustTempBut){
            sb.append(I_X_EmailTemplate.NEWACC);
        }
        else if (view.getId() == R.id.csoTempBut){
            /**
             * This one needs to be dynamic based the on the customer
             * email address and what they've stopped ordering
             */
        }
        else if (view.getId() == R.id.promoTempBut){
            sb.append(I_X_EmailTemplate.PROMO);
        }
        else if (view.getId() == R.id.introTempBut){
            sb.append(I_X_EmailTemplate.INTRODUCTION);
        }
        else if (view.getId() == R.id.addEmailBut){
            addEmail();
            return;
        }

        DBQuery query = new DBQuery(sb.toString());
        Cursor response = query.executeQuery();
        while (response.moveToNext()){
            Log.v("SQL", sb.toString());
            Log.v("ReturnSubject", "  Sub : " + response.getString(response.getColumnIndex(I_X_EmailTemplate.COLUMNNAME_EmailSubject)));
            Log.v("ReturnBody", "  Sub : " + response.getString(response.getColumnIndex(I_X_EmailTemplate.COLUMNNAME_EmailBody)));
            emailSubject.setText(response.getString(response.getColumnIndex(I_X_EmailTemplate.COLUMNNAME_EmailSubject)));
            emailBody.setText(response.getString(response.getColumnIndex(I_X_EmailTemplate.COLUMNNAME_EmailBody)));
        }
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

    private void addEmail(){
        if ("".equals(emailAddr.getText())){
            Log.v("EmailAddr", "EmaiLAddr Is Null");
            Toast.makeText(getBaseContext(), "Cannot add null email", Toast.LENGTH_LONG);
            return;
        }
        else if (!emailAddr.getText().toString().contains("@")){
            Log.v("EmailAddr", "Does not contain @ ");
            Toast.makeText(getBaseContext(), "Please enter valid email and add again", Toast.LENGTH_LONG);
            return;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT Email FROM C_BPartner WHERE Email LIKE '% " + emailAddr.getText().toString() + " %' ");
        DBQuery query = new DBQuery(sb.toString());
        Cursor response = query.executeQuery();
        boolean found = false;
        while (response.moveToNext()) {
            if (response.getString(response.getColumnIndex("Email")) != null){
                found = true;
            }
        }
        Log.v("EmailAddr", found + " Email found or not");
        if (!found){
            Toast.makeText(this.getApplicationContext(), "Beware : This contact is not in your address book ", Toast.LENGTH_LONG);
            email = emailAddr.getText().toString();
        }
        Log.v("FinalEmail", email);
    }

}
