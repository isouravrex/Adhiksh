package com.bandwidth.adhiksh.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bandwidth.adhiksh.adapter.ComplaintAdapter;
import com.bandwidth.adhiksh.model.Model;
import com.bandwidth.adhiksh.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComplaintFragment extends Fragment {

    RecyclerView recyclerView;
    List<Model> list;
    ComplaintAdapter adapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Complaints");


    public ComplaintFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_complaint, container, false);

        list = new ArrayList<>();
//        for(int i=0;i<10;i++){
//            Model model = new Model();
////            model.setDate("11-12-19");
////            model.setLar("123456789");
////            model.setStatus("Approved");
//            model.setSubject("Burglary");
//            list.add(model);
//        }
        recyclerView = view.findViewById(R.id.rv_compaint);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));


        return view;

    }

    @Override
    public void onStart() {
        super.onStart();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot complaintSnapshot: dataSnapshot.getChildren()){

                    Model complaint= complaintSnapshot.getValue(Model.class);
                    list.add(complaint);

                }
                adapter = new ComplaintAdapter(getActivity(), list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
