package com.ben.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ben.R;

/**
 * @author Ben Parker
 * @created 6/2/2018
 * @usage  Main Menu activity showing user all options
 * after logging into the app
 */
public class MainMenu extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        Button trigSchedBut = (Button)findViewById(R.id.actionScheduleBut);
        trigSchedBut.setOnClickListener(this);
        Button custListBut = (Button)findViewById(R.id.manageCustomerBut);
        custListBut.setOnClickListener(this);
        Button leadLeadBut = (Button)findViewById(R.id.manageLeadBut);
        leadLeadBut.setOnClickListener(this);
        Button emailCustBut = (Button)findViewById(R.id.emailCustomerBut);
        emailCustBut.setOnClickListener(this);
        Button routePlanBut = (Button)findViewById(R.id.routePlanBut);
        routePlanBut.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){
        if (view.getId() == R.id.actionScheduleBut){
            Intent intent = new Intent(this.getBaseContext(), TriggerSchedule.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.manageCustomerBut){
            Intent intent = new Intent(this.getBaseContext(), CustomerList.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.manageLeadBut){
            Intent intent = new Intent(this.getBaseContext(), LeadList.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.emailCustomerBut){
            Intent intent = new Intent(this.getBaseContext(), EmailCustomer.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.routePlanBut){
            Intent intent = new Intent(this.getBaseContext(), RoutePlan.class);
            startActivity(intent);
        }
    }
}
