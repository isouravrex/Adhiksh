package com.bandwidth.adhiksh.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bandwidth.adhiksh.model.AppModel;
import com.bandwidth.adhiksh.R;
import com.bandwidth.adhiksh.adapter.FirAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFir extends Fragment {

    RecyclerView recyclerView;
    List<AppModel> list;
    FirAdapter adapter;



    public FragmentFir() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_fir, container, false);

        list = new ArrayList<>();
        for(int i=0;i<10;i++){
            AppModel model = new AppModel();
//            model.setDate("11-12-19");
//            model.setLar("123456789");
//            model.setStatus("Approved");
            model.setSubject("Burglary");
            list.add(model);
        }
        recyclerView = view.findViewById(R.id.rv_fir);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        adapter = new FirAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

        return view;


    }

}
