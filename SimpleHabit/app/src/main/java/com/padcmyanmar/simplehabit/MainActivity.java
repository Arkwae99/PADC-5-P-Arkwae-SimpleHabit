package com.padcmyanmar.simplehabit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.adapters.AHealthyMindAdapter;
import com.padcmyanmar.simplehabit.adapters.AllTopicsAdapter;
import com.padcmyanmar.simplehabit.adapters.MostPopularAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_a_healthy_mind)
    RecyclerView rvAHealthyMind;

    @BindView(R.id.rv_all_topics)
    RecyclerView rvAllTopics;

    @BindView(R.id.rv_most_popular)
    RecyclerView rvMostPopular;


    private AHealthyMindAdapter mAHealthyMindAdapter;

    private AllTopicsAdapter mAllTopicsAdapter;

    private MostPopularAdapter mMostPopularAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this, this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        mAHealthyMindAdapter = new AHealthyMindAdapter();
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvAHealthyMind.setAdapter(mAHealthyMindAdapter);
        rvAHealthyMind.setLayoutManager(linearLayoutManager2);

        mMostPopularAdapter = new MostPopularAdapter();
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvMostPopular.setAdapter(mMostPopularAdapter);
        rvMostPopular.setLayoutManager(linearLayoutManager4);

        mAllTopicsAdapter = new AllTopicsAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvAllTopics.setLayoutManager(linearLayoutManager);
        rvAllTopics.setAdapter(mAllTopicsAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
