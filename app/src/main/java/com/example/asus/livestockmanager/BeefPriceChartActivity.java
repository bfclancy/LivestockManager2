package com.example.asus.livestockmanager;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class BeefPriceChartActivity extends AppCompatActivity {

    private String[] mMonth = new String[] {"Jan", "Feb" , "Mar", "Apr", "May", "Jun","Jul", "Aug" , "Sep", "Oct", "Nov", "Dec"};

    public static final String TYPE = "type";
    private XYMultipleSeriesDataset mDataset = getDemoDataset();
    private XYMultipleSeriesRenderer mRenderer = getDemoRenderer(mMonth);
    private GraphicalView mChartView;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beef_price_chart);

        setRendererStyling();
        if (mChartView == null) {
            LinearLayout layout = (LinearLayout) findViewById(R.id.chart);
            mChartView = ChartFactory.getLineChartView(this, mDataset,
                    mRenderer);
            mRenderer.setSelectableBuffer(100);
            layout.addView(mChartView, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        } else
            mChartView.repaint();
    }

    private void setRendererStyling() {
        mRenderer.setApplyBackgroundColor(true);
        mRenderer.setBackgroundColor(Color.argb(100, 50, 50, 50));
        mRenderer.setAxisTitleTextSize(30);
        mRenderer.setChartTitleTextSize(40);
        mRenderer.setLabelsTextSize(25);
        mRenderer.setLegendTextSize(50);
        mRenderer.setMargins(new int[] {  30, 30, 30, 30 });
        mRenderer.setZoomButtonsVisible(true);
        mRenderer.setPointSize(10);
    }

    private XYMultipleSeriesDataset getDemoDataset() {
        double[] seriesFirstY = {3.24, 3.49, 4.25, 5.04, 4.98, 5.26, 3.24, 3.49, 4.25, 5.04, 4.98, 5.26};
        double[] seriesSecondY = {2.24, 4.49, 4.25, 4.04, 3.98, 4.26, 4.24, 5.49, 5.25, 6.04, 5.98, 4.26};

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();

        XYSeries firstSeries = new XYSeries("Beef Prices Per Kg 2014");
        for (int i = 0; i < 12; i++)
            firstSeries.add(i, seriesFirstY[i]);
        dataset.addSeries(firstSeries);

        XYSeries secondSeries = new XYSeries("Beef Prices Per Kg 2015");
        for (int j = 0; j < 12; j++)
            secondSeries.add(j, seriesSecondY[j]);
        dataset.addSeries(secondSeries);
        return dataset;
    }

    private XYMultipleSeriesRenderer getDemoRenderer(String[] mMonth) {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setMargins(new int[]{30, 30, 30, 30});
        XYSeriesRenderer r = new XYSeriesRenderer();
        r.setColor(Color.BLUE);
        r.setPointStyle(PointStyle.SQUARE);
        r.setFillPoints(true);
        renderer.addSeriesRenderer(r);
        r = new XYSeriesRenderer();
        r.setPointStyle(PointStyle.CIRCLE);
        r.setColor(Color.GREEN);
        r.setFillPoints(true);
        renderer.addSeriesRenderer(r);
        renderer.setAxesColor(Color.DKGRAY);
        renderer.setLabelsColor(Color.LTGRAY);
        renderer.setXTitle("Month");
        renderer.setYTitle("Beef price per kg");
        for(int i=0; i< 12;i++){
            renderer.addXTextLabel(i, mMonth[i]);
        }
        return renderer;
    }
}
