package milatary;
import milatary.entities.*;
import milatary.enums.Corps;
import milatary.enums.MissionState;
import milatary.interfaces.Commando;
import milatary.interfaces.Engineer;
import milatary.interfaces.Spy;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        Map<Integer, PrivateImpl> soldiers = new TreeMap<>(Comparator.reverseOrder());

        String command;
        while (!"End".equals(command = sc.nextLine())) {

            String[] input = command.split("\\s+");

            if (input.length >= 5) {

                String typeOfSoldier = input[0];
                int id = Integer.parseInt(input[1]);
                String firstName = input[2];
                String lastName = input[3];
                double salary = Double.parseDouble(input[4]);

                if (id > 0) {
                    switch (typeOfSoldier) {

                        case "Private":
                            PrivateImpl pr = new PrivateImpl(id, firstName, lastName, salary);
                            soldiers.putIfAbsent(id, pr);

                            System.out.println(pr);
                            break;

                        case "LeutenantGeneral":
                            LieutenantGeneralImpl lt = new LieutenantGeneralImpl(id, firstName, lastName, salary);

                            for (Map.Entry<Integer, PrivateImpl> soldier : soldiers.entrySet()) {

                                for (int i = 5; i < input.length; i++) {

                                    if (soldier.getKey() == Integer.parseInt(input[i])) {

                                        lt.addPrivate(soldier.getValue());
                                    }
                                }
                            }
                            System.out.print(lt.toString());
                            break;

                        case "Engineer":
                            if (isCorpsValid(input[5])) {

                                Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, Corps.valueOf(input[5]));

                                for (int i = 6; i < input.length; i += 2) {

                                    engineer.addRepair(new Repair(input[i], Integer.parseInt(input[i + 1])));
                                }
                                System.out.println(engineer.toString());
                            }
                            break;

                        case "Commando":
                            if (isCorpsValid(input[5])) {

                                Commando commando = new CommandoImpl(id, firstName, lastName, salary, Corps.valueOf(input[5]));

                                for (int i = 6; i < input.length; i += 2) {

                                    if (isMissionStateValid(input[i + 1])) {
                                        commando.addMission(new Mission(input[i], MissionState.valueOf(input[i + 1])));
                                    }
                                }
                                System.out.print(commando);
                            }
                            break;

                        case "Spy":
                            Spy spy = new SpyImpl(id,firstName,lastName,Integer.parseInt(input[4]));
                            System.out.println(spy.toString());
                            break;

                        default:
                            break;
                    }
                }
            }
        }
    }
    private static boolean isCorpsValid (String corps) {

        return Corps.valueOf(corps) == Corps.Airforces
                || Corps.valueOf(corps) == Corps.Marines;
    }
    private static boolean isMissionStateValid (String state){

        return MissionState.valueOf(state) == MissionState.inProgress;
    }
}
