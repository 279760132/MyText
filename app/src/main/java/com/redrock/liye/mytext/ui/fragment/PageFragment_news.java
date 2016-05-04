package com.redrock.liye.mytext.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.redrock.liye.mytext.R;
import com.redrock.liye.mytext.ui.Dates.HttpCallbackListener;
import com.redrock.liye.mytext.ui.Dates.HttpUtil;
import com.redrock.liye.mytext.ui.model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2016/4/30.
 */
public class PageFragment_news extends Fragment {
    private List<String> mDates;
    public static final int UPDATE = 1;
    public static final String ARG_PAGE = "ARG_PAGE";

    private Handler handler =  new  Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE :
                    Log.i("Redrock","hehe");
            }
        }
    };
    public static PageFragment_news newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment_news pageFragment_news = new PageFragment_news();
        pageFragment_news.setArguments(args);
        return pageFragment_news;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page1, container, false);
        RecyclerView newsRecyclerView = (RecyclerView) view.findViewById(R.id.news_recycler_view);
        initDates();
        Adapter_news adapter_news = new Adapter_news(mDates);
        newsRecyclerView.setAdapter(adapter_news);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
    private void initDates(){
        String address = "http://jandan.net/?oxwlxojflwblxbsapi=jandan.get_duan_comments&page=1";
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
               // Message message = new Message();
                parseJSONWithGSON(response);


            }

            @Override
            public void onError(Exception e) {

            }
        });

    }
    private void parseJSONWithGSON(String jsonData){
        List Dates = new ArrayList<String>();
        Gson gson = new Gson();
        Log.i("Redrock", "1");
        News news = gson.fromJson(jsonData, News.class);
        Log.i("Redrock", "2");
        List<News.CommentsBean> newsList = news.getComments();


        for (News.CommentsBean c : newsList){
            Log.i("Redrock","3");
            Log.i("Redrock", c.getComment_author());
            Dates.add(c.getComment_author());
        }
        mDates = Dates;
        Message message = new Message();
        message.what = UPDATE;
        handler.sendMessage(message);

    }

}