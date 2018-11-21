package com.example.prive.student_portal;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class activity_add_url extends AppCompatActivity {

    StoreInfo storeInfo;

    Button button;
    EditText urlText, titleText;
    String url, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_url);

        storeInfo = new StoreInfo(null, null);

        urlText = findViewById(R.id.txt_url);
        titleText = findViewById(R.id.txt_title);
        button = findViewById(R.id.btn_save_portal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = urlText.getText().toString();
                title = titleText.getText().toString();

                Intent intent = new Intent(activity_add_url.this, MainActivity.class);
                intent.putExtra("url",url);
                intent.putExtra("title",title);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Portal " + title + " is angemaakt.",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
