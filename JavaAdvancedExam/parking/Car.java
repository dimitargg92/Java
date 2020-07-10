package parking;

public class Car {

    private String manufacturer;
    private String model;
    private int year;

    public Car (String manufacturer,String model,int year){

        setManufacturer(manufacturer);
        setModel(model);
        setYear(year);
    }
    public void setManufacturer (String manufacturer){
        this.manufacturer = manufacturer;
    }
    public void setModel (String model){
        this.model = model;
    }
    public void setYear (int year){
        this.year = year;
    }
    public String getManufacturer (){return manufacturer;}
    public String getModel (){return model;}
    public int getYear (){return year;}


    @Override
    public String toString (){

        String car = getManufacturer() + " " + getModel() + " (" + getYear() + ")";

        return car.trim();
    }
}
