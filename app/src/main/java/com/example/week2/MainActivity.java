package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;
import com.example.week2.UnitAbbrUtils;
import com.example.week2.ConversionFactors;
import com.example.week2.TempConversion;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Spinner categoriesSpinner;
    private Spinner sourceUnitSpinner;
    private Spinner destinationUnitSpinner;
    private EditText editText;
    private Button button;

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        categoriesSpinner = findViewById(R.id.category_spinner);
        sourceUnitSpinner = findViewById(R.id.source_unit_spinner);
        destinationUnitSpinner = findViewById(R.id.destination_unit_spinner);

        editText = findViewById(R.id.input_value);
        button = findViewById(R.id.convert_btn);
        resultText = findViewById(R.id.result_value);

        categoriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String[] selectedArray;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCat = categoriesSpinner.getSelectedItem().toString(); // Retrieve selected category here
                switch (selectedCat) {
                    case "Length conversions":
                        selectedArray = getResources().getStringArray(R.array.length_units);
                        break;
                    case "Weight conversions":
                        selectedArray = getResources().getStringArray(R.array.weight_units);
                        break;
                    case "Temperature conversions":
                        selectedArray = getResources().getStringArray(R.array.temp_units);
                        break;
                    default:
                        selectedArray = getResources().getStringArray(R.array.length_units);
                        break;
                }

                Log.d("MainActivity", "" + selectedCat);

                // Create an ArrayAdapter with the selected string array
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, selectedArray);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Set the adapter to the appropriate spinner
                sourceUnitSpinner.setAdapter(adapter);
                destinationUnitSpinner.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle case where nothing is selected, if needed
            }
        });


    }

    public void convertValue(View view) {

        UnitAbbrUtils unitAbbrUtils = new UnitAbbrUtils();
        ConversionFactors conversionFactors = new ConversionFactors();
        TempConversion tempConversion = new TempConversion();

        String sourceUnit = sourceUnitSpinner.getSelectedItem().toString();
        String destinationUnit = destinationUnitSpinner.getSelectedItem().toString();
        String strVal = editText.getText().toString();

        //Check for empty user input
        if(strVal.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please Enter the value", Toast.LENGTH_SHORT).show();
            resultText.setText("Please provide an input");
            return;
        }

        try {
            //Handle the invalid user input
            double doubleVal = Double.parseDouble(strVal);
            String conversationKey = sourceUnit + "_" + destinationUnit;
            Double finalConvertedValue;
            if (((String)categoriesSpinner.getSelectedItem()).equals("Temperature conversions")) {
                finalConvertedValue = tempConversion.getConvertedTemp(conversationKey, doubleVal);
            } else {
                Double ratio = conversionFactors.getConversionRation(conversationKey);
                finalConvertedValue = ratio*doubleVal;
            }
            String formattedValue =String.format("%.10f", finalConvertedValue);
            resultText.setText(formattedValue + " " + unitAbbrUtils.getUnitAbbr(destinationUnit));

        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Please enter a valid value", Toast.LENGTH_SHORT).show();
            resultText.setText("Invalid input");
            return;
        }
    }
}