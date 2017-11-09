package com.freelancing.ahmed.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahmed on 9/8/2017.
 */

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.DataHandler2> {

    private LayoutInflater inflater;
    private RecyclerViewAdapter2.ItemClickCallBack itemClickCallBack;
    Context context;
    TripsDataProvider2 data;
    ArrayList<TripsDataProvider2> tripDataProviders;

    public RecyclerViewAdapter2(Activity context, ArrayList<TripsDataProvider2> tripDataProviders) {

        this.context = context;
        this.tripDataProviders = tripDataProviders;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewAdapter2.DataHandler2 onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.list_item2, parent, false);

        Typeface myTypeface = Typeface.createFromAsset(v.getContext().getAssets(), "lalezar.ttf");
        TextView txt = (TextView) v.findViewById(R.id.list_text);
        txt.setTypeface(myTypeface);
        txt.setTextSize(20);
        txt.setGravity(Gravity.CENTER);

       // LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
       // llp.setMargins(50, 0, 0, 0); // llp.setMargins(left, top, right, bottom);
        //txt.setLayoutParams(llp);

        return new RecyclerViewAdapter2.DataHandler2(v);
    }

    @Override
    public void onBindViewHolder(DataHandler2 holder, int position) {
        data = tripDataProviders.get(position);

        holder.title.setText(data.getTitle());
       // holder.shortD.setText(data.getShortD());
        holder.image.setImageBitmap(data.getImg_front());
    }

    public void setItemClickCallBack(final RecyclerViewAdapter2.ItemClickCallBack itemClickCallBack) {
        this.itemClickCallBack = itemClickCallBack;
    }

    public interface ItemClickCallBack {
        void onItemClick(int p);
    }

    @Override
    public int getItemCount() {
        return tripDataProviders.size();
    }

    class DataHandler2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView title;
       // TextView shortD;
        LinearLayout container;
        View row;

        public DataHandler2(View itemView) {
            super(itemView);
            this.row = itemView;
            image = (ImageView) row.findViewById(R.id.imageView2);
            title = (TextView) row.findViewById(R.id.list_text);
           // shortD = (TextView) row.findViewById(R.id.list_text2);
            container = (LinearLayout) row.findViewById(R.id.text_container);
            container.setOnClickListener(this);

        }

        public View getRow() {
            return row;
        }

        @Override
        public void onClick(View v) {
            itemClickCallBack.onItemClick(getAdapterPosition());
        }
    }
}