package com.myapp.hackbanero.hackbanero;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.lang.reflect.Array;

public class CheckBoxActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerYellow);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.cities,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void selectFavAnimal(View view){
        boolean checked = ((CheckBox)view).isChecked();
        switch (view.getId()){
            case R.id.checkboxDog:
                showMessage(getResources().getString(R.string.perro),checked);
                break;
            case R.id.checkboxCat:
                showMessage(getResources().getString(R.string.gato),checked);
                break;
        }
    }

    private void showMessage(String animal, boolean like){
        String message;
        if(like) message = "Me gustan los "+animal;
        else message = "No me gustan los "+animal;
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    private void inicializar(){
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toogleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                } else {
                    // The toggle is disabled
                }
            }
        });

        Switch sw = (Switch) findViewById(R.id.switchButton);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        sw.isChecked();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] array = getResources().getStringArray(R.array.cities);
        String item = array[position];
        Toast.makeText(this,item,Toast.LENGTH_SHORT).show();
        if(position == 1){
            DialogFragment dp = new DatePickerFragment();
            dp.show(getSupportFragmentManager(),"DATEPICKER");
        }
        else if(position == 2){
            DialogFragment tp =new TimePickerFragment();
            tp.show(getSupportFragmentManager(),"TIMEPICKER");
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
