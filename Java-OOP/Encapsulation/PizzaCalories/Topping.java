package Encapsulation.PizzaCalories;
import java.util.Map;

public class Topping {

    private final int BASE_CALORIES = 2;
    private static final Map<String,Double> VALID_TOPPINGS = Map.of(

            "Meat",1.2,
            "Veggies",0.8,
            "Cheese",1.1,
            "Sauce",0.9);


    private String type;
    private double weight;

    public Topping (String type,double weight){

        setType(type);
        setWeight(weight);
    }

    private void setType (String type){

       if (!VALID_TOPPINGS.containsKey(type)){
           throw new IllegalArgumentException("Cannot place " + type + " on top of your pizza.");
       }
       this.type = type;
    }
    private void setWeight (double weight){

        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException(this.type + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories (){

        return (BASE_CALORIES * this.weight) * VALID_TOPPINGS.get(this.type);
    }
}
