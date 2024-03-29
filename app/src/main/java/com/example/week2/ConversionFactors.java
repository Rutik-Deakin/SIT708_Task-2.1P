package com.example.week2;
import java.util.HashMap;

public class ConversionFactors {
    HashMap<String, Double> conversionFactors;
    public ConversionFactors() {
        conversionFactors = new HashMap<>();
        initializeConversionFactors();
    }

    private void initializeConversionFactors() {
        // For direct conversions (same unit to same unit)
        conversionFactors.put("Inches_Inches", 1.0);
        conversionFactors.put("Feet_Feet", 1.0);
        conversionFactors.put("Yards_Yards", 1.0);
        conversionFactors.put("Miles_Miles", 1.0);
        conversionFactors.put("Centimeters_Centimeters", 1.0);
        conversionFactors.put("Meters_Meters", 1.0);
        conversionFactors.put("Kilometers_Kilometers", 1.0);

        //From Inches to different Units
        conversionFactors.put("Inches_Feet", 1.0/12.0);
        conversionFactors.put("Inches_Yards", 1.0/36.0);
        conversionFactors.put("Inches_Miles", 1.0/63360.0);
        conversionFactors.put("Inches_Centimeters", 2.54);
        conversionFactors.put("Inches_Meters", 0.0254);
        conversionFactors.put("Inches_Kilometers", 0.0000254);

        //From Feet to different units
        conversionFactors.put("Feet_Inches", 12.0);
        conversionFactors.put("Feet_Yards", 1.0/3.0);
        conversionFactors.put("Feet_Miles", 0.0001894);
        conversionFactors.put("Feet_Centimeters", 30.48);
        conversionFactors.put("Feet_Meters", 0.3048);
        conversionFactors.put("Feet_Kilometers", 0.0003048);

        //From Yards to different units
        conversionFactors.put("Yards_Inches", 36.0);
        conversionFactors.put("Yards_Feet", 3.0);
        conversionFactors.put("Yards_Miles", 1/1760.0);
        conversionFactors.put("Yards_Centimeters", 91.44);
        conversionFactors.put("Yards_Meters", 0.9144);
        conversionFactors.put("Yards_Kilometers", 0.0009144);

        //From Miles to different units
        conversionFactors.put("Miles_Inches", 63360.0);
        conversionFactors.put("Miles_Feet", 5280.0);
        conversionFactors.put("Miles_Yards", 1760.0);
        conversionFactors.put("Miles_Centimeters", 160934.4);
        conversionFactors.put("Miles_Meters", 1609.344);
        conversionFactors.put("Miles_Kilometers", 1.609344);

        // From Centimeters to different units
        conversionFactors.put("Centimeters_Inches", 0.393701);
        conversionFactors.put("Centimeters_Feet", 0.0328);
        conversionFactors.put("Centimeters_Yards", 0.010936133);
        conversionFactors.put("Centimeters_Miles", 0.0000062137);
        conversionFactors.put("Centimeters_Meters", 0.01);
        conversionFactors.put("Centimeters_Kilometers", 0.00001);

        //From Meters to different units
        conversionFactors.put("Meters_Inches", 39.26);
        conversionFactors.put("Meters_Feet", 3.28);
        conversionFactors.put("Meters_Yards", 1.0936);
        conversionFactors.put("Meters_Miles", 0.000621);
        conversionFactors.put("Meters_Centimeters", 100.0);
        conversionFactors.put("Meters_Kilometers", 0.001);

        //From Kilometers to different units
        conversionFactors.put("Kilometers_Inches", 39370.1);
        conversionFactors.put("Kilometers_Feet", 3280.8398950131);
        conversionFactors.put("Kilometers_Yards", 1093.613298);
        conversionFactors.put("Kilometers_Miles", 0.621371);
        conversionFactors.put("Kilometers_Centimeters", 100000.0);
        conversionFactors.put("Kilometers_Meters", 1000.0);


        //Weight Conversation

        //For same source and destination
        conversionFactors.put("Pound_Pound", 1.0);
        conversionFactors.put("Ounce_Ounce", 1.0);
        conversionFactors.put("Ton_Ton", 1.0);

        //Pound to other units
        conversionFactors.put("Pound_Ounce", 16.0);
        conversionFactors.put("Pound_Ton", 0.0005);

        //Ounce to other units
        conversionFactors.put("Ounce_Pound", 0.0625);
        conversionFactors.put("Ounce_Ton", 0.00003125);

        //Ton to other units
        conversionFactors.put("Ton_Pound", 2000.0);
        conversionFactors.put("Ton_Ounce", 32000.0);
    }
    
    public double getConversionRation(String key) {
        return conversionFactors.get(key);
    }
}
