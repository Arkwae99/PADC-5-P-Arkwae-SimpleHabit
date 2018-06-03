package com.padcmyanmar.simplehabit.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.adapters.SeriesAdapter;
import com.padcmyanmar.simplehabit.data.models.SimpleHabitsModel;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramDelegate;
import com.padcmyanmar.simplehabit.delegates.CurrentProgramDelegate;
import com.padcmyanmar.simplehabit.events.SimpleHabitEvents;
import com.padcmyanmar.simplehabit.events.SuccessEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements CurrentProgramDelegate,CategoryProgramDelegate {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;


    public static Intent meditateIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    private SeriesAdapter mSeriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this, this);

        SimpleHabitsModel.getInstance().startLoadingSimpleHabits();

        mSeriesAdapter = new SeriesAdapter(getApplicationContext(), this,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()
                , LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(mSeriesAdapter);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id) {
                    case R.id.item_meditate:
//                        Intent intentForMeditate=MainActivity.meditateIntent(getApplicationContext());
//                        startActivity(intentForMeditate);
                        break;
                    case R.id.item_me:
                        Intent intentForMe = MeActivity.MeIntent(getApplicationContext());
                        startActivity(intentForMe);
                    case R.id.item_more:
                        break;
                }

                return true;
            }


        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoaded(SuccessEvent event) {
        mSeriesAdapter.setNewData(event.getmData());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(SimpleHabitEvents.ErrorInvokingAPIEvent event) {
        Snackbar.make(rvList, event.getErrorMsg(), Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void onTapCurrentProgram() {
        Intent intent = ItemDetailActivity.newIntentCurrentProgram(getApplicationContext());
        startActivity(intent);

    }

    @Override
    public void onTapCategoryProgramDelegate(String categoryId, String categoryProgramId) {
        Intent intent = ItemDetailActivity.newIntentCategoryProgram(getApplicationContext(),categoryId,categoryProgramId);
        startActivity(intent);

    }
}
