package com.ben.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ben.R;
import com.ben.database.Database;
import com.ben.model.X_Login_Detail;

/**
 * @author Ben Parker
 * @created 6/2/2018
 * @usage   Initial Main Activity on load of the app
 * Allows login to the app
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button signUp;
    private Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /** Initialise the buttons used on this activity **/
        signUp = (Button)findViewById(R.id.signupButton);
        signUp.setOnClickListener(this);
        logIn = (Button)findViewById(R.id.loginButton);
        logIn.setOnClickListener(this);

        /** Create the database on load of the app if applicable **/
        Database.createOrUpgradeDatabase(this);
    }

    /**
     * Check the entered username and password
     * If they exist in the db then forward to Main
     * Menu activity
     * Else show error
     */
    private void validateLoginCredentials(){
        TextView username = (TextView)findViewById(R.id.usernameText);
        TextView password = (TextView)findViewById(R.id.passwordText);
        if (username.getText().length() == 0){
            Toast.makeText(getBaseContext(), "Username cannot be null", Toast.LENGTH_LONG).show();
        }
        if (password.getText().length() == 0){
            Toast.makeText(getBaseContext(), "Password cannot be null", Toast.LENGTH_LONG).show();
        }
        /** Get the user ID if it exists **/
        int userID = X_Login_Detail.validate(username.getText().toString(), password.getText().toString());

        /** Display error if user is not recognised **/
        if (userID == 0){
            Toast.makeText(this.getBaseContext(), "Login Details not recognised. Please try again", Toast.LENGTH_SHORT).show();
        }
        /** Otherwise set as active user and continue **/
        else {
            X_Login_Detail.setLoggedInUser(userID);
            Intent intent = new Intent(this.getBaseContext(), MainMenu.class);
            startActivity(intent);
        }
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == logIn.getId()){
            validateLoginCredentials();
        }
        else if (view.getId() == signUp.getId()){
            Intent signup = new Intent(getBaseContext(), SignUp.class);
            startActivity(signup);
        }
    }
}

