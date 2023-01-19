package com.raiff.java.lesson3_2;
//Конвертация градусов в другие еденицы измерения
public class DegreeConversion implements BaseConverter{


    private double value;

    DegreeConversion(double value){
        this.value = value;
    }

    @Override
    public void convert(Unit unit) {

        if (unit == Unit.CELSIUS){
            System.out.println("Нет смысла конвертировать градусы цельсия в градусы цельсия!");
        }

        if (unit == Unit.FAHRENHEIT){

            double fahrenheit = (value * 9/5) + 32;
            System.out.printf("%f градус цельсия это %f градус фаренгейт\n", value, fahrenheit);
        }

        if (unit == Unit.KELVIN){
            double kelvin = value + 273.15;
            System.out.printf("%f градус цельсия это %f кельвин\n", value, kelvin);
        }
    }
}
