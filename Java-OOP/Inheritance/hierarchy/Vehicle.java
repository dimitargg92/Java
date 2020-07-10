package Inheritance.hierarchy;

public class Vehicle {

    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle (double fuel,int horsePower){

        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
        setFuel(fuel);
        setHorsePower(horsePower);
    }
    public void setFuel (double fuel){
        this.fuel = fuel;
    }
    public void setHorsePower (int horsePower){
        this.horsePower = horsePower;
    }
    protected void setFuelConsumption (double fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }
    public double getFuel (){
        return fuel;
    }
    public double getFuelConsumption (){
        return fuelConsumption;
    }
    public int getHorsePower (){
        return horsePower;
    }
    public void drive (double kilometers){

        if (this.getFuel() >= (this.fuelConsumption * kilometers)) {

            this.fuel -= (this.fuelConsumption * kilometers);
        }

    }
}
