package br.scl.ifsp.edu.registerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private EditText nameEdit;
    private EditText phoneEdit;
    private EditText emailEdit;
    private CheckBox emailCheckbox;
    private RadioGroup sexRadioGroup;
    private EditText cityEdit;
    private Spinner estateSpinner;

    private Gender gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = findViewById(R.id.nomeEdit);
        phoneEdit = findViewById(R.id.phoneEdit);
        emailEdit = findViewById(R.id.emailEdit);
        emailCheckbox = findViewById(R.id.emailCheckbox);
        sexRadioGroup = findViewById(R.id.sexRadioGroup);
        cityEdit = findViewById(R.id.cityEdit);
        estateSpinner = findViewById(R.id.estateSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.estates));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        sexRadioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.sexMaleButton) gender = Gender.MALE;
            else if (i == R.id.sexFemaleButton) gender = Gender.FEMALE;
        });

        estateSpinner.setAdapter(adapter);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(view -> {
            RegisterData registerData = new RegisterData(
                    nameEdit.getText().toString(),
                    phoneEdit.getText().toString(),
                    emailEdit.getText().toString(),
                    emailCheckbox.isChecked(),
                    gender,
                    cityEdit.getText().toString(),
                    estateSpinner.getSelectedItem().toString()
            );
            Log.println(Log.ASSERT, "asd", registerData.toString());
            Toast.makeText(MainActivity.this, registerData.toString(), Toast.LENGTH_SHORT).show();
        });

        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEdit.setText("");
                phoneEdit.setText("");
                emailEdit.setText("");
                emailCheckbox.setChecked(
                        false
                );
                sexRadioGroup.check(-1);
                cityEdit.setText("");
                estateSpinner.setSelection(0);
            }
        });
    }
}