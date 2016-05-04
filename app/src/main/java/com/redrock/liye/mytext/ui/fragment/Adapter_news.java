package com.redrock.liye.mytext.ui.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redrock.liye.mytext.R;

import java.util.List;

/**
 * Created by a on 2016/5/1.
 */
public class Adapter_news extends RecyclerView.Adapter<Adapter_news.NewsViewHolder> {
    private List<String> mDates;
    //private LayoutInflater inflater;
    public Adapter_news (List<String>mDates){
        this.mDates = mDates;
        //this.inflater = LayoutInflater.from(context);//创建渲染。
    }



    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建条目缓存的视图。
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        //绑定数据到条目.
        holder.newsTitle.setText(mDates.get(position ));

    }

    @Override
    public int getItemCount() {
        //返回有多少个条目。
        return mDates.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView newsTitle ;
        public NewsViewHolder(View itemView) {
            super(itemView);
            newsTitle = (TextView) itemView.findViewById(R.id.item_title_joke);
        }
    }

}
