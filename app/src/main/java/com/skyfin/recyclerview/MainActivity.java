package com.skyfin.recyclerview;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.skyfin.recyclerview.bean.RecycleItemBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    //适配器
    RecycleAdapter mAdapter;
    //数据实体集合 包含一张图片,一个标题
    List<RecycleItemBean> mData;
    //布局器，负责Item视图的布局
    RecyclerView.LayoutManager mLayoutManager;
    //activity的view
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = getLayoutInflater().inflate(R.layout.activity_main,null);
        setContentView(view);
        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
        //初始化适配器
        mAdapter = new RecycleAdapter(mData,getApplicationContext());
        //初始化比较管理器
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //设置单击监听
        mAdapter.setOnCLickListener(new RecycleAdapter.ItemClickListener() {
            @Override
            public void OnClick(View v) {
                Snackbar.make(view, v.getTag().toString(), Snackbar.LENGTH_SHORT).show();
            }
        });
        //设置长按监听
        mAdapter.setOnLongClickListener(new RecycleAdapter.ItemLongClickListener() {
            @Override
            public void OnLongClick(View v) {
                Snackbar.make(view, v.getTag().toString(), Snackbar.LENGTH_SHORT).show();
            }
        });
        //添加的滚动监听
        mRecyclerView.addOnScrollListener(new MyOnScrollListener());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i =0;i<100;i++){
            RecycleItemBean pItem = new RecycleItemBean();
            pItem.setImageviewdrawable(R.mipmap.ic_launcher);
            pItem.setTitle("RecycleDome" + i);
            mData.add(pItem);
        }
    }
    class MyOnScrollListener extends RecyclerView.OnScrollListener{
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
        /*
         * newState
         * SCROLL_STATE_IDLE: pager处于空闲状态
         * SCROLL_STATE_DRAGGING： pager处于正在拖拽中
         * SCROLL_STATE_SETTLING： pager正在自动沉降，相当于松手后，pager恢复到一个完整pager的过程
         */
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }
    }

}
