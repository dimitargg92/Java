package Inheritance.person;

public class Person {

    private String name;
    private int age;

    public Person (String name,int age){
        setName(name);
        setAge(age);
    }
    private void setName (String name){
        this.name = name;
    }
    private void setAge (int age){
        this.age = age;
    }
    public String getName (){return this.name;}
    public int getAge (){return this.age;}
}
