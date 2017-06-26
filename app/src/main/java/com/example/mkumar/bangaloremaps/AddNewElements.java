package com.example.mkumar.bangaloremaps;

import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class AddNewElements extends AppCompatActivity {

    public static String TAG = AddNewElements.class.getSimpleName();
    RadioButton radioShopping, radioTemples, radioVeg, radioNonVeg, radioPlacesToVisit;
    TextView shoppingTextView, templeTextView, vegTextView, nonVegTextView, placesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_elements);

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

       /* switch (radioButton.getId()) {

            case R.id.radioButtonShopping :
                radioShopping.setChecked(true);
                break;
            case R.id.radioButtonTemple:
                radioTemples.setChecked(true);
                break;
            case R.id.radioButtonVeg:
                radioVeg.setChecked(true);
                break;
            case  R.id.radioButtonNonVeg:
                radioNonVeg.setChecked(true);
                break;
        }*/

    }
}
