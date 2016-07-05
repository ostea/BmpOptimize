package com.github.ostea.bmpoptimize.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.ostea.bmpoptimize.R;
import com.github.ostea.bmpoptimize.adapter.MainAdapter;

import java.util.ArrayList;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class MainActivity extends AppCompatActivity implements MainContract.View, AdapterView.OnItemClickListener {

    MainContract.Presenter mPresenter;
    PtrFrameLayout mPtrLayout;
    ListView mListView;
    MainAdapter mAdapter;
    ArrayList<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewEvent();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
    }

    @Override
    public void initView() {
        mPresenter = new MainPresenter(MainActivity.this, mListView, this);
        mPtrLayout = (PtrFrameLayout) findViewById(R.id.ptrLayout);
        mListView = (ListView) findViewById(R.id.mListView);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void initViewEvent() {
        mPtrLayout.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mAdapter == null) {
                            mAdapter = new MainAdapter(MainActivity.this, mData);
                            mListView.setAdapter(mAdapter);
                        }
                        loadComplete();
                    }
                }, 1800);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });
        mPtrLayout.autoRefresh(true);
    }

    @Override
    public void loadComplete() {
        mAdapter.setData(mPresenter.loadData());
        mPtrLayout.refreshComplete();
    }

    @Override
    public void loadFail() {
        mPtrLayout.refreshComplete();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mPresenter.switch2Aty(i);
    }
}
