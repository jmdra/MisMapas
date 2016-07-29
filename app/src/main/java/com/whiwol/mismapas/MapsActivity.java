package com.whiwol.mismapas;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static int puntoInteres;
    public static String titulo;
    public static String snippet;
    public static LatLng marcador = new LatLng(20.556598565201107, -100.8448149397675);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Bundle parametros = getIntent().getExtras();

        puntoInteres = parametros.getInt("locacion");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);

        LatLng celaya = new LatLng(20.556598565201107, -100.8448149397675);

        LatLng estadioCelaya = new LatLng(20.534860401905753, -100.81870736887663);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        switch (puntoInteres){
            case 1:
                marcador = new LatLng(20.534860401905753, -100.81870736887663);
                titulo = getResources().getString(R.string.titulo_estadio);
                snippet = getResources().getString(R.string.snippet_estadio);
                break;
            case 2:
                marcador = new LatLng(20.536056998622833, -100.82857239552992);
                titulo = getResources().getString(R.string.titulo_auditorio);
                snippet = getResources().getString(R.string.snippet_auditorio);
                break;
            case 3:
                marcador = new LatLng(20.527605187789735, -100.8106794709862);
                titulo = getResources().getString(R.string.titulo_alameda);
                snippet = getResources().getString(R.string.snippet_alameda);
                break;
            case 4:
                marcador = new LatLng(20.521806624035502, -100.81402811714666);
                titulo = getResources().getString(R.string.titulo_centro);
                snippet = getResources().getString(R.string.snippet_centro);
                break;
        }


        mMap.setMyLocationEnabled(true);
        mMap.addMarker(new MarkerOptions().position(marcador).title(titulo).snippet(snippet));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marcador, 13));

    }
}
