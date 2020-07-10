package Inheritance.restaurant;

import java.math.BigDecimal;

public class Dessert extends Food {

    private double calories;

    public Dessert(String name, BigDecimal price, double grams,double calories) {
        super(name, price, grams);
        setCalories(calories);
    }
    private void setCalories (double calories){
        this.calories = calories;
    }
    public double getCalories (){
        return calories;
    }
}
