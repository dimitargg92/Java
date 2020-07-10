package Encapsulation.PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static Pizza pizza;
    private static BufferedReader reader;

    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));

        try{

            createPizza();
            createDough();
            addToppings();

            System.out.println(pizza.toString());

        } catch (IllegalArgumentException | IOException exception) {
            System.out.println(exception.getMessage());
        }

    }
    private static void addToppings () throws IOException {

        String command;
        while (!"END".equals(command = reader.readLine())) {

            String[] toppingData = command.split("\\s+");
            Topping topping = new Topping(toppingData[1],Double.parseDouble(toppingData[2]));
            pizza.addTopping(topping);
        }
    }
    private static void createDough () throws IOException {

        String[] doughData = reader.readLine().split("\\s+");
        Dough dough = new Dough(doughData[1],doughData[2],Double.parseDouble(doughData[3]));
        pizza.setDough(dough);
    }
    private static void createPizza () throws IOException {

        String[] pizzaData = reader.readLine().split("\\s+");
        pizza = new Pizza(pizzaData[1],Integer.parseInt(pizzaData[2]));
    }
}
