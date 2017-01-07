package com.example.icoper.euroteh.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.icoper.euroteh.Engine.StockLogic;
import com.example.icoper.euroteh.MainActivity;
import com.example.icoper.euroteh.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by icoper on 01.01.17.
 */

public class StockNavFragmen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.in_stock_content, container, false);
        new StockLogic().onCreate(view, MainActivity.getMaContext());

        return view;
    }


}
