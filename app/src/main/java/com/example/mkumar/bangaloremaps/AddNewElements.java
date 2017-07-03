package com.example.mkumar.bangaloremaps;

import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.Map;

public class AddNewElements extends AppCompatActivity {

    public static final String TAG = AddNewElements.class.getSimpleName();
    public static final String FIREBASE_URL = BuildConfig.UNIQUE_FIREBASE_ROOT_URL;
    public static final String CANNOT_BE_EMPTY = "Cannot be empty";
    RadioButton radioShopping, radioTemples, radioVeg, radioNonVeg, radioPlacesToVisit;
    TextView shoppingTextView, templeTextView, vegTextView, nonVegTextView, placesTextView;
    TextInputLayout inputLayoutName, inputLatitude, inputLongitude;
    Button addButton;
    MapElements newMapElement;
    String currentCategory = "Shopping";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_elements);

        InitialView();
        Firebase.setAndroidContext(this);


        radioShopping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                if(checked) {

                    EvaluateAndChange(shoppingTextView, radioShopping);
                }

            }
        });

        radioTemples.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                if(checked) {

                    EvaluateAndChange(templeTextView, radioTemples);
                }
            }
        });

        radioVeg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                if(checked) {

                    EvaluateAndChange(vegTextView, radioVeg);
                }
            }
        });

        radioNonVeg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                if(checked) {

                    EvaluateAndChange(nonVegTextView, radioNonVeg);
                }
            }
        });

        radioPlacesToVisit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                if(checked) {

                    EvaluateAndChange(placesTextView, radioPlacesToVisit);
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ValidateAndPush();
            }
        });

    }

    private void ValidateAndPush() {

        Firebase ref = new Firebase(FIREBASE_URL);

        String tempCategory=null,
                tempName = null,
                tempLatitude = null,
                tempLongitude = null;

        if(!inputLayoutName.getEditText().getText().equals("")) {
            tempName = inputLayoutName.getEditText().getText().toString();
        }
        else {
            inputLayoutName.setError(CANNOT_BE_EMPTY);
        }

        if(!inputLatitude.getEditText().getText().equals("")) {
            tempLatitude = inputLatitude.getEditText().getText().toString();
        }
        else {
            inputLatitude.setError(CANNOT_BE_EMPTY);
        }

        if(!inputLongitude.getEditText().getText().equals("")) {
            tempLongitude = inputLongitude.getEditText().getText().toString();
        }
        else {
            inputLongitude.setError(CANNOT_BE_EMPTY);
        }
        tempCategory = currentCategory;

        newMapElement = new MapElements(tempName,
                Double.parseDouble(tempLatitude), Double.parseDouble(tempLongitude));


        ref.child(tempCategory).setValue(newMapElement);

        Log.d(TAG, "Clicked");


    }

    private void InitialView() {

        radioShopping = (RadioButton)findViewById(R.id.radioButtonShopping);
        radioTemples = (RadioButton)findViewById(R.id.radioButtonTemple);
        radioVeg = (RadioButton)findViewById(R.id.radioButtonVeg);
        radioNonVeg = (RadioButton)findViewById(R.id.radioButtonNonVeg);
        radioPlacesToVisit =(RadioButton)findViewById(R.id.radioButtonToDo);

        shoppingTextView = (TextView)findViewById(R.id.textViewShopping);
        templeTextView = (TextView)findViewById(R.id.textViewTemple);
        vegTextView = (TextView)findViewById(R.id.textViewVeg);
        nonVegTextView = (TextView)findViewById(R.id.textViewNonVeg);
        placesTextView = (TextView)findViewById(R.id.textViewThingToDo);

        inputLayoutName = (TextInputLayout)findViewById(R.id.inputLayoutName);
        inputLatitude = (TextInputLayout)findViewById(R.id.inputLatitude);
        inputLongitude = (TextInputLayout)findViewById(R.id.inputLongitude);

        addButton = (Button)findViewById(R.id.addButton);

    }


    private void EvaluateAndChange(TextView textView, RadioButton radioButton) {

        radioShopping.setChecked(false);
        radioTemples.setChecked(false);
        radioVeg.setChecked(false);
        radioNonVeg.setChecked(false);
        radioPlacesToVisit.setChecked(false);

        shoppingTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.TextColor));
        shoppingTextView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);

        templeTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.TextColor));
        templeTextView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);

        vegTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.TextColor));
        vegTextView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);

        nonVegTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.TextColor));
        nonVegTextView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);

        placesTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.TextColor));
        placesTextView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);


        textView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
        textView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

        radioButton.setChecked(true);
        currentCategory = textView.getText().toString();

    }
}
