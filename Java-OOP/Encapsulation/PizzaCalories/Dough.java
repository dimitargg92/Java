package Encapsulation.PizzaCalories;
import java.util.Map;

public class Dough {

    private final double BASE_CALORIES = 2;
    private final String INVALID_DOUGH_TYPE_OR_BAKING_TECHNIQUE = "Invalid type of dough.";
    private final String INVALID_WEIGHT = "Dough weight should be in the range [1..200].";

    private static final Map<String,Double> FLOUR_TYPE_MODIFIERS = Map.of(

            "White",1.5,
            "Wholegrain",1.0);


    private static final Map<String,Double> BAKING_TECHNIQUES_MODIFIERS = Map.of(

            "Crispy",0.9,
            "Chewy",1.1,
            "Homemade",1.0);


    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough (String flourType, String bakingTechnique, double weight){

        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }
    private void setFlourType (String flourType){

        if (!FLOUR_TYPE_MODIFIERS.containsKey(flourType)){
            throw new IllegalArgumentException(INVALID_DOUGH_TYPE_OR_BAKING_TECHNIQUE);
        }
        this.flourType = flourType;
    }
    private void setBakingTechnique (String bakingTechnique){

        if (!BAKING_TECHNIQUES_MODIFIERS.containsKey(bakingTechnique)){
            throw new IllegalArgumentException(INVALID_DOUGH_TYPE_OR_BAKING_TECHNIQUE);
        }
        this.bakingTechnique = bakingTechnique;
    }
    private void setWeight (double weight){

        if (weight < 0 || weight > 200){
            throw new IllegalArgumentException(INVALID_WEIGHT);
        }
        this.weight = weight;
    }
    public double calculateCalories (){

        return (this.BASE_CALORIES * this.weight)
                * FLOUR_TYPE_MODIFIERS.get(this.flourType)
                * BAKING_TECHNIQUES_MODIFIERS.get(this.bakingTechnique);
    }
}
