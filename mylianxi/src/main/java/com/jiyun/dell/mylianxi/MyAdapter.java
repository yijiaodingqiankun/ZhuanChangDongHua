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

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final Context context;
    private final List<Object> list;
    private OnClickListener onClickListener;
    public ImageView imagephoto;

    public MyAdapter(Context context, List<Object> list) {
        this.context = context;
        this.list = list;
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_buju, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.name.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position)).into(holder.img11);
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
        private final ImageView img11;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView1 = itemView;
            name = itemView.findViewById(R.id.name11);
            img11 = itemView.findViewById(R.id.img11);
            imagephoto=img11;
        }
    }
}
