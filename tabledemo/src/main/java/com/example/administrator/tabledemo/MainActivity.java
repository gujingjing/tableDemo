package com.example.administrator.tabledemo;

import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import com.db.chart.Tools;
import com.db.chart.model.LineSet;
import com.db.chart.view.AxisController;
import com.db.chart.view.ChartView;
import com.db.chart.view.LineChartView;
import com.db.chart.view.Tooltip;
import com.db.chart.view.animation.Animation;

public class MainActivity extends Activity {

    /**
     * First chart
     */
    private LineChartView mChartOne;
    private ImageButton mPlayOne;
    private boolean mUpdateOne;
    private final String[] mLabelsOne = {"", "10-15", "", "15-20", "", "20-25", "", "25-30", "", "30-35", ""};
    private final float[][] mValuesOne = {{3.5f, 4.7f, 4.3f, 8f, 6.5f, 10f, 7f, 8.3f, 7.0f, 7.3f, 5f},
            {2.5f, 3.5f, 3.5f, 7f, 5.5f, 8.5f, 6f, 6.3f, 5.8f, 6.3f, 4.5f},
            {1.5f, 2.5f, 2.5f, 4f, 2.5f, 5.5f, 5f, 5.3f, 4.8f, 5.3f, 3f}};

    /** Third chart */
    private LineChartView mChartThree;
    private ImageButton mPlayThree;
    private boolean mUpdateThree;
    private final String[] mLabelsThree= {"11月7日", "04", "08", "12", "16", "20", "24"};
    private final float[][] mValuesThree = {  {4.5f, 5.7f, 4f, 8f, 2.5f, 3f, 6.5f},
            {1.5f, 2.5f, 1.5f, 5f, 5.5f, 5.5f, 3f},
            {8f, 7.5f, 7.8f, 1.5f, 8f, 8f, .5f}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUpdateOne = true;
        mChartOne = (LineChartView) findViewById(R.id.linechart1);
        mPlayOne = (ImageButton) findViewById(R.id.play1);


        mChartThree = (LineChartView)findViewById(R.id.linechart3);
        mPlayThree = (ImageButton)findViewById(R.id.play3);
        produceOne(mChartOne);
        produceThree(mChartThree);

        mChartOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"mChartOne",Toast.LENGTH_SHORT).show();
            }
        });
        mChartThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"mChartThree",Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Show CardView play button
     *
     * @param btn Play button
     */
    private void showPlay(ImageButton btn) {
        btn.setEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            btn.animate().alpha(1).scaleX(1).scaleY(1);
        else
            btn.setVisibility(View.VISIBLE);
    }

    /**
     * Dismiss CardView play button
     *
     * @param btn Play button
     */
    private void dismissPlay(ImageButton btn) {
        btn.setEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            btn.animate().alpha(0).scaleX(0).scaleY(0);
        else
            btn.setVisibility(View.INVISIBLE);
    }

    /**
     * Chart 1
     */

    public void produceOne(LineChartView chart) {

        LineSet dataset = new LineSet(mLabelsOne, mValuesOne[0]);
        dataset.setColor(Color.parseColor("#a34545"))
                .setFill(Color.parseColor("#a34545"))
                .setSmooth(true);
        chart.addData(dataset);

//        dataset = new LineSet(mLabelsOne, mValuesOne[1]);
//        dataset.setColor(Color.parseColor("#e08b36"))
//                .setFill(Color.parseColor("#e08b36"))
//                .setSmooth(true);
//        chart.addData(dataset);
//
//        dataset = new LineSet(mLabelsOne, mValuesOne[2]);
//        dataset.setColor(Color.parseColor("#61263c"))
//                .setFill(Color.parseColor("#61263c"))
//                .setSmooth(true);
//        chart.addData(dataset);
//
//        chart.setTopSpacing(Tools.fromDpToPx(15))
//                .setBorderSpacing(Tools.fromDpToPx(0))
//                .setAxisBorderValues(0, 10, 1)
//                .setXLabels(AxisController.LabelPosition.INSIDE)
//                .setYLabels(AxisController.LabelPosition.NONE)
//                .setLabelsColor(Color.parseColor("#e08b36"))
//                .setXAxis(false)
//                .setYAxis(false);
        chart.setTopSpacing(Tools.fromDpToPx(15))
                .setBorderSpacing(Tools.fromDpToPx(0))
                .setAxisBorderValues(0, 10, 1)
                .setXLabels(AxisController.LabelPosition.INSIDE)
                .setYLabels(AxisController.LabelPosition.NONE)
                .setLabelsColor(Color.parseColor("#e08b36"))
                .setXAxis(false)
                .setYAxis(false);
        Animation anim = new Animation().setStartPoint(-1, 1);

        chart.show(anim);
    }
    /**
     *
     * Chart 3
     *
     */

    public void produceThree(LineChartView chart){

//        Tooltip tip = new Tooltip(MainActivity.this, R.layout.linechart_three_tooltip, R.id.value);
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
//
//            tip.setEnterAnimation(PropertyValuesHolder.ofFloat(View.ALPHA, 1),
//                    PropertyValuesHolder.ofFloat(View.SCALE_X, 1f),
//                    PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f));
//
//            tip.setExitAnimation(PropertyValuesHolder.ofFloat(View.ALPHA,0),
//                    PropertyValuesHolder.ofFloat(View.SCALE_X,0f),
//                    PropertyValuesHolder.ofFloat(View.SCALE_Y,0f));
//        }
//
//        chart.setTooltips(tip);

        LineSet dataset = new LineSet(mLabelsThree, mValuesThree[0]);
//        dataset.setColor(Color.parseColor("#FFFFFF"))
//                .setDotsStrokeThickness(Tools.fromDpToPx(2))//设置点的外围大小
//                .setDotsStrokeColor(Color.parseColor("#FF58C674"))//设置点的外围颜色
//                .setDotsColor(Color.parseColor("#eef1f6"));//设置点的颜色

        dataset.setColor(Color.WHITE) //设置线的颜色
                .setDotsColor(Color.parseColor("#61263c"))//设置点的颜色
                .setDotsStrokeColor(Color.parseColor("#FF58C674"))//设置点的外围颜色
//                .setThickness(Tools.fromDpToPx(3))
                    ;
        //实现，向下覆盖内容
//        dataset.setColor(Color.parseColor("#a34545"))
//                .setFill(Color.parseColor("#a34545"))
//                .setSmooth(true);
        //设置虚线
//        dataset.setColor(Color.parseColor("#97b867"))
//                .setThickness(Tools.fromDpToPx(3))
//                .setDashed(new float[]{10, 10});

        chart.addData(dataset);

//        dataset = new LineSet(mLabelsThree, mValuesThree[1]);
//        dataset.setColor(Color.parseColor("#FFA03436"))
//                .setDotsStrokeThickness(Tools.fromDpToPx(2))
//                .setDotsStrokeColor(Color.parseColor("#FFA03436"))
//                .setDotsColor(Color.parseColor("#eef1f6"));
//        chart.addData(dataset);
//
//        dataset = new LineSet(mLabelsThree, mValuesThree[2]);
//        dataset.setColor(Color.parseColor("#FF365EAF"))
//                .setDotsStrokeThickness(Tools.fromDpToPx(2))
//                .setDotsStrokeColor(Color.parseColor("#FF365EAF"))
//                .setDotsColor(Color.parseColor("#eef1f6"));
//        chart.addData(dataset);

        Paint gridPaint = new Paint();
        gridPaint.setColor(Color.parseColor("#308E9196"));
        gridPaint.setStyle(Paint.Style.STROKE);
        gridPaint.setAntiAlias(true);
        gridPaint.setStrokeWidth(Tools.fromDpToPx(1f));

        chart.setTopSpacing(Tools.fromDpToPx(15))
                .setBorderSpacing(Tools.fromDpToPx(0))
                .setAxisBorderValues(0, 10, 1)
                .setXLabels(AxisController.LabelPosition.INSIDE)
                .setYLabels(AxisController.LabelPosition.NONE)
                .setLabelsColor(Color.parseColor("#FF8E9196"))
                .setXAxis(false)
                .setYAxis(false)
//                .setStep(2)//设置垂直间距
                .setBorderSpacing(Tools.fromDpToPx(5))
//                .setGrid(ChartView.GridType.VERTICAL, gridPaint)  //设置添加线条
        ;

//        chart.setTopSpacing(Tools.fromDpToPx(15))
//                .setBorderSpacing(Tools.fromDpToPx(0))
//                .setAxisBorderValues(0, 10, 1)
//                .setXLabels(AxisController.LabelPosition.INSIDE)
//                .setYLabels(AxisController.LabelPosition.NONE)
//                .setLabelsColor(Color.parseColor("#e08b36"))
//                .setXAxis(false)
//                .setYAxis(false);
        Animation anim = new Animation().setStartPoint(-1, 1);

        chart.show(anim);
    }
}
