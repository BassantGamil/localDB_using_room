package com.bassant.madarsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bassant.madarsoft.Model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText nameEdt, ageEdt, jobTitleEdt;
    Spinner genderSpinner;
    Button saveDataButton , getDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        nameEdt= findViewById(R.id.name_user_editText);
        ageEdt= findViewById(R.id.age_user_editText);
        jobTitleEdt= findViewById(R.id.job_title_user_editText);
        genderSpinner = findViewById(R.id.gender_user_spinner);
        saveDataButton = findViewById(R.id.save_data_user_button);
        getDataButton = findViewById(R.id.get_data_user_button);
       saveDataButton.setOnClickListener(view -> saveData());
       getDataButton.setOnClickListener(view -> getData());
        spinner();

    }

    private void saveData(){
        String name = nameEdt.getText().toString().trim();
        String age = ageEdt.getText().toString().trim();
        String jobTitle = jobTitleEdt.getText().toString().trim();
        String gender = genderSpinner.getSelectedItem().toString().trim();
        if(!name.isEmpty() && !age.isEmpty()  && !jobTitle.isEmpty()  && !gender.isEmpty() ){
            UserModel model = new UserModel();
            model.setName(name);
            model.setAge(age);
            model.setJobTitle(jobTitle);
            model.setGender(gender);
            DatabaseClass.getDatabase(getApplicationContext()).getDao().insertData(model);
                Log.i("SHOW"  , model.getName());

        nameEdt.setText("");
        ageEdt.setText("");
        jobTitleEdt.setText("");

            Toast.makeText(this ,"Data saved successfully ",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this ,"All fields are required",Toast.LENGTH_LONG).show();
        }
    }

    private void getData() {
        startActivity(new Intent(getApplicationContext(), GetData.class));
    }
    private void spinner() {
        genderSpinner.setOnItemSelectedListener(this);
        List<String> gender = new ArrayList<>();
        gender.add(getString(R.string.male));
        gender.add(getString(R.string.female));
        ArrayAdapter genderList = new ArrayAdapter(this, R.layout.spinner_item, gender);
        genderList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderList);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}