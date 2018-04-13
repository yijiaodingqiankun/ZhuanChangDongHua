package com.jiyun.dell.mylianxi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/9/30.
 */

class MyAdapters extends RecyclerView.Adapter<MyAdapters.ViewHolder> {
    private List<Game> list;
    private Context context;
    private OnClickListener onClickListener;

    public MyAdapters(Context context, List<Game> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public MyAdapters.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_buju, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapters.ViewHolder holder, final int position) {
//        holder.name.setText(list.get(position).getName());
        String img = list.get(position).getImg();
        int i = Integer.parseInt(img);
        Glide.with(context).load(i).into(holder.img2);
        holder.itemView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.setOnClickItemListener(view, position);
                onClickListener.setOnLongClickListener(view, position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnClickListener {
        void setOnClickItemListener(View view, int position);

        void setOnLongClickListener(View view, int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final View itemView1;
        private final ImageView img2;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView1 = itemView;
            name = itemView.findViewById(R.id.name11);
            img2 = itemView.findViewById(R.id.img11);
        }
    }
}
