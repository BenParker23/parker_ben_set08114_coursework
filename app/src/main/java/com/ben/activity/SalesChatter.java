package com.ben.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ben.R;
import com.ben.database.DBQuery;
import com.ben.model.I_X_SalesChatter;
import com.ben.model.I_X_Trigger;
import com.ben.model.X_SalesChatter;
import com.ben.utils.DisplayUtils;

import java.util.ArrayList;

/**
 * Created by ben on 13/03/18.
 */

public class SalesChatter extends AppCompatActivity implements View.OnClickListener {

    private int marginCounter = 20;
    private CoordinatorLayout coorLay;
    private ArrayList<X_SalesChatter> chats = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saleschatter);
        coorLay = (CoordinatorLayout)findViewById(R.id.coorLayFeed);
        getSalesChatRecords();
        createViews();
    }


    private void getSalesChatRecords(){
        String sql = "SELECT X_SalesChatter.*, C_BPartner.Name FROM X_SalesChatter JOIN C_BPartner ON X_SalesChatter.C_BPartner_ID = C_BPartner.C_BPartner_ID ";
        DBQuery query = new DBQuery(sql);
        Cursor response = query.executeQuery();
        while (response.moveToNext()){
            X_SalesChatter chat = new X_SalesChatter();
            chat.setC_BPartner_ID(response.getInt(response.getColumnIndex(I_X_SalesChatter.COLUMNNAME_C_BPartner_ID)));
            chat.setX_SalesChatter_ID(response.getInt(response.getColumnIndex(I_X_SalesChatter.COLUMNNAME_X_SalesChatter_ID)));
            chat.setLinkedImagePath(response.getString(response.getColumnIndex(I_X_SalesChatter.COLUMNNAME_LinkedImagePath)));
            chat.setMessage(response.getString(response.getColumnIndex(I_X_SalesChatter.COLUMNNAME_Message)));
            chat.setX_SalesChatter_Parent_ID(response.getInt(response.getColumnIndex(I_X_SalesChatter.COLUMNNAME_X_SalesChatter_Parent_ID)));
            chat.setBpName(response.getString(response.getColumnIndex("Name")));
            chats.add(chat);
        }
    }


    private void createViews(){
        for (X_SalesChatter chat : chats) {
            TextView user = new TextView(this);
            user.setText(chat.getBpName());
            user.setLayoutParams(createParams(200, 50, 150));
            user.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f);

            marginCounter = marginCounter + DisplayUtils.getDPFromPixels(getResources(), 40);
            TextView valueTV = new TextView(this);
            valueTV.setText(chat.getMessage());
            // valueTV.setId(action.getX_Trigger_ID());
            valueTV.setLayoutParams(createParams(800, 100, 150));
            valueTV.setOnClickListener(this);
            valueTV.setBackground(createBorder());
            valueTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f);
            Button reply = new Button(this);
            reply.setText("Reply");
            reply.setId(chat.getX_SalesChatter_ID());
            reply.setLayoutParams(createParams(150, 100, 975));
            reply.setOnClickListener(this);

            marginCounter = marginCounter + DisplayUtils.getDPFromPixels(getResources(), 110);
            coorLay.addView(user);
            coorLay.addView(valueTV);
            coorLay.addView(reply);
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




    private ViewGroup.MarginLayoutParams createParams(int width, int height, int left){
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(
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
        for (X_SalesChatter chat : chats){
            if (view.getId() == chat.getX_SalesChatter_ID()){
                Intent intent = new Intent(this.getBaseContext(), Reply.class);
                intent.putExtra("C_BPartner_ID", String.valueOf(chat.getC_BPartner_ID()));
                intent.putExtra("X_SalesChatter_ID", String.valueOf(chat.getX_SalesChatter_ID()));
                startActivity(intent);
            }
        }

    }
}
