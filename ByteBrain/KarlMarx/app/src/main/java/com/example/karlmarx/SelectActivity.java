package com.example.karlmarx;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SelectActivity extends AppCompatActivity {
    public int course;
    public int unit;
    public int chapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        ListView listView = findViewById(R.id.listview);
        List<String> list = new ArrayList<>();
        list.add("Physics ");
        list.add("Math");
        list.add("Chemistry");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    course=1;
                } else if (position == 1) {
                    course=2;
                } else if (position==3) {
                    course=3;
                }
                startActivity(new Intent(SelectActivity.this,UnitActivity.class));

            }

        });



    }




    }

