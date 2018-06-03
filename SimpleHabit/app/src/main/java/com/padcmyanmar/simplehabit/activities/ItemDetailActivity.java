package com.padcmyanmar.simplehabit.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.SimpleHabitApp;
import com.padcmyanmar.simplehabit.adapters.SessionAdapter;
import com.padcmyanmar.simplehabit.data.models.SimpleHabitsModel;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramsVO;
import com.padcmyanmar.simplehabit.data.vo.ProgramsVO;
import com.padcmyanmar.simplehabit.data.vo.SessionsVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ag Phone Khant on 2/6/2018.
 */

public class ItemDetailActivity extends AppCompatActivity {
    @BindView(R.id.tv_start_here_detail_name)
    TextView tvDetailName;

    @BindView(R.id.tv_about)
    TextView tvAbout;

    @BindView(R.id.rv_item_detail)
    RecyclerView rvItemDetail;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private SessionAdapter mSessionAdapter;

    private CurrentProgramsVO currentProgramsVO;
    private ProgramsVO programsVO;
    private List<SessionsVO> sessionsVOList;

    public static Intent newIntentCategoryProgram(Context context, String categoryId, String categoryProgramId) {
        Intent intent = new Intent(context, ItemDetailActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE, SimpleHabitApp.CATEGORY);
        intent.putExtra(SimpleHabitApp.CATEGORY_ID, categoryId);
        intent.putExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID, categoryProgramId);
        return intent;
    }

    public static Intent newIntentCurrentProgram(Context context) {
        Intent intent = new Intent(context, ItemDetailActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE, SimpleHabitApp.CURRENT_PROGRAM);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_here_detail);

        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp));
        }

        mSessionAdapter = new SessionAdapter(this);
        String programId = getIntent().getStringExtra(SimpleHabitApp.PROGRAM_ID);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvItemDetail.setLayoutManager(linearLayoutManager);
        rvItemDetail.setAdapter(mSessionAdapter);


        if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CURRENT_PROGRAM)) {
            CurrentProgramsVO currentProgram = SimpleHabitsModel.getInstance().getCurrentProgram();
            mSessionAdapter.setNewData(currentProgram.getSessions());
            tvDetailName.setText(currentProgram.getTitle());
            tvAbout.setText(currentProgram.getDescription());
        } else if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CATEGORY)) {
            String categoryId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_ID);
            String categoryProgramId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID);

            ProgramsVO categoryProgram = SimpleHabitsModel.getInstance().getProgram(categoryId, categoryProgramId);
            mSessionAdapter.setNewData(categoryProgram.getSessions());
            tvDetailName.setText(categoryProgram.getTitle());
            tvAbout.setText(categoryProgram.getDescription());
        }
    }
}
