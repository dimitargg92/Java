package Abstraction.border;


public class Citizen implements Identifiable {

    private String name;
    private int age;
    private String id;

    public Citizen (String name,int age,String id){

        setName(name);
        setAge(age);
        setId(id);
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
    public String getName (){
        return this.name;
    }
    public int getAge (){
        return age;
    }
    @Override
    public String getId() {
        return id;
    }
}
