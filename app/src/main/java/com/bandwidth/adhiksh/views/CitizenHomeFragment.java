package com.bandwidth.adhiksh.views;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bandwidth.adhiksh.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CitizenHomeFragment extends Fragment {

    LinearLayout registerFIR, requestNOC, registerComplaint, requestAppointment;
    Layout inc;



    public CitizenHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_citizen_home, container, false);

        registerFIR=view.findViewById(R.id.registerFIR);
        registerComplaint=view.findViewById(R.id.registerComplaint);
        requestAppointment=view.findViewById(R.id.requestAppointment);
        requestNOC=view.findViewById(R.id.requestNOC);


        registerFIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FirForm.class));
            }
        });

        registerComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ComplaintForm.class));
            }
        });

        requestAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AppointmentForm.class));
            }
        });

        requestNOC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NOCForm.class));
            }
        });
    return view;
    }


}
