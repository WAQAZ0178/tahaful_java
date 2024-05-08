package com.example.tahaful_java.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tahaful_java.Models.UniversityModel;
import com.example.tahaful_java.Network.ApiClient;
import com.example.tahaful_java.Network.RetrofitClient;
import com.example.tahaful_java.R;
import com.example.tahaful_java.Adapters.RCAdapter;
import com.example.tahaful_java.Models.RCModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    RCAdapter rcAdopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.details);
        recyclerView = findViewById(R.id.recyclerView);

        ApiClient apiService = RetrofitClient.getClient().create(ApiClient.class);

        Call<ArrayList<UniversityModel>> call = apiService.getUniversities("United Arab Emirates");

        call.enqueue(new Callback<ArrayList<UniversityModel>>() {
            @Override
            public void onResponse(Call<ArrayList<UniversityModel>> call, Response<ArrayList<UniversityModel>> response) {

                if (response.isSuccessful()) {
                    ArrayList<UniversityModel> response1 = response.body();
                    if (response1 != null) {
                        rcAdopter = new RCAdapter(MainActivity.this, response1);
                        recyclerView.setAdapter(rcAdopter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UniversityModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this,  t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Message",t.getMessage());
            }
        });
    }

}