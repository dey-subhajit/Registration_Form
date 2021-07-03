package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ShowData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        Intent get_data = getIntent();
        /*System.out.println(get_data.getStringExtra("full_name"));*/
        TableLayout show_table_data = (TableLayout)findViewById(R.id.show_table_data);
        TableRow row = new TableRow(this);
        TextView col1 = new TextView(this);
        TextView col2 = new TextView(this);
        col1.setText("Name: ");
        col2.setText(get_data.getStringExtra("full_name"));
        row.addView(col1);
        row.addView(col2);
        show_table_data.addView(row);
    }
}