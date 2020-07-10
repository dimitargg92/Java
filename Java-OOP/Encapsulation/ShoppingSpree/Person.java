package Encapsulation.ShoppingSpree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person (String name,double money){

        setName(name);
        setMoney(money);
        this.products = new LinkedList<>();
    }
    private void setName (String name){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
    private void setMoney (double money){
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
    public String getName (){
        return name;
    }

    public void buyProduct (Product product){
        double price = product.getCost();

        if (this.money >= price){

            this.products.add(product);
            this.money -= price;

        }else {

            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }
    }
    public String displayBoughtProducts (){

        if (!this.products.isEmpty()){

            return this.name + " - " + this.products.stream()
                    .map(Product::getName)
                    .collect(Collectors.toList())
                    .toString().replaceAll("[\\[\\]]","");
        }else {

            return this.name + " - " + "Nothing bought";
        }
    }
}
