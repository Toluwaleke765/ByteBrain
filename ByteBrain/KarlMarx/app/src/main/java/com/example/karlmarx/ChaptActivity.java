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
import android.os.Bundle;

public class ChaptActivity extends UnitActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapt);
        ListView listView = findViewById(R.id.listview);
        List<String> list = new ArrayList<>();
        list.add("Chapter 1");
        list.add("Chapter 2");
        list.add("Chapter 3");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    chapter=1;
                } else if (position == 1) {
                    chapter=2;
                } else if (position==3) {
                    chapter=3;
                }
                startActivity(new Intent(ChaptActivity.this,QActivity.class));



            }

        });
    }
}