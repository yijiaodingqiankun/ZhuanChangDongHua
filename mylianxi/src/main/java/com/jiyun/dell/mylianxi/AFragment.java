package com.jiyun.dell.mylianxi;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    private RecyclerView recyc;
    private List<Object> list;
    private MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        initView(view);
        initData();
        initAdapter();
        return view;
    }

    private void initAdapter() {
        //线性布局
//                     LinearLayoutManager manager = new LinearLayoutManager(this);
        //表格布局
        //        GridLayoutManager manager=new GridLayoutManager(this,2);
        //        manager.setOrientation(GridLayoutManager.VERTICAL);
        // 瀑布流
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //给RecyclerView设置布局
        recyc.setLayoutManager(manager);
        //适配器
        adapter = new MyAdapter(getActivity(), list);
        //给RecyclerView设置适配器
        recyc.setAdapter(adapter);

        adapter.setOnClickListener(new MyAdapter.OnClickListener() {
            @Override
            public void setOnClickItemListener(View view, int position) {
                //转场动画
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity(), adapter.imagephoto, "zhanghuirong").toBundle();
                Intent intent = new Intent(getActivity(), XActivity.class);

                intent.putExtra("img",(Integer) list.get(position));
                startActivity(intent,bundle);
            }

            @Override
            public void setOnLongClickListener(View view, int position) {

            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            list.add(R.drawable.m);
        }

    }

    private void initView(View view) {
        recyc = (RecyclerView) view.findViewById(R.id.recyc);
    }
}
