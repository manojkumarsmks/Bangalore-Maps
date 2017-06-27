package com.example.mkumar.bangaloremaps;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingActivity extends AppCompatActivity{


    public static final String TAG = SettingActivity.class.getSimpleName();
    SeekBar areaRadiusSeekBar;
    TextView areaChangeTextView, shoppingTextView, templeTextView, vegTextView, nonVegTextView, placesTextView ;
    CheckBox checkBoxShopping, checkBoxTemple, checkBoxVeg, checkBoxNonVeg, checkBoxThingToDo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ActionBarInitialization();

        Initialization();

        SharedPreferencesDefault();

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

    private void ActionBarInitialization() {
        ActionBar action = getActionBar();
        setTitle("Setting");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.setting_action_bar, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_reset:
                ResetDefaultSetting();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void ResetDefaultSetting() {

        SharedPreferences resetSetting = getSharedPreferences("DefaultSetting", Context.MODE_PRIVATE);
       /* Log.d(TAG, "Distance is "+resetSetting.getInt("Distance",-1));
        Log.d(TAG, "Shopping is "+resetSetting.getBoolean("Shopping",false));
        Log.d(TAG, "Temples is "+resetSetting.getBoolean("Temples",false));
        Log.d(TAG, "Veg is "+resetSetting.getBoolean("Veg Restaurants",false));
        Log.d(TAG, "Non - Veg is "+resetSetting.getBoolean("Non-Veg Restaurants",false));
        Log.d(TAG, "Places to visit "+resetSetting.getBoolean("Places to Visit",false));*/

        areaRadiusSeekBar.setProgress(2);
        checkBoxShopping.setChecked(true);
        checkBoxTemple.setChecked(true);
        checkBoxVeg.setChecked(true);
        checkBoxNonVeg.setChecked(true);
        checkBoxThingToDo.setChecked(true);
    }

    private void SharedPreferencesDefault() {

        SharedPreferences defaultSetting = getSharedPreferences("DefaultSetting", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = defaultSetting.edit();
        editor.putInt("Distance", 30);
        editor.putBoolean("Shopping", true);
        editor.putBoolean("Temples", true);
        editor.putBoolean("Veg Restaurants", true);
        editor.putBoolean("Non-Veg Restaurants", true);
        editor.putBoolean("Places to Visit", true);

        editor.commit();

    }

    private void Initialization() {

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
    }
}
