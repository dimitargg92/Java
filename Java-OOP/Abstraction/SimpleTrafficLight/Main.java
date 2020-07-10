package enums;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String [] input = sc.nextLine().split("\\s+");

        int n = Integer.parseInt(sc.nextLine());


        TrafficLights light = new TrafficLights();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < input.length; j++) {

                light.color = Lights.valueOf(input[j]);

                light.change();

                input[j] = String.valueOf(light.color);

            }
            System.out.println(String.join(" ", input));
        }
    }
}
