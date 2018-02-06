package com.ben.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ben.R;

/**
 * @author Ben Parker
 * @created 6/2/2018
 * @usage  Main Menu activity showing user all options
 * after logging into the app
 */
public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }

}
