package com.example.tahaful_java.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tahaful_java.R;

public class Details extends AppCompatActivity {

    TextView tvUniversityName,tvCountry,tvCountryCode,tvWebPage;

    String universityName,country,countryCode,webPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvUniversityName = findViewById(R.id.tvUniversityName);
        tvCountry = findViewById(R.id.tvCountry);
        tvWebPage = findViewById(R.id.tvWebPage);
        tvCountryCode = findViewById(R.id.tvCountryCode);

        universityName = getIntent().getStringExtra("university_name");
        country = getIntent().getStringExtra("country");
        countryCode = getIntent().getStringExtra("country_code");
        webPage = getIntent().getStringExtra("web_page");

        if (universityName != null) {
            tvUniversityName.setText(universityName);
        }
        if (countryCode != null) {
            tvCountryCode.setText(countryCode);
        }
        if (country != null) {
            tvCountry.setText(country);
        }
        if (webPage != null) {
            tvWebPage.setText(webPage);
        }

    }
}