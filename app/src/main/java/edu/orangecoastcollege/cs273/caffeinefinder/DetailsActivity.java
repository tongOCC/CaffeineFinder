package edu.orangecoastcollege.cs273.caffeinefinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
private TextView nameofLocationTextView;
    private TextView AddressTextView;
    private TextView PhoneNumberTextView;
    private TextView CoordinatesTextVIew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameofLocationTextView=(TextView) findViewById(R.id.nameOfLocation);
        AddressTextView= (TextView) findViewById(R.id.AddressOfLocation);
        PhoneNumberTextView= (TextView) findViewById(R.id.phoneNumber);
        CoordinatesTextVIew= (TextView) findViewById(R.id.Coordinates);


        Location location= getIntent().getExtras()
                .getParcelable("selectedLocation");

        String lat=String.valueOf(location.getLatitude());
        String longitude= String.valueOf(location.getLongitude());

        nameofLocationTextView.setText(location.getName());
        AddressTextView.setText(location.getFullAddress());
        if(location.getLongitude()<0)
            lat+=" N ";
        else
            lat+=" S ";
        if(location.getLatitude()<0)
            longitude+=" E ";
        else
            longitude+=" W ";
        CoordinatesTextVIew.setText(lat+longitude);

        PhoneNumberTextView.setText(location.getPhone());

    }
}
