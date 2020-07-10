package parking;
import java.util.*;

public class Parking {

    private String type;
    private int capacity;
    Collection<Car> data;

    public Parking (String type,int capacity){

        setType(type);
        setCapacity(capacity);
        this.data = new ArrayList<>();

    }
    public void setType (String type){this.type = type;}
    public void setCapacity (int capacity){this.capacity = capacity;}

    public int getCount (){
        return data.size();
    }
    public void add (Car car){
        if (getCount() < this.capacity){
            data.add(car);
        }
    }
    public boolean remove (String manufacturer,String model){

        return data.removeIf(car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model));
    }
    public Car getLatestCar (){

        if (getCount() == 0){
            return null;
        }

        Car car = null;
        int latest = Integer.MIN_VALUE;

        for (Car car1 : data) {

            if(car1.getYear() > latest){
                latest = car1.getYear();
                car = car1;
            }
        }
        return car;
    }
    public Car getCar (String manufacturer,String model){


        for (Car car1 : data) {

            if (car1.getManufacturer().equals(manufacturer)
                    && car1.getModel().equals(model)) {

                return car1;
            }
        }
        return null;
    }
    public String getStatistics (){

        StringBuilder sb = new StringBuilder();

        sb.append("The cars are parked in ").append(this.type).append(":")
                .append(System.lineSeparator());

        data.forEach(car -> sb.append(car.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
