package com.example.homework3_health;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ActivityPressure extends AppCompatActivity {
    private final static String TAG = "ActivityPressure";

    private ArrayList<Pressure> listPressure = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        final EditText topPressure = findViewById(R.id.topPressure);
        final EditText lowerPressure = findViewById(R.id.lowerPressure);
        final EditText editTextPulse = findViewById(R.id.pulse);
        final TextView textViewDate = findViewById(R.id.dateTime);
        Button buttonSavePressure = findViewById(R.id.buttonSavePressure);
        final CheckBox checkBox = findViewById(R.id.checkBox);
        buttonSavePressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "OnClick buttonSavePressure");
                String topPress = topPressure.getText().toString();
                String lowerPress = lowerPressure.getText().toString();
                String pulse = editTextPulse.getText().toString();

                if(topPress.isEmpty() || lowerPress.isEmpty() || pulse.isEmpty() ){
                    Toast.makeText(ActivityPressure.this, getText(R.string.emptyfield), Toast.LENGTH_LONG).show();
                    return;
                }
                int tp;
                int lp;
                int p;

                try {
                    tp = Integer.parseInt(topPress);
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Неверный формат", e);
                    topPressure.getText().clear();
                    Toast.makeText(ActivityPressure.this, getText(R.string.errorformat), Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    lp = Integer.parseInt(lowerPress);
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Неверный формат", e);
                    lowerPressure.getText().toString();
                    Toast.makeText(ActivityPressure.this, getText(R.string.errorformat), Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    p = Integer.parseInt(pulse);
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Неверный формат", e);
                    editTextPulse.getText().toString();
                    Toast.makeText(ActivityPressure.this, getText(R.string.errorformat), Toast.LENGTH_LONG).show();
                    return;
                }
                if (p > 100){
                  checkBox.setChecked(true);
                  Toast.makeText(ActivityPressure.this, "Обратите внимание на тахикардию!", Toast.LENGTH_SHORT).show();
                } else checkBox.setChecked(false);

                Toast.makeText(ActivityPressure.this, "Данные сохранены:" + "\n" + "Верхнее давление: " + tp +"\n" + "Нижнее давление: " + lp  +"\n" + "Пульс: " + p,  Toast.LENGTH_LONG).show();

                Calendar calendar = Calendar.getInstance();
                Date date = calendar.getTime();
                textViewDate.setText(date.toString());
                Pressure pressure = new Pressure(tp, lp, p, date);
                listPressure.add(pressure);
            }
        });

    }
}