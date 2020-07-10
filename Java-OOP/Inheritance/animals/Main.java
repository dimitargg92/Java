package Inheritance.animals;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String animalType;
        while (!"Beast!".equals(animalType = sc.nextLine())){

            String[] input = sc.nextLine().split("\\s+");

            try {

                switch (animalType) {

                    case "Dog":
                        Dog dog = new Dog(input[0], Integer.parseInt(input[1]), input[2]);

                        System.out.println(dog);
                        break;

                    case "Frog":
                        Frog frog = new Frog(input[0], Integer.parseInt(input[1]), input[2]);

                        System.out.println(frog);
                        break;
                    case "Cat":
                        Cat cat = new Cat(input[0], Integer.parseInt(input[1]), input[2]);

                        System.out.println(cat);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(input[0], Integer.parseInt(input[1]));

                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(input[0], Integer.parseInt(input[1]));

                        System.out.println(tomcat);
                        break;
                }

            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
    }
}
