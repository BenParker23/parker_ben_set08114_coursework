package com.ben.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ben.R;
import com.ben.database.DBQuery;
import com.ben.model.I_X_SalesChatter;
import com.ben.model.I_X_Trigger;
import com.ben.model.X_SalesChatter;
import com.ben.utils.DisplayUtils;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by ben on 13/03/18.
 */

public class SalesChatter extends AppCompatActivity implements View.OnClickListener {

    private int marginCounter = 20;
    private CoordinatorLayout coorLay;
    private ArrayList<X_SalesChatter> chats = new ArrayList<>();
    private Button addMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saleschatter);
        coorLay = (CoordinatorLayout)findViewById(R.id.coorLayFeed);
        addMessage= (Button)findViewById(R.id.addMessageBut);
        addMessage.setOnClickListener(this);
        getSalesChatRecords();
        createViews();
    }

    /** Get all sales chatter records stored in the local db **/
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
        TextView parent;
        for (X_SalesChatter chat : chats) {

            /** If this record is already linked to another **/
            if (chat.getX_SalesChatter_Parent_ID() != 0){
                parent = (TextView)findViewById(chat.getX_SalesChatter_Parent_ID());
                parent.setHeight(DisplayUtils.getDPFromPixels(getResources(), ( 50 )));

                TextView replyCount = new TextView(this);
                replyCount.setLayoutParams(createLinkedParams(parent.getLayoutParams(),150, 50));
                replyCount.setText((chat.getReplyCounter() + 1) + " replies");
                replyCount.setTextSize(20);
                chat.setReplyCounter(chat.getReplyCounter() + 1);
                try { chat.save(); } catch (Exception e){ Log.e("ReplyCount", e.getLocalizedMessage()); }
                coorLay.addView(replyCount);
            }
            else {
                /**
                ImageView img = new ImageView(this);
                File imgFile = new  File(chat.getLinkedImagePath());
                if(imgFile.exists()){
                    Log.v("ImageFiledExists", "Exists");
                    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                    img.setImageBitmap(myBitmap);
                }
                **/

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
                valueTV.setBackgroundResource(R.color.green);
                valueTV.setTextColor(Color.WHITE);
                valueTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f);
                Button reply = new Button(this);
                reply.setText("Reply");
                reply.setId(chat.getX_SalesChatter_ID());
                reply.setBackgroundResource(R.color.green);
                reply.setTextColor(Color.WHITE);
                reply.setTag("MakeReply");
                reply.setLayoutParams(createParams(150, 50, 975));
                reply.setOnClickListener(this);

                marginCounter = marginCounter + DisplayUtils.getDPFromPixels(getResources(), 110);
                coorLay.addView(user);
                coorLay.addView(valueTV);
                coorLay.addView(reply);
            }
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


    /** Create MarginLayoutParams for descending textviews **/
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


    /** Create unique params for Reply Counter button **/
    private ViewGroup.MarginLayoutParams createLinkedParams(ViewGroup.LayoutParams param, int width, int height){
        ViewGroup.MarginLayoutParams paramHeight = (ViewGroup.MarginLayoutParams)param;
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(
                DisplayUtils.getDPFromPixels(getResources(), width),
                DisplayUtils.getDPFromPixels(getResources(), height)
        );
        params.topMargin = paramHeight.topMargin + 100;
        params.leftMargin = paramHeight.leftMargin;
        return params;
    }




    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.addMessageBut){
            Intent intent = new Intent(this.getBaseContext(), Reply.class);
            startActivity(intent);
        }
        else if (view.getTag() != null &&  view.getTag().equals("MakeReply")){
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
}
