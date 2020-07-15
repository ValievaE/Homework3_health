package com.example.homework3_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    private ArrayList<Person> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextPersonName = findViewById(R.id.editTextPersonName);
        final EditText editTextAge = findViewById(R.id.editTextAge);
        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonWeight = findViewById(R.id.buttonWeight);
        Button buttonPressure = findViewById(R.id.buttonPressure);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "OnClick buttonSave");
                String name = editTextPersonName.getText().toString();
                String inputAge = editTextAge.getText().toString();

                if(name.isEmpty() || inputAge.isEmpty()){
                    Toast.makeText(MainActivity.this, getText(R.string.emptyfield), Toast.LENGTH_LONG).show();
                    return;
                }
                int age;
                try {
                    age = Integer.parseInt(inputAge);
                    if (age > 100) {
                        Toast.makeText(MainActivity.this, "Ошибка в поле Возраст", Toast.LENGTH_LONG).show();
                        editTextAge.getText().clear();
                        return;
                    }
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Неверный формат в поле Возраст", e);
                    editTextAge.getText().clear();
                    Toast.makeText(MainActivity.this, getText(R.string.errorformat), Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "ФИО " + name + " Возраст " + age, Toast.LENGTH_SHORT).show();
                Person person = new Person(name,age);
                list.add(person);
            }
        });

        buttonWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "OnClick buttonWeight");
                Intent intent = new Intent(MainActivity.this, ActivityWeight.class);
                startActivity(intent);

            }
        });
        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "OnClick buttonPressure");
                Intent intent = new Intent(MainActivity.this, ActivityPressure.class);
                startActivity(intent);
            }
        });


    }
}