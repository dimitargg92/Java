package Abstraction.foodShortage;

import Abstraction.Interfaces.Buyer;
import Abstraction.Interfaces.IRebel;
import Abstraction.Interfaces.Person;

public class Rebel implements Buyer,IRebel,Person {

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel (String name,int age,String group){

        setName(name);
        setAge(age);
        setGroup(group);
    }
    private void setName (String name){
        this.name = name;
    }
    private void setAge (int age){
        this.age = age;
    }
    private void setGroup(String group){
        this.group = group;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }
    @Override
    public int getFood() {
        return food;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getGroup() {
        return group;
    }
    @Override
    public int getAge() {
        return age;
    }
}
