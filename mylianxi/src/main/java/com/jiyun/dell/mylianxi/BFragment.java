package com.jiyun.dell.mylianxi;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {


    private RecyclerView recycle;
    private List<Game> list;
    private MyAdapters adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        initView(view);
        initData();
        initAdapter();
        return view;
    }

    private void initAdapter() {
        //线性布局
//                     LinearLayoutManager manager = new LinearLayoutManager(this);
        //表格布局
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        //        manager.setOrientation(GridLayoutManager.VERTICAL);
        // 瀑布流
        //        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //给RecyclerView设置布局
        recycle.setLayoutManager(manager);
        //适配器
        adapter = new MyAdapters(getActivity(), list);
        //给RecyclerView设置适配器
        recycle.setAdapter(adapter);


        adapter.setOnClickListener(new MyAdapters.OnClickListener() {
            @Override
            public void setOnClickItemListener(View view, int position) {
                Intent intent=new Intent(getActivity(),ScrollingActivity.class);
                intent.putExtra("imgs",list.get(position).getImg());
                startActivity(intent);
            }

            @Override
            public void setOnLongClickListener(View view, int position) {

            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            Game game=new Game(R.mipmap.ic_launcher+"","标题"+i);
            list.add(game);
        }

    }

    private void initView(View view) {
        recycle = (RecyclerView) view.findViewById(R.id.recycle);
    }
}
