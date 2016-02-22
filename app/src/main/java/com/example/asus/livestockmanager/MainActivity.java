package com.example.asus.livestockmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    RelativeLayout background;
    Button button_manageLivestock, buttonFinance, buttonSync, buttonReports, button_tasks, buttonDBManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = (RelativeLayout) findViewById(R.id.background);
        button_manageLivestock = (Button) findViewById(R.id.buttonLivestock);
        buttonFinance = (Button) findViewById(R.id.buttonFinance);
        buttonSync =(Button) findViewById(R.id.buttonSync);
        buttonReports = (Button) findViewById(R.id.buttonReports);
        button_tasks = (Button) findViewById(R.id.buttonTasks);
        buttonDBManager = (Button) findViewById(R.id.buttonDBManager);

        button_manageLivestock.setOnClickListener(this);;
        buttonFinance.setOnClickListener(this);
        buttonReports.setOnClickListener(this);
        buttonSync.setOnClickListener(this);
        button_tasks.setOnClickListener(this);
        buttonDBManager.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLivestock:
                buttonManageLivestockClick();
                break;

            case R.id.buttonFinance:
                buttonFinanceClick();
                break;

            case R.id.buttonReports:
                buttonReportsClick();
                break;

            case R.id.buttonSync:
                buttonSyncClick();
                break;

            case R.id.buttonTasks:
                buttonTasksClick();
                break;

            case R.id.buttonDBManager:
                buttonDBManagerClick();
                break;
        }
    }

    private void buttonManageLivestockClick() {
        startActivity(new Intent("android.intent.action.ManageLivestockActivity"));
    }

    private void buttonFinanceClick() {
        startActivity(new Intent("android.intent.action.FinanceActivity"));
    }

    private void buttonSyncClick() {
        startActivity(new Intent("android.intent.action.SyncActivity"));
    }

    private void buttonReportsClick() {
        startActivity(new Intent("android.intent.action.ReportsActivity"));
    }

    private void buttonTasksClick() {
        startActivity(new Intent("android.intent.action.TasksActivity"));
    }

    private void buttonDBManagerClick() {
        startActivity(new Intent("android.intent.action.AndroidDatabaseManager"));
    }
}