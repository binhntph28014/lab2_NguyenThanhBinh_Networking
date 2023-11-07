package binhntph28014.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity  {
    Button btnBai1, btnBai2, btnBai3, btnBai4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBai1 = findViewById(R.id.btnBai1);
        btnBai2 = findViewById(R.id.btnBai2);
        btnBai3 = findViewById(R.id.btnBai3);
        btnBai4 = findViewById(R.id.btnBai4);

        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Bai1_Activity.class);
                startActivity(intent1);
            }
        });

        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Bai2_Activity.class);
                startActivity(intent2);
            }
        });

        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Bai3_Activity.class);
                startActivity(intent3);
            }
        });

        btnBai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this, Bai4_Activity.class);
                startActivity(intent4);
            }
        });

    }




}