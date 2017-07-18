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
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingActivity extends AppCompatActivity{

    public static final String TAG = SettingActivity.class.getSimpleName();
    public static final String SHARED_PREF_DISTANCE = "Distance";
    public static final String SHARED_PREF_SHOPPING ="Shopping";
    public static final String SHARED_PREF_TEMPLES = "Temples";
    public static final String SHARED_PREF_VEG_RESTAURANTS  = "Veg Restaurants";
    public static final String SHARED_PREF_NON_VEG_RESTAURANTS = "Non-Veg Restaurants";
    public static final String SHARED_PREF_PLACES_TO_VISIT = "Places to Visit";
    public static final String SHARED_PREF_DEFAULT_SETTING ="Default Settings";
    public static final String SHARED_PREF_CUSTOM_SETTING ="Custom Setting";

    SeekBar areaRadiusSeekBar;
    TextView areaChangeTextView, shoppingTextView, templeTextView, vegTextView, nonVegTextView, placesTextView ;
    CheckBox checkBoxShopping, checkBoxTemple, checkBoxVeg, checkBoxNonVeg, checkBoxThingToDo;
    Button settingApply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ActionBarInitialization();

        Initialization();

        SharedPreferencesDefault();

        GetBackSavedSetting();

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

        settingApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customSettingApply();

                finish();
            }
        });
    }



    private void GetBackSavedSetting() {

        SharedPreferences getSavedSetting = getSharedPreferences(SHARED_PREF_DEFAULT_SETTING, Context.MODE_PRIVATE);

        Log.d(TAG, "Value stored "+getSavedSetting.getBoolean(SHARED_PREF_CUSTOM_SETTING,true));
        if(getSavedSetting.getBoolean(SHARED_PREF_CUSTOM_SETTING,false)) {
            SharedPreferences getCustomSetting = getSharedPreferences(SHARED_PREF_CUSTOM_SETTING, Context.MODE_PRIVATE);
            Log.d(TAG, String.valueOf(getCustomSetting.getInt(SHARED_PREF_DISTANCE, -1)));
            Log.d(TAG, "Shopping is "+getCustomSetting.getBoolean("Shopping",false));
            Log.d(TAG, "Temples is "+getCustomSetting.getBoolean("Temples",false));
            Log.d(TAG, "Veg is "+getCustomSetting.getBoolean("Veg Restaurants",false));
            Log.d(TAG, "Non - Veg is "+getCustomSetting.getBoolean("Non-Veg Restaurants",false));
            Log.d(TAG, "Places to visit "+getCustomSetting.getBoolean("Places to Visit",false));
        }
        else {

            ResetDefaultSetting();
        }



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

        SharedPreferences resetSetting = getSharedPreferences(SHARED_PREF_DEFAULT_SETTING, Context.MODE_PRIVATE);
       /* Log.d(TAG, "Distance is "+resetSetting.getInt("Distance",-1));
        Log.d(TAG, "Shopping is "+resetSetting.getBoolean("Shopping",false));
        Log.d(TAG, "Temples is "+resetSetting.getBoolean("Temples",false));
        Log.d(TAG, "Veg is "+resetSetting.getBoolean("Veg Restaurants",false));
        Log.d(TAG, "Non - Veg is "+resetSetting.getBoolean("Non-Veg Restaurants",false));
        Log.d(TAG, "Places to visit "+resetSetting.getBoolean("Places to Visit",false));*/

        areaRadiusSeekBar.setProgress(resetSetting.getInt(SHARED_PREF_DISTANCE,-1));
        checkBoxShopping.setChecked(resetSetting.getBoolean(SHARED_PREF_SHOPPING,false));
        checkBoxTemple.setChecked(resetSetting.getBoolean(SHARED_PREF_TEMPLES,false));
        checkBoxVeg.setChecked(resetSetting.getBoolean(SHARED_PREF_VEG_RESTAURANTS,false));
        checkBoxNonVeg.setChecked(resetSetting.getBoolean(SHARED_PREF_NON_VEG_RESTAURANTS,false));
        checkBoxThingToDo.setChecked(resetSetting.getBoolean(SHARED_PREF_PLACES_TO_VISIT,false));
    }

    private void SharedPreferencesDefault() {

        SharedPreferences defaultSetting = getSharedPreferences(SHARED_PREF_DEFAULT_SETTING, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = defaultSetting.edit();
        editor.putInt(SHARED_PREF_DISTANCE, 2);
        editor.putBoolean(SHARED_PREF_SHOPPING, true);
        editor.putBoolean(SHARED_PREF_TEMPLES, true);
        editor.putBoolean(SHARED_PREF_VEG_RESTAURANTS, true);
        editor.putBoolean(SHARED_PREF_NON_VEG_RESTAURANTS, true);
        editor.putBoolean(SHARED_PREF_PLACES_TO_VISIT, true);
        editor.putBoolean(SHARED_PREF_CUSTOM_SETTING, false);

        editor.commit();

    }

    private void customSettingApply() {
        SharedPreferences customSetting = getSharedPreferences(SHARED_PREF_CUSTOM_SETTING, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = customSetting.edit();

        //Log.d(TAG, String.valueOf(areaRadiusSeekBar.getProgress()));
        editor.putInt(SHARED_PREF_DISTANCE, areaRadiusSeekBar.getProgress());
        editor.putBoolean(SHARED_PREF_SHOPPING, checkBoxShopping.isChecked());
        editor.putBoolean(SHARED_PREF_TEMPLES, checkBoxTemple.isChecked());
        editor.putBoolean(SHARED_PREF_VEG_RESTAURANTS, checkBoxVeg.isChecked());
        editor.putBoolean(SHARED_PREF_NON_VEG_RESTAURANTS, checkBoxNonVeg.isChecked());
        editor.putBoolean(SHARED_PREF_PLACES_TO_VISIT, checkBoxThingToDo.isChecked());
        editor.commit();

        //
        SharedPreferences defaultSetting = getSharedPreferences(SHARED_PREF_DEFAULT_SETTING, Context.MODE_PRIVATE);
        SharedPreferences.Editor defaultEditor = defaultSetting.edit();
        defaultEditor.putBoolean(SHARED_PREF_CUSTOM_SETTING, true);
        defaultEditor.commit();



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

        settingApply = (Button)findViewById(R.id.settingButton);


        //Initializing the
        checkBoxShopping.setChecked(true);
        checkBoxTemple.setChecked(true);
        checkBoxVeg.setChecked(true);
        checkBoxNonVeg.setChecked(true);
        checkBoxThingToDo.setChecked(true);

        shoppingTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
        shoppingTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

        templeTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
        templeTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

        vegTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
        vegTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

        nonVegTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
        nonVegTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

        placesTextView.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
        placesTextView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

    }
}
