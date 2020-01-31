package com.bandwidth.adhiksh;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class FragmentNoc extends Fragment {

    RecyclerView recyclerView;
    List<NocModel> list;
    NocAdapter adapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Nocrequests");


    public FragmentNoc() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_noc, container, false);
        list = new ArrayList<>();
////        for (int i=0;i<10;i++){
////            AppModel model = new AppModel();
//////            model.setDate("11-12-19");
//////            model.setLar("123456789");
//////            model.setStatus("Approved");
////            model.setSubject("Burglary");
////            list.add(model);
//        }
        recyclerView = view.findViewById(R.id.rv_noc);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot nocSnapshot: dataSnapshot.getChildren()){

                    NocModel noc= nocSnapshot.getValue(NocModel.class);
                    list.add(noc);

                }
                adapter = new NocAdapter(getActivity(),list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
