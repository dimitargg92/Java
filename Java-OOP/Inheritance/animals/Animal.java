package Inheritance.animals;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name,int age,String gender){
        setName(name);
        setAge(age);
        setGender(gender);
    }
    public void setName (String name){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }
    public void setAge (int age){
        if (age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }
    private void setGender (String gender){
        if (gender == null || gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }
    public String getName (){
        return name;
    }
    public int getAge (){
        return age;
    }
    public String getGender (){
        return gender;
    }

    public String produceSound (){
        return "Sound!";
    }

    @Override
    public String toString (){

        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append(this.getName()).append(" ")
                .append(this.getAge()).append(" ")
                .append(this.getGender()).append(System.lineSeparator())
                .append(this.produceSound());

        return sb.toString().trim();
    }
}
