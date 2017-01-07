package com.example.icoper.euroteh.Engine;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.icoper.euroteh.BaseData.ItemModelFB;
import com.example.icoper.euroteh.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by samik on 07.01.2017.
 */

public class StockLogic {
    public static final String CHILD_NAME = "notebooks";
    private Context mContext;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private DatabaseReference mDatabaseReference;
    private FirebaseRecyclerAdapter<ItemModelFB, StockListViewHolder> modelFBStockListAdapter;

    public void onCreate(View view, Context context) {
        this.mContext = context;
        mRecyclerView = (RecyclerView) view.findViewById(R.id.in_stock_RV);
        mLayoutManager = new LinearLayoutManager(mContext);
        mLayoutManager.setStackFromEnd(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        modelFBStockListAdapter = new FirebaseRecyclerAdapter<ItemModelFB, StockListViewHolder>(
                ItemModelFB.class,
                R.layout.in_stock_category_list,
                StockListViewHolder.class,
                mDatabaseReference.child(CHILD_NAME)
        ) {
            @Override
            protected void populateViewHolder(StockListViewHolder viewHolder, ItemModelFB model, int position) {
                viewHolder.itemName.setText(model.getName());
            }
        };

        modelFBStockListAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                int count = modelFBStockListAdapter.getItemCount();
                int lastVisiblePosition = mLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisiblePosition == -1 || (positionStart >= (count - 1) && lastVisiblePosition == (positionStart - 1))) {
                    mRecyclerView.scrollToPosition(positionStart);
                }
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(modelFBStockListAdapter);
            }
        });
    }

    public static class StockListViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;

        public StockListViewHolder(View view) {
            super(view);
            itemName = (TextView) view.findViewById(R.id.list_category_name_tv);
        }
    }

    public static class StockSmallViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImg;
        TextView itemName;
        TextView itemPrice;

        public StockSmallViewHolder(View view) {
            super(view);
            itemImg = (ImageView) view.findViewById(R.id.small_card_iv);
            itemName = (TextView) view.findViewById(R.id.small_card_item_name_tv);
            itemPrice = (TextView) view.findViewById(R.id.small_card_item_price_tv);
        }
    }
}
