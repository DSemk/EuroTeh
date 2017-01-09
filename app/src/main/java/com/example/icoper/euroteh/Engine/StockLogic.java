package com.example.icoper.euroteh.Engine;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.icoper.euroteh.ModelsFB.StockListFullCardModel;

import com.example.icoper.euroteh.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by samik on 07.01.2017.
 */

public class StockLogic {
    public static final String CHILD_NAME = "";
    private Context mContext;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private DatabaseReference mDatabaseReference;
    private FirebaseRecyclerAdapter<StockListFullCardModel, StockFullViewHolder> modelFBStockListAdapter;

    public void onCreate(final View view, Context context) {
        this.mContext = context;

        mRecyclerView = (RecyclerView) view.findViewById(R.id.in_stock_RV);
        mLayoutManager = new LinearLayoutManager(mContext);
        mLayoutManager.setStackFromEnd(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        modelFBStockListAdapter = new FirebaseRecyclerAdapter<StockListFullCardModel, StockFullViewHolder>(
                StockListFullCardModel.class,
                R.layout.in_stock_category_full_card,
                StockFullViewHolder.class,
                mDatabaseReference.child(CHILD_NAME)
        ) {
            @Override
            protected void populateViewHolder(StockFullViewHolder viewHolder, StockListFullCardModel model, int position) {
                viewHolder.itemNameFC.setText("ERROR");
                viewHolder.itemNameFC.setText(model.getName());
                viewHolder.gPriceFC.setText(model.getGprice());
                viewHolder.infoFC.setText(model.getInfo());
                viewHolder.priceFC.setText(model.getPrice());
            }
        };

        Toast.makeText(context,"Stock Fragment",Toast.LENGTH_SHORT).show();

    }

    public static class StockFullViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameFC;
        TextView priceFC;
        TextView gPriceFC;
        TextView infoFC;

        public StockFullViewHolder(View view) {
            super(view);
            itemNameFC = (TextView) view.findViewById(R.id.full_card_itemName_tv);
            priceFC = (TextView) view.findViewById(R.id.full_card_itemPrice_tv);
            gPriceFC = (TextView) view.findViewById(R.id.full_card_itemGPrice_tv);
            infoFC = (TextView) view.findViewById(R.id.full_card_itemInfo_tv);
        }
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
