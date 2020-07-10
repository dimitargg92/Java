package Encapsulation.ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


            Map<String, Person> personList = new LinkedHashMap<>();

            String[] peopleInput = sc.nextLine().split(";");

            for (String data : peopleInput) {

                String personName = data.split("=")[0];
                double personMoney = Double.parseDouble(data.split("=")[1]);

                try {

                    Person person = new Person(personName, personMoney);
                    personList.put(personName, person);

                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                    return;
                }
            }

            Map<String, Product> productsList = new LinkedHashMap<>();

            String[] productsInput = sc.nextLine().split(";");

             for (String data : productsInput) {

                 String productName = data.split("=")[0];
                 double productPrice = Double.parseDouble(data.split("=")[1]);

                 try {

                  Product product = new Product(productName, productPrice);
                  productsList.put(productName, product);

                 } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                    return;
                }
             }

             String command;
             while (!"END".equals(command = sc.nextLine())) {

                String[] tokens = command.split("\\s+");

                String buyer = tokens[0];
                String product = tokens[1];

                try {

                    if (personList.containsKey(buyer) && productsList.containsKey(product)) {

                        personList.get(buyer).buyProduct(productsList.get(product));

                        System.out.println(buyer + " bought " + product);
                    }

                } catch (IllegalArgumentException exception) {

                    System.out.println(exception.getMessage());
                }
            }
            for (Person person : personList.values()) {

                System.out.println(person.displayBoughtProducts());
            }
        }
    }


