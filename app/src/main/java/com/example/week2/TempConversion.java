package com.example.week2;

public class TempConversion {
    public double getConvertedTemp(String key, double val) {
        switch (key){
            case "C_F":
                return (val*(9.0/5.0))+32.0;
            case "C_K":
                return val+273.15;
            case "F_C":
                return (val-32.0)*(5.0/9.0);
            case "F_K":
                return ((val-32.0)*5.0/9.0)+273.15;
            case "K_C":
                return val-273.15;
            case "K_F":
                return ((val-273.15)*1.8)+32;
            default:
                return val;
        }
    }
}
