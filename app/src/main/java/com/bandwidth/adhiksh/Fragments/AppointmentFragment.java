package com.bandwidth.adhiksh.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bandwidth.adhiksh.AppointmentAdapter;
import com.bandwidth.adhiksh.ComplaintAdapter;
import com.bandwidth.adhiksh.Model;
import com.bandwidth.adhiksh.R;
import com.bandwidth.adhiksh.AppModel;
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
public class AppointmentFragment extends Fragment {

    RecyclerView recyclerView;
    List<AppModel> list;
    AppointmentAdapter adapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Appointments");

    private static final String TAG = "AppointmentFragment";

    public AppointmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_appointment, container, false);

        list = new ArrayList<>();
        recyclerView = view.findViewById(R.id.appointment_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        adapter = new AppointmentAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

//        getDataFromDB();
        return  view;
    }

    @Override
    public void onStart() {
        super.onStart();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot appointmentSnapshot: dataSnapshot.getChildren()){

                    AppModel appointment= appointmentSnapshot.getValue(AppModel.class);
                    list.add(appointment);

                }
                adapter = new AppointmentAdapter(getActivity(),list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
