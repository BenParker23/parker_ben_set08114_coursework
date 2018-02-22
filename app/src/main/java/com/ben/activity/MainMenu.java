package com.ben.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ben.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

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

        createLineChart();
        createBarChart();
        createPieChart();
        createCandleChart();
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

    private void createBarChart(){
        BarChart barChart = (BarChart) findViewById(R.id.barChart);

        List<BarEntry> barEntries = new ArrayList<>();
        for (int y = 0 ; y < 10 ; y++) {
            // turn data into Entry objects
            barEntries.add(new BarEntry(y+1, y));
            Log.v("Entry", y  + " " + y+1);
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "Data "); // add entries to dataset
        barDataSet.setColor(Color.GRAY);
        barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        barDataSet.setValueTextColor(Color.BLACK);

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.invalidate(); // refresh
    }

    private void createLineChart(){
        LineChart chart = (LineChart) findViewById(R.id.chart);

        List<Entry> entries = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            // turn data into Entry objects
            entries.add(new Entry(i, i+1));
            Log.v("Entry", i  + " " + i+1);
        }

        LineDataSet dataSet = new LineDataSet(entries, "Data "); // add entries to dataset
        dataSet.setColor(Color.GRAY);
        dataSet.setValueTextColor(Color.BLACK);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }

    private void createPieChart(){
        PieChart chart = (PieChart) findViewById(R.id.pieChart);

        List<PieEntry> entries = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            // turn data into Entry objects
            entries.add(new PieEntry(i, i+1));
            Log.v("Entry", i  + " " + i+1);
        }

        PieDataSet dataSet = new PieDataSet(entries, "Data "); // add entries to dataset
        dataSet.setColor(Color.GRAY);
        dataSet.setValueTextColor(Color.BLACK);

        PieData lineData = new PieData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }


    private void createCandleChart(){
        CandleStickChart chart = (CandleStickChart) findViewById(R.id.candleChart);

        List<CandleEntry> entries = new ArrayList<>();
        entries.add(new CandleEntry(0, 7.62f, 4.02f, 4.70f, 7.13f));
        entries.add(new CandleEntry(1, 5.50f, 2.70f, 3.35f, 4.96f));
        entries.add(new CandleEntry(2, 5.25f, 3.02f, 3.50f, 4.50f));
        entries.add(new CandleEntry(3, 6f,    3.25f, 4.40f, 5.0f));
        entries.add(new CandleEntry(4, 5.57f, 2f,    2.80f, 4.5f));

        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");

        CandleDataSet dataSet = new CandleDataSet(entries, "Data "); // add entries to dataset
        dataSet.setColor(Color.rgb(80, 80, 80));
        dataSet.setShadowColor(Color.GRAY);
        dataSet.setShadowWidth(1.5f);
        dataSet.setDecreasingColor(Color.GRAY);
        dataSet.setDecreasingPaintStyle(Paint.Style.FILL);
        dataSet.setIncreasingColor(Color.GRAY);
        dataSet.setIncreasingPaintStyle(Paint.Style.FILL);
        dataSet.setNeutralColor(Color.GRAY);
        dataSet.setValueTextColor(Color.RED);

        CandleData candleData = new CandleData(dataSet);
        chart.setData(candleData);
        chart.invalidate(); // refresh
    }


}
