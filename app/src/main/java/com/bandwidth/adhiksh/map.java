package com.bandwidth.adhiksh;//package com.bandwidth.adhiksh;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//public class map extends AppCompatActivity {
//
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("Sos");
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_map);
//
//
//
//    }
//
//    private void setDatabase(){
//
////        DatabaseReference myRef = database.getReference("Appointments").child(id);
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//
//                String sosId=dataSnapshot.child("Id").getValue().toString();
//                String lat=dataSnapshot.child("lat").getValue().toString();
//                String lng=dataSnapshot.child("lng").getValue().toString();
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//    }
//}

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bandwidth.adhiksh.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.valdesekamdem.library.mdtoast.MDToast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import static com.bandwidth.adhiksh.MainActivity.b;

public class map extends FragmentActivity implements OnMapReadyCallback {
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseSos = database.getReference("Sos");
    MaterialButton info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLocation();
        setUIViews();
        if(b==true){
            info.setVisibility(View.INVISIBLE);
        }

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(map.this, AuthorityPanel.class));

            }
        });

    }

    private void fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
//                    Toast.makeText(getApplicationContext(), currentLocation.getLatitude() + "" + currentLocation.getLongitude(), Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.myMap);
                    assert supportMapFragment != null;
                    supportMapFragment.getMapAsync(map.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
//        double l1 = 28.7041, l2 = 77.1025;
        final LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Live Location!");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));
        googleMap.addMarker(markerOptions);
        String id = databaseSos.push().getKey();
        String lat=String.valueOf(currentLocation.getLatitude());
        String lng=String.valueOf( currentLocation.getLongitude());
        databaseSos.child("Id").setValue(id);
        databaseSos.child("lat").setValue(lat);
        databaseSos.child("lng").setValue(lng);
        if(b==false) {
            databaseSos.addValueEventListener(new ValueEventListener() {
                            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String sosId=dataSnapshot.child("Id").getValue().toString();
                String late=dataSnapshot.child("lat").getValue().toString();
                String lnge=dataSnapshot.child("lng").getValue().toString();
                                double lati=Double.parseDouble(late);
                                double lngi=Double.parseDouble(lnge);
//
                                LatLng latLng2 = new LatLng(lati, lngi);
                                MarkerOptions markerOptions2 = new MarkerOptions().position(latLng2).title("SOS!!! Reach For Help");
                                googleMap.addMarker(markerOptions2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));




                            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocation();
                }
                break;
        }
    }
    public void setUIViews(){
        info=findViewById(R.id.btn_info);
    }
}