package com.example.week2;

public class UnitAbbrUtils {
    public String getUnitAbbr(String key) {
        switch (key) {
            case "Inches":
                return "in";
            case "Feet":
                return "ft";
            case "Yards":
                return "yd";
            case "Miles":
                return "mi";
            case "Centimeters":
                return "cm";
            case "Meters":
                return "m";
            case "Kilometers":
                return "km";
            case "Pound":
                return "lb";
            case "Ounce":
                return "oz";
            case "Ton":
                return "ton";
            default:
                return key;
        }
    }
}
