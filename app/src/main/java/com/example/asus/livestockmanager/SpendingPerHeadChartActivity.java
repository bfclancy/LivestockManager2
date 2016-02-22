package com.example.asus.livestockmanager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import java.text.DecimalFormat;

import BusinessLogic.Controller;
import DataAccessLayer.LivestockManagerDatabaseOperations;

public class SpendingPerHeadChartActivity extends AppCompatActivity {

    private String[] expTypes;
    private double[] distribution, percentages;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending_per_head_chart);
        expTypes = getResources().getStringArray(R.array.expenditureTypes);

        // Pie Chart Section Value
        distribution = Controller.getExpenditureAmountsFromDB(context) ;

        //get percentages
        double[] percentages = getPercentages(distribution);

        // Color of each Pie Chart Sections
        int[] colors = { Color.BLUE, Color.MAGENTA, Color.GREEN, Color.CYAN , Color.RED};

        // Instantiating CategorySeries to plot Pie Chart
        CategorySeries distributionSeries = new CategorySeries("Average spend per head of cattle as of 2016");
        for(int i=0 ;i < distribution.length;i++){
            // Adding a slice with its values and name to the Pie Chart
            distributionSeries.add(expTypes[i] + " " + percentages[i] + "%", distribution[i]);
        }

        // Instantiating a renderer for the Pie Chart
        DefaultRenderer defaultRenderer  = new DefaultRenderer();
        for(int i = 0 ;i<distribution.length;i++){
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(colors[i]);
            seriesRenderer.setDisplayChartValues(true);
            // Adding a renderer for a slice
            defaultRenderer.addSeriesRenderer(seriesRenderer);
        }

        defaultRenderer.setChartTitle("Cost per head as of 2016");
        defaultRenderer.setBackgroundColor(Color.DKGRAY);
        defaultRenderer.setApplyBackgroundColor(true);
        defaultRenderer.setLegendTextSize(40);
        defaultRenderer.setLabelsTextSize(40);
        defaultRenderer.setChartTitleTextSize(60);
        defaultRenderer.setZoomButtonsVisible(true);

        // Creating an intent to plot bar chart using dataset and multipleRenderer
        Intent intent = ChartFactory.getPieChartIntent(getBaseContext(), distributionSeries, defaultRenderer, "Cost Per head");

        // Start Activity
        startActivity(intent);
    }

    private double[] getPercentages(double[] expenditures) {
        DecimalFormat df = new DecimalFormat("#.00");
        double[] percentages = {0,0,0,0,0};
        double total = 0.0;
        for(int i = 0; i < expenditures.length; i++){
            total += expenditures[i];
        }
        for(int j = 0; j < expenditures.length; j++){
            percentages[j] = Math.round(100 / (total / expenditures[j])*100)/100;
        }
        return percentages;
    }
}
