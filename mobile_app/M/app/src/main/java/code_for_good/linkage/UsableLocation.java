package code_for_good.linkage;

/**
 * Created by dimarammfire on 18.11.17.
 */
import android.Manifest;
import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.test.mock.MockPackageManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.Locale;

import static android.content.ContentValues.TAG;

public class UsableLocation extends Activity {

    Button btnShowLocation;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
//    private FusedLocationProviderClient mFusedLocationClient;
//    private LocationManager manager;

    GPSLocation gps;

//    protected Location mLastLocation;
//
//    private String mLatitudeLabel;
//    private String mLongitudeLabel;
//    private TextView mLatitudeText;
//    private TextView mLongitudeText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);
//
//        mLatitudeLabel = getResources().getString(R.string.latitude_label);
//        mLongitudeLabel = getResources().getString(R.string.longitude_label);
//        mLatitudeText = (TextView) findViewById((R.id.latitude_text));
//        mLongitudeText = (TextView) findViewById((R.id.longitude_text));
//
//        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
//    }
//
//    public void onStart() {
//        super.onStart();
//        getLastLocation();
//    }
//
//    private void getLastLocation() {
//        mFusedLocationClient.getLastLocation()
//                .addOnCompleteListener(this, new OnCompleteListener<Location>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Location> task) {
//                        if (task.isSuccessful() && task.getResult() != null) {
//                            mLastLocation = task.getResult();
//                            mLatitudeText.setText(String.format(Locale.ENGLISH, "%s: %f",
//                                    mLatitudeLabel,
//                                    mLastLocation.getLatitude()));
//                            mLongitudeText.setText(String.format(Locale.ENGLISH, "%s: %f",
//                                    mLongitudeLabel,
//                                    mLastLocation.getLongitude()));
//                        } else {
//                            Log.w(TAG, "getLastLocation:exception", task.getException());
//                        }
//                    }
//                });
//    }

        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != MockPackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        btnShowLocation = (Button) findViewById(R.id.button);

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // create class object
                gps = new GPSLocation(UsableLocation.this);

                // check if GPS enabled
                if(gps.canGetLocation()) {

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: "
                            + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }
                else {
                    // can't get location
                    // GPS or Network is not enabled
                    gps.showSettingsAlert();
                }

            }
        });
    }
}

