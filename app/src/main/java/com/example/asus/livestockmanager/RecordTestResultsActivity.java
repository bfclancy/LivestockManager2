package com.example.asus.livestockmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import BusinessLogic.RecordTestResultsPresenter;

public class RecordTestResultsActivity extends AppCompatActivity {

    private RecordTestResultsPresenter recordTestResultsPresenter;
    private List<String> tagNumbers;
    private LinearLayout layout, layout2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_test_results);
        recordTestResultsPresenter = new RecordTestResultsPresenter();
        tagNumbers = recordTestResultsPresenter.getAllTagNumbersForTest(this);
        layout = (LinearLayout) findViewById(R.id.Linear1);
        ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams lparams2 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for(int j = 0; j < 10; j++){

            //create linear layout
            LinearLayout innerLayout = new LinearLayout(this);
            innerLayout.setId(3000 + j);
            innerLayout.setLayoutParams(lparams2);

            //create text view
            TextView tv = new TextView(this);
            tv.setId(j);
            tv.setText("TagNumber" + j);
            tv.setLayoutParams(lparams);
            innerLayout.addView(tv);

            //create checkbox for pass
            CheckBox checkBoxPass = new CheckBox(this);
            checkBoxPass.setId(1000 + j);
            checkBoxPass.setLayoutParams(lparams);
            innerLayout.addView(checkBoxPass);

            //create checkbow for fail
            CheckBox checkBoxFail = new CheckBox(this);
            checkBoxFail.setId(2000 + j);
            checkBoxFail.setLayoutParams(lparams);
            innerLayout.addView(checkBoxFail);

            //add inner layout to parent layout
            layout.addView(innerLayout);
        }
    }


}
