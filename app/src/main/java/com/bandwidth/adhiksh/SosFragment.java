package com.bandwidth.adhiksh;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.valdesekamdem.library.mdtoast.MDToast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SosFragment extends Fragment {

//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference databaseSos = database.getReference("Sos");
    MaterialButton sosbt;


    public SosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sos, container, false);

        sosbt=view.findViewById(R.id.btn_sos);
        sosbt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), map.class));
                MDToast mdToast = MDToast.makeText(getActivity(), "Keep Calm!! We Are On Our Way To Help", 12000, 1);
                mdToast.show();

//                int lati=20,lngi=20;
//                String id = databaseSos.push().getKey();
//                String lat=String.valueOf(lati);
//                String lng=String.valueOf(lngi);
//
//
//                databaseSos.child("Id").setValue(id);
//                databaseSos.child("lat").setValue(lat);
//                databaseSos.child("lng").setValue(lng);

//                MDToast mdToast = MDToast.makeText(SosFragment.this, "Log out successful", 1000, 1);
//                mdToast.show();


                //myRef.setValue("demo", personalName);
            }

        });

        return view;

    }

}
