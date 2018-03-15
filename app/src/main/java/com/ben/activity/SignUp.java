package com.ben.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.ben.R;

import com.ben.model.X_C_BPartner;
import com.ben.model.X_Login_Detail;

import org.w3c.dom.Text;

/**
 * Created by BenPa on 14/03/2018.
 */

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    private Button complete;
    private Button addImage;
    @Override
    public void onClick(View view) {
        if (view.getId() == complete.getId()){
            createNewUser();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        complete = (Button)findViewById(R.id.confirmBut);
        complete.setOnClickListener(this);
        addImage = (Button)findViewById(R.id.changePhotoBut);
    }


    private void createNewUser(){
        EditText user = (EditText)findViewById(R.id.usernameET);
        EditText pass = (EditText)findViewById(R.id.passwordET);
        EditText email = (EditText)findViewById(R.id.emailET);
        EditText name = (EditText)findViewById(R.id.nameET);
        X_C_BPartner bpartner = new X_C_BPartner();
        X_Login_Detail newUser = new X_Login_Detail();

        if (user.getText() == null){
            Toast.makeText(getBaseContext(), "Username cannot be null", Toast.LENGTH_LONG).show();
        }
        if (pass.getText() == null){
            Toast.makeText(getBaseContext(), "Password cannot be null", Toast.LENGTH_LONG).show();
        }
        if (email.getText() == null){
            Toast.makeText(getBaseContext(), "Email cannot be null", Toast.LENGTH_LONG).show();
        }
        if (name.getText() == null){
            Toast.makeText(getBaseContext(), "Name cannot be null", Toast.LENGTH_LONG).show();
        }
        bpartner.setName(name.getText().toString());

        try {
            bpartner.save();
        } catch (Exception e){

        }
        newUser.setC_Bpartner_ID(bpartner.getC_BPartner_ID());
        newUser.setUsername(user.getText().toString());
        newUser.setPassword(pass.getText().toString());
        newUser.setEmail(email.getText().toString());
        newUser.setName(name.getText().toString());
        try {
            newUser.save();
        }
        catch (Exception e){
            Toast.makeText(getBaseContext(), "User already exists ", Toast.LENGTH_SHORT);
        };

        finish();

    }

}
