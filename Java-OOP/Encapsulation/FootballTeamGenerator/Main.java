package Encapsulation.FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        Map<String, FootballTeam> teams = new LinkedHashMap<>();

        String command;
        while (!"END".equals(command = sc.nextLine())) {

            try {
                String[] input = command.split(";");

                switch (input[0]) {
                    case "Team":
                        teams.putIfAbsent(input[1], new FootballTeam(input[1]));
                        break;

                    case "Add":
                        if (teams.containsKey(input[1])) {

                            teams.get(input[1]).addPlayer(new Player(input[2],
                                    Integer.parseInt(input[3]), Integer.parseInt(input[4]),
                                    Integer.parseInt(input[5]), Integer.parseInt(input[6]),
                                    Integer.parseInt(input[7])));
                        }else{
                            System.out.println("Team " + input[1] + " does not exist.");
                        }
                        break;

                    case "Remove":
                        if (teams.containsKey(input[1])) {
                            teams.get(input[1]).removePlayer(input[2]);
                        }
                        break;

                    case "Rating":
                        if (teams.containsKey(input[1])) {

                            System.out.println(String.format("%s - %.0f",
                                    teams.get(input[1]).getName(),
                                    teams.get(input[1]).getRating()));
                        }else{
                            System.out.println("Team " + input[1] + " does not exist.");
                        }
                        break;
                }

            }catch (IllegalArgumentException exception) {

                System.out.println(exception.getMessage());
            }
        }
    }
}
