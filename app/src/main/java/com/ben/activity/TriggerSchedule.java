package com.ben.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ben.R;
import com.ben.database.DBQuery;
import com.ben.model.I_X_SalesChatter;
import com.ben.utils.DisplayUtils;
import com.ben.model.I_X_Action_Purpose;
import com.ben.model.I_X_Action_Status;
import com.ben.model.I_X_C_BPartner;
import com.ben.model.I_X_Trigger;
import com.ben.model.X_C_BPartner;
import com.ben.model.X_X_Trigger;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ben on 17/02/18.
 */

public class TriggerSchedule extends AppCompatActivity implements View.OnClickListener {

    /** Testing commit on PC after clone **/


    private CoordinatorLayout listCoorLay;
    private CoordinatorLayout coorLayDetail;
    private int marginCounter = 200;
    private Map<X_C_BPartner, X_X_Trigger> todaysActions = new HashMap<X_C_BPartner, X_X_Trigger>();

    private TextView acctNo;
    private TextView webPercent;
    private TextView salesValue;
    private TextView profit;

    private TextView descValue;
    private TextView purposeValue;
    private Spinner statusValue;


    private Button emailCust;
    private Button refresh;
    private Button searchBut;
    private EditText bpartnerToFind;
    private EditText resultET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triggerschedule);
        /** Hide the keyboard on load of activity **/
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        searchBut = (Button)findViewById(R.id.searchButton);
        searchBut.setOnClickListener(this);
        bpartnerToFind = (EditText)findViewById(R.id.bpartnerToFindET);
        listCoorLay = (CoordinatorLayout)findViewById(R.id.coorLayout);
        coorLayDetail = (CoordinatorLayout)findViewById(R.id.coorLayoutDetail);
        acctNo = (TextView)findViewById(R.id.tvAccNoValue);
        refresh = (Button)findViewById(R.id.refresh);
        refresh.setOnClickListener(this);
        webPercent = (TextView)findViewById(R.id.tvWebPercentageValue);
        salesValue = (TextView)findViewById(R.id.tvSalesValue2);
        profit = (TextView)findViewById(R.id.tvGrossProfitValue);
        descValue = (TextView)findViewById(R.id.tvDescriptionValue);
        purposeValue = (TextView)findViewById(R.id.tvTrigPurpValue);
        emailCust = (Button)findViewById(R.id.emailCustButTS);
        emailCust.setOnClickListener(this);
        createResultTextView();
        createActionList(null);
        createStatusSpinner();
    }


    private void createStatusSpinner(){
        statusValue = (Spinner)findViewById(R.id.tvTrigStatusValue);
        final ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(this, R.array.statusTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusValue.setAdapter(adapter);
        statusValue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("OnItemSelected - i / l", String.valueOf(i) + " " + String.valueOf(l));
                Log.v("ItemSelectedSpinner", adapterView.getItemAtPosition(i) + " has been selected");
                statusValue.setSelection(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void createResultTextView(){
        resultET = (EditText)findViewById(R.id.etResult);
        resultET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                for (X_X_Trigger t : todaysActions.values()) {
                    if (t.getX_Trigger_ID() == resultET.getId()) {
                        t.setResult(editable.toString());
                        t.save();
                    }
                }
            }
        });
    }


    private void clearActionList(){
        marginCounter = 200;
        for (Map.Entry<X_C_BPartner, X_X_Trigger> t : todaysActions.entrySet()) {
            TextView record = (TextView)findViewById(t.getValue().getX_Trigger_ID());
            listCoorLay.removeView(record);
        }
    }


    private void createActionList(String name){
        clearActionList();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT X_Action_Status.Name AS StatusName, bp.Email, bp.name as BPName, bp.value, bp.webpercent, bp.SalesValue, bp.GrossProfit, X_Trigger.*, X_Action_Purpose.Name FROM X_Trigger ");
        sb.append("JOIN X_Action_Purpose ON X_Trigger.X_Action_Purpose_ID = X_Action_Purpose.X_Action_Purpose_ID ");
        sb.append("JOIN C_BPartner bp on X_Trigger.C_BPartner_ID = bp.C_BPartner_ID ");
        sb.append("JOIN X_Action_Status on X_Trigger.X_Action_Status_ID = X_Action_Status.X_Action_Status_ID ");
        if (name != null){
            sb.append(" WHERE bp.Name = '" + name + "'");
        }
        DBQuery query = new DBQuery(sb.toString());
        Cursor response = query.executeQuery();
        while (response.moveToNext()){
            X_X_Trigger action = new X_X_Trigger();
            X_C_BPartner bpartner = new X_C_BPartner();
            action.setX_Trigger_ID(response.getInt(response.getColumnIndex(I_X_Trigger.COLUMNNAME_X_Trigger_ID)));
            action.setC_BPartner_ID(response.getInt(response.getColumnIndex(I_X_Trigger.COLUMNNAME_C_BPartner_ID)));
            action.setSalesRep_ID(response.getInt(response.getColumnIndex(I_X_Trigger.COLUMNNAME_SalesRep_ID)));
            action.setDescription(response.getString(response.getColumnIndex(I_X_Trigger.COLUMNNAME_Description)));
            action.setStatusName(response.getString(response.getColumnIndex("StatusName")));
            action.setActionPurposeName(response.getString(response.getColumnIndex(I_X_Action_Purpose.COLUMNNAME_Name)));
            action.setX_Action_Purpose_ID(response.getInt(response.getColumnIndex(I_X_Trigger.COLUMNNAME_X_Action_Purpose_ID)));
            action.setX_Action_Status_ID(response.getInt(response.getColumnIndex(I_X_Trigger.COLUMNNAME_X_Action_Status_ID)));
            action.setResult(response.getString(response.getColumnIndex(I_X_Trigger.COLUMNNAME_Result)));
            Log.v("SalesValueReturned : ", " SV - " + response.getDouble(response.getColumnIndex(I_X_C_BPartner.COLUMNNAME_SalesValue)));
            bpartner.setSalesValue(response.getDouble(response.getColumnIndex(I_X_C_BPartner.COLUMNNAME_SalesValue)));
            bpartner.setValue(response.getString(response.getColumnIndex(I_X_C_BPartner.COLUMNNAME_Value)));
            bpartner.setGrossProfit(response.getDouble(response.getColumnIndex(I_X_C_BPartner.COLUMNNAME_GrossProfit)));
            bpartner.setWebPercent(response.getDouble(response.getColumnIndex(I_X_C_BPartner.COLUMNNAME_WebPercent)));
            bpartner.setName(response.getString(response.getColumnIndex("BPName")));
            bpartner.setEmail(response.getString(response.getColumnIndex("Email")));
            todaysActions.put(bpartner, action);

            TextView valueTV = new TextView(this);
            valueTV.setText(response.getString(response.getColumnIndex("BPName")));
            valueTV.setId(action.getX_Trigger_ID());
            valueTV.setTextSize(24);
            valueTV.setGravity(Gravity.CENTER);
            valueTV.setBackgroundResource(R.color.green);
            valueTV.setTextColor(Color.WHITE);
            valueTV.setLayoutParams(createParams(400, 100, 0));
            valueTV.setOnClickListener(this);
            //valueTV.set(createBorder());
            marginCounter = marginCounter + DisplayUtils.getDPFromPixels(getResources(), 110);
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
        /** Email Customer Event **/
        if (view.getId() == emailCust.getId()){
            if (emailCust.getTag() == null){
                Toast.makeText(getBaseContext(), "Please select a trigger record first", Toast.LENGTH_LONG).show();
                return;
            }
            X_C_BPartner bp = getCustomerDetails((String)view.getTag());
            Intent intent = new Intent(this.getBaseContext(), EmailCustomer.class);
            intent.putExtra("EmailAddress",bp.getEmail());
            intent.putExtra("EmailBody", "Dear " + bp.getName() + ", ");
            startActivity(intent);
        }
        else if (view.getId() == searchBut.getId()){
            if (bpartnerToFind.getText().length() == 0){
                Toast.makeText(getBaseContext(), "Please enter a business partner name first ", Toast.LENGTH_LONG).show();
            }
            else {
                String bpName = bpartnerToFind.getText().toString();
                for (Map.Entry<X_C_BPartner, X_X_Trigger> t : todaysActions.entrySet()) {
                    if (t.getKey().getName().contains(bpName)){
                        createActionList(t.getKey().getName());
                        break;
                    }
                }
                Toast.makeText(getBaseContext(), "Business Partner " + bpName + " not found", Toast.LENGTH_LONG);
            }
        }
        else if (view.getId() == refresh.getId()){
            createActionList(null);
        }
        else {
            createTriggerDetail(view);
        }
    }


    /** Onclick of the trigger record from the list
     * We want to load the details of that trigger and display them
     * on the view on the right
     * @param v
     */
    private void createTriggerDetail(View v){
        for (Map.Entry<X_C_BPartner, X_X_Trigger> t : todaysActions.entrySet()) {
            X_X_Trigger trig = t.getValue();
            if (trig.getX_Trigger_ID() == v.getId()) {
                descValue.setText(trig.getDescription());
                purposeValue.setText(trig.getActionPurposeName());
                resultET.setId(trig.getX_Trigger_ID());
                resultET.setText(trig.getResult());
                statusValue.setId(trig.getX_Trigger_ID());
                acctNo.setText(t.getKey().getValue());
                webPercent.setText(String.valueOf(t.getKey().getWebPercent()));
                salesValue.setText(String.valueOf(t.getKey().getSalesValue()));
                profit.setText(String.valueOf(t.getKey().getGrossProfit()));
                emailCust.setTag(String.valueOf(trig.getX_Trigger_ID()));
                assignSpinnerDefaultValue(trig);
            }
        }
    }


    private X_C_BPartner getCustomerDetails(String id){
        for (Map.Entry<X_C_BPartner, X_X_Trigger> entry : todaysActions.entrySet() ){
            if (entry.getValue().getX_Trigger_ID() == Integer.parseInt(id)){
                return entry.getKey();
            }
        }
        return null;
    }


    private void assignSpinnerDefaultValue(final X_X_Trigger t){
        final ArrayAdapter adap = (ArrayAdapter)statusValue.getAdapter();
        /**
         * Status ID's in db ( 1,2,3,4 ) link up with order of string array
         * Always shows first spinner value unless I encapsulate in a runnable
         **/
        statusValue.post(new Runnable() {
            @Override
            public void run() {
                Log.v("AddingDefaultSelection", String.valueOf(t.getX_Action_Status_ID()));
                statusValue.setSelection(t.getX_Action_Status_ID());
            }
        });
    }

}
