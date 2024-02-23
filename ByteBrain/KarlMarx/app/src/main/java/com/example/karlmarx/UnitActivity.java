package com.example.karlmarx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UnitActivity extends SelectActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);

        ListView listView = findViewById(R.id.listview);
        List<String> list = new ArrayList<>();
        list.add("Unit 1");
        list.add("Unit 2");
        list.add("Unit 3");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    unit=1;
                } else if (position == 1) {
                    unit=2;
                } else if (position==3) {
                    unit=3;
                }
                startActivity(new Intent(UnitActivity.this,ChaptActivity.class));



            }

        });
    }

}