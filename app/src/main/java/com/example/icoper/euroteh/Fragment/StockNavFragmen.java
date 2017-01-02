package com.example.icoper.euroteh.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.icoper.euroteh.R;

/**
 * Created by icoper on 01.01.17.
 */

public class StockNavFragmen extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.in_stock_category_list,container,false);

        return view;
    }
}
