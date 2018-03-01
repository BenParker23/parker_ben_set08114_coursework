package com.ben.activity;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.TextView;

import com.ben.R;
import com.ben.database.DBQuery;
import com.ben.display.DisplayUtils;
import com.ben.model.I_X_Action_Purpose;
import com.ben.model.I_X_Trigger;
import com.ben.model.X_X_Trigger;

import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ben on 17/02/18.
 */

public class TriggerSchedule extends AppCompatActivity implements View.OnClickListener {

    /** Testing commit on PC after clone **/


    private CoordinatorLayout listCoorLay;
    private CoordinatorLayout coorLayDetail;
    private int marginCounter = 200;
    private Set<X_X_Trigger> todaysActions = new HashSet<>();


    private TextView acctNo;
    private TextView webPercent;
    private TextView salesValue;
    private TextView profit;

    private TextView descValue;
    private TextView purposeValue;
    private TextView statusValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triggerschedule);

        /** Hide the keyboard on load of activity **/
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        listCoorLay = (CoordinatorLayout)findViewById(R.id.coorLayout);
        coorLayDetail = (CoordinatorLayout)findViewById(R.id.coorLayoutDetail);
        acctNo = (TextView)findViewById(R.id.tvAccNo);
        webPercent = (TextView)findViewById(R.id.tvWebPercentage);
        salesValue = (TextView)findViewById(R.id.tvSalesValue);
        profit = (TextView)findViewById(R.id.tvGrossProfit);
        descValue = (TextView)findViewById(R.id.tvDescriptionValue);
        purposeValue = (TextView)findViewById(R.id.tvTrigPurpValue);
        statusValue = (TextView)findViewById(R.id.tvTrigStatusValue);
        createActionList();
    }


    private void createActionList(){
        DBQuery query = new DBQuery("SELECT * FROM X_Trigger JOIN X_Action_Purpose ON X_Trigger.X_Action_Purpose_ID = X_Action_Purpose.X_Action_Purpose_ID ");
        Cursor response = query.executeQuery();
        while (response.moveToNext()){
            X_X_Trigger action = new X_X_Trigger();
            action.setX_Trigger_ID(response.getInt(response.getColumnIndex(I_X_Trigger.COLUMNNAME_X_Trigger_ID)));
            action.setC_BPartner_ID(response.getInt(response.getColumnIndex(I_X_Trigger.COLUMNNAME_C_BPartner_ID)));
            action.setSalesRep_ID(response.getInt(response.getColumnIndex(I_X_Trigger.COLUMNNAME_SalesRep_ID)));
            action.setDescription(response.getString(response.getColumnIndex(I_X_Trigger.COLUMNNAME_Description)));
            action.setActionPurposeName(response.getString(response.getColumnIndex(I_X_Action_Purpose.COLUMNNAME_Name)));
            action.setX_Action_Purpose_ID(response.getInt(response.getColumnIndex(I_X_Trigger.COLUMNNAME_X_Action_Purpose_ID)));
            action.setX_Action_Status_ID(response.getInt(response.getColumnIndex(I_X_Trigger.COLUMNNAME_X_Action_Status_ID)));
            todaysActions.add(action);
            TextView valueTV = new TextView(this);
            valueTV.setText(String.valueOf(action.getC_BPartner_ID()));
            valueTV.setId(action.getX_Trigger_ID());
            valueTV.setLayoutParams(createParams(400, 100, 0));
            valueTV.setOnClickListener(this);
            valueTV.setBackground(createBorder());
            marginCounter = marginCounter + DisplayUtils.getDPFromPixels(getResources(), 100);
            listCoorLay.addView(valueTV);
        }
    }


    private ShapeDrawable createBorder(){
        ShapeDrawable sd = new ShapeDrawable();
        sd.setShape(new RectShape());
        sd.getPaint().setColor(Color.BLACK);
        sd.getPaint().setStrokeWidth(5f);
        sd.getPaint().setStyle(Paint.Style.STROKE);
        return sd;
    }


    private MarginLayoutParams createParams(int width, int height, int left){
        MarginLayoutParams params = new MarginLayoutParams(
                DisplayUtils.getDPFromPixels(getResources(), width),
                DisplayUtils.getDPFromPixels(getResources(), height)
        );
        params.topMargin = marginCounter;
        if (left >  0)
            params.leftMargin = DisplayUtils.getDPFromPixels(getResources(), left);
        return params;
    }


    @Override
    public void onClick(View view) {
        createTriggerDetail(view);
    }


    /** Onclick of the trigger record from the list
     * We want to load the details of that trigger and display them
     * on the view on the right
     * @param v
     */
    private void createTriggerDetail(View v){
        for (X_X_Trigger t : todaysActions){
            if (t.getX_Trigger_ID() == v.getId()){
                descValue.setText(t.getDescription());
                purposeValue.setText(t.getActionPurposeName());
                statusValue.setText(String.valueOf(t.getX_Action_Status_ID()));
            }
        }

    }
}
