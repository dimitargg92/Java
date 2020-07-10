package Abstraction.foodShortage;
import Abstraction.Interfaces.*;


public class Citizen implements Identifiable,Birthable, Buyer,Person {

    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name,int age,String id,String birthDate){
        setName(name);
        setAge(age);
        setId(id);
        setBirthDate(birthDate);
    }
    private void setName (String name){
        this.name = name;
    }
    private void setAge (int age){
        this.age = age;
    }
    private void setId (String id){
        this.id = id;
    }
    private void setBirthDate (String birthDate){
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public String getBirthDate() {
        return birthDate;
    }
    @Override
    public void buyFood() {
        this.food += 10;
    }
    @Override
    public int getFood() {
        return food;
    }
    @Override
    public int getAge() {
        return age;
    }
}
