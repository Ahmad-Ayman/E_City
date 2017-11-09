package com.freelancing.ahmed.myapplication;
        import android.content.Intent;
        import android.graphics.Typeface;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.ArrayList;
public class SecondFragment extends Fragment implements RecyclerViewAdapter.ItemClickCallBack {
    View rootView;
    AppDataCenter dataCenter;
    RecyclerViewAdapter itemsAdapter;
    RecyclerView clv;
    ArrayList<TripsDataProvider> TD;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_layout,container, false);
        dataCenter = new AppDataCenter(getActivity());
        TD = new ArrayList<TripsDataProvider>();
        TD = dataCenter.getTripsItems();
        itemsAdapter = new RecyclerViewAdapter(getActivity(),TD);
        clv = (RecyclerView) rootView.findViewById(R.id.clist);
        clv.setLayoutManager(new LinearLayoutManager(getActivity()));
        clv.setAdapter(itemsAdapter);
        itemsAdapter.setItemClickCallBack(this);


        return rootView;
    }

    @Override
    public void onItemClick(int p) {
        Intent intent = new Intent(getActivity(),DataVieweer.class);
        intent.putExtra("position",p);
        startActivity(intent);
    }


}