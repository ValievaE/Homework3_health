package com.example.homework3_health;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityWeight extends AppCompatActivity {
    private final static String TAG = "ActivityWeight";

    private ArrayList<Weight> listWeight = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        final EditText weight = findViewById(R.id.weight);
        final EditText foots = findViewById(R.id.foots);
        Button buttonSaveWeight = findViewById(R.id.buttonSaveWeight);
        buttonSaveWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "OnClick buttonSaveWeight");
                String w = weight.getText().toString();
                String f = foots.getText().toString();

                if(w.isEmpty() || f.isEmpty()){
                    Toast.makeText(ActivityWeight.this, getText(R.string.emptyfield), Toast.LENGTH_LONG).show();
                    return;
                }

                double weightDouble;
                try {
                    weightDouble = Double.parseDouble(w);
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Неверный формат ввода", e);
                    weight.getText().clear();
                    Toast.makeText(ActivityWeight.this, getText(R.string.errorformat), Toast.LENGTH_LONG).show();
                    return;
                }

                int footsInt;
                try {
                    footsInt = Integer.parseInt(f);
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Неверный формат ввода", e);
                    foots.getText().clear();
                    Toast.makeText(ActivityWeight.this, getText(R.string.errorformat), Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(ActivityWeight.this, "Вес " + weightDouble + " Кол-во шагов " + footsInt, Toast.LENGTH_SHORT).show();

                Weight weightfoots = new Weight(weightDouble, footsInt);
                listWeight.add(weightfoots);

            }
        });
    }
}