package com.ben.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ben.R;
import com.ben.database.Database;

/**
 * @author Ben Parker
 * @created 6/2/2018
 * @usage   Initial Main Activity on load of the app
 * Allows login to the app
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Database.createOrUpgradeDatabase(this);

        Intent intent = new Intent(this.getBaseContext(), MainMenu.class);
        startActivity(intent);
    }
}

