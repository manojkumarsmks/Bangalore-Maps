package com.example.mkumar.bangaloremaps;

import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingActivity extends AppCompatActivity {

    public static final String TAG = SettingActivity.class.getSimpleName();
    SeekBar areaRadiusSeekBar;
    TextView areaChangeTextView, shoppingTextView, templeTextView, vegTextView, nonVegTextView, placesTextView ;
    CheckBox checkBoxShopping, checkBoxTemple, checkBoxVeg, checkBoxNonVeg, checkBoxThingToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle("Filter Interests");

        areaRadiusSeekBar = (SeekBar)findViewById(R.id.areaRadiusSeekBar);
        areaChangeTextView = (TextView)findViewById(R.id.areaRadiusTextView);

        checkBoxShopping = (CheckBox)findViewById(R.id.checkBoxShopping);
        checkBoxTemple = (CheckBox)findViewById(R.id.checkBoxTemple);
        checkBoxVeg = (CheckBox)findViewById(R.id.checkBoxVeg);
        checkBoxNonVeg = (CheckBox)findViewById(R.id.checkBoxNonVeg);
        checkBoxThingToDo = (CheckBox)findViewById(R.id.checkBoxThingToDo);


        shoppingTextView = (TextView)findViewById(R.id.textViewShopping);
        templeTextView = (TextView)findViewById(R.id.textViewTemple);
        vegTextView = (TextView)findViewById(R.id.textViewVeg);
        nonVegTextView = (TextView)findViewById(R.id.textViewNonVeg);
        placesTextView = (TextView)findViewById(R.id.textViewThingToDo);

        //areaRadiusSeekBar.setMax();
        areaRadiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                String distanceRadius = Integer.toString(10 * (progress+1));
                if(distanceRadius.equals("50")) {
                    distanceRadius = "Maximum";
                }
                else {
                    distanceRadius = distanceRadius + " kms";
                }

                areaChangeTextView.setText(distanceRadius);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        checkBoxShopping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean clickStatus) {
                if(clickStatus) {
                    shoppingTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
                    shoppingTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

                }
                else {
                    shoppingTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.TextColor));
                    shoppingTextView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                }
            }
        });

        checkBoxTemple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean clickStatus) {
                if(clickStatus) {
                    templeTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
                    templeTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

                }
                else {
                    templeTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.TextColor));
                    templeTextView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                }
            }
        });

        checkBoxVeg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean clickStatus) {
                if(clickStatus) {
                    vegTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
                    vegTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

                }
                else {
                    vegTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.TextColor));
                    vegTextView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                }
            }
        });

        checkBoxNonVeg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean clickStatus) {
                if(clickStatus) {
                    nonVegTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
                    nonVegTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

                }
                else {
                    nonVegTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.TextColor));
                    nonVegTextView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                }
            }
        });

        checkBoxThingToDo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean clickStatus) {
                if(clickStatus) {
                    placesTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
                    placesTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

                }
                else {
                    placesTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.TextColor));
                    placesTextView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                }
            }
        });




    }
}
