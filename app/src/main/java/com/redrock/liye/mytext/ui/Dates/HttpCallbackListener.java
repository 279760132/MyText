package com.redrock.liye.mytext.ui.Dates;

/**
 * Created by a on 2016/5/2.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
