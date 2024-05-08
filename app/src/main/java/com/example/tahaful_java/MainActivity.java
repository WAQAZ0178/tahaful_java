package com.example.tahaful_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<RCModel> modelArrayList;
    RCAdopter rcAdopter;
    private RequestQueue requestQueue;
    private TextView textView;









    final String[][] universities = {
            // Name, Country, StateProvince, AlphaTwoCode, Domains, WebPages
            {"Mohamed bin Zayed University of Artificial Intelligence (MBZUAI)", "United Arab Emirates", "Abu Dhabi", "AE", "mbzuai.ac.ae", "https://mbzuai.ac.ae/"},
            {"American College Of Dubai", "United Arab Emirates", null, "AE", "acd.ac.ae", "http://www.acd.ac.ae/"},
            {"Abu Dhabi University", "United Arab Emirates", null, "AE", "adu.ac.ae", "http://www.adu.ac.ae/"},
            {"Al Ghurair University", "United Arab Emirates", null, "AE", "agu.ae", "http://www.agu.ae/"},
            {"Ajman University of Science & Technology", "United Arab Emirates", null, "AE", "ajman.ac.ae", "http://www.ajman.ac.ae/"},
            {"Alain University of Science and Technology", "United Arab Emirates", null, "AE", "alainuniversity.ac.ae", "http://www.alainuniversity.ac.ae/"},
            {"Alhosn University", "United Arab Emirates", null, "AE", "alhosnu.ae", "http://www.alhosnu.ae/"},
            {"American University in Dubai", "United Arab Emirates", null, "AE", "aud.edu", "http://www.aud.edu/"},
            {"American University in the Emirates", "United Arab Emirates", null, "AE", "aue.ae", "http://www.aue.ae/"},
            {"American University of Sharjah", "United Arab Emirates", null, "AE", "aus.edu", "http://www.aus.edu/"},

    };






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        VolleySingleton.getInstance(this);
        fetchJsonResponse();
        recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        modelArrayList= new ArrayList<>();
        rcAdopter = new RCAdopter(this, modelArrayList);

        recyclerView.setAdapter(rcAdopter);


        for (String[] university : universities) {
            RCModel rcModel = new RCModel(university[0],university[1],university[2],university[3],university[4]);
            modelArrayList.add(rcModel);
        }
        rcAdopter.notifyDataSetChanged();



    }


    private void fetchJsonResponse() {
        String url = "http://universities.hipolabs.com/search?country=United%20Arab%20Emirates";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        textView.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Error: " + error.toString());
            }
        });

        VolleySingleton.getInstance(this).getRequestQueue().add(jsonObjectRequest);
    }
}
