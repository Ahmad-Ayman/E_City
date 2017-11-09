package com.freelancing.ahmed.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements RecyclerViewAdapter2.ItemClickCallBack {

    View rootView;
    AppDataCenter2 dataCenter;
    RecyclerViewAdapter2 itemsAdapter;
    RecyclerView clv;
    ArrayList<TripsDataProvider2> TD;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_layout,container, false);
        dataCenter = new AppDataCenter2(getActivity());
        TD = new ArrayList<TripsDataProvider2>();
        TD = dataCenter.getTripsItems();
        itemsAdapter = new RecyclerViewAdapter2(getActivity(),TD);
        clv = (RecyclerView) rootView.findViewById(R.id.clist);
        clv.setLayoutManager(new LinearLayoutManager(getActivity()));
        clv.setAdapter(itemsAdapter);
        itemsAdapter.setItemClickCallBack(this);


        return rootView;
    }
    public void onItemClick(int p) {
        Intent intent = new Intent(getActivity(),DataVieweer2.class);
        intent.putExtra("position",p);
        startActivity(intent);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}