package com.freelancing.ahmed.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdFragment extends Fragment {
    View rootView;
    AppDataCenter dataCenter;
    RecyclerViewAdapter itemsAdapter;
    RecyclerView clv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_layout,container, false);

        TextView txt = (TextView) rootView.findViewById(R.id.welcome);
        Typeface myTypeface = Typeface.createFromAsset(getActivity().getAssets(),"lalezar.ttf");
        txt.setTypeface(myTypeface);
        TextView txt2 = (TextView) rootView.findViewById(R.id.textView4);
        txt2.setTypeface(myTypeface);
        TextView txt3 = (TextView) rootView.findViewById(R.id.bestplaces);
        txt3.setTypeface(myTypeface);
        TextView txt4 = (TextView) rootView.findViewById(R.id.textView5);
        txt4.setTypeface(myTypeface);
        TextView txt5 = (TextView) rootView.findViewById(R.id.textView6);
        txt5.setTypeface(myTypeface);
        TextView txt6 = (TextView) rootView.findViewById(R.id.textView7);
        txt6.setTypeface(myTypeface);
        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}