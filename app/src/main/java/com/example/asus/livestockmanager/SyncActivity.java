package com.example.asus.livestockmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import BusinessEntities.Appointment;
import BusinessEntities.Cattle;
import BusinessEntities.Expenditure;
import BusinessEntities.Income;
import BusinessEntities.Remedy;
import BusinessLogic.Controller;
import RestClient.HttpManager;

public class SyncActivity extends AppCompatActivity implements View.OnClickListener  {

    TextView output;
    Button buttonSyncAction;
    ProgressBar pb;
    List<MyTask> tasks;
    List<Cattle> cattle;
    Context context = this;
    String username, password, herdNumber;
    SharedPreferences preferences = null;
    String myPreferences = "Login Credentials";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);

        preferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        herdNumber = preferences.getString("herdNumber", "");
        username = preferences.getString("username", "");
        password = preferences.getString("password", "");

        buttonSyncAction = (Button) findViewById(R.id.buttonSyncAction);
        buttonSyncAction.setOnClickListener(this);

        output = (TextView) findViewById(R.id.textViewGetData);
        output.setMovementMethod(new ScrollingMovementMethod());

        pb = (ProgressBar) findViewById(R.id.progressBar2);
        pb.setVisibility(View.INVISIBLE);

        tasks = new ArrayList<>();
        cattle = Controller.getAllAnimals(context);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sync, menu);
        return true;
    }

    private void requestData(String uri) {
        MyTask task = new MyTask();
        task.execute(uri);
    }

    protected void updateDisplay(String message) {
        output.append("The response is: " + message + "\n");
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSyncAction:
                buttonSyncActionClick();
                break;
        }
    }

    private void buttonSyncActionClick(){
        if (isOnline()) {
            requestData("http://uherd.azurewebsites.net/uHerd/GetCloudData?username=" + username + "&password=" + password + "&herdNumber=" + herdNumber);
        } else {
            Toast.makeText(this, "Network isn't available", Toast.LENGTH_LONG).show();
        }
    }

    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            updateDisplay("Starting task");

            if (tasks.size() == 0) {
                pb.setVisibility(View.VISIBLE);
            }
            tasks.add(this);
        }

        @Override
        protected String doInBackground(String... params) {

            String content = HttpManager.getData(params[0]);
            String[] contentParts = content.split("\\r?\\n");
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            List<Cattle> cattle = new ArrayList<>();
            cattle = Arrays.asList(gson.fromJson(contentParts[0], Cattle[].class));
            for(Cattle c : cattle){
                Controller.addAnimalToDB(c, context);
            }

            List<Appointment> appointments = new ArrayList<>();
            appointments = Arrays.asList(gson.fromJson(contentParts[1], Appointment[].class));
            for(Appointment a : appointments){
                Controller.addAppointmentFromCloudToDB(a, context);
            }
            List<Income> incomes = new ArrayList<>();
            incomes = Arrays.asList(gson.fromJson(contentParts[2], Income[].class));
            for(Income i : incomes){
                Controller.addIncomeToDB(i, context);
            }
            List<Expenditure> expenditures = new ArrayList<>();
            expenditures = Arrays.asList(gson.fromJson(contentParts[3], Expenditure[].class));
            for(Expenditure e : expenditures){
                Controller.addExpenditureToDB(e, context);
            }
            List<Remedy> remedies = new ArrayList<>();
            remedies = Arrays.asList(gson.fromJson(contentParts[4], Remedy[].class));
            for(Remedy r : remedies){
                Controller.addRemedyToDB(r, context);
            }
            return "Sync completed successfully!!";
        }

        @Override
        protected void onPostExecute(String result) {

            tasks.remove(this);
            if (tasks.size() == 0) {
                pb.setVisibility(View.INVISIBLE);
            }
            if(result ==null){
                Toast.makeText(SyncActivity.this, "Can't connect to web service", Toast.LENGTH_LONG).show();
                return;
            }
            updateDisplay(result);

        }

        @Override
        protected void onProgressUpdate(String... values) {
            updateDisplay(values[0]);
        }

    }
}

