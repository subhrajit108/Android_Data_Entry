package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private EditText name;
    private EditText dept;
    private EditText phone;
    private EditText roll;
    private Switch gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        name = findViewById(R.id.main_name_et);
        dept = findViewById(R.id.main_dept_et);
        phone = findViewById(R.id.main_phone_et);
        roll = findViewById(R.id.main_roll_et);
        gender =findViewById(R.id.switch1);
    }

    public void onSubmitPressed(View view){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        try {
            MyPerson person = realm.createObject(MyPerson.class, System.currentTimeMillis() / 1000);
            person.setName(name.getText().toString());
            person.setDept(dept.getText().toString());
            person.setPhone(phone.getText().toString());
            person.setRoll(Integer.parseInt(roll.getText().toString()));
            if(gender.isChecked())
                person.setGender("Female");
            else
                person.setGender("Male");
            realm.commitTransaction();
            Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex){
            realm.cancelTransaction();
            Toast.makeText(mContext, "Failure" + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    public void onDisplayButtonPressed(View view){
        Intent intent = new Intent(this,DisplayActivity.class);
        startActivity(intent);
    }
}
