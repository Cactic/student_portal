package com.example.prive.student_portal;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StoreInfoAdapter.PortalClickListener {

    FloatingActionButton button;
    RecyclerView rV;
    Intent intent;

    StoreInfoAdapter adapter;

    public static final String PORTAL = "PORTAL";

    //Constants used when calling the update activity
    public static final String EXTRA_REMINDER = "Reminder";
    public static final int REQUESTCODE = 1234;
    private int mModifyPosition;

    static List<StoreInfo> infoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = getIntent();

        if(getIntent().getStringExtra("url") != null){
            String url = getIntent().getStringExtra("url");
            String title = getIntent().getStringExtra("title");

            StoreInfo storeInfo = new StoreInfo(url,title);

            infoList.add(storeInfo);
        }


        rV = findViewById(R.id.recyclerView);
        rV.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        adapter = new StoreInfoAdapter(infoList, this);
        rV.setAdapter(adapter);


        button = findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_add_url.class);
                startActivity(intent);
            }
        });


    }

    private void updateUI() {
        if (adapter == null) {
            adapter = new StoreInfoAdapter(infoList, this);
            rV.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }


    public void portalOnClick(int i) {
        Intent intent = new Intent(MainActivity.this, WebviewActivity.class);
        intent.putExtra(PORTAL,MainActivity.infoList.get(i));
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUESTCODE) {
            if (resultCode == RESULT_OK) {
                StoreInfo updatedInfo = data.getParcelableExtra(MainActivity.PORTAL);
                infoList.add(updatedInfo);
                updateUI();
            }
        }
    }
}
