package milatary.entities;

import milatary.interfaces.Soldier;

public abstract class SoldierImpl implements Soldier {

    private int id;
    private String firstName;
    private String lastName;

    public SoldierImpl (int id,String firstName,String lastName){
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }
    private void setId (int id){
        this.id = id;
    }
    private void setFirstName (String firstName){
        this.firstName = firstName;
    }
    private void setLastName (String lastName){
        this.lastName = lastName;
    }
    @Override
    public int getId (){
        return this.id;
    }
    @Override
    public String getFirstName (){
        return this.firstName;
    }
    @Override
    public String getLastName (){
        return this.lastName;
    }

    @Override
    public String toString (){
        return String.format("Name: %s %s Id: %d ",getFirstName(),getLastName(),getId());
    }

}
