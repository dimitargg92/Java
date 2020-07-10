package Abstraction.border;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<Identifiable> list = new ArrayList<>();

        String command;
        while (!"End".equals(command = reader.readLine())){

            String[]tokens = command.split("\\s+");

            switch (tokens.length){

                case 3:
                    Citizen citizen = new Citizen(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
                    list.add(citizen);
                    break;

                case 2:
                    Robot robot = new Robot(tokens[0],tokens[1]);
                    list.add(robot);
                    break;
            }
        }
        String fakeIdLastDigits = reader.readLine();

        printFakeIds(list,fakeIdLastDigits);

    }
    private static void printFakeIds (List<Identifiable> list,String fakeIdLastDigits){

        for (Identifiable element : list) {

            if (element.getId().endsWith(fakeIdLastDigits)) {
                System.out.println(element.getId());
            }
        }
    }
}
