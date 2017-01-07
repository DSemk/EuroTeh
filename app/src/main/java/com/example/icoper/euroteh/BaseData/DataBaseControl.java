package com.example.icoper.euroteh.BaseData;

import android.util.Log;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by icoper on 01.01.17.
 */

public class DataBaseControl {

    FirebaseDatabase database;
    DatabaseReference myRef;

    public DataBaseControl() {
        writeDataFB();
        readDataFB();
    }

    private void writeDataFB() {
        // Write a message to the database
//        database = FirebaseDatabase.getInstance();
//
//        myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
    }


    //Read from the database
    private void readDataFB() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("read", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("read", "Failed to read value.", error.toException());
            }
        });
    }
}
