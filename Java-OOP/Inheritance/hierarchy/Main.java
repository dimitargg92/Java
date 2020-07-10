package Inheritance.hierarchy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        SportCar car = new SportCar(50,200);

        System.out.println(car.getFuelConsumption());

    }
}
