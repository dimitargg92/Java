package Abstraction.foodShortage;
import Abstraction.Interfaces.Buyer;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        Map<String,Buyer> list = new LinkedHashMap<>();


        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = sc.nextLine().split("\\s+");

            switch (tokens.length){

                case 4:
                    Citizen citizen = new Citizen(tokens[0]
                            ,Integer.parseInt(tokens[1]), tokens[2],tokens[3]);

                    list.put(tokens[0],citizen);
                    break;

                case 3:
                    Rebel rebel = new Rebel(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);

                    list.put(tokens[0],rebel);
                    break;
            }
        }

        String person;
        while (!"End".equals(person = sc.nextLine())){

            if (list.containsKey(person)){
                list.get(person).buyFood();
            }
        }
        System.out.println(list.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
