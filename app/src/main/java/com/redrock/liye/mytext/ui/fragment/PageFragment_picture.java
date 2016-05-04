package com.redrock.liye.mytext.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redrock.liye.mytext.R;

/**
 * Created by a on 2016/4/30.
 */
public class PageFragment_picture extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    public static PageFragment_picture newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment_picture pageFragment_picture = new PageFragment_picture();
        pageFragment_picture.setArguments(args);
        return pageFragment_picture;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        return view;
    }

}
