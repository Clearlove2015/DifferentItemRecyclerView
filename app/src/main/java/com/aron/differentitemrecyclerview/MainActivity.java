package com.aron.differentitemrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.rv)
    RecyclerView rv;
    @Bind(R.id.iv_float)
    ImageView ivFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ResultBeanData resultBeanData = new ResultBeanData();
        Log.e("TAG","集合长度 = " + resultBeanData.imagesUrl.size());

        rv.setLayoutManager(new GridLayoutManager(this,1));
        rv.setAdapter(new MyRecyclerViewAdapter(this,resultBeanData));
    }

    @OnClick(R.id.iv_float)
    public void onViewClicked() {
        Toast.makeText(MainActivity.this,"回到顶部",Toast.LENGTH_SHORT).show();
    }

}
