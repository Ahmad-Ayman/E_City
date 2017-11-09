package com.freelancing.ahmed.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DataHandler> {
    private LayoutInflater inflater;
    private ItemClickCallBack itemClickCallBack;
    Context context;
    TripsDataProvider data;
    ArrayList<TripsDataProvider> tripDataProviders;
    public RecyclerViewAdapter(Activity context, ArrayList<TripsDataProvider> tripDataProviders) {

        this.context = context;
        this.tripDataProviders = tripDataProviders;
        this.inflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewAdapter.DataHandler onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.list_item,parent,false);

        Typeface myTypeface = Typeface.createFromAsset(v.getContext().getAssets(),"lalezar.ttf");
        TextView txt = (TextView) v.findViewById(R.id.list_text);
        txt.setTypeface(myTypeface);
        txt.setTextSize(20);
        txt.setGravity(Gravity.CENTER);
        TextView txt2 = (TextView) v.findViewById(R.id.list_text2);
        txt2.setTypeface(myTypeface);
        txt2.setTextSize(14);
        return new DataHandler(v);
    }
    @Override
    public void onBindViewHolder(DataHandler holder, int position) {
        data= tripDataProviders.get(position);

        holder.title.setText(data.getTitle());
        holder.shortD.setText(data.getShortD());
        holder.image.setImageBitmap(data.getImg_front());
      //  holder.image.setImageBitmap(ImageNicer.decodeSampledBitmapFromResource(context.getResources(),data.getImg_front(),100,100));


    }
    public void setItemClickCallBack (final ItemClickCallBack itemClickCallBack){
        this.itemClickCallBack=itemClickCallBack;
    }
    public interface ItemClickCallBack{
        void onItemClick(int p);
    }
    @Override
    public int getItemCount() {
        return tripDataProviders.size();
    }

     class DataHandler extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView title;
        TextView shortD;
        LinearLayout container;
        View row;

        public DataHandler(View itemView) {
            super(itemView);
            this.row=itemView;
            image=(ImageView) row.findViewById(R.id.imageView2);
            title=(TextView)row.findViewById(R.id.list_text);
            shortD = (TextView) row.findViewById(R.id.list_text2);
            container=(LinearLayout)row.findViewById(R.id.text_container);
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